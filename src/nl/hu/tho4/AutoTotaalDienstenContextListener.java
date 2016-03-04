package nl.hu.tho4;

import java.util.Calendar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import nl.hu.tho4.model.Adres;
import nl.hu.tho4.model.Auto;
import nl.hu.tho4.model.Klant;
import nl.hu.tho4.controller.KlantenDao;
import nl.hu.tho4.controller.MonteursDao;
import nl.hu.tho4.controller.WerkzaamhedenDao;
import nl.hu.tho4.controller.impl.KlantenDaoImpl;
import nl.hu.tho4.controller.impl.MonteursDaoImpl;
import nl.hu.tho4.controller.impl.WerkzaamhedenDaoImpl;
import nl.hu.tho4.model.Monteur;

public class AutoTotaalDienstenContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// initialiseren controllers
		KlantenDao klanten = new KlantenDaoImpl(sce.getServletContext());
		klanten.init();

		MonteursDao monteurs = new MonteursDaoImpl(sce.getServletContext());
		monteurs.init();

		WerkzaamhedenDao werkzaamheden = new WerkzaamhedenDaoImpl(sce.getServletContext());
		werkzaamheden.init();

		// Dummy Data
		Auto auto1 = new Auto("Peugeot", "506", "NH-56-KJ", 2001);
		Auto auto2 = new Auto("BMW", "M5", "GHJ-23-K", 2013);
		Auto auto3 = new Auto("Mazda", "626", "ODX-1-00", 1999);
		Auto auto4 = new Auto("Nissan", "GTR", "81-PVJ-1", 2012);
		Auto auto5 = new Auto("Suzuki", "Swift", "1-KBB-00", 2011);

		Adres adres1 = new Adres("Houtstraat", 1, "", "1521GH", "Utrecht");
		Adres adres2 = new Adres("Pinkstraat", 15, "", "1541HC", "Koog aan de Zaan");
		Adres adres3 = new Adres("Verschuurstraat", 21, "", "7891OP", "Hilversum");
		Adres adres4 = new Adres("Bakkerstraat", 67, "", "4652AL", "Hilversum");
		Adres adres5 = new Adres("Houtstraat", 1, "a", "1658FG", "Utrecht");

		Calendar gd1 = Calendar.getInstance();
		Calendar gd2 = Calendar.getInstance();
		Calendar gd3 = Calendar.getInstance();
		Calendar gd4 = Calendar.getInstance();
		Calendar gd5 = Calendar.getInstance();

		gd1.set(1973, 1, 1);
		gd2.set(1994, 9, 3);
		gd3.set(1993, 9, 21);
		gd4.set(1993, 1, 15);
		gd5.set(1973, 1, 1);

		Klant klant1 = new Klant("Henk", "", "Sjaak", gd1, adres1);
		Klant klant2 = new Klant("Liam", "de", "Haas", gd2, adres2);
		Klant klant3 = new Klant("Nathan", "van", "Nispen", gd3, adres3);
		Klant klant4 = new Klant("Frits", "", "Budding", gd4, adres4);
		Klant klant5 = new Klant("Jasper", "is de", "Sjaak", gd5, adres5);

		klanten.voegKlantToe(klant1);
		klanten.voegKlantToe(klant2);
		klanten.voegKlantToe(klant3);
		klanten.voegKlantToe(klant4);
		klanten.voegKlantToe(klant5);

		klanten.voegAutoToe(klant1, auto1);
		klanten.voegAutoToe(klant2, auto2);
		klanten.voegAutoToe(klant3, auto3);
		klanten.voegAutoToe(klant4, auto4);
		klanten.voegAutoToe(klant5, auto5);

		Adres adres6 = new Adres("Bakkersweg", 12, "a", "4687DK", "Lutjebroek");
		Adres adres7 = new Adres("Houtveldweg", 156, "", "4791KL", "Utrecht");
		Adres adres8 = new Adres("Nijenoord", 1, "", "1354HJ", "Amersfoort");
		Adres adres9 = new Adres("Oudenoord", 700, "", "1492RT", "Utrecht");
		Adres adres10 = new Adres("Dorpsstraat", 210, "", "1376HJ", "Utrecht");

		Calendar gd6 = Calendar.getInstance();
		Calendar gd7 = Calendar.getInstance();
		Calendar gd8 = Calendar.getInstance();
		Calendar gd9 = Calendar.getInstance();
		Calendar gd10 = Calendar.getInstance();

		gd6.set(1990, 8, 12);
		gd7.set(1980, 6, 5);
		gd8.set(1975, 2, 19);
		gd9.set(1989, 3, 21);
		gd10.set(1960, 11, 21);

		Monteur m1 = new Monteur("Japie", "van", "Oosten", gd6, adres6);
		Monteur m2 = new Monteur("Kees", "", "Havik", gd7, adres7);
		Monteur m3 = new Monteur("Joop", "", "Zoetemelk", gd8, adres8);
		Monteur m4 = new Monteur("Menno", "de", "Bakker", gd9, adres9);
		Monteur m5 = new Monteur("Wiebrand", "", "Langenbach", gd10, adres10);

		monteurs.voegMonteurToe(m1);
		monteurs.voegMonteurToe(m2);
		monteurs.voegMonteurToe(m3);
		monteurs.voegMonteurToe(m4);
		monteurs.voegMonteurToe(m5);

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}
}
