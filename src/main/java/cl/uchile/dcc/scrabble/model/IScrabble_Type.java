package cl.uchile.dcc.scrabble.model;

public interface IScrabble_Type {
    /**
     * @return the Scrabble type turned into
     * a Java String
     */
    String toString();

    /**
     * @return the the Scrabble type turned into
     * a Scrabble String
     */
    Scrabble_String toScrabbleString();
}

