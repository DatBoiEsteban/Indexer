package fileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileTxt extends File{

	private BufferedReader br;
	Map<String, Integer> dict = new HashMap<String, Integer>();

	@Override
	public Map<String, Integer> parse(String file) {
		String line = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String Txt = br.readLine();
			while ((line = br.readLine()) != null) {
				Txt = Txt + line;
			}
			dict = super.filDict(Txt);
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
