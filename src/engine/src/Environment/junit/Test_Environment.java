package Environment.junit;

import static org.junit.Assert.*;
import static rabbitescape.engine.ChangeDescription.State.*;
import org.junit.Test;

import rabbitescape.engine.Fire;
import rabbitescape.engine.Fire_Factory;

public class Test_Environment {

	@Test
	public void test_Fire_A() {
		Fire fire = Fire_Factory.getFire(0, 0, FIRE_A);
		assertEquals(fire.state,FIRE_A);
	}
	@Test
	public void test_Fire_B() {
		Fire fire = Fire_Factory.getFire(0, 0, FIRE_B);
		assertEquals(fire.state,FIRE_B);
	}
	@Test
	public void test_Fire_C() {
		Fire fire = Fire_Factory.getFire(0, 0, FIRE_C);
		assertEquals(fire.state,FIRE_C);
	}
	@Test
	public void test_Fire_D() {
		Fire fire = Fire_Factory.getFire(0, 0, FIRE_D);
		assertEquals(fire.state,FIRE_D);
	}

}