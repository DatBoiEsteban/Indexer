package query;

import java.io.BufferedReader;
import java.io.FileReader;

public class WTD {
	private String[] WTD;
	public WTD() {
		String line = null;
		try {
			FileReader fr = new FileReader("wordsToDelete.txt");
			BufferedReader br = new BufferedReader(fr);
			String Txt = br.readLine();
			while ((line = br.readLine()) != null) {
				Txt = Txt + " " + line;
			}
			br.close();
			WTD = Txt.split(" ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String[] getWTD() {
		return WTD;
	}
	

}
