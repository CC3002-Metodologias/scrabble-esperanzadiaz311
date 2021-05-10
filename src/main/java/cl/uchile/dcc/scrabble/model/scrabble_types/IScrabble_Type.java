package cl.uchile.dcc.scrabble.model.scrabble_types;

public interface IScrabble_Type {
    /**
     * @return the element turned into a Java String
     */
    String toString();

    /**
     * @return the element turned into a Scrabble String
     */
    Scrabble_String toScrabbleString();
}
