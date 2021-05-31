package cl.uchile.dcc.scrabble.model;

public interface IScrabbleArithmetic {
    Scrabble_Float toFloat();
    IScrabbleArithmetic add(IScrabbleArithmetic a);
    IScrabbleArithmetic sub(IScrabbleArithmetic s);
    IScrabbleArithmetic mult(IScrabbleArithmetic mlt);
    IScrabbleArithmetic div(IScrabbleArithmetic dv);
    IScrabbleArithmetic addCalledByInt(Scrabble_Int i);
    IScrabbleArithmetic addCalledByFloat(Scrabble_Float f);
    IScrabbleArithmetic addCalledByBinary(Scrabble_Binary bin);
    IScrabbleArithmetic subCalledByInt(Scrabble_Int i);
    IScrabbleArithmetic subCalledByFloat(Scrabble_Float f);
    IScrabbleArithmetic subCalledByBinary(Scrabble_Binary bin);
    IScrabbleArithmetic multCalledByInt(Scrabble_Int i);
    IScrabbleArithmetic multCalledByFloat(Scrabble_Float f);
    IScrabbleArithmetic multCalledByBinary(Scrabble_Binary bin);
    IScrabbleArithmetic divCalledByInt(Scrabble_Int i);
    IScrabbleArithmetic divCalledByFloat(Scrabble_Float f);
    IScrabbleArithmetic divCalledByBinary(Scrabble_Binary bin);
}
