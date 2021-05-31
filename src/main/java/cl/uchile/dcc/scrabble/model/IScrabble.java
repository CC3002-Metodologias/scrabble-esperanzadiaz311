package cl.uchile.dcc.scrabble.model;

public interface IScrabble {
    /** Takes the Scrabble type and transforms it into a Java String
     * @return the Scrabble type turned into a Java String
     */
    String toString();

    /** Takes the Scrabble type and transforms it into a Scrabble String.
     * @return the Scrabble type turned into a Scrabble String
     */
    Scrabble_String toScrabbleString();

    Scrabble_String addCalledByString(Scrabble_String str);
}
