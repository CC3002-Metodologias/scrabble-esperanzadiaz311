package cl.uchile.dcc.scrabble.operationtree.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.TreeArithmeticTest;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Add;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Div;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Mult;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Sub;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.And;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Not;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MultTest extends TreeArithmeticTest {
    private Mult mult1, mult2, mult3, mult4, mult5, mult6, mult7, mult8, mult9, mult10, mult11, mult12, mult13, mult14,
            mult15, mult16, mult17, mult18, mult19, mult20, mult21, mult22, mult23, mult24, mult25, bigTree;
    private Component[] comps;

    @BeforeEach
    public void setUp(){
        SetUp();

        mult1 = new Mult(l1, l2); // Leaves: ScrabbleInt x2
        mult3 = new Mult(l1, l5); // Leaves: ScrabbleInt, ScrabbleFloat
        mult4 = new Mult(l1, l7); // Leaves: ScrabbleInt, ScrabbleBinary
        mult5= new Mult(l1, l3);  // Leaves: ScrabbleInt, ScrabbleString
        mult6 = new Mult(l1, l9); // Leaves: ScrabbleInt, ScrabbleBool

        mult7 = new Mult(l3, l4); // Leaves: ScrabbleString x2
        mult2 = new Mult(l3, l1); // ScrabbleString and ScrabbleInt
        mult8 = new Mult(l3, l9); // Leaves: ScrabbleString, ScrabbleBool
        mult9 = new Mult(l3, l5); // Leaves: ScrabbleString, ScrabbleFloat
        mult10 = new Mult(l3, l7); // Leaves: ScrabbleString, ScrabbleBinary

        mult11 = new Mult(l5, l6); // Leaves: ScrabbleFloat x2
        mult12 = new Mult(l5, l1); // Leaves: ScrabbleFloat, ScrabbleInt
        mult13 = new Mult(l5, l7); // Leaves: ScrabbleFloat, ScrabbleBinary
        mult14 = new Mult(l5, l3); // Leaves: ScrabbleFloat, ScrabbleString
        mult15 = new Mult(l5, l9); // Leaves: ScrabbleFloat, ScrabbleBool

        mult16 = new Mult(l7, l8); // Leaves: ScrabbleBinary x2
        mult17 = new Mult(l7, l1); // Leaves: ScrabbleBinary, ScrabbleInt
        mult18 = new Mult(l7, l5); // Leaves: ScrabbleBinary, ScrabbleFloat
        mult19 = new Mult(l7, l3); // Leaves: ScrabbleBinary, ScrabbleString
        mult20 = new Mult(l7, l9); // Leaves: ScrabbleBinary, ScrabbleBool

        mult21 = new Mult(l9, l10); // Leaves: ScrabbleBool x2
        mult22 = new Mult(l9, l1); // Leaves: ScrabbleBool, ScrabbleInt
        mult23 = new Mult(l9, l5); // Leaves: ScrabbleBool, ScrabbleFloat
        mult24 = new Mult(l9, l3); // Leaves: ScrabbleBool, ScrabbleString
        mult25 = new Mult(l9, l7); // Leaves: ScrabbleBool, ScrabbleBinary

        bigTree = new Mult(new Add(l1, l2), new Div(new Sub(l5, l6), new Not(new Or(l7, new And(l7, l9)))));

        comps = new Component[] {mult1, mult2, mult3, mult4, mult5, mult6, mult7, mult8, mult9, mult10, mult11, mult12, mult13, mult14,
                mult15, mult16, mult17, mult18, mult19, mult20, mult21, mult22, mult23, mult24, mult25};
    }

    @Test
    public void multTest(){

        // Basic Mult Tree (Leaf <- Mult -> Leaf)

        // Leaves: ScrabbleInt x2
        IScrabble expected = new Scrabble_Int(25*-100);
        assertEquals(expected, mult1.calculate());
        assertEquals(expected.hashCode(), mult1.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        IScrabble expected2 = new Scrabble_Float(25*22.5);
        assertEquals(expected2, mult3.calculate());
        assertEquals(expected2.hashCode(), mult3.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        IScrabble expected3 = new Scrabble_Int(25*282);
        assertEquals(expected3, mult4.calculate());
        assertEquals(expected3.hashCode(), mult4.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(mult5.calculate());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(mult6.calculate());

        // Leaves: ScrabbleString x2
        assertNull(mult7.calculate());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(mult8.calculate());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(mult9.calculate());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(mult2.calculate());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(mult10.calculate());

        // Leaves: ScrabbleFloat x2
        IScrabble expected9 = new Scrabble_Float(22.5*-902.345);
        assertEquals(expected9, mult11.calculate());
        assertEquals(expected9.hashCode(), mult11.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        IScrabble expected10 = new Scrabble_Float(22.5*25);
        assertEquals(expected10, mult12.calculate());
        assertEquals(expected10.hashCode(), mult12.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        IScrabble expected11 = new Scrabble_Float(22.5*282);
        assertEquals(expected11, mult13.calculate());
        assertEquals(expected11.hashCode(), mult13.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(mult14.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(mult15.calculate());

        // Leaves: ScrabbleBinary x2
        IScrabble expected12 = new Scrabble_Binary("11111111111111111110010001110110");
        assertEquals(expected12, mult16.calculate());
        assertEquals(expected12.hashCode(), mult16.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        IScrabble expected13 = new Scrabble_Binary("1101110001010");
        assertEquals(expected13, mult17.calculate());
        assertEquals(expected13.hashCode(), mult17.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(mult18.calculate());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(mult19.calculate());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(mult20.calculate());

        // Leaves: ScrabbleBool x2
        assertNull(mult21.calculate());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(mult22.calculate());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(mult23.calculate());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(mult24.calculate());
        // Leaves: ScrabbleBool, ScrabbleBinary
        assertNull(mult25.calculate());

        // multiple operations tree
        IScrabble expectedValue = new Scrabble_Float(-75*((22.5+902.345)/229));
        assertEquals(expectedValue, bigTree.calculate());
        assertEquals(expectedValue.hashCode(), bigTree.calculate().hashCode());
    }

    @Test
    void toBinaryTest(){
        IScrabble expected = new Scrabble_Binary("11111111111111111111011000111100");
        IScrabble expected2 = new Scrabble_Binary("1101110001010");
        IScrabble expected3 = new Scrabble_Binary("11111111111111111110010001110110");

        IScrabble[] expecting = {expected, expected2, expected3, expected2};
        Component[] comps = {mult1, mult2, mult3, mult4, mult5, mult6, mult7, mult8, mult9, mult10, mult11, mult12, mult13, mult14,
                mult15, mult16, mult17, mult18, mult19, mult20, mult21, mult22, mult23, mult24, mult25};

        toSBinaryTest(expecting, comps);
    }

    @Test
    void toIntTest(){
        IScrabble expected = new Scrabble_Int(-2500);
        IScrabble expected2 = new Scrabble_Int(25*282);
        IScrabble expected3 = new Scrabble_Int(-25*282);

        IScrabble[] expecting = {expected, expected2, expected3, expected2};

        toSIntTest(expecting, comps);
    }

    @Test
    void toFloatTest(){
        IScrabble expected = new Scrabble_Float(-2500.0);
        IScrabble expected2 = new Scrabble_Float(25*22.5);
        IScrabble expected3 = new Scrabble_Float(25*282);
        IScrabble expected4 = new Scrabble_Float(22.5*-902.345);
        IScrabble expected5 = new Scrabble_Float(22.5*282);
        IScrabble expected6 = new Scrabble_Float(282*-25);

        IScrabble[] expecting = {expected, expected2, expected3, expected4, expected2, expected5,
                expected6, expected3};

        toSFloatTest(expecting, comps);
    }

    @Test
    void toStringTest(){

        IScrabble expected = new Scrabble_String("-2500");
        IScrabble expected2 = new Scrabble_String("562.5");
        IScrabble expected3 = new Scrabble_String("7050");
        IScrabble expected4 = new Scrabble_String("-20302.7625");
        IScrabble expected5 = new Scrabble_String("6345.0");
        IScrabble expected6 = new Scrabble_String("11111111111111111110010001110110");
        IScrabble expected7 = new Scrabble_String("1101110001010");

        IScrabble[] expecting = {expected, expected2, expected3, expected4, expected2, expected5, expected6
                , expected7};

        toSStringTest(expecting, comps);
    }

    @Test
    void toBoolTest(){
        IScrabble[] expected = {};
        toSBoolTest(expected, comps);
    }
}
