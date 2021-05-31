package cl.uchile.dcc.scrabble.model;

/**
 * This class contains the necessary elements for the subclasses
 * who needs a Java String to be created
 * @author Esperanza Díaz Adaro
 */
public abstract class BuiltWithString implements IScrabble, IBuiltWithString {
    private String s;

    /** Creates an object that is built from a Java String
     * @param s the String that is going to be used in the constructor
     */
    public BuiltWithString(String s){ this.s = s; }

    @Override
    public String toString(){
        return this.getString();
    }

    public abstract Scrabble_String toScrabbleString();

    @Override
    public String getString(){ return s; }
}
