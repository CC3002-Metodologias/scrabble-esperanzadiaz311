package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.TreeTest;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrTest extends TreeTest {
    private Or or1, or2, or3, or4, or5, or6, or7, or8, or9, or10, or11, or12, or13, or14,
            or15, or16, or17, or18, or19, or20, or21, or22, or23, or24, or25, bigTree;

    @BeforeEach
    public void setUp(){
        SetUp();

        or1 = new Or(l1, l2); // Leaves: ScrabbleInt x2
        or3 = new Or(l1, l5); // Leaves: ScrabbleInt, ScrabbleFloat
        or4 = new Or(l1, l7); // Leaves: ScrabbleInt, ScrabbleBinary
        or5= new Or(l1, l3);  // Leaves: ScrabbleInt, ScrabbleString
        or6 = new Or(l1, l9); // Leaves: ScrabbleInt, ScrabbleBool

        or7 = new Or(l3, l4); // Leaves: ScrabbleString x2
        or2 = new Or(l3, l1); // ScrabbleString or ScrabbleInt
        or8 = new Or(l3, l9); // Leaves: ScrabbleString, ScrabbleBool
        or9 = new Or(l3, l5); // Leaves: ScrabbleString, ScrabbleFloat
        or10 = new Or(l3, l7); // Leaves: ScrabbleString, ScrabbleBinary

        or11 = new Or(l5, l6); // Leaves: ScrabbleFloat x2
        or12 = new Or(l5, l1); // Leaves: ScrabbleFloat, ScrabbleInt
        or13 = new Or(l5, l7); // Leaves: ScrabbleFloat, ScrabbleBinary
        or14 = new Or(l5, l3); // Leaves: ScrabbleFloat, ScrabbleString
        or15 = new Or(l5, l9); // Leaves: ScrabbleFloat, ScrabbleBool

        or16 = new Or(l7, l8); // Leaves: ScrabbleBinary x2
        or17 = new Or(l7, l1); // Leaves: ScrabbleBinary, ScrabbleInt
        or18 = new Or(l7, l5); // Leaves: ScrabbleBinary, ScrabbleFloat
        or19 = new Or(l7, l3); // Leaves: ScrabbleBinary, ScrabbleString
        or20 = new Or(l7, l9); // Leaves: ScrabbleBinary, ScrabbleBool

        or21 = new Or(l9, l10); // Leaves: ScrabbleBool x2
        or22 = new Or(l9, l1); // Leaves: ScrabbleBool, ScrabbleInt
        or23 = new Or(l9, l5); // Leaves: ScrabbleBool, ScrabbleFloat
        or24 = new Or(l9, l3); // Leaves: ScrabbleBool, ScrabbleString
        or25 = new Or(l9, l7); // Leaves: ScrabbleBool, ScrabbleBinary
    }

    @Test
    public void OrTest(){

    }

    @Override
    protected void toSBinaryTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSIntTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSFloatTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSStringTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSBoolTest(IScrabble[] expected, Component[] comp) {

    }
}
