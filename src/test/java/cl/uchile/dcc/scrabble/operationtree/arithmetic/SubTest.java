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

public class SubTest extends TreeArithmeticTest {
    private Sub sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10, sub11, sub12, sub13, sub14,
            sub15, sub16, sub17, sub18, sub19, sub20, sub21, sub22, sub23, sub24, sub25, bigTree;
    private Component[] comps;

    @BeforeEach
    public void setUp(){
        SetUp();

        sub1 = new Sub(l1, l2); // Leaves: ScrabbleInt x2
        sub3 = new Sub(l1, l5); // Leaves: ScrabbleInt, ScrabbleFloat
        sub4 = new Sub(l1, l7); // Leaves: ScrabbleInt, ScrabbleBinary
        sub5= new Sub(l1, l3);  // Leaves: ScrabbleInt, ScrabbleString
        sub6 = new Sub(l1, l9); // Leaves: ScrabbleInt, ScrabbleBool

        sub7 = new Sub(l3, l4); // Leaves: ScrabbleString x2
        sub2 = new Sub(l3, l1); // ScrabbleString and ScrabbleInt
        sub8 = new Sub(l3, l9); // Leaves: ScrabbleString, ScrabbleBool
        sub9 = new Sub(l3, l5); // Leaves: ScrabbleString, ScrabbleFloat
        sub10 = new Sub(l3, l7); // Leaves: ScrabbleString, ScrabbleBinary

        sub11 = new Sub(l5, l6); // Leaves: ScrabbleFloat x2
        sub12 = new Sub(l5, l1); // Leaves: ScrabbleFloat, ScrabbleInt
        sub13 = new Sub(l5, l7); // Leaves: ScrabbleFloat, ScrabbleBinary
        sub14 = new Sub(l5, l3); // Leaves: ScrabbleFloat, ScrabbleString
        sub15 = new Sub(l5, l9); // Leaves: ScrabbleFloat, ScrabbleBool

        sub16 = new Sub(l7, l8); // Leaves: ScrabbleBinary x2
        sub17 = new Sub(l7, l1); // Leaves: ScrabbleBinary, ScrabbleInt
        sub18 = new Sub(l7, l5); // Leaves: ScrabbleBinary, ScrabbleFloat
        sub19 = new Sub(l7, l3); // Leaves: ScrabbleBinary, ScrabbleString
        sub20 = new Sub(l7, l9); // Leaves: ScrabbleBinary, ScrabbleBool

        sub21 = new Sub(l9, l10); // Leaves: ScrabbleBool x2
        sub22 = new Sub(l9, l1); // Leaves: ScrabbleBool, ScrabbleInt
        sub23 = new Sub(l9, l5); // Leaves: ScrabbleBool, ScrabbleFloat
        sub24 = new Sub(l9, l3); // Leaves: ScrabbleBool, ScrabbleString
        sub25 = new Sub(l9, l7); // Leaves: ScrabbleBool, ScrabbleBinary

        bigTree = new Sub(new Add(l1, l2), new Mult(new Div(l5, l6), new Not(new Or(l7, new And(l7, l9)))));

        comps = new Component[] {sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10, sub11, sub12, sub13, sub14,
                sub15, sub16, sub17, sub18, sub19, sub20, sub21, sub22, sub23, sub24, sub25};
    }

