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

public class DivTest extends TreeArithmeticTest {
    private Div div1, div2, div3, div4, div5, div6, div7, div8, div9, div10, div11, div12, div13, div14,
            div15, div16, div17, div18, div19, div20, div21, div22, div23, div24, div25, bigTree;
    private Component[] comps;

    @BeforeEach
    public void setUp(){
        SetUp();

        div1 = new Div(l1, l2); // Leaves: ScrabbleInt x2
        div3 = new Div(l1, l5); // Leaves: ScrabbleInt, ScrabbleFloat
        div4 = new Div(l1, l7); // Leaves: ScrabbleInt, ScrabbleBinary
        div5= new Div(l1, l3);  // Leaves: ScrabbleInt, ScrabbleString
        div6 = new Div(l1, l9); // Leaves: ScrabbleInt, ScrabbleBool

        div7 = new Div(l3, l4); // Leaves: ScrabbleString x2
        div2 = new Div(l3, l1); // ScrabbleString and ScrabbleInt
        div8 = new Div(l3, l9); // Leaves: ScrabbleString, ScrabbleBool
        div9 = new Div(l3, l5); // Leaves: ScrabbleString, ScrabbleFloat
        div10 = new Div(l3, l7); // Leaves: ScrabbleString, ScrabbleBinary

        div11 = new Div(l5, l6); // Leaves: ScrabbleFloat x2
        div12 = new Div(l5, l1); // Leaves: ScrabbleFloat, ScrabbleInt
        div13 = new Div(l5, l7); // Leaves: ScrabbleFloat, ScrabbleBinary
        div14 = new Div(l5, l3); // Leaves: ScrabbleFloat, ScrabbleString
        div15 = new Div(l5, l9); // Leaves: ScrabbleFloat, ScrabbleBool

        div16 = new Div(l7, l8); // Leaves: ScrabbleBinary x2
        div17 = new Div(l7, l1); // Leaves: ScrabbleBinary, ScrabbleInt
        div18 = new Div(l7, l5); // Leaves: ScrabbleBinary, ScrabbleFloat
        div19 = new Div(l7, l3); // Leaves: ScrabbleBinary, ScrabbleString
        div20 = new Div(l7, l9); // Leaves: ScrabbleBinary, ScrabbleBool

        div21 = new Div(l9, l10); // Leaves: ScrabbleBool x2
        div22 = new Div(l9, l1); // Leaves: ScrabbleBool, ScrabbleInt
        div23 = new Div(l9, l5); // Leaves: ScrabbleBool, ScrabbleFloat
        div24 = new Div(l9, l3); // Leaves: ScrabbleBool, ScrabbleString
        div25 = new Div(l9, l7); // Leaves: ScrabbleBool, ScrabbleBinary

        bigTree = new Div(new Add(l1, l2), new Mult(new Sub(l5, l6), new Not(new Or(l7, new And(l7, l9)))));

        comps = new Component[] {div1, div2, div3, div4, div5, div6, div7, div8, div9, div10, div11, div12, div13, div14,
                div15, div16, div17, div18, div19, div20, div21, div22, div23, div24, div25};

    }

