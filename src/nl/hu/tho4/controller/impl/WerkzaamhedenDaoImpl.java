package nl.hu.tho4.controller.impl;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletContext;

import nl.hu.tho4.controller.WerkzaamhedenDao;
import nl.hu.tho4.model.Auto;
import nl.hu.tho4.model.Klant;
import nl.hu.tho4.model.Werkzaamheid;

public class WerkzaamhedenDaoImpl implements WerkzaamhedenDao {
	public static final String ALLE_WERKZAAMHEDEN = "alleWerkzaamheden";
	private static ServletContext	servletContext;

	private ArrayList<Werkzaamheid>	alleWerkzaamheden;

	/**
	 * Constructor waar de ServletContext geset wordt
	 * 
	 * @param servletContext
	 *            De ServletContext die nodig is voor alle bewerkingen
	 */
	public WerkzaamhedenDaoImpl(ServletContext servletContext) {
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
		WerkzaamhedenDaoImpl.servletContext = servletContext;
	}

	@Override
	public void init() {
		alleWerkzaamheden = new ArrayList<>();
		getServletContext().setAttribute(ALLE_WERKZAAMHEDEN, alleWerkzaamheden);
	}

	@Override
	public void voegWerkzaamheidToe(Werkzaamheid werkzaamheid) {
		alleWerkzaamheden = (ArrayList<Werkzaamheid>) getServletContext().getAttribute(ALLE_WERKZAAMHEDEN);
		alleWerkzaamheden.add(werkzaamheid);
		getServletContext().setAttribute(ALLE_WERKZAAMHEDEN, alleWerkzaamheden);
	}

	@Override
	public Werkzaamheid zoekWerkzaamheid(Klant klant, Auto auto, String werkzaamheidsType, Calendar aangemaakt) {
		alleWerkzaamheden = (ArrayList<Werkzaamheid>) getServletContext().getAttribute(ALLE_WERKZAAMHEDEN);
		Werkzaamheid gevondenWerkzaamheid = null;
		for (Werkzaamheid w : alleWerkzaamheden) {
			if (w.getKlant().equals(klant) && w.getAuto().equals(auto) && w.getWerkzaamheidsType().equals(werkzaamheidsType) && w.getAangemaakt().equals(aangemaakt)) {
				gevondenWerkzaamheid = w;
			}
		}
		return gevondenWerkzaamheid;
	}

	@Override
	public void verwijderWerkzaamheid(Werkzaamheid werkzaamheid) {
		alleWerkzaamheden = (ArrayList<Werkzaamheid>) getServletContext().getAttribute(ALLE_WERKZAAMHEDEN);

		alleWerkzaamheden.remove(werkzaamheid);

		getServletContext().setAttribute(ALLE_WERKZAAMHEDEN, alleWerkzaamheden);
	}

	@Override
	public List<Werkzaamheid> getAlleWerkzaamheden() {
		alleWerkzaamheden = (ArrayList<Werkzaamheid>) getServletContext().getAttribute(ALLE_WERKZAAMHEDEN);
		return alleWerkzaamheden;
	}
}
