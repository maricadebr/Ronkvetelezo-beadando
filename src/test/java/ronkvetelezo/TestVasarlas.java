package ronkvetelezo;

import static org.junit.Assert.*;
import hu.nagymarica.ova4i6.ronkvetelezo.model.*;

import org.junit.Test;

public class TestVasarlas {
	
	@Test
	public void testGetValues() {
		Vasarlas v = new Vasarlas(1, "10", 100, 5.5, 3000);
	
		assertEquals( 1, v.getVasarlas_azon());
		assertEquals( "10", v.getVasarlo_azon());
		assertEquals( 100, v.getFaj_azon());
		assertEquals(5.5, v.getVasarolt_kobmeter(), 0.001);
		assertEquals(3000, v.getFizetendo_osszeg());
		
	}
	
	@Test
	public void testSetValue() {
		Vasarlas v = new Vasarlas();
		
		v.setVasarlas_azon(1);
		v.setVasarlo_azon("10");
		v.setFaj_azon(100);
		v.setVasarolt_kobmeter(5.5);
		v.setFizetendo_osszeg(3000);
		
		assertEquals( 1, v.getVasarlas_azon());
		assertEquals( "10", v.getVasarlo_azon());
		assertEquals( 100, v.getFaj_azon());
		assertEquals(5.5, v.getVasarolt_kobmeter(), 0.001);
		assertEquals(3000, v.getFizetendo_osszeg());
		
	}

}
