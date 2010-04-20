package koopa.app.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import koopa.app.ApplicationSupport;
import koopa.app.batchit.BatchResults;
import koopa.util.Getter;

@SuppressWarnings("serial")
public class ExportBatchResultsToCSVAction extends AbstractAction implements
		Action {

	private static final String CSV_SEPARATOR = ";";
	private static final char CSV_QUOTATION = '"';

	private Getter<BatchResults> batchResultsGetter = null;
	private FileFilter filter = null;
	private Component parent = null;

	public ExportBatchResultsToCSVAction(
			Getter<BatchResults> batchResultsGetter, FileFilter filter,
			Component parent) {
		super("Export batch results to CSV...");
		this.batchResultsGetter = batchResultsGetter;
		this.filter = filter;
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new ThreadGroup("actions"), new Runnable() {
			public void run() {
				final BatchResults batchResults = batchResultsGetter.getIt();
				File file = ApplicationSupport.askUserForFile(false,
						"last-folder", filter, parent);

				if (file == null) {
					return;
				}

				try {
					exportBatchResultsToCSV(batchResults, file);
					JOptionPane.showMessageDialog(parent,
							"Batch results have been exported.", "Export",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (IOException e) {
					JOptionPane.showMessageDialog(parent, "Export failed.\n"
							+ e.getMessage(), "Input/Output problem",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		}).start();
	}

	private void exportBatchResultsToCSV(BatchResults batchResults, File file)
			throws IOException {

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		try {
			for (int column = 0; column < batchResults.getColumnCount(); column++) {
				if (column != 0) {
					bw.append(CSV_SEPARATOR);
				}

				bw.append(CSV_QUOTATION);
				bw.append(batchResults.getColumnName(column));
				bw.append(CSV_QUOTATION);
			}

			bw.append('\n');

			for (int row = 0; row < batchResults.getRowCount(); row++) {
				for (int column = 0; column < batchResults.getColumnCount(); column++) {
					Object obj = batchResults.getValueAt(row, column);

					if (column != 0) {
						bw.append(CSV_SEPARATOR);
					}

					bw.append(CSV_QUOTATION);
					bw.append(obj.toString());
					bw.append(CSV_QUOTATION);
				}

				bw.append('\n');
			}

		} finally {
			bw.close();
		}
	}
}
