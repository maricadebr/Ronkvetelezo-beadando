package hu.nagymarica.ova4i6.ronkvetelezo.model;

/**
 * 
 * Az alkalmazásban használt vásárlást reprezentáló osztály.
 *
 */
public class Vasarlas {
	
	/**
	 * A vásárlás azonosiójának értéke.
	 */
	private int vasarlas_azon;
	
	/**
	 * A vásárló személyigazolvány száma.
	 */
	private String vasarlo_azon;
	
	/**
	 * A vásárolt rönk azonosítója.
	 */
	private int faj_azon;
	
	/**
	 * Az adott fafajtájú rönkből vásárolt köbméter.
	 */
	private double vasarolt_kobmeter;
	
	/**
	 * A vásárlás soránk keletkezett költség.
	 */
	private int fizetendo_osszeg;
	
	
	/**
	 * Alapértelmezett konstruktor egy vásárlás előállításához.
	 */
	public Vasarlas() {}

	/**
	 * Konstruktor egy vásárlás előállításához.
	 * @param vasarlas_azon a vásárlás azonosítója
	 * @param vasarlo_azon a vásárló személyigazolvány száma
	 * @param faj_azon a vásárolt rönk azonosítója
	 * @param vasarolt_kobmeter az adott fafajtájú rönkből vásárolt köbméter.
	 * @param fizetendo_osszeg a vásárlás soránk keletkezett költség.
	 */
	public Vasarlas(int vasarlas_azon, String vasarlo_azon, int faj_azon,
			double vasarolt_kobmeter, int fizetendo_osszeg) {
		this.vasarlas_azon = vasarlas_azon;
		this.vasarlo_azon = vasarlo_azon;
		this.faj_azon = faj_azon;
		this.vasarolt_kobmeter = vasarolt_kobmeter;
		this.fizetendo_osszeg = fizetendo_osszeg;
	} 

	/**
	 * A vásárlás azonosítóját adja vissza.
	 * @return a vásárlás azonosítója
	 */
	public int getVasarlas_azon() {
		return vasarlas_azon;
	}

	/**
	 * A vásárlás azonosítóját állítja be.
	 * @param vasarlas_azon a vásárlás azonosítója
	 */
	public void setVasarlas_azon(int vasarlas_azon) {
		this.vasarlas_azon = vasarlas_azon;
	}

	/**
	 * A vásárló személyigazolvány számát adja vissza.
	 * @return a vásárló személyigazolvány száma
	 */
	public String getVasarlo_azon() {
		return vasarlo_azon;
	}

	/**
	 * A vásárló személyigazolvány számát állítja be.
	 * @param vasarlo_azon a vásárló személyigazolvány száma
	 */
	public void setVasarlo_azon(String vasarlo_azon) {
		this.vasarlo_azon = vasarlo_azon;
	}

	/**
	 * A vásárolt rönk azonosítáját adja vissza.
	 * @return a vásárolt rönk azonosítója
	 */
	public int getFaj_azon() {
		return faj_azon;
	}

	/**
	 * A vásárolt rönk azonosítáját állítja be.
	 * @param faj_azon a vásárolt rönk azonosítója
	 */
	public void setFaj_azon(int faj_azon) {
		this.faj_azon = faj_azon;
	}

	/**
	 * Az adott fafajtájú rönkből vásárolt köbméter értékét adja vissza.
	 * @return az adott fafajtájú rönkből vásárolt köbméter.
	 */
	public double getVasarolt_kobmeter() {
		return vasarolt_kobmeter;
	}

	
	/**
	 * Az adott fafajtájú rönkből vásárolt köbméter értékét állítja be.
	 * @param vasarolt_kobmeter az adott fafajtájú rönkből vásárolt köbméter
	 */
	public void setVasarolt_kobmeter(double vasarolt_kobmeter) {
		this.vasarolt_kobmeter = vasarolt_kobmeter;
	}

	/**
	 * A vásárlás soránk keletkezett költséget adja vissza.
	 * @return a vásárlás soránk keletkezett költség
	 */
	public int getFizetendo_osszeg() {
		return fizetendo_osszeg;
	}

	/**
	 * A vásárlás soránk keletkezett költséget állítja be.
	 * @param fizetendo_osszeg a vásárlás soránk keletkezett költség
	 */
	public void setFizetendo_osszeg(int fizetendo_osszeg) {
		this.fizetendo_osszeg = fizetendo_osszeg;
	}

	
}
