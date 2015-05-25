package hu.nagymarica.ova4i6.ronkvetelezo.controller;

import hu.nagymarica.ova4i6.ronkvetelezo.model.ConnectionHandler;
import hu.nagymarica.ova4i6.ronkvetelezo.model.DBUtil;
import hu.nagymarica.ova4i6.ronkvetelezo.model.Vasarlas;
import hu.nagymarica.ova4i6.ronkvetelezo.model.Vasarlo;

import java.sql.SQLException;
import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * A vásárló adatai, a vásárlás és vételezés menetét irányító osztály.
 *
 */
public class Szamitas {
	
	/**
	 * Az osztályban használt logger.
	 * @see <a href="http://www.slf4j.org/api/org/slf4j/Logger.html">SLF4J API</a>
	 */
	private static Logger logger = LoggerFactory.getLogger(Szamitas.class);
	
	/**
	 * Ellenőrzi, hogy vásárló megadta-e az adatait.
	 * @param szig a vásárló személyigazolvány száma
	 * @param nev a vásárló neve
	 * @param iranyitoszam a vásárló irányítószáma
	 * @param varos a vásárló lakhelye
	 * @param utca a vásárló utcájának neve
	 * @param hazszam a vásárló házszáma
	 * @return aktuális vásárló
	 */
	public static Vasarlo vasarloAdatokEllenorzes(String szig, String nev, 
			String iranyitoszam, String varos, String utca, String hazszam ){
		
		Vasarlo v = null;
		if ("".equals(szig) || "".equals(nev) || "".equals(varos)){
			logger.warn("A vásárló helytelenül töltötte ki az adatokat");
			return null;
		} else {
			logger.info("A vásárló helyesen töltötte ki adatokat");
			v = new Vasarlo();
			v.setSzemIgSzam(szig);
			v.setNev(nev);
			v.setVaros(varos);
			
			
			if(iranyitoszam != null && !"".equals(iranyitoszam)) {
				v.setIranyitoszam(iranyitoszam);
			}
			else v.setIranyitoszam(null);
			
			if(utca != null && !"".equals(utca)) {
				v.setUtca(utca);
			}
			else v.setUtca(null);
			
			if(hazszam != null && !"".equals(hazszam)) {
				v.setHazszam(Integer.parseInt(hazszam));
			}
			else v.setHazszam(0);
		} 
		
		return v;
		
	}
	
	/**
	 * Ellenőrzi, hogy a vásárló megfelelő tulajdonságokkal rendelkező 
	 * és megfeleleő mennyiségű rönköt szeretne vételezni.
	 * @param atmero a rönk átmerője
	 * @param hossz a rönk hossza
	 * @param db a rönk darabszáma
	 * @return a felhasználó tájékoztatására szolgáló üzeneteket tartalmazó tömb 
	 */
	public static String[] ronkAdatokEllenorzes(String atmero, String hossz, String db){
		String[] hibak = new String[7];
		
		int adottAtmero = 0;
		int adottMennyiseg = 0;
		Double adottHossz = 0.0;
		
		if("".equals(atmero) || 
				"".equals(hossz) || 
				"".equals(db)){	
				hibak[0]= "Hiányzó adat!";
				logger.warn("A vásárló helytelenül töltötte ki a rönk adatait");
		} else{
			if(isEgeszSzam(atmero)){
				adottAtmero = Integer.parseInt(atmero);
				if(adottAtmero < 12 || adottAtmero > 100){
					hibak[1] = "Az átmérő 12 és 100 cm között lehet!";
					logger.warn("A vásárló helytelenül töltötte ki a rönk átmérőjét");
				}
				logger.info("A vásárló helyesen töltötte ki a rönk átmérőjét");
			} else {
				hibak[2] = "A átmérő csak egész szám lehet!";
				logger.warn("A vásárló helytelenül töltötte ki a rönk átmérőjét");
			}
		
			if(isEgeszSzam(db)){
				adottMennyiseg = Integer.parseInt(db);
				if(adottMennyiseg <= 0){
					hibak[3] = "A mennyiség csak pozitív egész szám lehet!";
					logger.warn("A vásárló helytelenül töltötte ki a rönk darabszámát");
				}
				logger.info("A vásárló helyesen töltötte ki a rönk darabszámát");
			} else {
				hibak[4] = "A mennyiség csak pozitív egész szám lehet!";
				logger.warn("A vásárló helytelenül töltötte ki a rönk darabszámát");
			}
			
			if(isDoubleSzam(hossz)){
				
				adottHossz = Double.parseDouble(hossz);
				adottHossz = egytizedesJegyesKerekites(adottHossz);
				if(adottHossz < 1.0 || adottHossz > 6.0){
					hibak[5] = "Az hossz 1.0 és 6.0 m között lehet!";
					logger.warn("A vásárló helytelenül töltötte ki a rönk hosszát");
				}
				logger.info("A vásárló helytelenül töltötte ki a rönk hosszát");
			} else {
				hibak[6]=
						"A hossz csak egy tizedesjegy pontossággal lehet megadni!\n"
						+ "FONTOS: Az egész és a tizedes helyiérték között pontot használjon!";
				logger.warn("A vásárló helytelenül töltötte ki a rönk átmérőjét");
			}
		}
		return hibak;
	}
	
	/**
	 * Egy racionális szám három tizedesjegyre kerekítését végző metódus.
	 * @param szam a kerekítendő szám
	 * @return a kerekített szám
	 */
	public static double haromtizedesJegyesKerekites(double szam){
		szam = szam * 1000;
		szam = Math.round(szam);
		int seged = (int) szam;
		return (double) seged / 1000.0;
	}
	
