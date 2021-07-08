package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

/** Contains all the shared methods between all the Scrabble types
 * @author Esperanza Díaz Adaro
 */

public interface IScrabble {
    /** Takes the Scrabble model and transforms it into a Java String
     * @return the Scrabble model turned into a Java String
     */
    String toString();

    /** Takes the Scrabble model and transforms it into a Scrabble String.
     * @return the Scrabble model turned into a Scrabble String
     */
    Scrabble_String toScrabbleString();

    /** Concatenates a Scrabble String with any Scrabble model
     * @param str a Scrabble String
     * @return a Scrabble String with the result of the concatenation
     */
    Scrabble_String addCalledByString(Scrabble_String str);

    /** Transforms Int, Float and Binary Scrabble types into a Scrabble Float
     * @return a Scrabble Float
     */
    Scrabble_Float toFloat();

    /** Transforms Int and Binary Scrabble types into a Scrabble Binary
     * @return a Scrabble Binary
     */
    Scrabble_Binary toBinary();

    /** Transforms Int and Binary Scrabble types into a Scrabble Int
     * @return a Scrabble Int
     */
    Scrabble_Int toInt();

    /** Returns a new Scrabble Bool
     * @return a Scrabble Bool
     */
    Scrabble_Bool toBool();

    /** Calls a method which makes the 'add' operation
     * @param a Scrabble Type that can do arithmetical operations
     * @return a Scrabble model that contains the result of the 'add' operation
     */
    IScrabble add(IScrabble a);

    /** Calls a method which makes the 'sub' operation
     * @param s a Scrabble Type that can do arithmetical operations
     * @return a Scrabble model that contains the result of the 'sub' operation
     */
    IScrabble sub(IScrabble s);

    /** Calls a method which makes the 'mult' operation
     * @param mlt a Scrabble model that contains the result of the 'mult' operation
     * @return a Scrabble model that contains the result of the 'mult' operation
     */
    IScrabble mult(IScrabble mlt);

    /** Calls a method which makes the 'div' operation
     * @param dv a Scrabble model that contains the result of the 'div' operation
     * @return a Scrabble model that contains the result of the 'div' operation
     */
    IScrabble div(IScrabble dv);

    /** Makes the addition between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the addition in a Scrabble Int or Float
     */
    IScrabble addCalledByInt(Scrabble_Int i);

    /** Makes the addition between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the addition in a Scrabble Float
     */
    IScrabble addCalledByFloat(Scrabble_Float f);

    /** Makes the addition between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the addition in a Scrabble Binary
     */
    IScrabble addCalledByBinary(Scrabble_Binary bin);

    /** Makes the subtraction between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the subtraction in a Scrabble Int or Float
     */
    IScrabble subCalledByInt(Scrabble_Int i);

    /** Makes the subtraction between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the subtraction in a Scrabble Float
     */
    IScrabble subCalledByFloat(Scrabble_Float f);

    /** Makes the subtraction between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the subtraction in a Scrabble Binary
     */
    IScrabble subCalledByBinary(Scrabble_Binary bin);

    /** Makes the multiplication between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the multiplication in a Scrabble Int or Float
     */
    IScrabble multCalledByInt(Scrabble_Int i);

    /** Makes the multiplication between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the multiplication in a Scrabble Float
     */
    IScrabble multCalledByFloat(Scrabble_Float f);

    /** Makes the multiplication between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the multiplication in a Scrabble Binary
     */
    IScrabble multCalledByBinary(Scrabble_Binary bin);

    /** Makes the division between a Scrabble Int and a Scrabble Int, Float or Binary
     * @param i a Scrabble Int
     * @return the result of the division in a Scrabble Int or Float
     */
    IScrabble divCalledByInt(Scrabble_Int i);

    /** Makes the division between a Scrabble Float and a Scrabble Int, Float or Binary
     * @param f a Scrabble Float
     * @return the result of the division in a Scrabble Float
     */
    IScrabble divCalledByFloat(Scrabble_Float f);

    /** Makes the division between a Scrabble Binary and a Scrabble Int or Binary
     * @param bin a Scrabble Binary
     * @return the result of the division in a Scrabble Binary
     */
    IScrabble divCalledByBinary(Scrabble_Binary bin);

    /** Calls a method which makes the 'or' operation
     * @param l the scrabble model that is going to be compared
     * @return a Scrabble model which contains the result of an 'or' operation
     */
    IScrabble or(IScrabble l);

    /** Calls a method which makes the 'and' operation
     * @param l the scrabble model that is going to be compared
     * @return a Scrabble model with the result of an 'and' operation
     */
    IScrabble and(IScrabble l);

    /**
     * @return a Scrabble model with the opposite value of the original Scrabble model
     */
    IScrabble not();

    /** A method that makes the 'or' operation between a Bool and a
     * (Bool/Binary) Scrabble model
     * @param b a Scrabble Boolean
     * @return a Scrabble model with the result of the 'or' operation
     */
    IScrabble orCalledByBoolean(Scrabble_Bool b);

    /** A method that makes the 'and' operation between a Bool and a
     * (Boolean/Binary) Scrabble model
     * @param b a Scrabble Bool
     * @return a Scrabble model with the result of the 'and' operation
     */
    IScrabble andCalledByBoolean(Scrabble_Bool b);

    /** A method that makes the 'or' operation between a Binary and a
     * (Boolean/Binary) Scrabble model
     * @param bin a Scrabble Binary
     * @return a Scrabble model with the result of the 'or' operation
     */
    IScrabble orCalledByBinary(Scrabble_Binary bin);

    /** A method that makes the 'and' operation between a Binary and a
     * (Boolean/Binary) Scrabble model
     * @param bin a Scrabble Binary
     * @return a Scrabble model with the result of the 'or' operation
     */
    IScrabble andCalledByBinary(Scrabble_Binary bin);
}
