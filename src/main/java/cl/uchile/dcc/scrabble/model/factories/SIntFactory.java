package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

import java.util.HashMap;

/** Factory for creating Scrabble Int types
 * @author Esperanza Díaz Adaro
 */
public class SIntFactory implements ISFactory{
    private int i;
    private HashMap<Integer, Scrabble_Int> ints = new HashMap<>();

    /** Sets the value of the Scrabble Int that's going to be created
     * @param value an int
     */
    public void setValue(int value) {
        i = value;
    }

    @Override
    public IScrabble create() {
        if (!ints.containsKey(i)) {
            Scrabble_Int element = new Scrabble_Int(i);
            ints.put(i, element);
        }
        return ints.get(i);
    }
}
