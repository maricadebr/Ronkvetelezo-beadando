package ronkvetelezo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import hu.nagymarica.ova4i6.ronkvetelezo.controller.Szamitas;
import hu.nagymarica.ova4i6.ronkvetelezo.model.Vasarlo;

import org.junit.Test;

public class TestSzamitas {

	
	@Test
	public void testHaromtizedesJegyreKerekites() {
		
		assertEquals(0.122 , Szamitas.haromtizedesJegyesKerekites(0.1222222), 0.001);
		assertEquals(-0.156, Szamitas.haromtizedesJegyesKerekites(-0.15555), 0.001);
		assertEquals(0.000, Szamitas.haromtizedesJegyesKerekites(0.0000000001), 0.001);

	}
	
	@Test
	public void testEgytizedesJegyreKerekites() {
		
		assertEquals(0.1 , Szamitas.egytizedesJegyesKerekites(0.12222), 0.001);
		assertEquals(-0.2, Szamitas.haromtizedesJegyesKerekites(-0.199999), 0.001);
		assertEquals(0.0, Szamitas.haromtizedesJegyesKerekites(0.0000000001), 0.001);

	}

	@Test
	public void testvasarloAdatokEllenorzes()
	{
		
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("", "", "4028", "", "Kassai", "26"));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("", "Marica", "4028", "", "Kassai", "26"));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("", "Marica", "4028", "Debrecen", "Kassai", "26"));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("032659", "", "4028", "Debrecen", "Kassai", "26"));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("032659", "", "4028", "", "Kassai", "26"));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("", "", "4028", "Debrecen", "Kassai", "26"));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("", "", "", "", "", ""));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("", "Marica", "", "", "", ""));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("032659", "", "", "", "", ""));
		assertEquals(null, Szamitas.vasarloAdatokEllenorzes("", "", "", "Debrecen", "", ""));

		assertNull(Szamitas.vasarloAdatokEllenorzes("", "", "4028", "Debrecen", "Kassai", "26"));

		Vasarlo v = new Vasarlo();
		
		assertEquals(v.getClass(), Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "4028", "Debrecen", "Kassai", "26").getClass());
		assertEquals(v.getClass(), Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "", "Debrecen", "", "").getClass());
		assertEquals(v.getClass(), Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "4028", "Debrecen", "", "").getClass());
		assertEquals(v.getClass(), Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "4028", "Debrecen", "Kassai", "").getClass());
		assertEquals(v.getClass(), Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "", "Debrecen", "Kassai", "26").getClass());
		assertEquals(v.getClass(), Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "", "Debrecen", "Kassai", "").getClass());
		assertEquals(v.getClass(), Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "", "Debrecen", "", "26").getClass());
		
		assertNotNull(Szamitas.vasarloAdatokEllenorzes("032659", "Marica", "", "Debrecen", "Kassai", "26"));

	}
	
	@Test
	public void testronkAdatokEllenorzes()
	{
		String hiba0 = Szamitas.ronkAdatokEllenorzes("", "", "")[0];
		assertEquals("Hiányzó adat!", hiba0);
		assertNotNull(hiba0);
		
		String hiba1 = Szamitas.ronkAdatokEllenorzes("10", "5.0", "3")[1];
		assertEquals("Az átmérő 12 és 100 cm között lehet!", hiba1);
		assertNotNull(hiba1);
		
		String hiba2 = Szamitas.ronkAdatokEllenorzes("12.5", "5.0", "3")[2];
		assertEquals("A átmérő csak egész szám lehet!", hiba2);
		assertNotNull(hiba2);
		
		String hiba3 = Szamitas.ronkAdatokEllenorzes("15", "5.0", "0")[3];
		assertEquals("A mennyiség csak pozitív egész szám lehet!", hiba3);
		assertNotNull(hiba3);
		
		String hiba4 = Szamitas.ronkAdatokEllenorzes("15", "5.0", "1.5")[4];
		assertEquals("A mennyiség csak pozitív egész szám lehet!", hiba4);
		assertNotNull(hiba4);
		
		String hiba5 = Szamitas.ronkAdatokEllenorzes("12.5", "0.5", "3")[5];
		assertEquals("Az hossz 1.0 és 6.0 m között lehet!", hiba5);
		assertNotNull(hiba5);
		
		String hiba6 = Szamitas.ronkAdatokEllenorzes("12.5", "1,5", "3")[6];
		assertEquals("A hossz csak egy tizedesjegy pontossággal lehet megadni!\n"
				+ "FONTOS: Az egész és a tizedes helyiérték között pontot használjon!", hiba6);
		assertNotNull(hiba6);
		
	}
	
	@Test
	public void testgetAdottRonkTerfogata()
	{
		assertEquals(0.012, Szamitas.getAdottRonkTerfogata(12, 1.0, 0.00971103),0.0001);
		assertEquals(0.251, Szamitas.getAdottRonkTerfogata(20, 6.0, 0.00971103),0.0001);
		assertEquals(0.036, Szamitas.getAdottRonkTerfogata(21, 1.0, 0.00971103),0.0001);
		assertEquals(0.546, Szamitas.getAdottRonkTerfogata(31, 6.0, 0.00971103),0.0001);
		
		assertEquals(0.084, Szamitas.getAdottRonkTerfogata(32, 1.0, 0.01379839),0.0001);
		assertEquals(0.926, Szamitas.getAdottRonkTerfogata(40, 6.0, 0.01379839),0.0001);
		assertEquals(0.137, Szamitas.getAdottRonkTerfogata(41, 1.0, 0.01379839),0.0001);
		assertEquals(1.441, Szamitas.getAdottRonkTerfogata(51, 6.0, 0.01379839),0.0001);
		
		assertEquals(0.220, Szamitas.getAdottRonkTerfogata(52, 1.0, 0.01928736),0.0001);
		assertEquals(2.055, Szamitas.getAdottRonkTerfogata(60, 6.0, 0.01928736),0.0001);
		assertEquals(0.465, Szamitas.getAdottRonkTerfogata(76, 1.0, 0.01928736),0.0001);
		assertEquals(5.289, Szamitas.getAdottRonkTerfogata(100, 6.0, 0.01928736),0.0001);
		
		
		assertEquals(0.012, Szamitas.getAdottRonkTerfogata(12, 1.0, 0.00835125),0.0001);
		assertEquals(0.242, Szamitas.getAdottRonkTerfogata(20, 6.0, 0.00835125),0.0001);
		assertEquals(0.036, Szamitas.getAdottRonkTerfogata(21, 1.0, 0.00835125),0.0001);
		assertEquals(0.532, Szamitas.getAdottRonkTerfogata(31, 6.0, 0.00835125),0.0001);
		
		assertEquals(0.083, Szamitas.getAdottRonkTerfogata(32, 1.0, 0.011017),0.0001);
		assertEquals(0.889, Szamitas.getAdottRonkTerfogata(40, 6.0, 0.011017),0.0001);
		assertEquals(0.136, Szamitas.getAdottRonkTerfogata(41, 1.0, 0.011017),0.0001);
		assertEquals(1.395, Szamitas.getAdottRonkTerfogata(51, 6.0, 0.011017),0.0001);
		
		assertEquals(0.218, Szamitas.getAdottRonkTerfogata(52, 1.0, 0.0134175),0.0001);
		assertEquals(1.939, Szamitas.getAdottRonkTerfogata(60, 6.0, 0.0134175),0.0001);
		assertEquals(0.462, Szamitas.getAdottRonkTerfogata(76, 1.0, 0.0134175),0.0001);
		assertEquals(5.107, Szamitas.getAdottRonkTerfogata(100, 6.0, 0.0134175),0.0001);
		
	}
	
	@Test 
	public void testgetAdottRonkOsszTerfogata(){
				
		assertEquals(0.012, Szamitas.getAdottRonkOsszTerfogata(1, 0.012), 0.000001);
		assertEquals(0.024, Szamitas.getAdottRonkOsszTerfogata(2, 0.012), 0.000001);
		assertEquals(0.036, Szamitas.getAdottRonkOsszTerfogata(3, 0.012), 0.000001);
		assertEquals(1.2, Szamitas.getAdottRonkOsszTerfogata(100, 0.012), 0.000001);
		
		assertEquals(0.546, Szamitas.getAdottRonkOsszTerfogata(1, 0.546), 0.000001);
		assertEquals(1.092, Szamitas.getAdottRonkOsszTerfogata(2, 0.546), 0.000001);
		assertEquals(1.638, Szamitas.getAdottRonkOsszTerfogata(3, 0.546), 0.000001);
		assertEquals(54.6, Szamitas.getAdottRonkOsszTerfogata(100, 0.546), 0.000001);
		
		assertEquals(0.084, Szamitas.getAdottRonkOsszTerfogata(1, 0.084), 0.000001);
		assertEquals(8.4, Szamitas.getAdottRonkOsszTerfogata(100, 0.084), 0.000001);
		
		assertEquals(1.441, Szamitas.getAdottRonkOsszTerfogata(1, 1.441), 0.000001);
		assertEquals(144.1, Szamitas.getAdottRonkOsszTerfogata(100, 1.441), 0.000001);
		
		assertEquals(0.220, Szamitas.getAdottRonkOsszTerfogata(1, 0.220), 0.000001);
		assertEquals(22.0, Szamitas.getAdottRonkOsszTerfogata(100, 0.220), 0.000001);
		
		assertEquals(5.289, Szamitas.getAdottRonkOsszTerfogata(1, 5.289), 0.000001);
		assertEquals(528.9, Szamitas.getAdottRonkOsszTerfogata(100, 5.289), 0.000001);
		
	}
	
	@Test
	public void testgetOsszTerfogat(){

		List<Double> terfogatok = new ArrayList<>();
		terfogatok.add(0.012);
		terfogatok.add(1.2);
		terfogatok.add(0.546);
		terfogatok.add(54.6);
		terfogatok.add(0.084);
		terfogatok.add(8.4);
		terfogatok.add(1.441);
		terfogatok.add(144.1);
		terfogatok.add(0.220);
		terfogatok.add(22.0);
		terfogatok.add(5.289);
		terfogatok.add(528.9);
		
		assertEquals(766.792, Szamitas.getOsszTerfogat(terfogatok), 0.0001);
	}
	
	@Test
	public void testfizetendoOsszeg()
	{
		assertEquals(60, Szamitas.fizetendoOsszeg(0.012, 1));
		assertEquals(120, Szamitas.fizetendoOsszeg(0.012, 2));
		
		assertEquals(3833960, Szamitas.fizetendoOsszeg(766.792, 1));
		assertEquals(7667920, Szamitas.fizetendoOsszeg(766.792, 2));
	}
	
	@Test
	public void testisEgeszSzam()
	{
		assertTrue(Szamitas.isEgeszSzam("5"));
		assertTrue(Szamitas.isEgeszSzam("-5"));
		
		assertFalse(Szamitas.isEgeszSzam("5.5"));
		assertFalse(Szamitas.isEgeszSzam("-5.3"));
	}
	
	@Test
	public void testisDoubleSzam()
	{
		assertTrue(Szamitas.isDoubleSzam("5.5"));
		assertTrue(Szamitas.isDoubleSzam("-5.3"));	
	}
	
	@Test
	public void testgetFajAzon(){
		
		assertEquals(1, Szamitas.getFajAzon("nyár"));
		assertEquals(2, Szamitas.getFajAzon("tölgy"));
	}
	
	@Test 
	public void testmelyikSE(){
				
		assertEquals(0.00971103, Szamitas.melyikSE(1, 12),0.000000001);
		assertEquals(0.00971103, Szamitas.melyikSE(1, 21),0.000000001);
		assertEquals(0.00971103, Szamitas.melyikSE(1, 31),0.000000001);
		assertEquals(0.01379839, Szamitas.melyikSE(1, 32),0.000000001);
		assertEquals(0.01379839, Szamitas.melyikSE(1, 41),0.000000001);
		assertEquals(0.01379839, Szamitas.melyikSE(1, 51),0.000000001);
		assertEquals(0.01928736, Szamitas.melyikSE(1, 52),0.000000001);
		assertEquals(0.01928736, Szamitas.melyikSE(1, 76),0.000000001);
		assertEquals(0.01928736, Szamitas.melyikSE(1, 100),0.000000001);
		
		assertEquals(0.00835125, Szamitas.melyikSE(2, 12),0.000000001);
		assertEquals(0.00835125, Szamitas.melyikSE(2, 21),0.000000001);
		assertEquals(0.00835125, Szamitas.melyikSE(2, 31),0.000000001);
		assertEquals(0.011017, Szamitas.melyikSE(2, 32),0.000000001);
		assertEquals(0.011017, Szamitas.melyikSE(2, 41),0.000000001);
		assertEquals(0.011017, Szamitas.melyikSE(2, 51),0.000000001);
		assertEquals(0.0134175, Szamitas.melyikSE(2, 52),0.000000001);
		assertEquals(0.0134175, Szamitas.melyikSE(2, 76),0.000000001);
		assertEquals(0.0134175, Szamitas.melyikSE(2, 100),0.000000001);
	}
}
