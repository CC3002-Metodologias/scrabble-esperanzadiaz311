package cl.uchile.dcc.scrabble.model;

public interface IScrabbleArithmetic {
    IScrabbleArithmetic add(IScrabbleArithmetic a);
    IScrabbleArithmetic sub(IScrabbleArithmetic s);
    IScrabbleArithmetic mult(IScrabbleArithmetic mlt);
    IScrabbleArithmetic div(IScrabbleArithmetic dv);
    IScrabbleArithmetic addWithInt(Scrabble_Int i);
    IScrabbleArithmetic addWithFloat(Scrabble_Float f);
    IScrabbleArithmetic addWithBinary(Scrabble_Binary bin);
    IScrabbleArithmetic subWithInt(Scrabble_Int i);
    IScrabbleArithmetic subWithFloat(Scrabble_Float f);
    IScrabbleArithmetic subWithBinary(Scrabble_Binary bin);
    IScrabbleArithmetic multWithInt(Scrabble_Int i);
    IScrabbleArithmetic multWithFloat(Scrabble_Float f);
    IScrabbleArithmetic multWithBinary(Scrabble_Binary bin);
    IScrabbleArithmetic divWithInt(Scrabble_Int i);
    IScrabbleArithmetic divWithFloat(Scrabble_Float f);
    IScrabbleArithmetic divWithBinary(Scrabble_Binary bin);
}
