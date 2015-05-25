package hu.nagymarica.ova4i6.ronkvetelezo.model;



/**
 * 
 * Az alkalmazásban használt vásárlót reprezentáló osztály.
 *
 */
public class Vasarlo {
	/**
	 * A vásárló személyigazolványának száma.
	 */
	private String szemIgSzam;
	
	/**
	 * A vásárló neve.
	 */
	private String nev;
	
	/**
	 * A vásárló lakhelyének irányítószáma.
	 */
	private String iranyitoszam;
	
	/**
	 * A vásárló lakhelye.
	 */
	private String varos;
	
	/**
	 * Annak az utcának a neve, ahol a vásárló lakik.
	 */
	private String utca;
	
	/**
	 * A vásárló házszáma.
	 */
	private int hazszam;
	
	
	/**
	 * Alapértelmezett konstruktor egy vásárló előállításához.
	 */
	public Vasarlo() {
	}

	/**
	 * Konstruktor egy vásárló előállításához.
	 * @param szemIgSzam a vásárló személyigazolványának száma
	 * @param nev a vásárló neve
	 * @param varos a vásárló lakhelye
	 */
	public Vasarlo(String szemIgSzam, String nev, String varos) {
		this.szemIgSzam = szemIgSzam;
		this.nev = nev;
		this.varos = varos;
	}

	/**
	 * Konstruktor egy vásárló előállításához.
	 * @param szemIgSzam a vásárló személyigazolványának száma
	 * @param nev a vásárló neve
	 * @param iranyitoszam a vásárló lakhelyének irányítószáma
	 * @param varos a vásárló lakhelye
	 * @param utca a vásárló utcájának neve
	 * @param hazszam a vásárló házszáma
	 */
	public Vasarlo(String szemIgSzam, String nev, String iranyitoszam, String varos, String utca,
			int hazszam) {
		this.szemIgSzam = szemIgSzam;
		this.nev = nev;
		this.iranyitoszam = iranyitoszam;
		this.varos = varos;
		this.utca = utca;
		this.hazszam = hazszam;
	}

	/**
	 * A vásárló személyigazolvány számának értékét adja vissza.
	 * @return a vásárló személyigazolvány száma
	 */
	public String getSzemIgSzam() {
		return szemIgSzam;
	}

	/**
	 * A vásárló személyigazolvány számának értékét állítja be.
	 * @param szemIgSzam a vásárló személyigazolványának száma
	 */
	public void setSzemIgSzam(String szemIgSzam) {
		this.szemIgSzam = szemIgSzam;
	}

	/**
	 * A vásárló nevét adja vissza.
	 * @return a vásárló neve
	 */
	public String getNev() {
		return nev;
	}

	/**
	 * A vásárló nevét állítja be.
	 * @param nev a vásárló neve
	 */
	public void setNev(String nev) {
		this.nev = nev;
	}

	/**
	 * A vásárló lakhelyének irányítószámát adja vissza.
	 * @return a vásárló lakhelyének irányítószáma
	 */
	public String getIranyitoszam() {
		return iranyitoszam;
	} 

	/**
	 * A vásárló lakhelyének irányítószámát állítja be.
	 * @param iranyitoszam a vásárló lakhelyének irányítószáma
	 */
	public void setIranyitoszam(String iranyitoszam) {
		this.iranyitoszam = iranyitoszam;
	}

	/**
	 * A vásárló lakhelyét adja vissza.
	 * @return a vásárló lakhelye
	 */
	public String getVaros() {
		return varos;
	}

	/**
	 * A vásárló lakhelyét állítja be.
	 * @param varos a vásárló lakhelye
	 */
	public void setVaros(String varos) {
		this.varos = varos;
	}

	/**
	 * Annak az utcának a nevét adja vissza, ahol a vásárló lakik.
	 * @return a vásárló utcájának neve
	 */
	public String getUtca() {
		return utca;
	}

	/**
	 * Annak az utcának a nevét állítja be, ahol a vásárló lakik.
	 * @param utca a vásárló utcájának neve
	 */
	public void setUtca(String utca) {
		this.utca = utca;
	}

	/**
	 * A vásárló házszámát adja vissza.
	 * @return a vásárló házszáma
	 */
	public int getHazszam() {
		return hazszam;
	}

	/**
	 * A vásárló házszámát állítja be.
	 * @param hazszam a vásárló házszáma
	 */
	public void setHazszam(int hazszam) {
		this.hazszam = hazszam;
	}

	
	
	
}
