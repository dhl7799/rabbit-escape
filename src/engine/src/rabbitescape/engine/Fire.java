package rabbitescape.engine;



import java.util.HashMap;
import java.util.Map;

import rabbitescape.engine.ChangeDescription.State;

public abstract class Fire extends Thing
{


    public Fire( int x, int y, State fire )
    {
        super( x, y, fire );


    }

    @Override
    abstract public void calcNewState( World world );
    

   

    @Override
    public abstract void step( World world );
    

    @Override
    public Map<String, String> saveState( boolean runtimeMeta )
    {
        return new HashMap<String, String>();
    }

    @Override
    public void restoreFromState( Map<String, String> state )
    {
    }

    @Override
    public String overlayText()
    {
        return "Fire";
    }
}