package cl.uchile.dcc.scrabble.operationtree;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

public interface Component {
   IScrabble calculate();
   Scrabble_Binary toSBinary();
   Scrabble_Int toSInt();
   Scrabble_String toSString();
   Scrabble_Float toSFloat();
   Scrabble_Bool toSBool();
}
