package ch.zhaw.exercise.le05a.task8;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Person {
	private String name;
	private String vorname;
	private GregorianCalendar geburtsdatum;
	private String strasse;
	private String wohnort;
	private String hausnummer;
	private int plz;

	public Person()
	{
		this.name = "";
		this.vorname = "";
		this.geburtsdatum = null;
		this.strasse = "";
		this.wohnort = "";
		this.hausnummer = "";
		this.plz = 0;
	}

	public Person(String name, String vorname, GregorianCalendar geburtsdatum, String strasse,
					String hausnummer, String wohnort, int plz)
	{
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.strasse = strasse;
		this.wohnort = wohnort;
		this.hausnummer = hausnummer;
		this.plz = plz;
	}

	public int getAlter()
	{
		GregorianCalendar heute = new GregorianCalendar();
		int alter = heute.get(Calendar.YEAR) - geburtsdatum.get(Calendar.YEAR);
		if (heute.get(Calendar.DAY_OF_YEAR) < geburtsdatum.get(Calendar.DAY_OF_YEAR))
		{
			alter--;
		}
		return alter;
	}

	public String  print() {
		SimpleDateFormat df = new SimpleDateFormat("dd. MMMM yyyy");
		return (vorname + " " + name + "\n"
							+ strasse + " " + hausnummer + "\n"
							+ plz + " " + wohnort + "\n"
							+ "Geburtsdatum: " + df.format(geburtsdatum.getTime()) + "\n"
							+ getAlter() + " Jahre alt.\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public GregorianCalendar getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(GregorianCalendar geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getWohnort() {
		return wohnort;
	}

	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}
}
