package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;

import java.util.HashMap;

/** Factory for creating Scrabble String types
 * @author Esperanza Díaz Adaro
 */
public class SStringFactory implements ISFactory{
    private String str;
    private HashMap<String, Scrabble_String> strings = new HashMap<>();

    /** Sets the value of the Scrabble String that's going to be created
     * @param s a String
     */
    public void setValue(String s){
        str = s;
    }

    @Override
    public IScrabble create() {
        if(!strings.containsKey(str)){
            Scrabble_String element = new Scrabble_String(str);
            strings.put(str, element);
        }
        return strings.get(str);
    }
}
