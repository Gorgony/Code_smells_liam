package nl.hu.tho4.controller;

import nl.hu.tho4.model.Monteur;

import java.util.ArrayList;

public interface MonteursDao {
	/**
	 * init methode dient eenmalig alleen door de ContextListener te worden
	 * aangeroepen. Deze methode dient ter initialisatie van interne attributen.
	 */
	public void init();

	/**
	 * Toevoegen van een monteur aan de door DaoImpl bijgehouden lijst met monteurs
	 * 
	 * @param monteur
	 *            Monteur die toegevoegd dient te worden
	 */
	public void voegMonteurToe(Monteur monteur);

	/**
	 * Geeft een instantie van de model klasse Monteur terug
	 * 
	 * @param voornaam
	 *            Voornaam van de te zoeken Monteur
	 * @param tussenvoegsel
	 *            Tussenvoegsel van de te zoeken Monteur
	 * @param achternaam
	 *            Achternaam van de te zoeken Monteur
	 * @return Instantie van Monteur indien gevonden, anders null
	 */
	public Monteur zoekMonteur(String voornaam, String tussenvoegsel, String achternaam);

	/**
	 * Verwijderen van Monteur in de door DaoImpl bbjigehouden lijst met monteurs
	 * 
	 * @param monteur
	 *            Monteur die verwijdert dient te worden
	 */
	public void verwijderMonteur(Monteur monteur);

	/**
	 * Geeft een ArrayList van alle door DaoImpl bijgehouden lijst met monteurs
	 * terug
	 * 
	 * @return ArrayList met alle Monteuren
	 */
	public List<Monteur> getAlleMonteurs();
}
