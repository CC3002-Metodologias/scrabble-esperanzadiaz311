package cl.uchile.dcc.scrabble.model;

public interface IScrabble_Type {
    /** Takes the Scrabble type and transforms it into a Java String
     * @return the Scrabble type turned into a Java String
     */
    String toString();

    /** Takes the Scrabble type and transforms it into a Scrabble String. If the
     * type is Scrabble String, it returns the same object
     * @return the Scrabble type turned into
     * a Scrabble String
     */
    Scrabble_String toScrabbleString();
}

