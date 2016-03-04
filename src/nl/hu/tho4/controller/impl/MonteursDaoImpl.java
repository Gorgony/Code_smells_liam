package nl.hu.tho4.controller.impl;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import nl.hu.tho4.controller.MonteursDao;
import nl.hu.tho4.model.Monteur;

/**
 * Klasse waar alle bewerkingen aan monteurs plaatsvinden
 * 
 * @author Liam de Haas
 * @version 1.0
 */

public class MonteursDaoImpl implements MonteursDao {
	public static final String ALLE_MONTEURS = "alleMonteurs";
	private static ServletContext	servletContext;

	private ArrayList<Monteur>		alleMonteurs;

	/**
	 * Constructor waar de ServletContext geset wordt
	 * 
	 * @param servletContext
	 *            De ServletContext die nodig is voor alle bewerkingen
	 */
	public MonteursDaoImpl(ServletContext servletContext) {
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
		MonteursDaoImpl.servletContext = servletContext;
	}

	@Override
	public void init() {
		alleMonteurs = new ArrayList<>();
		getServletContext().setAttribute(ALLE_MONTEURS, alleMonteurs);
	}

	@Override
	public void voegMonteurToe(Monteur monteur) {
		alleMonteurs = (ArrayList<Monteur>) getServletContext().getAttribute(ALLE_MONTEURS);
		if (zoekMonteur(monteur.getVoornaam(), monteur.getTussenvoegsel(), monteur.getAchternaam()) == null) {
			alleMonteurs.add(monteur);
		}
		getServletContext().setAttribute(ALLE_MONTEURS, alleMonteurs);

	}

	@Override
	public Monteur zoekMonteur(String voornaam, String tussenvoegsel, String achternaam) {
		alleMonteurs = (ArrayList<Monteur>) getServletContext().getAttribute(ALLE_MONTEURS);
		Monteur gevondenMonteur = null;
		for (Monteur m : alleMonteurs) {
			if (m.getVoornaam().equals(voornaam) && m.getTussenvoegsel().equals(tussenvoegsel) && m.getAchternaam().equals(achternaam)) {
				gevondenMonteur = m;
			}
		}
		return gevondenMonteur;
	}

	@Override
	public void verwijderMonteur(Monteur monteur) {
		alleMonteurs = (ArrayList<Monteur>) getServletContext().getAttribute(ALLE_MONTEURS);

		alleMonteurs.remove(monteur);

		getServletContext().setAttribute(ALLE_MONTEURS, alleMonteurs);

	}

	@Override
	public List<Monteur> getAlleMonteurs() {
		alleMonteurs = (ArrayList<Monteur>) getServletContext().getAttribute(ALLE_MONTEURS);
		return alleMonteurs;
	}

	/**
	 * Geeft een ArrayList van 0.0 tot max aantal manuren mogelijk
	 * 
	 * @return ArrayList met doubles
	 */
	public List<Double> getMogelijkeManuren() {
		ArrayList<Double> manuren = new ArrayList<>();
		alleMonteurs = (ArrayList<Monteur>) getServletContext().getAttribute(ALLE_MONTEURS);

		for (double i = 0.5; i <= (alleMonteurs.size() * 8); i += 0.5) {
			manuren.add(i);
		}

		return manuren;
	}

}
