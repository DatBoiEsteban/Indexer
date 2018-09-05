package fileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileTxt extends Files{

	private BufferedReader br;
	Map<String, Integer> dict = new HashMap<String, Integer>();

	public FileTxt(String fileName) {
		super.readFile(fileName);
	}
	
	@Override
	public Map<String, Integer> parse() {
		String line = null;
		try {
			FileReader fr = new FileReader(super.getName());
			br = new BufferedReader(fr);
			String Txt = br.readLine();
			while ((line = br.readLine()) != null) {
				Txt = Txt + line;
			}
			dict = super.filDict(Txt);
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + super.getName() + "'");

		} catch (IOException ex) {
			System.out.println("Error reading file '" + super.getName() + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return dict;
	}

}
