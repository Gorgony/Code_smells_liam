package nl.hu.tho4.controller;

import java.util.ArrayList;

import nl.hu.tho4.model.Klant;
import nl.hu.tho4.model.Auto;

public interface KlantenDao {
	/**
	 * init methode dient eenmalig alleen door de ContextListener te worden
	 * aangeroepen. Deze methode dient ter initialisatie van interne attributen.
	 */
	public void init();

	/**
	 * Toevoegen van een klant aan de door DaoImpl bijgehouden lijst met klanten
	 * 
	 * @param klant
	 *            Klant die toegevoegd dient te worden
	 */
	public void voegKlantToe(Klant klant);

	/**
	 * Geeft een instantie van de model klasse Klant terug
	 * 
	 * @param voornaam
	 *            Voornaam van de te zoeken Klant
	 * @param tussenvoegsel
	 *            Tussenvoegsel van de te zoeken Klant
	 * @param achternaam
	 *            Achternaam van de te zoeken Klant
	 * @return Instantie van Klant indien gevonden, anders null
	 */
	public Klant zoekKlant(String voornaam, String tussenvoegsel, String achternaam);

	/**
	 * Verwijderen van Klant in de door DaoImpl bbjigehouden lijst met klanten
	 * 
	 * @param klant
	 *            Klant die verwijdert dient te worden
	 */
	public void verwijderKlant(Klant klant);

	/**
	 * Geeft een ArrayList van alle door DaoImpl bijgehouden lijst met klanten
	 * terug
	 * 
	 * @return ArrayList met alle Klanten
	 */
	public List<Klant> getAlleKlanten();

	/**
	 * Auto toevoegen aan Klant
	 * 
	 * @param klant
	 *            Klant waar auto aan toegevoegd dient te worden
	 * @param auto
	 *            Auto die aan de Klant toegevoegd dient te worden
	 */
	public void voegAutoToe(Klant klant, Auto auto);

}
