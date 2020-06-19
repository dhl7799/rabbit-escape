package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

public class Fire_C extends Fire{

	public Fire_C(int x, int y) {
		super(x, y, FIRE_C);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void calcNewState( World world )
    {
        // Check if being extinguished.
        for ( WaterRegion waterRegion : world.waterTable.getItemsAt( x, y ) )
        {
            if ( waterRegion.getContents() > 0 )
            {
                state = FIRE_EXTINGUISHING;
                return;
            }
        }

        Block blockBelow = world.getBlockAt( x, y + 1 );
        // Note: when flatBelow is true may be on a slope with a flat below,
        // or sitting on the flat
        boolean flatBelow = BehaviourTools.s_isFlat( blockBelow );
        boolean still = (
                   flatBelow
                || ( world.getBlockAt( x, y ) != null )
                || BridgeTools.someoneIsBridgingAt( world, x, y )
            );
        if ( still )
        {
            Block onBlock = world.getBlockAt( x, y );
            if ( BehaviourTools.isLeftRiseSlope( onBlock ) )
            {
                state = FIRE_C_RISE_LEFT;
                    
                return;
            }
            if ( BehaviourTools.isRightRiseSlope( onBlock ) )
            {
                state = FIRE_C_RISE_RIGHT; 
               
                return;
            }
            
            if ( flatBelow )
            {
                state = FIRE_C;
                return;
            }
        }
        else // Falling
        {
            if ( BehaviourTools.isLeftRiseSlope( blockBelow ) )
            {
                state = FIRE_C_FALL_TO_RISE_LEFT;
                return;
            }
            if ( BehaviourTools.isRightRiseSlope( blockBelow ) )
            {
                state = FIRE_C_FALL_TO_RISE_RIGHT;
                return;
            }
            state = FIRE_C_FALLING;
            return;
        }
    }
	
	@Override
	public void step( World world )
    {
        switch ( state )
        {
        case FIRE_C_FALLING:

        case FIRE_C_FALL_TO_RISE_RIGHT:

        case FIRE_C_FALL_TO_RISE_LEFT:

            ++y;

            if ( y >= world.size.height )
            {
                world.changes.removeFire( this );
            }
            return;
        case FIRE_EXTINGUISHING:
            world.changes.removeFire( this );
            return;
        default:
            return;
        }

    }
}


