package hu.nagymarica.ova4i6.ronkvetelezo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *SQL parancsokat végrehajtó osztály.
 */
public class DBUtil {

	/**
	 * Egy kapcsolat. 
	 */ 
	private static Connection conn;
		
	/**
	 * Az adatbázis kapcsolatot adja vissza.
	 * @return conn
	 */
	public static Connection getConn() {
		return conn;
	}

	/**
	 * Egy vásárló adatainak mentése az adatbázisba.
	 * @param v egy vásárló
	 */
	public static void vasarloFelvetel(Vasarlo v){
		try {
			conn = ConnectionHandler.getConnection();
			try(PreparedStatement pstmt = 
					conn.prepareStatement("insert into ronkvetelezo_vasarlok" + " values (?,?,?,?,?,?)")){
				pstmt.setString(1, v.getSzemIgSzam());
				pstmt.setString(2,v.getNev());
				pstmt.setString(3,v.getIranyitoszam());
				pstmt.setString(4,v.getVaros());
				pstmt.setString(5,v.getUtca());
				pstmt.setInt(6, v.getHazszam());
				pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Egy vásárlás mentése az adatbázisba.
	 * @param v egy vásárlás
	 */
	public static void vasarlasFelvetel(Vasarlas v){
		try {
			conn = ConnectionHandler.getConnection();
			try(PreparedStatement pstmt = 
					conn.prepareStatement("insert into ronkvetelezo_vasarlasok" + " values (?,?,?,?,?, sysdate)")){
				pstmt.setInt(1, v.getVasarlas_azon());
				pstmt.setString(2,v.getVasarlo_azon());
				pstmt.setInt(3,v.getFaj_azon());
				pstmt.setDouble(4,v.getVasarolt_kobmeter());
				pstmt.setInt(5,v.getFizetendo_osszeg());
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Ellenőrzi, hogy van-e az adatbázisban az adott személyigazolvány számmal rendelkező vásárló.
	 * @param szemIgSzam a vásárló személyigazolvány száma
	 * @return <code>true</code> ha az adott vásárló már vásárolt, <code>false</code> egyébként
	 */
	public static boolean isFelvettVasarlo(String szemIgSzam){
		String sql="select szem_ig_szam "
				+ "from ronkvetelezo_vasarlok "
				+ "where szem_ig_szam = '" + szemIgSzam + "'" ;
		boolean volt = false;
		try {
			conn = ConnectionHandler.getConnection();
			try(Statement stmt = conn.createStatement()){
				try(ResultSet rs = stmt.executeQuery(sql)){
					if(rs.next()) volt = true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return volt;
	}
	
	/**
	 * Az adott fafajú rönk sudarlósági értékét kéri le az adatbázisből az átmérő függvényében.
	 * @param faj_azon a rönk azonosítója
	 * @param atmero a rönk átmérője
	 * @return a rönk sudarlósági értéke
	 */
	public static double getSEByFaj(int faj_azon, int atmero){
		double se = 0;
		try{
			conn = ConnectionHandler.getConnection();
			try(Statement stmt = conn.createStatement()){
				String lekerdezes = "select sudarlosagi_ertek "
						+ "from ronkvetelezo_ronk "
						+ "where faj_azon=" + faj_azon 
						+ "and " + atmero + " between min_atmero and max_atmero";
				
				try(ResultSet rs = stmt.executeQuery(lekerdezes)){
					rs.next();
					se = rs.getDouble(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return se;
	}
	
	/**
	 * A fafajok nevét kéri le az adatbázisból.
	 * @return a fafajok nevét tartalmazó lista
	 */
	public static List<String> getFajok(){
		List<String> fajok = new ArrayList<String>();
		try{ 
			conn = ConnectionHandler.getConnection();
			try(Statement stmt = conn.createStatement()){
				String lekerdezes = "select faj from ronkvetelezo_fajok order by faj";
				try(ResultSet rs = stmt.executeQuery(lekerdezes)){
					while(rs.next()){
						fajok.add(rs.getString(1));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return fajok;
	}
	
	/**
	 * Egy rönk fafajának neve alapján lekéri az adatbázisból a hozzá tartozó azonosítót.
	 * @param faj a rönk fafajának neve
	 * @return a rönk azonosítója
	 */
	public static int getFajAzonositoja(String faj){
		int faj_azon = 0;
		try{
			conn = ConnectionHandler.getConnection();
			try(Statement stmt = conn.createStatement()){
				String lekerdezes = "select faj_azon "
								+ "from ronkvetelezo_fajok "
								+ "where faj='" + faj + "'";
				try(ResultSet rs = stmt.executeQuery(lekerdezes)){
					rs.next();
					faj_azon = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return faj_azon;
	}
	
	/**
	 * Egy rönk azonosítója alapján lekéri az adatbázisból a rönk fafajának a nevét.
	 * @param faj_azon a rönk azonosítója
	 * @return a rönk fafajának neve
	 */
	public static String getFaj (int faj_azon){
		String faj = null;
		try{ 
			conn = ConnectionHandler.getConnection();
			try(Statement stmt = conn.createStatement()){
				String lekerdezes = "select faj "
								+ "from ronkvetelezo_fajok "
								+ "where faj_azon=" + faj_azon ;
				try(ResultSet rs = stmt.executeQuery(lekerdezes)){
					rs.next();
					faj = rs.getString(1);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return faj;
	}
	
	/**
	 * A rönk azonosítója alapján lekéri az adatbázisból az adott rönk egységárát.
	 * @param faj_azon a rönk azonosítója
	 * @return az adott rönk egységára
	 */
	public static int getFajAra(int faj_azon) {
		try{ 
			conn = ConnectionHandler.getConnection();
			try(Statement stmt = conn.createStatement()){
				String lekerdezes = "select egysegar "
								+ "from ronkvetelezo_fajok "
								+ "where faj_azon=" + faj_azon ;
				try(ResultSet rs = stmt.executeQuery(lekerdezes)){
					rs.next();
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/**
	 * Lekéri az adatbázisból a vásárlások számát.
	 * @return a vásárlások száma
	 */
	public static int getSorokSzama() {
		int sorok = 0;
		try{ 
			conn= ConnectionHandler.getConnection();
			try(Statement stmt = conn.createStatement()){
				String lekerdezes = "select count(*) "
								+ "from ronkvetelezo_vasarlasok ";
				try(ResultSet rs = stmt.executeQuery(lekerdezes)){
					rs.next();
					sorok = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return sorok;
	}

	
	
}
