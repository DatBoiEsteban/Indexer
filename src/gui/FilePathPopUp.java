package gui;

import java.io.File;

import javax.swing.JFileChooser;

public class FilePathPopUp extends Thread{
	private JFileChooser chooser;

	public FilePathPopUp() {
		this.chooser = new JFileChooser();
		this.chooser.setCurrentDirectory(new File(".\\"));
		this.chooser.setDialogTitle("Select Directory to index");
		this.chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.chooser.setAcceptAllFileFilterUsed(false);

		if (this.chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
			System.exit(0);
		}
	}

	public File getFilePath() {
		return this.chooser.getSelectedFile();
	}
}
