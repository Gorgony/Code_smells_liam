package nl.hu.tho4.model;

import java.util.Calendar;

/**
 * 
 * @author Liam de Haas
 * @version 1.1
 * 
 */
public class Werkzaamheid {
	private String		werkzaamheidsType;
	private Klant		klant;
	private Auto		auto;
	private String		opmerkingAanmaken;
	private double		verwachteUrenNodig;
	private Calendar	aangemaakt;

	public Werkzaamheid(String werkzaamheidsType, Klant klant, Auto auto, String opmerkingAanmaken, double verwachteUrenNodig) {
		setWerkzaamheidsType(werkzaamheidsType);
		setKlant(klant);
		setAuto(auto);
		setOpmerkingAanmaken(opmerkingAanmaken);
		setVerwachteUrenNodig(verwachteUrenNodig);

		this.aangemaakt = Calendar.getInstance();
	}

	/**
	 * Geeft het werkzaamheidstype van een Werkzaamheid terug
	 * 
	 * @return het werkzaamheidstype
	 */
	public String getWerkzaamheidsType() {
		return werkzaamheidsType;
	}

	/**
	 * Geeft de instantie van de Klant van de Werkzaamheid terug
	 * 
	 * @return instanite van Klant
	 */
	public Klant getKlant() {
		return klant;
	}

	/**
	 * Geeft de instantie van de Auto van de Werkzaamheid terug
	 * 
	 * @return instantie van Auto
	 */
	public Auto getAuto() {
		return auto;
	}

	/**
	 * Geeft de opmerking die mij het aanmaken is meegegeven terug
	 * 
	 * @return de opmerking
	 */
	public String getOpmerkingAanmaken() {
		return opmerkingAanmaken;
	}

	/**
	 * Geeft het verwachte aantal manuren terug dat nodig is voor de
	 * Werkzaamheid
	 * 
	 * @return verwacht aantal manuren
	 */
	public double getVerwachteUrenNodig() {
		return verwachteUrenNodig;
	}

	/**
	 * Geeft de datum terug waarop de Werkzaamheid is aangemaakt
	 * 
	 * @return
	 */
	public Calendar getAangemaakt() {
		return aangemaakt;
	}

	/**
	 * Toekennen van het werkzaamheidstype aan een Werkzaamheid
	 * 
	 * @param werkzaamheidsType
	 */
	private void setWerkzaamheidsType(String werkzaamheidsType) {
		this.werkzaamheidsType = werkzaamheidsType;
	}

	/**
	 * Toekennen van een klant aan een Werkzaamheid
	 * 
	 * @param klant
	 */
	private void setKlant(Klant klant) {
		this.klant = klant;
	}

	/**
	 * Toekennen van een Auto aan een Werkzaamheid
	 * 
	 * @param auto
	 */
	private void setAuto(Auto auto) {
		this.auto = auto;
	}

	/**
	 * Toekennen van een opmerking bij het aanmaken van een Werkzaamheid
	 * 
	 * @param opmerkingAanmaken
	 */
	private void setOpmerkingAanmaken(String opmerkingAanmaken) {
		this.opmerkingAanmaken = opmerkingAanmaken;
	}

	/**
	 * Toekennen van het verwachte aantal manuren dat nodig is voor een
	 * Werkzaamheid
	 * 
	 * @param verwachteUrenNodig
	 */
	private void setVerwachteUrenNodig(double verwachteUrenNodig) {
		this.verwachteUrenNodig = verwachteUrenNodig;
	}
}
