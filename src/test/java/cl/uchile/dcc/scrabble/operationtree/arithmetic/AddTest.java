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

public class AddTest extends TreeArithmeticTest {
    private Add add1, add2, add3, add4, add5, add6, add7, add8, add9, add10, add11, add12, add13, add14,
            add15, add16, add17, add18, add19, add20, add21, add22, add23, add24, add25, bigTree;
    private Component[] comps;

    @BeforeEach
    public void setUp(){
        SetUp();

        add1 = new Add(l1, l2); // Leaves: ScrabbleInt x2
        add3 = new Add(l1, l5); // Leaves: ScrabbleInt, ScrabbleFloat
        add4 = new Add(l1, l7); // Leaves: ScrabbleInt, ScrabbleBinary
        add5= new Add(l1, l3);  // Leaves: ScrabbleInt, ScrabbleString
        add6 = new Add(l1, l9); // Leaves: ScrabbleInt, ScrabbleBool

        add7 = new Add(l3, l4); // Leaves: ScrabbleString x2
        add2 = new Add(l3, l1); // ScrabbleString and ScrabbleInt
        add8 = new Add(l3, l9); // Leaves: ScrabbleString, ScrabbleBool
        add9 = new Add(l3, l5); // Leaves: ScrabbleString, ScrabbleFloat
        add10 = new Add(l3, l7); // Leaves: ScrabbleString, ScrabbleBinary

        add11 = new Add(l5, l6); // Leaves: ScrabbleFloat x2
        add12 = new Add(l5, l1); // Leaves: ScrabbleFloat, ScrabbleInt
        add13 = new Add(l5, l7); // Leaves: ScrabbleFloat, ScrabbleBinary
        add14 = new Add(l5, l3); // Leaves: ScrabbleFloat, ScrabbleString
        add15 = new Add(l5, l9); // Leaves: ScrabbleFloat, ScrabbleBool

        add16 = new Add(l7, l8); // Leaves: ScrabbleBinary x2
        add17 = new Add(l7, l1); // Leaves: ScrabbleBinary, ScrabbleInt
        add18 = new Add(l7, l5); // Leaves: ScrabbleBinary, ScrabbleFloat
        add19 = new Add(l7, l3); // Leaves: ScrabbleBinary, ScrabbleString
        add20 = new Add(l7, l9); // Leaves: ScrabbleBinary, ScrabbleBool

        add21 = new Add(l9, l10); // Leaves: ScrabbleBool x2
        add22 = new Add(l9, l1); // Leaves: ScrabbleBool, ScrabbleInt
        add23 = new Add(l9, l5); // Leaves: ScrabbleBool, ScrabbleFloat
        add24 = new Add(l9, l3); // Leaves: ScrabbleBool, ScrabbleString
        add25 = new Add(l9, l7); // Leaves: ScrabbleBool, ScrabbleBinary

        bigTree = new Add(new Sub(l1, l2), new Mult(new Div(l5, l6), new Not(new Or(l7, new And(l7, l9)))));

        comps = new Component[]{add1, add2, add3, add4, add5, add6, add7, add8, add9, add10, add11, add12, add13, add14,
                add15, add16, add17, add18, add19, add20, add21, add22, add23, add24, add25};

    }

