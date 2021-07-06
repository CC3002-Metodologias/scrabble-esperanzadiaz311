package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;

import java.util.HashMap;

public class SStringFactory implements ISFactory{
    private String str;
    private HashMap<String, Scrabble_String> strings = new HashMap<>();

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