    @Test
    public void subTest(){

        // Basic Sub Tree (Leaf <- Sub -> Leaf)

        // Leaves: ScrabbleInt x2
        IScrabble expected = new Scrabble_Int(125);
        assertEquals(expected, sub1.calculate());
        assertEquals(expected.hashCode(), sub1.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        IScrabble expected2 = new Scrabble_Float(25-22.5);
        assertEquals(expected2, sub3.calculate());
        assertEquals(expected2.hashCode(), sub3.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        IScrabble expected3 = new Scrabble_Int(25-282);
        assertEquals(expected3, sub4.calculate());
        assertEquals(expected3.hashCode(), sub4.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(sub5.calculate());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(sub6.calculate());

        // Leaves: ScrabbleString x2
        assertNull(sub7.calculate());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(sub8.calculate());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(sub9.calculate());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(sub2.calculate());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(sub10.calculate());

        // Leaves: ScrabbleFloat x2
        IScrabble expected9 = new Scrabble_Float(22.5+902.345);
        assertEquals(expected9, sub11.calculate());
        assertEquals(expected9.hashCode(), sub11.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        IScrabble expected10 = new Scrabble_Float(22.5-25);
        assertEquals(expected10, sub12.calculate());
        assertEquals(expected10.hashCode(), sub12.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        IScrabble expected11 = new Scrabble_Float(22.5-282);
        assertEquals(expected11, sub13.calculate());
        assertEquals(expected11.hashCode(), sub13.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(sub14.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(sub15.calculate());

        // Leaves: ScrabbleBinary x2
        IScrabble expected12 = new Scrabble_Binary("100110011");
        assertEquals(expected12, sub16.calculate());
        assertEquals(expected12.hashCode(), sub16.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        IScrabble expected13 = new Scrabble_Binary("100000001");
        assertEquals(expected13, sub17.calculate());
        assertEquals(expected13.hashCode(), sub17.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(sub18.calculate());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(sub19.calculate());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(sub20.calculate());

        // Leaves: ScrabbleBool x2
        assertNull(sub21.calculate());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(sub22.calculate());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(sub23.calculate());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(sub24.calculate());
        // Leaves: ScrabbleBool, ScrabbleBinary
        assertNull(sub25.calculate());

        // multiple operations tree
        IScrabble expectedValue = new Scrabble_Float(-75-(22.5/-902.345)*229);
        assertEquals(expectedValue, bigTree.calculate());
        assertEquals(expectedValue.hashCode(), bigTree.calculate().hashCode());
    }

    @Test
    void toBinaryTest(){
        IScrabble expected = new Scrabble_Binary("1111101");
        IScrabble expected2 = new Scrabble_Binary("11111111111111111111111011111111");
        IScrabble expected3 = new Scrabble_Binary("100110011");
        IScrabble expected4 = new Scrabble_Binary("100000001");

        IScrabble[] expecting = {expected, expected2, expected3, expected4};

        toSBinaryTest(expecting, comps);
    }

    @Test
    void toIntTest(){
        IScrabble expected4 = new Scrabble_Int(125);
        IScrabble expected = new Scrabble_Int(-257);
        IScrabble expected2 = new Scrabble_Int(307);
        IScrabble expected3 = new Scrabble_Int(257);

        IScrabble[] expecting = {expected4, expected, expected2, expected3};

        toSIntTest(expecting, comps);
    }

    @Test
    void toFloatTest(){
        IScrabble expected = new Scrabble_Float(125.0);
        IScrabble expected2 = new Scrabble_Float(25-22.5);
        IScrabble expected3 = new Scrabble_Float(25-282);
        IScrabble expected4 = new Scrabble_Float(22.5+902.345);
        IScrabble expected5 = new Scrabble_Float(22.5-25);
        IScrabble expected6 = new Scrabble_Float(22.5-282);
        IScrabble expected7 = new Scrabble_Float(307.0);
        IScrabble expected8 = new Scrabble_Float(257.0);

        IScrabble[] expecting = {expected, expected2, expected3, expected4, expected5, expected6,
                expected7, expected8};

        toSFloatTest(expecting, comps);
    }

    @Test
    void toStringTest(){
        IScrabble expected = new Scrabble_String("125");
        IScrabble expected2 = new Scrabble_String("2.5");
        IScrabble expected3 = new Scrabble_String("-257");
        IScrabble expected4 = new Scrabble_String("924.845");
        IScrabble expected5 = new Scrabble_String("-2.5");
        IScrabble expected6 = new Scrabble_String("-259.5");
        IScrabble expected7 = new Scrabble_String("100110011");
        IScrabble expected8 = new Scrabble_String("100000001");

        IScrabble[] expecting = {expected, expected2, expected3, expected4, expected5, expected6, expected7
                , expected8};

        toSStringTest(expecting, comps);
    }

    @Test
    void toBoolTest(){
        IScrabble[] expected = {};
        toSBoolTest(expected, comps);
    }
}
