package fileManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class DirectoryLoader extends Thread {

	private String[] extensions = { "json", "csv", "xml", "html", "txt" };
	private ArrayList<FileFather> arr = new ArrayList<FileFather>();

	public DirectoryLoader(File directory) {
		Iterator<File> it = FileUtils.iterateFiles(directory, extensions, true);
		while (it.hasNext()) {
			String path = it.next().getAbsolutePath();
			if (path.endsWith(extensions[0])) {
				FileJson file = new FileJson(path);
				file.parse();
				arr.add(file);
			} else if (path.endsWith(extensions[1])) {
				FileCSV file = new FileCSV(path);
				file.parse();
				arr.add(file);
			}
			if (path.endsWith(extensions[2])) {
				FileXml file = new FileXml(path);
				file.parse();
				arr.add(file);
			} else if (path.endsWith(extensions[3])) {
				FileHtml file = new FileHtml(path);
				file.parse();
				arr.add(file);
			} else if (path.endsWith(extensions[4])) {
				FileTxt file = new FileTxt(path);
				file.parse();
				arr.add(file);
			}
		}
		/*for(FileFather file : arr) {
			System.out.println(file.toString());
		}*/
	}

	public ArrayList<FileFather> getArr() {
		return arr;
	}

}
