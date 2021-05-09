package cl.uchile.dcc.scrabble.gui.scrabble_types;

public interface IScrabble_Type {
    /**
     * @return the element turned into a java String
     */
    String toString();
    Scrabble_String toScrabbleString();

    /*
    Scrabble_String toBinary();
    boolean toBoolean();
    int toInt();
    double toFloat();
    */
}
