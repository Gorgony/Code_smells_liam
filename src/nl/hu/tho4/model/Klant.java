package nl.hu.tho4.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 * @author Liam de Haas
 * @version 1.1
 */

public class Klant implements Persoon {
	private String 			tussenvoegsel;
	private String			voornaam;
	private String 			achternaam;
	private Calendar		geboorteDatum;
	private Adres			adres;
	private ArrayList<Auto>	alleAutos;

	/**
	 * Constructor van Klant.
	 * 
	 * @param voornaam
	 *            Voornaam van de Klant
	 * @param tussenvoegsel
	 *            tussenvoegsel van de Klant
	 * @param achternaam
	 *            Achternaam van de Klant
	 * @param geboorteDatum
	 *            Geboortedatum van de Klant
	 * @param adres
	 *            Adres van de Klant
	 */
	public Klant(String voornaam, String tussenvoegsel, String achternaam, Calendar geboorteDatum, Adres adres) {
		setVoornaam(voornaam);
		setTussenvoegsel(tussenvoegsel);
		setAchternaam(achternaam);
		setGeboorteDatum(geboorteDatum);
		setAdres(adres);

		alleAutos = new ArrayList<>();
	}

	/**
	 * Voegt de Auto auto toe aan alleAutos indien diegene de auto nog niet
	 * bezit.
	 * 
	 * @param auto
	 *            Auto die toegevoegd wordt aan alleAutos
	 * @return true als de Auto auto is toegevoegd
	 */
	public boolean voegAutoToe(Auto auto) {
		boolean toegevoegd = false;
		if (zoekAuto(auto.getKenteken()) == null) {
			alleAutos.add(auto);
			toegevoegd = true;
		}
		return toegevoegd;
	}

	/**
	 * Zoekt de auto behorende bij het kenteken.
	 * 
	 * @param kenteken
	 *            Kenteken van de auto waarop gezocht wordt
	 * @return de Auto die bij het kenteken hoort, als er geen auto gevonden kan
	 *         worden null
	 */
	public Auto zoekAuto(String kenteken) {
		Auto gevondenAuto = null;
		for (Auto a : getAlleAutos()) {
			if (a.getKenteken().equals(kenteken)) {
				gevondenAuto = a;
			}
		}
		return gevondenAuto;
	}

	public int getLeeftijd() {
		Calendar cal = getGeboorteDatum();
		Calendar now = Calendar.getInstance();

		int leeftijd = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
		if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
				|| (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
			leeftijd--;
		}
		return leeftijd;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String naam) {
		this.voornaam = naam;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Calendar getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(Calendar geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	/**
	 * 
	 * @return ArrayList met alle Auto's
	 */
	public List<Auto> getAlleAutos() {
		return alleAutos;
	}

	/**
	 * Geeft de volledige naam van de klant
	 * 
	 * @return De volledige naam van de klant in het formaat : achternaam,
	 *         voornaam tussenvoegsel
	 */
	public String getVolledigeNaam() {
		return getAchternaam() + ", " + getVoornaam() + " " + getTussenvoegsel();
	}
}
