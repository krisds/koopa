package koopa.app.components.query;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import koopa.app.Application;
import koopa.app.ApplicationListener;
import koopa.app.components.detail.Detail;
import koopa.app.components.highlights.Highlights;
import koopa.app.components.overview.Overview;
import koopa.core.data.Token;
import koopa.core.trees.Tree;
import koopa.core.trees.jaxen.Jaxen;
import koopa.core.trees.jaxen.XPathException;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

public class XPathQueryingDialog extends JDialog implements ApplicationListener {

	private static final long serialVersionUID = 1L;

	private static final Color HIGHLIGHT_COLOR = new Color(248, 236, 201);
	private Highlights highlights = null;

	private static XPathQueryingDialog dialog = null;

	private Application application = null;

	private JButton queryButton = null;
	private JTextField xpathQuery = null;
	private JXTable resultsTable = null;
	private JLabel status = null;

	private Map<Detail, XPathResults> resultsPerDetail = new HashMap<>();
	private XPathResults selectedResults = new XPathResults();

	public static synchronized XPathQueryingDialog getDialog(Frame owner,
			Application application) {

		if (dialog == null)
			dialog = new XPathQueryingDialog(owner, application);

		return dialog;
	}

	public XPathQueryingDialog(Frame owner, Application application) {
		super(owner, "Find by XPath", false);

		this.application = application;

		resultsPerDetail.put(null, selectedResults);

		setupComponents();

		setSize(600, 300);
		setLocationRelativeTo(owner);

		application.addApplicationListener(this);
	}

	private void setupComponents() {
		xpathQuery = new JTextField();
		queryButton = new JButton("Query");

		status = new JLabel("Please enter a valid XPath expression.");

		final ActionListener performSearch = e -> {
			final String theQuery = xpathQuery.getText();

			if (theQuery == null) {
				selectedResults.setResults(null);
				return;
			}

			try {
				Tree tree = application.getSyntaxTree();

				final List<?> matches = Jaxen.evaluate(tree, theQuery);

				selectedResults.setResults(matches);
				status.setText(matches == null ? "No" : matches.size()
						+ " matches.");

				Component view = application.getView();
				if (view instanceof Detail)
					highlightAllMatches((Detail) view);

			} catch (XPathException xpe) {
				selectedResults.setResults(null);
				status.setText(xpe.getMessage());
			}
		};

		xpathQuery.addActionListener(performSearch);
		queryButton.addActionListener(performSearch);

		resultsTable = new JXTable();
		resultsTable.setModel(selectedResults);

		resultsTable.getColumnModel().getColumn(XPathResults.TYPE_COLUMN)
				.setPreferredWidth(40);
		resultsTable.getColumnModel().getColumn(XPathResults.TEXT_COLUMN)
				.setPreferredWidth(480);
		resultsTable.getColumnModel().getColumn(XPathResults.LINE_COLUMN)
				.setPreferredWidth(40);
		resultsTable.getColumnModel().getColumn(XPathResults.COLUMN_COLUMN)
				.setPreferredWidth(40);
		resultsTable.getColumnModel().getColumn(XPathResults.RESOURCE_COLUMN)
				.setPreferredWidth(100);

		resultsTable.getColumnModel().getColumn(XPathResults.TYPE_COLUMN)
				.setCellRenderer(new XPathResultTypeRenderer());

		resultsTable.setBorder(null);
		resultsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		resultsTable.setHighlighters(HighlighterFactory.createSimpleStriping());

		resultsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					final int row = resultsTable.rowAtPoint(e.getPoint());
					final Token token = selectedResults.getToken(row);
					if (token != null)
						application.scrollTo(token);
				}
			}
		});

		JScrollPane scrollableResultsTable = new JScrollPane(resultsTable);
		scrollableResultsTable.setBorder(null);

		setLayout(new BorderLayout());

		final JPanel queryPanel = new JPanel();
		queryPanel.setLayout(new BorderLayout());

		queryPanel.add(new JLabel(" xpath:"), BorderLayout.WEST);
		queryPanel.add(xpathQuery, BorderLayout.CENTER);
		queryPanel.add(queryButton, BorderLayout.EAST);

		add(queryPanel, BorderLayout.NORTH);
		add(scrollableResultsTable, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);

		switchedView(application.getView());
	}

	private void highlightAllMatches(Detail detail) {
		if (highlights != null)
			highlights.removeAllHighlights();

		highlights = detail.getNewHighlights();

		// Highlight all matches in the source view...
		for (Object match : selectedResults.getResults()) {
			if (match instanceof Tree) {
				final Tree tree = (Tree) match;
				for (Token t : tree.allTokens())
					highlights.addHighlight(t, HIGHLIGHT_COLOR);
			}
		}
	}

	@Override
	public void switchedView(Component view) {
		if (view instanceof Overview) {
			xpathQuery.setEnabled(false);
			queryButton.setEnabled(false);
			selectedResults = resultsPerDetail.get(null);
			resultsTable.setModel(selectedResults);
			resultsTable.updateUI();

		} else {
			Detail detail = (Detail) view;

			selectedResults = resultsPerDetail.get(detail);
			if (selectedResults == null) {
				selectedResults = new XPathResults();
				resultsPerDetail.put(detail, selectedResults);
			}

			resultsTable.setModel(selectedResults);
			resultsTable.updateUI();

			if (detail.hasSyntaxTree()) {
				queryButton.setEnabled(true);
				xpathQuery.setEnabled(true);

			} else {
				xpathQuery.setEnabled(false);
				queryButton.setEnabled(false);
			}
		}

		int matches = selectedResults.getRowCount();
		status.setText((matches == 0 ? "No" : matches) + " matches.");

	}

	@Override
	public void updatedView(Component view) {
		if (view instanceof Detail) {
			Detail detail = (Detail) view;
			XPathResults results = resultsPerDetail.get(detail);

			if (results == null)
				return;

			results.setResults(null);

			if (results == selectedResults)
				resultsTable.updateUI();
		}
	}

	@Override
	public void closedDetail(Component view) {
		if (view instanceof Detail)
			resultsPerDetail.remove(view);

		xpathQuery.setEnabled(false);
		queryButton.setEnabled(false);
	}
}
