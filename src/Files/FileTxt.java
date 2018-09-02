package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileTxt extends File{

	private BufferedReader br;
	Map<String, Integer> dict = new HashMap<String, Integer>();

	public Map<String, Integer> parse(File file) {
		String line = null;
		try {
			FileReader fr = new FileReader(file.getRoute());
			br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				String words[] = line.split(" ");
				for (int i = 0; i < words.length; i++) {
					if (!dict.containsKey(words[i])) {
						dict.put(words[i], 1);
					} else {
						dict.replace(words[i], dict.get(words[i]), dict.get(words[i]) + 1);
					}
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + file.getName() + "'");
			
		} catch (IOException ex) {
			System.out.println("Error reading file '" + file.getName() + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return dict;
	}

}
