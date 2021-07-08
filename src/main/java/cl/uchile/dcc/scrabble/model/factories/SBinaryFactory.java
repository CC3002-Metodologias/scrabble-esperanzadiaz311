package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;

import java.util.HashMap;

/** Factory for creating Scrabble Binary types
 * @author Esperanza Díaz Adaro
 */
public class SBinaryFactory implements ISFactory{
    private String bin;
    private HashMap<String, Scrabble_Binary> bins = new HashMap<>();

    /** Sets the value of the Scrabble Binary that's going to be created
     * @param s a String
     */
    public void setValue(String s){
        bin = s;
    }

    @Override
    public IScrabble create() {
        if (!bins.containsKey(bin)) {
            Scrabble_Binary element = new Scrabble_Binary(bin);
            bins.put(bin, element);
        }
        return bins.get(bin);
    }
}
