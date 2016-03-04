package nl.hu.tho4.view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.tho4.controller.KlantenDao;
import nl.hu.tho4.controller.impl.KlantenDaoImpl;
import nl.hu.tho4.model.Adres;
import nl.hu.tho4.model.Klant;

public class KlantServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		KlantenDao klanten = new KlantenDaoImpl(getServletContext());

		// kijken of het om een bestaande of nieuwe klant gaat
		String klantString = req.getParameter("klant");

		if ("nieuweKlant".equals(klantString)) {
			// ophalen klantgegevens
			String voornaam = req.getParameter("voornaam");
			String tussenvoegsel = req.getParameter("tussenvoegsel");
			String achternaam = req.getParameter("achternaam");
			String geboorteDatumString = req.getParameter("geboortedatum");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			Calendar geboorteDatum = Calendar.getInstance();
			try {
				geboorteDatum.setTime(sdf.parse(geboorteDatumString));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			// ophalen adresgegevens
			String straat = req.getParameter("straatnaam");
			int huisnummer = isInt(req.getParameter("huisnummer"));
			String toevoeging = req.getParameter("toevoeging");
			String postcode = req.getParameter("postcode");
			String woonplaats = req.getParameter("woonplaats");

			// nieuwe Klant aanmaken
			Adres nieuwAdres = new Adres(straat, huisnummer, toevoeging, postcode, woonplaats);
			Klant nieuweKlant = new Klant(voornaam, tussenvoegsel, achternaam, geboorteDatum, nieuwAdres);

			// nieuwe klant aan servletcontext en sessie toevoegen
			klanten.voegKlantToe(nieuweKlant);
			req.getSession().setAttribute("geselecteerdeKlant", nieuweKlant);

		} else {
			// geselecteerde klant ophalen en in sessie zetten
			String[] klant = klantString.split("-");
			Klant geselecteerdeKlant = klanten.zoekKlant(klant[0], klant[1], klant[2]);

			req.getSession().setAttribute("geselecteerdeKlant", geselecteerdeKlant);
		}

		// huidigjaar in de sessie zetten zodat die in AutoSelectie.jsp gebruikt
		// kan worden
		int huidigJaar = Calendar.getInstance().get(Calendar.YEAR);
		req.getSession().setAttribute("huidigJaar", huidigJaar);

		// doorgaan naar AutoSelectie.jsp
		RequestDispatcher rd = req.getRequestDispatcher("AutoSelectie.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * controleert of de gegeven String een int is.
	 * 
	 * @param s
	 *            de doorgegeven String die moet worden gecontroleert.
	 * @return de int die terug wordt gegeven als het een int is, en anders -1.
	 */
	private int isInt(String s) {
		int i;
		if (!"".equals(s)) {
			try {
				i = Integer.parseInt(s);
			} catch (NumberFormatException exc) {
				i = -1;
			}
		} else {
			i = -1;
		}
		return i;
	}
}
