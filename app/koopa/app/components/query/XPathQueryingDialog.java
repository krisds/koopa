package koopa.app.components.query;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.WeakHashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import koopa.trees.antlr.jaxen.Jaxen;
import koopa.trees.antlr.jaxen.XPathException;
import koopa.util.Getter;

import org.antlr.runtime.tree.CommonTree;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.decorator.HighlighterFactory;

public class XPathQueryingDialog extends JDialog {

	private static final long serialVersionUID = 8823045458789993217L;

	private static final WeakHashMap<Component, XPathQueryingDialog> DIALOGS = new WeakHashMap<Component, XPathQueryingDialog>();

	private Getter<CommonTree> treeGetter = null;

	public static synchronized XPathQueryingDialog getDialog(Frame owner,
			Getter<CommonTree> treeGetter) {

		XPathQueryingDialog dialog = DIALOGS.get(owner);

		if (dialog == null) {
			dialog = new XPathQueryingDialog(owner, treeGetter);
			DIALOGS.put(owner, dialog);
		}

		return dialog;
	}

	public XPathQueryingDialog(Frame owner, Getter<CommonTree> treeGetter) {
		super(owner, "Query using XPath", false);

		this.treeGetter = treeGetter;

		setupComponents();

		setSize(600, 300);
		setLocationRelativeTo(owner);
	}

	private void setupComponents() {
		final JTextField xpathQuery = new JTextField();
		final JButton queryButton = new JButton("Query");
		final XPathResults results = new XPathResults();
		final JLabel status = new JLabel(
				"Please enter a valid XPath expression.");

		final ActionListener performSearch = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String theQuery = xpathQuery.getText();

				if (theQuery == null) {
					results.setResults(null);
					return;
				}

				try {
					final List<?> matches = Jaxen.evaluate(treeGetter.getIt(),
							theQuery);

					results.setResults(matches);
					status.setText(matches == null ? "No" : matches.size()
							+ " matches.");

				} catch (XPathException xpe) {
					results.setResults(null);
					status.setText(xpe.getMessage());
				}
			}
		};

		xpathQuery.addActionListener(performSearch);
		queryButton.addActionListener(performSearch);

		final JXTable resultsTable = new JXTable();
		resultsTable.setModel(results);

		resultsTable.getColumnModel().getColumn(XPathResults.TYPE_COLUMN)
				.setPreferredWidth(40);
		resultsTable.getColumnModel().getColumn(XPathResults.TEXT_COLUMN)
				.setPreferredWidth(560);

		resultsTable.getColumnModel().getColumn(XPathResults.TYPE_COLUMN)
				.setCellRenderer(new XPathResultTypeRenderer());

		resultsTable.setBorder(null);
		resultsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		resultsTable.setHighlighters(HighlighterFactory.createSimpleStriping());

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
	}
}
