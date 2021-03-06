package rabbitescape.engine.behaviours.bashing;

import rabbitescape.engine.ChangeDescription.State;
import rabbitescape.engine.World;
import rabbitescape.engine.Rabbit;

import static rabbitescape.engine.ChangeDescription.State.RABBIT_BASHING_USELESSLY_RIGHT_UP;

public class BashingUselesslyRightUp implements BashingInterFace {

    @Override
    public State getState() {
        return RABBIT_BASHING_USELESSLY_RIGHT_UP;
    }

    @Override
    public boolean behave(World world, Rabbit rabbit) {
        rabbit.slopeBashHop = true;
        rabbit.y -= 1;
        return true;
    }
}