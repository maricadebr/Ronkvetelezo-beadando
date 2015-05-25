package hu.nagymarica.ova4i6.ronkvetelezo.model;

/**
 * 
 * Az alkalmazásban használ rönköket reprezentáló osztály.
 *
 */

public class Ronk {
	
	/**
	 * A rönk átmerőjének értéke (centiméterben).
	 */
	private int atmero;
	
	/**
	 * A rönk hosszának értéke (méterben).
	 */
	private double hossz;
	
	/**
	 * A rönk fajtájának azonosítására szolgáló érték.
	 */
	private int faj_azon;
	
	/**
	 * A rönk mennyiségének értéke.
	 */
	private int mennyiseg;
	

	/**
	 * Alapértelmezett konstruktor egy rönk előállításához.
	 */
	public Ronk(){}
	
	/**
	 * Konstruktor egy rönk előállításához.
	 * @param faj_azon a rönkhöz tartozó azonosító
	 */
	public Ronk(int faj_azon) {
		this.faj_azon = faj_azon;
	}
	
	/**
	 * Konstruktor egy rönk előállításához.
	 * @param atmero a rönk átmérője
	 * @param hossz a rönk hosszúsága
	 * @param faj_azon a rönk azonosítója
	 * @param mennyiseg az adott típusú rönk darabszáma
	 */
	public Ronk(int atmero, double hossz, int faj_azon, int mennyiseg) {
		super();
		this.atmero = atmero;
		this.hossz = hossz;
		this.faj_azon = faj_azon;
		this.mennyiseg = mennyiseg;
	}

	/**
	 * A rönk azonosítóját adja vissza.
	 * @return a rönk azonosítója
	 */
	public int getFajAzon() {
		return faj_azon;
	}

	/**
	 * A rönk azonosítójának értékét állítja be.
	 * @param faj_azon a rönk azonosítója
	 */
	public void setFajAzon(int faj_azon) {
		this.faj_azon = faj_azon;
	}
	
	/**
	 * A rönk átmérőjének értékét adja vissza.
	 * A mértékegysége centiméterben értendő.
	 * @return a rönk átmerőjének értéke
	 */
	public int getAtmero() {
		return atmero;
	}
	
	/**
	 * A rönk átmérőjének értékét állítja be.
	 * A mértékegysége centiméterben értendő
	 * @param atmero a rönk átmérője
	 */
	public void setAtmero(int atmero) {
		this.atmero = atmero;
	}

	/**
	 * A rönk hosszúságának értékét adja vissza.
	 * A mértékegysége méterben értendő.
	 * @return a rönk hosszúságának értéke
	 */
	public double getHossz() {
		return hossz;
	}

	/**
	 * A rönk hosszúságának értékét állítja be.
	 * A mértékegysége méterben értendő.
	 * @param hossz a rönk hosszúsága
	 */
	public void setHossz(double hossz) {
		this.hossz = hossz;
	}

	/**
	 * Az adott típusú rönk darabszámának értékét adja vissza.
	 * @return az adott típusú rönk darabszámának értéke
	 */
	public int getMennyiseg() {
		return mennyiseg;
	}

	/**
	 * Az adott típusú rönk darabszámának értékét állítja be.
	 * @param mennyiseg az adott típusú rönk darabszáma
	 */
	public void setMennyiseg(int mennyiseg) {
		this.mennyiseg = mennyiseg;
	}

	/**
	 * Két rönk összehasonlítására szolgáló metódus.
	 * @param obj az a rönk amit hasonlítunk az adott rönkhöz
	 * @return <code>true</code> ha az adott rönk ugyan olyan, mint paraméterként megadott rönk; 
     *        <code>false</code> egyébként.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ronk other = (Ronk) obj;
		if (atmero != other.atmero)
			return false;
		if (faj_azon != other.faj_azon)
			return false;
		if (Double.doubleToLongBits(hossz) != Double
				.doubleToLongBits(other.hossz))
			return false;
		return true;
	}

	
	
}