    @Test
    public void addTest(){

        // Basic Add Tree (Leaf <- Add -> Leaf)

        // Leaves: ScrabbleInt x2
        IScrabble expected = new Scrabble_Int(-75);
        assertEquals(expected, add1.calculate());
        assertEquals(expected.hashCode(), add1.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        IScrabble expected2 = new Scrabble_Float(47.5);
        assertEquals(expected2, add3.calculate());
        assertEquals(expected2.hashCode(), add3.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        IScrabble expected3 = new Scrabble_Int(307);
        assertEquals(expected3, add4.calculate());
        assertEquals(expected3.hashCode(), add4.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(add5.calculate());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(add6.calculate());

        // Leaves: ScrabbleString x2
        IScrabble expected4 = new Scrabble_String("testingnew testing");
        assertEquals(expected4, add7.calculate());
        assertEquals(expected4.hashCode(), add7.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleBool
        IScrabble expected5 = new Scrabble_String("testingtrue");
        assertEquals(expected5, add8.calculate());
        assertEquals(expected5.hashCode(), add8.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleFloat
        IScrabble expected6 = new Scrabble_String("testing22.5");
        assertEquals(expected6, add9.calculate());
        assertEquals(expected6.hashCode(), add9.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleInt
        IScrabble expected7 = new Scrabble_String("testing25");
        assertEquals(expected7, add2.calculate());
        assertEquals(expected7.hashCode(), add2.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleBinary
        IScrabble expected8 = new Scrabble_String("testing100011010");
        assertEquals(expected8, add10.calculate());
        assertEquals(expected8.hashCode(), add10.calculate().hashCode());

        // Leaves: ScrabbleFloat x2
        IScrabble expected9 = new Scrabble_Float(22.5-902.345);
        assertEquals(expected9, add11.calculate());
        assertEquals(expected9.hashCode(), add11.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        IScrabble expected10 = new Scrabble_Float(22.5+25);
        assertEquals(expected10, add12.calculate());
        assertEquals(expected10.hashCode(), add12.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        IScrabble expected11 = new Scrabble_Float(22.5+282);
        assertEquals(expected11, add13.calculate());
        assertEquals(expected11.hashCode(), add13.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(add14.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(add15.calculate());

        // Leaves: ScrabbleBinary x2
        IScrabble expected12 = new Scrabble_Binary("100000001");
        assertEquals(expected12, add16.calculate());
        assertEquals(expected12.hashCode(), add16.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        IScrabble expected13 = new Scrabble_Binary("100110011");
        assertEquals(expected13, add17.calculate());
        assertEquals(expected13.hashCode(), add17.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(add18.calculate());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(add19.calculate());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(add20.calculate());

        // Leaves: ScrabbleBool x2
        assertNull(add21.calculate());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(add22.calculate());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(add23.calculate());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(add24.calculate());
        // Leaves: ScrabbleBool, ScrabbleBinary
        assertNull(add25.calculate());

        // multiple operations tree
        IScrabble expectedValue = new Scrabble_Float(125+(22.5/-902.345)*229);
        assertEquals(expectedValue, bigTree.calculate());
        assertEquals(expectedValue.hashCode(), bigTree.calculate().hashCode());
    }

    @Test
    void toBinaryTest(){

        IScrabble expected = new Scrabble_Binary("11111111111111111111111110110101");
        IScrabble expected2 = new Scrabble_Binary("100110011");
        IScrabble expected3 = new Scrabble_Binary("100000001");

        IScrabble[] expecting = {expected, expected2, expected3, expected2};

        toSBinaryTest(expecting, comps);
    }

    @Test
    void toIntTest(){
        IScrabble expected = new Scrabble_Int(-75);
        IScrabble expected2 = new Scrabble_Int(307);
        IScrabble expected3 = new Scrabble_Int(257);

        IScrabble[] expecting = {expected, expected2, expected3, expected2};

        toSIntTest(expecting, comps);
    }

    @Test
    void toFloatTest(){
        IScrabble expected = new Scrabble_Float(-75.0);
        IScrabble expected2 = new Scrabble_Float(47.5);
        IScrabble expected3 = new Scrabble_Float(307.0);
        IScrabble expected4 = new Scrabble_Float(22.5-902.345);
        IScrabble expected5 = new Scrabble_Float(22.5+25);
        IScrabble expected6 = new Scrabble_Float(22.5+282);
        IScrabble expected7 = new Scrabble_Float(257.0);
        IScrabble expected8 = new Scrabble_Float(307.0);

        IScrabble[] expecting = {expected, expected2, expected3, expected4, expected5, expected6,
                expected7, expected8};

        toSFloatTest(expecting, comps);
    }

    @Test
    void toStringTest(){
        IScrabble expected = new Scrabble_String("-75");
        IScrabble expected2 = new Scrabble_String("47.5");
        IScrabble expected3 = new Scrabble_String("307");
        IScrabble expected4 = new Scrabble_String("testingnew testing");
        IScrabble expected5 = new Scrabble_String("testingtrue");
        IScrabble expected6 = new Scrabble_String("testing22.5");
        IScrabble expected7 = new Scrabble_String("testing25");
        IScrabble expected8 = new Scrabble_String("testing100011010");
        IScrabble expected9 = new Scrabble_String("-879.845");
        IScrabble expected10 = new Scrabble_String("304.5");
        IScrabble expected11 = new Scrabble_String("100000001");
        IScrabble expected12 = new Scrabble_String("100110011");

        IScrabble[] expecting = {expected, expected2, expected3, expected4, expected5, expected6, expected7
                , expected8, expected9, expected2, expected10, expected11, expected12};

        // Leaves: ScrabbleInt x2
        assertEquals(expecting[0], comps[0].toSString());
        assertEquals(expecting[0].hashCode(), comps[0].toSString().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertEquals(expecting[1], comps[2].toSString());
        assertEquals(expecting[1].hashCode(), comps[2].toSString().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        assertEquals(expecting[2], comps[3].toSString());
        assertEquals(expecting[2].hashCode(), comps[3].toSString().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(comps[4].toSString());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(comps[5].toSString());

        // Leaves: ScrabbleString x2
        assertEquals(expecting[3], comps[6].toSString());
        assertEquals(expecting[3].hashCode(), comps[6].toSString().hashCode());
        // Leaves: ScrabbleString, ScrabbleBool
        assertEquals(expecting[4], comps[7].toSString());
        assertEquals(expecting[4].hashCode(), comps[7].toSString().hashCode());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertEquals(expecting[5], comps[8].toSString());
        assertEquals(expecting[5].hashCode(), comps[8].toSString().hashCode());
        // Leaves: ScrabbleString, ScrabbleInt
        assertEquals(expecting[6], comps[1].toSString());
        assertEquals(expecting[6].hashCode(), comps[1].toSString().hashCode());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertEquals(expecting[7], comps[9].toSString());
        assertEquals(expecting[7].hashCode(), comps[9].toSString().hashCode());

        // Leaves: ScrabbleFloat x2
        assertEquals(expecting[8], comps[10].toSString());
        assertEquals(expecting[8].hashCode(), comps[10].toSString().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertEquals(expecting[9], comps[11].toSString());
        assertEquals(expecting[9].hashCode(), comps[11].toSString().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertEquals(expecting[10], comps[12].toSString());
        assertEquals(expecting[10].hashCode(), comps[12].toSString().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(comps[13].toSString());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(comps[14].toSString());

        // Leaves: ScrabbleBinary x2
        assertEquals(expecting[11], comps[15].toSString());
        assertEquals(expecting[11].hashCode(), comps[15].toSString().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertEquals(expecting[12], comps[16].toSString());
        assertEquals(expecting[12].hashCode(), comps[16].toSString().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(comps[17].toSString());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(comps[18].toSString());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(comps[19].toSString());

        // Leaves: ScrabbleBool x2
        assertNull(comps[20].toSString());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comps[21].toSString());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(comps[22].toSString());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(comps[23].toSString());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comps[24].toSString());
    }

    @Test
    void toBoolTest(){
        IScrabble[] expected = {};
        toSBoolTest(expected, comps);
    }

}
