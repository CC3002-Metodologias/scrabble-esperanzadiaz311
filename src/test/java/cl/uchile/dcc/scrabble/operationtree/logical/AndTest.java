package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.TreeTest;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Add;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Div;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Sub;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.And;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Not;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AndTest extends TreeTest {
    private And and1, and2, and3, and4, and5, and6, and7, and8, and9, and10, and11, and12, and13, and14,
            and15, and16, and17, and18, and19, and20, and21, and22, and23, and24, and25, bigTree;

    @BeforeEach
    public void setUp(){
        SetUp();

        and1 = new And(l1, l2); // Leaves: ScrabbleInt x2
        and3 = new And(l1, l5); // Leaves: ScrabbleInt, ScrabbleFloat
        and4 = new And(l1, l7); // Leaves: ScrabbleInt, ScrabbleBinary
        and5= new And(l1, l3);  // Leaves: ScrabbleInt, ScrabbleString
        and6 = new And(l1, l9); // Leaves: ScrabbleInt, ScrabbleBool

        and7 = new And(l3, l4); // Leaves: ScrabbleString x2
        and2 = new And(l3, l1); // ScrabbleString and ScrabbleInt
        and8 = new And(l3, l9); // Leaves: ScrabbleString, ScrabbleBool
        and9 = new And(l3, l5); // Leaves: ScrabbleString, ScrabbleFloat
        and10 = new And(l3, l7); // Leaves: ScrabbleString, ScrabbleBinary

        and11 = new And(l5, l6); // Leaves: ScrabbleFloat x2
        and12 = new And(l5, l1); // Leaves: ScrabbleFloat, ScrabbleInt
        and13 = new And(l5, l7); // Leaves: ScrabbleFloat, ScrabbleBinary
        and14 = new And(l5, l3); // Leaves: ScrabbleFloat, ScrabbleString
        and15 = new And(l5, l9); // Leaves: ScrabbleFloat, ScrabbleBool

        and16 = new And(l7, l8); // Leaves: ScrabbleBinary x2
        and17 = new And(l7, l1); // Leaves: ScrabbleBinary, ScrabbleInt
        and18 = new And(l7, l5); // Leaves: ScrabbleBinary, ScrabbleFloat
        and19 = new And(l7, l3); // Leaves: ScrabbleBinary, ScrabbleString
        and20 = new And(l7, l9); // Leaves: ScrabbleBinary, ScrabbleBool

        and21 = new And(l9, l10); // Leaves: ScrabbleBool x2
        and22 = new And(l9, l1); // Leaves: ScrabbleBool, ScrabbleInt
        and23 = new And(l9, l5); // Leaves: ScrabbleBool, ScrabbleFloat
        and24 = new And(l9, l3); // Leaves: ScrabbleBool, ScrabbleString
        and25 = new And(l9, l7); // Leaves: ScrabbleBool, ScrabbleBinary

        bigTree = new And(new Add(l1, l2), new Div(new Sub(l5, l6), new Not(new Or(l7, new And(l7, l9)))));

    }

    @Test
    public void AndTest(){

        // Basic And Tree (Leaf <- And -> Leaf)

        // Leaves: ScrabbleInt x2
        assertNull(and1.calculate());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertNull(and3.calculate());
        // Leaves: ScrabbleInt, ScrabbleBinary
        assertNull(and4.calculate());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(and5.calculate());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(and6.calculate());

        // Leaves: ScrabbleString x2
        assertNull(and7.calculate());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(and8.calculate());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(and9.calculate());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(and2.calculate());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(and10.calculate());

        // Leaves: ScrabbleFloat x2
        assertNull(and11.calculate());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertNull(and12.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertNull(and13.calculate());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(and14.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(and15.calculate());

        // Leaves: ScrabbleBinary x2
        IScrabble expected = new Scrabble_Binary("100000010");
        assertEquals(expected, and16.calculate());
        assertEquals(expected.hashCode(), and16.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertNull(and17.calculate());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(and18.calculate());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(and19.calculate());
        // Leaves: ScrabbleBinary, ScrabbleBool
        IScrabble expected3 = new Scrabble_Binary("100011010");
        assertEquals(expected3, and20.calculate());
        assertEquals(expected3.hashCode(), and20.calculate().hashCode());

        // Leaves: ScrabbleBool x2
        IScrabble expected2 = new Scrabble_Bool(false);
        assertEquals(expected2, and21.calculate());
        assertEquals(expected2.hashCode(), and21.calculate().hashCode());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(and22.calculate());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(and23.calculate());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(and24.calculate());
        // Leaves: ScrabbleBool, ScrabbleBinary
        IScrabble expected12 = new Scrabble_Binary("100011010");
        assertEquals(expected12, and25.calculate());
        assertEquals(expected12.hashCode(), and25.calculate().hashCode());

        // multiple operations tree
       /* IScrabble expectedValue = new Scrabble_Float(-75*((22.5+902.345)/229));
        assertEquals(expectedValue, bigTree.calculate());
        assertEquals(expectedValue.hashCode(), bigTree.calculate().hashCode());*/
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
