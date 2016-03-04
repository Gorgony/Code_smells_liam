package nl.hu.tho4.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.tho4.controller.KlantenDao;
import nl.hu.tho4.controller.impl.KlantenDaoImpl;
import nl.hu.tho4.controller.impl.MonteursDaoImpl;
import nl.hu.tho4.model.Auto;
import nl.hu.tho4.model.Klant;

public class AutoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		KlantenDao klanten = new KlantenDaoImpl(getServletContext());
		MonteursDaoImpl monteurs = new MonteursDaoImpl(getServletContext());

		// kijken of het om een bestaande of nieuwe auto gaat
		String autoString = req.getParameter("auto");

		if ("nieuweAuto".equals(autoString)) {
			// ophalen autogegevens
			String merk = req.getParameter("merk");
			String model = req.getParameter("model");
			String kenteken = req.getParameter("kenteken");
			int bouwjaar = isInt(req.getParameter("bouwjaar"));

			// ophalen geselecteerde klant
			Klant geselecteerdeKlant = (Klant) req.getSession().getAttribute("geselecteerdeKlant");

			// nieuwe auto aanmaken
			Auto nieuweAuto = new Auto(merk, model, kenteken, bouwjaar);

			// auto aan klant koppelen
			klanten.voegAutoToe(geselecteerdeKlant, nieuweAuto);

			// nieuwe auto in sessie zetten
			req.getSession().setAttribute("geselecteerdeAuto", nieuweAuto);
		} else {
			// zoeken van auto
			Klant geselecteerdeKlant = (Klant) req.getSession().getAttribute("geselecteerdeKlant");
			Auto geselecteerdeAuto = geselecteerdeKlant.zoekAuto(autoString);

			// auto in de sessie zetten
			req.getSession().setAttribute("geselecteerdeAuto", geselecteerdeAuto);
		}

		// max aantal manuren in de sessie zetten zodat WerkzaamheidAanmaken.jsp
		// die kan gebruiken
		ArrayList<Double> manuren = monteurs.getMogelijkeManuren();
		req.getSession().setAttribute("mogelijkeManuren", manuren);

		// doorgaan naar WerkzaamheidAanmaken.jsp
		RequestDispatcher rd = req.getRequestDispatcher("WerkzaamheidAanmaken.jsp");
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
