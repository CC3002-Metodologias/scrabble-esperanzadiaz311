package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;

import java.util.HashMap;

/** Factory for creating Scrabble Float types
 * @author Esperanza Díaz Adaro
 */
public class SFloatFactory implements ISFactory{
    private double flt;
    private HashMap<Double, Scrabble_Float> floats = new HashMap<>();

    /** Sets the value of the Scrabble Float that's going to be created
     * @param value a double
     */
    public void setValue(double value){
        flt = value;
    }
    
    @Override
    public IScrabble create() {
        if(!floats.containsKey(flt)){
            Scrabble_Float element = new Scrabble_Float(flt);
            floats.put(flt, element);
        }
        return floats.get(flt);
    }
}
