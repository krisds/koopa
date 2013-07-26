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
import au.com.bytecode.opencsv.CSVWriter;

@SuppressWarnings("serial")
public class ExportBatchResultsToCSVAction extends AbstractAction implements
		Action {

	private Getter<BatchResults> batchResultsGetter = null;
	private FileFilter filter = null;
	private Component parent = null;

	public ExportBatchResultsToCSVAction(
			Getter<BatchResults> batchResultsGetter, Component parent) {
		super("Export batch results to CSV...");
		this.batchResultsGetter = batchResultsGetter;
		this.parent = parent;

		this.filter = new FileFilter() {
			public boolean accept(File f) {
				if (!f.isFile())
					return false;
				final String name = f.getName().toUpperCase();
				return name.endsWith(".CSV");
			}

			public String getDescription() {
				return "CSV file (*.csv)";
			}
		};
	}

	public void actionPerformed(ActionEvent ae) {
		new Thread(new Runnable() {
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

		final FileWriter fw = new FileWriter(file);
		final BufferedWriter bw = new BufferedWriter(fw);
		final CSVWriter writer = new CSVWriter(bw);

		try {
			final int columnCount = batchResults.getColumnCount();
			final String[] entries = new String[columnCount];

			// Header row.
			for (int column = 0; column < columnCount; column++) {
				entries[column] = batchResults.getColumnName(column);
			}
			writer.writeNext(entries);

			// Results.
			for (int row = 0; row < batchResults.getRowCount(); row++) {
				for (int column = 0; column < columnCount; column++) {
					Object obj = batchResults.getValueAt(row, column);
					entries[column] = obj == null ? "" : obj.toString();
				}
				writer.writeNext(entries);
			}

		} finally {
			writer.close();
		}
	}
}
