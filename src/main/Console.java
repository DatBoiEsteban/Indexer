package main;

import java.util.Map;

import fileManager.*;

public class Console {

	public static void main(String[] args) {
		FileHtml df = new FileHtml();
		Map<String, Integer> d = df.parse("untitled.html");
		System.out.println(d.toString());
		FileTxt dgg = new FileTxt();
		Map<String, Integer> dcc = dgg.parse("untitled.txt");
		System.out.println(dcc.toString());
	}

}
