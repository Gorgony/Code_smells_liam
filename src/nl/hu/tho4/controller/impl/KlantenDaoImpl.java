package nl.hu.tho4.controller.impl;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import nl.hu.tho4.controller.KlantenDao;
import nl.hu.tho4.model.Auto;
import nl.hu.tho4.model.Klant;

/**
 * Klasse waar alle bewerkingen aan klanten plaatsvinden
 * 
 * @author Liam de Haas
 * @version 1.0
 */

public class KlantenDaoImpl implements KlantenDao {
	public static final String ALLE_KLANTEN = "alleKlanten";
	private static ServletContext	servletContext;

	private ArrayList<Klant>		alleKlanten;

	/**
	 * Constructor waar de ServletContext geset wordt
	 * 
	 * @param servletContext
	 *            De ServletContext die nodig is voor alle bewerkingen
	 */
	public KlantenDaoImpl(ServletContext servletContext) {
		setServletContext(servletContext);
	}

	/**
	 * Geeft een instantie van ServletContext terug
	 * 
	 * @return De ServletContext
	 */
	private static ServletContext getServletContext() {
		return servletContext;
	}

	/**
	 * Toekennen van de ServletContext
	 * 
	 * @param servletContext
	 */
	private static void setServletContext(ServletContext servletContext) {
		KlantenDaoImpl.servletContext = servletContext;
	}

	@Override
	public void init() {
		alleKlanten = new ArrayList<>();
		getServletContext().setAttribute(ALLE_KLANTEN, alleKlanten);
	}

	@Override
	public void voegKlantToe(Klant klant) {
		alleKlanten = (ArrayList<Klant>) getServletContext().getAttribute(ALLE_KLANTEN);
		if (zoekKlant(klant.getVoornaam(), klant.getTussenvoegsel(), klant.getAchternaam()) == null) {
			alleKlanten.add(klant);
		}
		getServletContext().setAttribute(ALLE_KLANTEN, alleKlanten);
	}

	@Override
	public Klant zoekKlant(String voornaam, String tussenvoegsel, String achternaam) {
		alleKlanten = (ArrayList<Klant>) getServletContext().getAttribute(ALLE_KLANTEN);
		Klant gevondenKlant = null;
		for (Klant k : alleKlanten) {
			if (k.getVoornaam().equals(voornaam) && k.getTussenvoegsel().equals(tussenvoegsel) && k.getAchternaam().equals(achternaam)) {
				gevondenKlant = k;
			}
		}
		return gevondenKlant;
	}

	@Override
	public void verwijderKlant(Klant klant) {
		alleKlanten = (ArrayList<Klant>) getServletContext().getAttribute(ALLE_KLANTEN);

		alleKlanten.remove(klant);

		getServletContext().setAttribute(ALLE_KLANTEN, alleKlanten);
	}

	@Override
	public List<Klant> getAlleKlanten() {
		alleKlanten = (ArrayList<Klant>) getServletContext().getAttribute(ALLE_KLANTEN);
		return alleKlanten;
	}

	@Override
	public void voegAutoToe(Klant klant, Auto auto) {
		klant.voegAutoToe(auto);
		getServletContext().setAttribute(ALLE_KLANTEN, alleKlanten);
	}

}
