package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;

public class Fire_D extends Fire{

	public Fire_D(int x, int y) {
		super(x, y, FIRE_D);
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
                state = FIRE_D_RISE_LEFT;
                    
                return;
            }
            if ( BehaviourTools.isRightRiseSlope( onBlock ) )
            {
                state = FIRE_D_RISE_RIGHT; 
               
                return;
            }
            
            if ( flatBelow )
            {
                state = FIRE_D;
                return;
            }
        }
        else // Falling
        {
            if ( BehaviourTools.isLeftRiseSlope( blockBelow ) )
            {
                state = FIRE_D_FALL_TO_RISE_LEFT;
                return;
            }
            if ( BehaviourTools.isRightRiseSlope( blockBelow ) )
            {
                state = FIRE_D_FALL_TO_RISE_RIGHT;
                return;
            }
            state = FIRE_D_FALLING;
            return;
        }
    }
	
	@Override
	public void step( World world )
    {
        switch ( state )
        {
        case FIRE_D_FALLING:

        case FIRE_D_FALL_TO_RISE_RIGHT:

        case FIRE_D_FALL_TO_RISE_LEFT:

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