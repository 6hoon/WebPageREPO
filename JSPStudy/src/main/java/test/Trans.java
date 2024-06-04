package test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Trans {
	public static void main(String[] args) {
		String name = "D:/MyProject/myjsp/JSPStudy/src/main/java/text/test.txt";
		try {
			Scanner sc = new Scanner(new File(name));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println("pw.println(\"" + line + "\");");
			}
		} catch (IOException e) {
			System.out.println("io");
		}
	}
}
