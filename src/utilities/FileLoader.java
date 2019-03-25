package utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileLoader extends Thread {

	/**
	 * Get a random line in a file
	 *
	 * @param filePath : The path of the file to read
	 * @return  a random line of the file
	 */
	public static String getRandomLine(String filePath) {
		String[] lines = read(filePath).split("\n");
		return lines[RandomClass.getRandBelow(lines.length - 1)];
	}

	/**
	 * Read a file and return the content
	 *
	 * @param filePath : the path to the file to read
	 * @return the content of the file
	 */
	public static String read(String filePath) {
		// On créé une chaîne vide qui contiendra le fichier texte
		String chaine = "";
		try {
			InputStream ips = new FileInputStream(filePath);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				// System.out.println(ligne);
				chaine += ligne + "\n";
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return chaine;
	}
}