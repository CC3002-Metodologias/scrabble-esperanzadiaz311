package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

import java.util.HashMap;

public class SIntFactory implements ISFactory{
    private int i;
    private HashMap<Integer, Scrabble_Int> ints = new HashMap<>();

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
