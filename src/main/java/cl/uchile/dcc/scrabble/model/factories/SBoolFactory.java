package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;

import java.util.HashMap;

/** Factory for creating Scrabble Bool types
 * @author Esperanza Díaz Adaro
 */
public class SBoolFactory implements ISFactory{
    private boolean bool;
    private HashMap<Boolean, Scrabble_Bool> booleans = new HashMap<>();

    /** Sets the value of the Scrabble Bool that's going to be created
     * @param b a boolean
     */
    public void setValue(boolean b){
        bool = b;
    }

    @Override
    public IScrabble create() {
        if(!booleans.containsKey(bool)){
            Scrabble_Bool element = new Scrabble_Bool(bool);
            booleans.put(bool, element);
        }
        return booleans.get(bool);
    }
}
