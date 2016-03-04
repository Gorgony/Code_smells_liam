package nl.hu.tho4.controller;

import java.util.ArrayList;
import java.util.Calendar;

import nl.hu.tho4.model.Auto;
import nl.hu.tho4.model.Klant;
import nl.hu.tho4.model.Werkzaamheid;

public interface WerkzaamhedenDao {
	/**
	 * init methode dient eenmalig alleen door de ContextListener te worden
	 * aangeroepen. Deze methode dient ter initialisatie van interne attributen.
	 */
	public void init();

	/**
	 * Toevoegen van een werkzaamheid aan de door DaoImpl bijgehouden lijst met
	 * Werkzaamheden
	 * 
	 * @param werkzaamheid
	 *            Werkzaamheid die toegevoegd dient te worden
	 */
	public void voegWerkzaamheidToe(Werkzaamheid werkzaamheid);

	/**
	 * Geeft een instantie van de model klasse Werkzaamheid terug
	 * 
	 * @param klant
	 *            Klant die bij de gezochte Werkzaamheid hoort
	 * @param auto
	 *            Auto die bij de gezochte Werkzaamheid hoort
	 * @param werkzaamheidsType
	 *            Type vanm de gezocht Werkzaamheid
	 * @param aangemaakt
	 *            Datum waarop de gezochte Werkzaamheid is aangemaakt
	 * @return Instantie van Werkzaamheid indien gevonden, anders null
	 */
	public Werkzaamheid zoekWerkzaamheid(Klant klant, Auto auto, String werkzaamheidsType, Calendar aangemaakt);

	/**
	 * Verwijderen van Werkzaamheid in de door DaoImpl bbjigehouden lijst met
	 * Werkzaamheden
	 * 
	 * @param werkzaamheid
	 *            Werkzaamheid die verwijdert dient te worden
	 */
	public void verwijderWerkzaamheid(Werkzaamheid werkzaamheid);

	/**
	 * Geeft een ArrayList van alle door DaoImpl bijgehouden lijst met
	 * Werkzaamheden terug
	 * 
	 * @return ArrayList met alle Werkzaamheden
	 */
	public List<Werkzaamheid> getAlleWerkzaamheden();

}
