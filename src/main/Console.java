package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import fileManager.DirectoryLoader;
import fileManager.FileFather;

public class Console {
	private static DirectoryLoader dl;

	public static void main(String[] args) {
		while (true) {

			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				System.out.print(">>>");
				String Commands = br.readLine();
				// Commands = Commands.substring(2);
				// System.out.println(Commands);
				doCommand(Commands);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void doCommand(String Commands) {
		String[] command = Commands.split(" ");
		if (command[0].toLowerCase().equalsIgnoreCase("indexar") && command[1].toLowerCase().equalsIgnoreCase("-f")) {
			indexar(command);
		}
	}

	private static void indexar(String[] command) {
		String FolderPath = command[2];
		if (command.length > 3) {
			for (int i = 3; i < command.length; i++) {
				FolderPath += command[i];
			}
		}
		setDl(new DirectoryLoader(new File(FolderPath)));
	}

	public static DirectoryLoader getDl() {
		return dl;
	}

	public static void setDl(DirectoryLoader dl) {
		Console.dl = dl;
	}
}