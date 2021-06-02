package cl.uchile.dcc.scrabble.model;

/** Contains all the shared methods between all the Scrabble types
 * @author Esperanza Díaz Adaro
 */

public interface IScrabble {
    /** Takes the Scrabble type and transforms it into a Java String
     * @return the Scrabble type turned into a Java String
     */
    String toString();

    /** Takes the Scrabble type and transforms it into a Scrabble String.
     * @return the Scrabble type turned into a Scrabble String
     */
    Scrabble_String toScrabbleString();

    /** Concatenates a Scrabble String with any Scrabble type
     * @param str a Scrabble String
     * @return a Scrabble String with the result of the concatenation
     */
    Scrabble_String addCalledByString(Scrabble_String str);
}
