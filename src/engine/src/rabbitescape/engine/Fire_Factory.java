package rabbitescape.engine;
import rabbitescape.engine.Fire_A;
import rabbitescape.engine.Fire_B;
import rabbitescape.engine.Fire_C;
import rabbitescape.engine.Fire_D;

import rabbitescape.engine.ChangeDescription.State;

public class Fire_Factory {
	public static Fire getFire(int x, int y, State state) {
		Fire fire = null;
		switch(state) {
			case FIRE_A:
			{
				fire = new Fire_A(x,y);
				break;
			}
			case FIRE_B:
			{
				fire = new Fire_B(x,y);
				break;
			}
			case FIRE_C:
			{
				fire = new Fire_C(x,y);
				break;
			}
			case FIRE_D:
			{
				fire = new Fire_D(x,y);
				break;
			}
		default:
			break;
		}
		return fire;
	}
	public static Fire getFire_byVariant(int x, int y, int variant) {
		Fire fire = null;
		switch(variant) {
			case 0:
			{
				fire = new Fire_A(x,y);
				break;
			}
			case 1:
			{
				fire = new Fire_B(x,y);
				break;
			}
			case 2:
			{
				fire = new Fire_C(x,y);
				break;
			}
			case 3:
			{
				fire = new Fire_D(x,y);
				break;
			}
		default:
			break;
		}
		return fire;
	}
}