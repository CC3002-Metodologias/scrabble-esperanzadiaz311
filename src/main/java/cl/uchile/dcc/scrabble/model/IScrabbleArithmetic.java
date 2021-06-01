package cl.uchile.dcc.scrabble.model;

/** Contains all the logical operations that the Scrabble types have in common
 * This interface is exclusively used by Scrabble Int, Scrabble Float and Scrabble Binary
 * @author Esperanza Díaz Adaro
 */
public interface IScrabbleArithmetic {

    /** Transforms Int, Float and Binary Scrabble types into a Scrabble Float
     * @return a Scrabble Float
     */
    Scrabble_Float toFloat();

    /** Calls a method which makes the 'add' operation
     * @param a a Scrabble Type that can do arithmetical operations
     * @return a Scrabble type that contains the result of the 'add' operation
     */
    IScrabbleArithmetic add(IScrabbleArithmetic a);

    /** Calls a method which makes the 'sub' operation
     * @param s a Scrabble Type that can do arithmetical operations
     * @return a Scrabble type that contains the result of the 'sub' operation
     */
    IScrabbleArithmetic sub(IScrabbleArithmetic s);

    /** Calls a method which makes the 'mult' operation
     * @param mlt a Scrabble type that contains the result of the 'mult' operation
     * @return a Scrabble type that contains the result of the 'mult' operation
     */
    IScrabbleArithmetic mult(IScrabbleArithmetic mlt);

    /** Calls a method which makes the 'div' operation
     * @param dv a Scrabble type that contains the result of the 'div' operation
     * @return a Scrabble type that contains the result of the 'div' operation
     */
    IScrabbleArithmetic div(IScrabbleArithmetic dv);

    /** Makes the addition between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the addition in a Scrabble Int or Float
     */
    IScrabbleArithmetic addCalledByInt(Scrabble_Int i);

    /** Makes the addition between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the addition in a Scrabble Float
     */
    IScrabbleArithmetic addCalledByFloat(Scrabble_Float f);

    /** Makes the addition between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the addition in a Scrabble Binary
     */
    IScrabbleArithmetic addCalledByBinary(Scrabble_Binary bin);

    /** Makes the subtraction between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the subtraction in a Scrabble Int or Float
     */
    IScrabbleArithmetic subCalledByInt(Scrabble_Int i);

    /** Makes the subtraction between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the subtraction in a Scrabble Float
     */
    IScrabbleArithmetic subCalledByFloat(Scrabble_Float f);

    /** Makes the subtraction between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the subtraction in a Scrabble Binary
     */
    IScrabbleArithmetic subCalledByBinary(Scrabble_Binary bin);

    /** Makes the multiplication between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the multiplication in a Scrabble Int or Float
     */
    IScrabbleArithmetic multCalledByInt(Scrabble_Int i);

    /** Makes the multiplication between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the multiplication in a Scrabble Float
     */
    IScrabbleArithmetic multCalledByFloat(Scrabble_Float f);

    /** Makes the multiplication between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the multiplication in a Scrabble Binary
     */
    IScrabbleArithmetic multCalledByBinary(Scrabble_Binary bin);

    /** Makes the division between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the division in a Scrabble Int or Float
     */
    IScrabbleArithmetic divCalledByInt(Scrabble_Int i);

    /** Makes the division between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the division in a Scrabble Float
     */
    IScrabbleArithmetic divCalledByFloat(Scrabble_Float f);

    /** Makes the division between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the division in a Scrabble Binary
     */
    IScrabbleArithmetic divCalledByBinary(Scrabble_Binary bin);
}
