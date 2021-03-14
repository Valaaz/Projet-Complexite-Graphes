package graphes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Fichier {

	private static final String FILENAME = "src/graphes/Long-n.10.0.gr";
	// private static final String FILENAME = "src/graphes/Square-n.21.0.gr";

	public static void main(String[] args) {
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

		try (BufferedReader bufferedreader = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			String[] columns = null;

			while ((strCurrentLine = bufferedreader.readLine()) != null) {
				if (strCurrentLine.startsWith("a")) { // On ne prend que les lignes avec les donn�es qui nous
														// int�ressent

					ArrayList<String> list = new ArrayList<String>();

					columns = strCurrentLine.split(" "); // On s�pare les diff�rentes colonnes

					// Si la cl� actuelle existe d�j� on rajoute sa valeur � sa liste
					// Sinon on vide la liste, ajoute la premi�re valeur et cr�e la cl� avec sa
					// liste associ�e
					if (map.get(Integer.parseInt(columns[1])) != null) { // On convertit juste les cl�s en entier afin
																			// que la HashMap se trie toute seule
						map.get(Integer.parseInt(columns[1])).add(columns[2]);
					} else {
						list.clear();
						list.add(columns[2]);
						map.put(Integer.parseInt(columns[1]), list);
					}
				}
			}

			// Affiche les cl�s avec leur valeur associ�e
			Set<Integer> listKeys = map.keySet();
			Iterator<Integer> iterateur = listKeys.iterator();
			while (iterateur.hasNext()) {
				Object key = iterateur.next();
				System.out.println(key + " => " + map.get(key));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
