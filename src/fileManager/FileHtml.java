package fileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FileHtml extends File {
Map<String, Integer> dict = new HashMap<String, Integer>();
	@Override
	public Map<String, Integer> parse(String file) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			String text = br.readLine();
			while((line = br.readLine()) != null) {
				text = text + line;
			}
			Document doc = Jsoup.parse(text);
			String html = doc.text();
			dict = super.filDict(html);
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + file + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + file + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}

		return dict;
	}

}
