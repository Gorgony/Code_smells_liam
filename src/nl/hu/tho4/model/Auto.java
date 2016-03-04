package nl.hu.tho4.model;


/**
 * 
 * @author Liam de Haas
 * @version 1.1
 */

public class Auto {
	private String	merk, kenteken, model;
	private int		bouwjaar;

	public Auto(String merk, String model, String kenteken, int bouwjaar) {
		setMerk(merk);
		setKenteken(kenteken);
		setModel(model);
		setBouwjaar(bouwjaar);
	}

	/**
	 * Geeft het merk van de Auto terug
	 * @return het merk
	 */
	public String getMerk() {
		return merk;
	}

	/**
	 * Toekennen van het merk aan een Auto
	 * @param merk
	 */
	public void setMerk(String merk) {
		this.merk = merk;
	}

	/**
	 * Geeft het kenteken van de Auto terug
	 * @return het kenteken
	 */
	public String getKenteken() {
		return kenteken;
	}

	/**
	 * Toekennen van het kenteken aan een Auto
	 * @param kenteken
	 */
	public void setKenteken(String kenteken) {
		this.kenteken = kenteken;
	}

	/**
	 * Geeft het model van de Auto terug
	 * @return
	 */
	public String getModel() {
		return model;
	}

	/**
	 * toekennen van het model van de Auto
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Geeft het bouwjaar van de Auto terug
	 * @return het bouwjaar
	 */
	public int getBouwjaar() {
		return bouwjaar;
	}

	/**
	 * Toekennen van het bouwjaar aan een Auto
	 * @param bouwjaar
	 */
	public void setBouwjaar(int bouwjaar) {
		this.bouwjaar = bouwjaar;
	}

}
