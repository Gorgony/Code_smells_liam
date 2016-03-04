package nl.hu.tho4.model;

import java.util.Calendar;

/**
 * 
 * @author Liam de Haas
 * @version 1.0
 */

public interface Persoon {
	/**
	 * 
	 * @param voornaam
	 *            Vooraam van de Persoon
	 */
	void setVoornaam(String voornaam);

	/**
	 * 
	 * @return Vooraam van de Persoon
	 */
	String getVoornaam();

	/**
	 * 
	 * @param tussenvoegsel
	 *            Tussenvoegsel van de Persoon
	 */
	void setTussenvoegsel(String tussenvoegsel);

	/**
	 * 
	 * @return Tussenvoegsel van de Persoon
	 */
	String getTussenvoegsel();

	/**
	 * 
	 * @param achternaam
	 *            Achternaam van de Persoon
	 */
	void setAchternaam(String achternaam);

	/**
	 * 
	 * @return Achternaam van de Persoon
	 */
	String getAchternaam();

	/**
	 * 
	 * @param geboorteDatum
	 *            Geboortedatum van de Persoon
	 */
	void setGeboorteDatum(Calendar geboorteDatum);

	/**
	 * 
	 * @return Geboortedatum van de Persoon
	 */
	Calendar getGeboorteDatum();

	/**
	 * 
	 * @param adres
	 *            Adres van de Persoon
	 */
	void setAdres(Adres adres);

	/**
	 * 
	 * @return Adres van de Persoon
	 */
	Adres getAdres();

	/**
	 * 
	 * @return Leeftijd van de Persoon in jaren
	 */
	int getLeeftijd();
}
