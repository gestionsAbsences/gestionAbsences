package co.simplon;

import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		AfficheResultats affiche;
		affiche = new AfficheResultats();                      // Aujourd'hui
		affiche = new AfficheResultats("24/5/2017");           // par défaut Repos samedi et dimanche
		affiche = new AfficheResultats("25/5/2017");           // Ascension
		affiche = new AfficheResultats("1/7/2017");            // par défaut Repos samedi et dimanche
		affiche = new AfficheResultats("1/7/2017", 65);        // 65 = Repos lundi  et dimanche
		affiche = new AfficheResultats("5/6/2017", 96, 128);   // Lundi de pentecôte, jour férié travaillé
	}
}
