package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

import java.util.HashMap;

public class SBinaryFactory implements ISFactory{
    private String bin;
    private HashMap<String, Scrabble_Binary> bins = new HashMap<>();

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
