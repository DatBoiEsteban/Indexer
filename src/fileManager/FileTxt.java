package fileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileTxt extends FileFather {

	public FileTxt(String filePath) {
		super.readFile(filePath);
	}

	@Override
	public void parse() {
		String line = null;
		try {
			FileReader fr = new FileReader(super.getPath());
			BufferedReader br = new BufferedReader(fr);
			String Txt = br.readLine();
			while ((line = br.readLine()) != null) {
				Txt = Txt + " " + line;
			}
			super.filDict(Txt);
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + super.getName() + "'");

		} catch (IOException ex) {
			System.out.println("Error reading file '" + super.getName() + "'");
		}
	}
}
