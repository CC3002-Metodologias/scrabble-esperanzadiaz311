package cl.uchile.dcc.scrabble.model;

public abstract class builtWithString implements IScrabble_Type{
    private String s;

    /** Creates an object that is built from a Java String
     * @param s, the String that is going to be used in the constructor
     */
    public builtWithString(String s){ this.s = s; }

    @Override
    public String toString(){
        return this.getString();
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    /**
     * @return the String used in the constructor
     */
    public String getString(){ return s; }
}
