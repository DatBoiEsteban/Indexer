package main;

import java.util.Map;

import fileManager.*;

public class Console {

	public static void main(String[] args) {
		FileHtml df = new FileHtml("untitled.html");
		Map<String, Integer> d = df.parse();
		System.out.println(d.toString());
		FileTxt dgg = new FileTxt("untitled.txt");
		Map<String, Integer> dcc = dgg.parse();
		System.out.println(dcc.toString());
		FileCSV abc = new FileCSV("untitled.csv");
		Map<String, Integer> aaa = abc.parse();
		System.out.println(aaa.toString());
		FileJson as = new FileJson("settings.json");
		as.parse();
	}

}
