package nl.hu.tho4.model;

/**
 * 
 * @author Liam de Haas
 * @version 1.1
 */
public class Adres {

	private String	straat;
	private int		huisnummer;
	private String	toevoeging;
	private String	postcode;
	private String	woonplaats;

	public Adres(String straat, int huisnummer, String toevoeging, String postcode, String woonplaats) {
		setStraat(straat);
		setHuisnummer(huisnummer);
		setToevoeging(toevoeging);
		setPostcode(postcode);
		setWoonplaats(woonplaats);
	}

	/**
	 * Geeft de straat van het Adres terug
	 * 
	 * @return de straat
	 */
	public String getStraat() {
		return straat;
	}

	/**
	 * Toekennen van de straat aan het Adres
	 * 
	 * @param straat
	 */
	public void setStraat(String straat) {
		this.straat = straat;
	}

	/**
	 * Geeft het huisnummer van het Adres terug
	 * 
	 * @return het huisnummer
	 */
	public int getHuisnummer() {
		return huisnummer;
	}

	/**
	 * Toekennen van het huisnummer aan het Adres
	 * 
	 * @param huisnummer
	 */
	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	/**
	 * Geeft de toevoeging van het adres terug
	 * 
	 * @return de toevoeging
	 */
	public String getToevoeging() {
		return toevoeging;
	}

	/**
	 * Toekennen van de toevoeging aan een Adres
	 * 
	 * @param toevoeging
	 */
	public void setToevoeging(String toevoeging) {
		this.toevoeging = toevoeging;
	}

	/**
	 * Geeft de postcode van het Adres terug
	 * 
	 * @return de postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * Toekennen van de postcode aan een Adres
	 * 
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		if (postcode.matches("^[1-9][0-9]{3}\\s?((?!SS|SA|SD)[a-zA-Z]{2})?$"))
			this.postcode = postcode;
	}

	/**
	 * Geeft de woonplaats van het Adres terug
	 * 
	 * @return de woonplaats
	 */
	public String getWoonplaats() {
		return woonplaats;
	}

	/**
	 * Toekennen van de woonplaats aan een adres
	 * 
	 * @param woonplaats
	 */
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

}
