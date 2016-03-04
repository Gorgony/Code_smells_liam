package nl.hu.tho4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hu.tho4.controller.WerkzaamhedenDao;
import nl.hu.tho4.controller.impl.WerkzaamhedenDaoImpl;
import nl.hu.tho4.model.*;

public class WerkzaamheidServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		WerkzaamhedenDao werkzaamheden = new WerkzaamhedenDaoImpl(getServletContext());

		// ophalen werkzaamheidsgegevens
		double manuren = Double.parseDouble(req.getParameter("manuren"));
		String opmerking = req.getParameter("opmerking");
		String werkzaamheidsType = req.getParameter("type");

		// ophalen auto en klant
		Klant geselecteerdeKlant = (Klant) req.getSession().getAttribute("geselecteerdeKlant");
		Auto geselecteerdeAuto = (Auto) req.getSession().getAttribute("geselecteerdeAuto");

		// aanmaken Werkzaamheid
		Werkzaamheid nieuweWerkzaamheid = new Werkzaamheid(werkzaamheidsType, geselecteerdeKlant, geselecteerdeAuto, opmerking, manuren);
		werkzaamheden.voegWerkzaamheidToe(nieuweWerkzaamheid);

		// doorgaan naar WerkzaamhedenOverzicht.jsp
		RequestDispatcher rd = req.getRequestDispatcher("WerkzaamhedenOverzicht.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
