package ronkvetelezo;
import static org.junit.Assert.*;
import hu.nagymarica.ova4i6.ronkvetelezo.model.*;
import org.junit.Test;

public class TestRonk {

	@Test
	public void testGetValues() {
		Ronk r = new Ronk(12, 1.0, 3, 100);
	
		assertEquals( 12 , r.getAtmero());
		assertEquals( 1.0, r.getHossz(), 0.001);
		assertEquals( 100 , r.getMennyiseg());
		assertEquals( 3 , r.getFajAzon());
	}
	
	@Test
	public void testSetValue() {
		Ronk r = new Ronk();
		
		r.setAtmero(12);
		r.setHossz(1);
		r.setMennyiseg(3);
		r.setFajAzon(100);
		
		assertEquals( 12 , r.getAtmero());
		assertEquals( 1, r.getHossz(), 0.001);
		assertEquals( 3 , r.getMennyiseg());
		assertEquals( 100 , r.getFajAzon());
	}
	
	@Test
	public void testEquals() {
		Ronk r1 = new Ronk(12, 1, 100, 3);
		Ronk r2 = new Ronk(12, 1, 100, 3);
		
		assertEquals( r1, r2);
	}
}
