package main;

import java.util.Map;

import fileManager.*;

public class Console {

	public static void main(String[] args) {
		FileHtml df = new FileHtml("untitled.html");
		df.parse();
		System.out.println(df.toString());
		FileTxt dgg = new FileTxt("untitled.txt");
		dgg.parse();
		System.out.println(dgg.toString());
		FileCSV abc = new FileCSV("untitled.csv");
		abc.parse();
		System.out.println(abc.toString());
		FileJson as = new FileJson("settings.json");
		as.parse();
	}

}
