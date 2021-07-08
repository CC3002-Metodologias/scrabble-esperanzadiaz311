package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;

/**
 * This class contains the necessary elements for the subclasses
 * who needs a Java String to be created
 * @author Esperanza Díaz Adaro
 */
public abstract class BuiltWithString implements IScrabble, IBuiltWithString {
    protected String s;

    /** Creates an object that is built from a Java String
     * @param s the String that is going to be used in the constructor
     */
    public BuiltWithString(String s){ this.s = s; }

    @Override
    public String toString(){
        return this.s;
    }

    public abstract Scrabble_String toScrabbleString();

    @Override
    public Scrabble_String addCalledByString(Scrabble_String str){
        return new Scrabble_String(str.getString() + this.s);
    }

    @Override
    public String getString(){ return s; }
}
