package ronkvetelezo;

import static org.junit.Assert.*;
import hu.nagymarica.ova4i6.ronkvetelezo.model.*;
import org.junit.Test;

public class TestVasarlo {
	
	@Test
	public void testGetValues() {
		Vasarlo v = new Vasarlo("PA123456", "Marica", "Debrecen");
	
		assertEquals( "PA123456" , v.getSzemIgSzam());
		assertEquals( "Marica", v.getNev());
		assertEquals( "Debrecen" , v.getVaros());
		
		Vasarlo v2 = new Vasarlo("PA123456", "Marica", "4028", "Debrecen", "Kassai", 26);
		
		assertEquals( "PA123456" , v2.getSzemIgSzam());
		assertEquals( "Marica", v2.getNev());
		assertEquals("4028", v2.getIranyitoszam());
		assertEquals( "Debrecen" , v2.getVaros());
		assertEquals("Kassai", v2.getUtca());
		assertEquals(26, v2.getHazszam());
				
	}
	
	@Test
	public void testSetValue() {
		Vasarlo v = new Vasarlo();
		
		v.setSzemIgSzam("PA123456");
		v.setNev("Marica");
		v.setVaros("Debrecen");
		
		assertEquals( "PA123456" , v.getSzemIgSzam());
		assertEquals( "Marica", v.getNev());
		assertEquals( "Debrecen" , v.getVaros());
		
		Vasarlo v2 = new Vasarlo();
		
		v2.setSzemIgSzam("KB123456");
		v2.setNev("Mario");
		v2.setVaros("Budapest");
		v2.setIranyitoszam("1116");
		v2.setUtca("Kossuth");
		v2.setHazszam(13);
		
		assertEquals("KB123456", v2.getSzemIgSzam());
		assertEquals( "Mario", v2.getNev());
		assertEquals("1116", v2.getIranyitoszam());
		assertEquals( "Budapest" , v2.getVaros());
		assertEquals("Kossuth", v2.getUtca());
		assertEquals(13, v2.getHazszam());
		
	}

}
