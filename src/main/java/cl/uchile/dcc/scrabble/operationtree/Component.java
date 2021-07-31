package cl.uchile.dcc.scrabble.operationtree;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

/** Contains all the methods that the elements of an operation tree share
 * @author Esperanza Díaz Adaro
 */
public interface Component {

   /**
    * @return a Scrabble type with the result of the operation
    */
   IScrabble calculate();

   /** Transforms the result of an operation into a Scrabble Binary
    * @return a Scrabble Binary
    */
   Scrabble_Binary toSBinary();

   /** Transforms the result of an operation into a Scrabble Int
    * @return a Scrabble Int
    */
   Scrabble_Int toSInt();

   /** Transforms the result of an operation into a Scrabble String
    * @return a Scrabble String
    */
   Scrabble_String toSString();

   /** Transforms the result of an operation into a Scrabble Float
    * @return a Scrabble Float
    */
   Scrabble_Float toSFloat();

   /** Transforms the result of an operation into a Scrabble Bool
    * @return a Scrabble Bool
    */
   Scrabble_Bool toSBool();
}