	/**
	 * Egy racionális szám egy tizedesjegyre kerekítését végző metódus.
	 * @param szam a kerekítendő szám
	 * @return a kerekített szám
	 */
	public static double egytizedesJegyesKerekites(double szam){
		szam = szam * 10;
		szam = Math.round(szam);
		int seged = (int) szam;
		return (double) seged / 10.0;
	}
	
	/**
	 * A megadott átmérővel és hosszúsággal rendelkező rönk térfogatát számítja ki a sudarlósági érték függvényében.
	 * @param atmero a rönk átmérője
	 * @param hossz a rönk hosszúsága
	 * @param se az adott rönk sudarlósági értéke
	 * @return az adott rönk térfogata
	 */
	public static double getAdottRonkTerfogata(int atmero, double hossz, double se){
		double v;
		
		v = (Math.PI / 8) * 
			 (  ( atmero / 100.0 ) * ( atmero / 100.0 )  +
			 (  ( atmero / 100.0 ) + ( hossz * se ) ) * 
			 (  ( atmero / 100.0 ) + ( hossz * se ) ) ) * hossz;
		
		return haromtizedesJegyesKerekites(v);
	}
	
	/**
	 * Kiszámítja, hogy egy adott átmérőjú és hosszúságú rönk mennyiségének és 
	 * térfogatának szorzatát, azaz az adott tulajdonságokkal rendelkező rönk össztérfogatát.
	 * @param db a rönk darabszáma
	 * @param v az adott rönk térfogata
	 * @return az adott tulajdonságokkal rendelkező rönk össztérfogatát
	 */
	public static double getAdottRonkOsszTerfogata(int db, double v){
		return haromtizedesJegyesKerekites(v * db);
	}
	
	/**
	 * Kiszámítja, hogy a vásárló adott fafatjájú rönkből hány köbmétert vásárolt összesen.
	 * @param terfogatok az egyes rönkök össztérfogatát tartalmazó lista
	 * @return a vásárolt köbméter értéke
	 */
	public static double getOsszTerfogat(List<Double> terfogatok){
		double osszeg = 0;
		for (Double d : terfogatok) {
			osszeg += d;
		}
		return haromtizedesJegyesKerekites(osszeg);
	}
	
	/**
	 * Kiszámítja, hogy a vásárlónak a vásárolni kívánt köbméterét mennyit kell fizetnie.
	 * @param osszTerfogat a vásárolnikívánt köbméter
	 * @param fajAzon a rönk azonosítója
	 * @return a fizetendő összeg értéke
	 */
	public static int fizetendoOsszeg(double osszTerfogat, int fajAzon){
		int ar = DBUtil.getFajAra(fajAzon);
		return (int)(osszTerfogat*ar);
	}
	
	/**Ellenőrzi, hogy a paraméterül adott sztring kasztolható-e egésszé.
	 * @param s az ellenőrizendő sztring
	 * @return <code>true</code>, ha a sztring kasztolható, <code>false</code> egyébként
	 */
	public static boolean isEgeszSzam(String s)
	{
		try{
			int i = Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException er){
			logger.warn(" {} helytelen bement", s);
			return false; 
		}
	}
	
	/**Ellenőrzi, hogy a paraméterül adott sztring kasztolható-e Double típusú racionális számmá.
	 * @param s az ellenőrizendő sztring
	 * @return <code>true</code>, ha a sztring kasztolható, <code>false</code> egyébként
	 */
	public static boolean isDoubleSzam(String s)
	{
		try{ 
			double i = Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException er){
			logger.warn(" {} helytelen bement", s);
			return false; 
		}
	}
	
	/**
	 * A vásárló és a vásárlás adatainak adatbázisba mentését segítő metódus.
	 * @param v a vásárló
	 * @param vasarlas a vásárlás
	 */
	public static void feltoltes(Vasarlo v, Vasarlas vasarlas){
		if(!DBUtil.isFelvettVasarlo(v.getSzemIgSzam())) {
			DBUtil.vasarloFelvetel(v);
			logger.info(" {} felvétele az adatbázisba", v.getNev());
		}
		DBUtil.vasarlasFelvetel(vasarlas);
		logger.info("Vásárlás mentése az adatbázisba");
	}
	
	/**
	 * A vásárlás mentését segítő metódus, amely visszaadja a vásárálás azonosítóját.
	 * @return a vásárlás azonosítója
	 */
	public static int vasarolAzonKov(){
		return (DBUtil.getSorokSzama()+1);
	}
	
	/**
	 * A rönk azonosítóját adja vissza.
	 * @param faj a rönk fafaja
	 * @return a rönk azonosítója
	 */
	public static int getFajAzon(String faj){
		return DBUtil.getFajAzonositoja(faj);
	}
	
	/**
	 * Az adott azonosítójú és átmérőjű rönk sudarlósági értékét adja vissza. 
	 * @param fajAzon a rönk azonosítója
	 * @param atmero a rönk átmérője
	 * @return a rönk sudarlósági értéke
	 */
	public static double melyikSE(int fajAzon, int atmero){
		return DBUtil.getSEByFaj(fajAzon, atmero);
	}
	
	/**
	 * A fafajok listáját visszaadó metódus.
	 * @return a fafajok listája
	 */
	public static List<String> getFajok(){
		return DBUtil.getFajok();
	}
	
	/**
	 * Az adatbázis kapcsolatot segítő metódus.
	 */
	public static void kapcsolatBezarasa(){
		try {
			ConnectionHandler.connClose();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.warn("Sikertelen kapcsolat lezárás");
		}
	}
}
