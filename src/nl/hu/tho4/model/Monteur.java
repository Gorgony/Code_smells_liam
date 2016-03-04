package nl.hu.tho4.model;

import java.util.Calendar;

/**
 *
 * @author Liam de Haas
 * @version 1.1
 */

public class Monteur implements Persoon {
    private String		voornaam;
    private String      tussenvoegsel;
    private String      achternaam;
    private Calendar	geboorteDatum;
    private Adres		adres;

    public Monteur(String voornaam, String tussenvoegsel, String achternaam, Calendar geboorteDatum, Adres adres) {
        setVoornaam(voornaam);
        setTussenvoegsel(tussenvoegsel);
        setAchternaam(achternaam);
        setGeboorteDatum(geboorteDatum);
        setAdres(adres);
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
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
}
