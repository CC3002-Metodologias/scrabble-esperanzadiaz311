package cl.uchile.dcc.scrabble.model;

/** Contains all the logical operations that the Scrabble types have in common
 * This interface is exclusively used by Bool and Binary Scrabble types
 * @author Esperanza Díaz Adaro
 */

public interface IScrabbleLogical {
    /** Calls a method which makes the 'or' operation
     * @param l the scrabble type that is going to be compared
     * @return a Scrabble type which contains the result of an 'or' operation
     */
    IScrabbleLogical or(IScrabbleLogical l);

    /** Calls a method which makes the 'and' operation
     * @param l the scrabble type that is going to be compared
     * @return a Scrabble type with the result of an 'and' operation
     */
    IScrabbleLogical and(IScrabbleLogical l);

    /**
     * @return a Scrabble type with the opposite value of the original Scrabble type
     */
    IScrabbleLogical not();

    /** A method that makes the 'or' operation between a Bool and a
     * (Bool/Binary) Scrabble type
     * @param b a Scrabble Boolean
     * @return a Scrabble type with the result of the 'or' operation
     */
    IScrabbleLogical orCalledByBoolean(Scrabble_Bool b);

    /** A method that makes the 'and' operation between a Bool and a
     * (Boolean/Binary) Scrabble type
     * @param b a Scrabble Bool
     * @return a Scrabble type with the result of the 'and' operation
     */
    IScrabbleLogical andCalledByBoolean(Scrabble_Bool b);

    /** A method that makes the 'or' operation between a Binary and a
     * (Boolean/Binary) Scrabble type
     * @param bin a Scrabble Binary
     * @return a Scrabble type with the result of the 'or' operation
     */
    IScrabbleLogical orCalledByBinary(Scrabble_Binary bin);

    /** A method that makes the 'and' operation between a Binary and a
     * (Boolean/Binary) Scrabble type
     * @param bin a Scrabble Binary
     * @return a Scrabble type with the result of the 'or' operation
     */
    IScrabbleLogical andCalledByBinary(Scrabble_Binary bin);
}