    @Test
    public void divTest(){

        // Basic Div Tree (Leaf <- Div -> Leaf)

        // Leaves: ScrabbleInt x2
        IScrabble expected = new Scrabble_Int(25/-100);
        assertEquals(expected, div1.calculate());
        assertEquals(expected.hashCode(), div1.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        IScrabble expected2 = new Scrabble_Float(25/22.5);
        assertEquals(expected2, div3.calculate());
        assertEquals(expected2.hashCode(), div3.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        IScrabble expected3 = new Scrabble_Int(25/282);
        assertEquals(expected3, div4.calculate());
        assertEquals(expected3.hashCode(), div4.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(div5.calculate());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(div6.calculate());

        // Leaves: ScrabbleString x2
        assertNull(div7.calculate());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(div8.calculate());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(div9.calculate());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(div2.calculate());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(div10.calculate());

        // Leaves: ScrabbleFloat x2
        IScrabble expected9 = new Scrabble_Float(22.5/-902.345);
        assertEquals(expected9, div11.calculate());
        assertEquals(expected9.hashCode(), div11.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        IScrabble expected10 = new Scrabble_Float(22.5/25);
        assertEquals(expected10, div12.calculate());
        assertEquals(expected10.hashCode(), div12.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        IScrabble expected11 = new Scrabble_Float(22.5/282);
        assertEquals(expected11, div13.calculate());
        assertEquals(expected11.hashCode(), div13.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(div14.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(div15.calculate());

        // Leaves: ScrabbleBinary x2
        IScrabble expected12 = new Scrabble_Binary("11111111111111111111111111110101");
        assertEquals(expected12, div16.calculate());
        assertEquals(expected12.hashCode(), div16.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        IScrabble expected13 = new Scrabble_Binary("1011");
        assertEquals(expected13, div17.calculate());
        assertEquals(expected13.hashCode(), div17.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(div18.calculate());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(div19.calculate());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(div20.calculate());

        // Leaves: ScrabbleBool x2
        assertNull(div21.calculate());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(div22.calculate());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(div23.calculate());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(div24.calculate());
        // Leaves: ScrabbleBool, ScrabbleBinary
        assertNull(div25.calculate());

        // multiple operations tree
        IScrabble expectedValue = new Scrabble_Float(-75/((22.5+902.345)*229));
        assertEquals(expectedValue, bigTree.calculate());
        assertEquals(expectedValue.hashCode(), bigTree.calculate().hashCode());
    }

    @Test
    void toBinaryTest() {
        IScrabble expected = new Scrabble_Binary("0");
        IScrabble expected2 = new Scrabble_Binary("11111111111111111111111111110101");
        IScrabble expected3 = new Scrabble_Binary("1011");

        IScrabble[] expecting = {expected, expected, expected2, expected3};

        toSBinaryTest(expecting, comps);
    }

    @Test
    void toIntTest(){
        IScrabble expected = new Scrabble_Int(0);
        IScrabble expected2 = new Scrabble_Int(282/-25);
        IScrabble expected3 = new Scrabble_Int(11);

        IScrabble[] expecting = {expected, expected, expected2, expected3};

        toSIntTest(expecting, comps);
    }


    @Test
    void toFloatTest(){
        IScrabble expected = new Scrabble_Float(0.0);
        IScrabble expected2 = new Scrabble_Float(25/22.5);
        IScrabble expected3 = new Scrabble_Float(22.5/-902.345);
        IScrabble expected4 = new Scrabble_Float(22.5/25);
        IScrabble expected5 = new Scrabble_Float(22.5/282);
        IScrabble expected6 = new Scrabble_Float(-11.0);
        IScrabble expected7 = new Scrabble_Float(11.0);

        IScrabble[] expecting = {expected, expected2, expected, expected3, expected4, expected5,
                expected6, expected7};

        toSFloatTest(expecting, comps);
    }

    @Test
    void toStringTest(){

        IScrabble expected = new Scrabble_String("0");
        IScrabble expected2 = new Scrabble_String(String.valueOf(25/22.5));
        IScrabble expected3 = new Scrabble_String(String.valueOf(22.5/-902.345));
        IScrabble expected4 = new Scrabble_String(String.valueOf(22.5/25));
        IScrabble expected5 = new Scrabble_String(String.valueOf(22.5/282));
        IScrabble expected6 = new Scrabble_String("11111111111111111111111111110101");
        IScrabble expected7 = new Scrabble_String("1011");

        IScrabble[] expecting = {expected, expected2, expected, expected3, expected4, expected5, expected6
                , expected7};

        toSStringTest(expecting, comps);
    }

    @Test
    void toBoolTest(){
        IScrabble[] expected = {};
        toSBoolTest(expected, comps);
    }
}
