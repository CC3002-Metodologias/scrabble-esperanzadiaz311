package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrTest extends TreeLogicalTest {
    private Or or1, or2, or3, or4, or5, or6, or7, or8, or9, or10, or11, or12, or13, or14,
            or15, or16, or17, or18, or19, or20, or21, or22, or23, or24, or25, bigTree;
    private Component[] comps;

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
        
        comps = new Component[] {or1, or2, or3, or4, or5, or6, or7, or8, or9, or10, or11, or12, or13, or14,
                or15, or16, or17, or18, or19, or20, or21, or22, or23, or24, or25};
    }

    @Test
    public void OrTest(){
        // Basic Or Tree (Leaf <- Or -> Leaf)

        // Leaves: ScrabbleInt x2
        assertNull(or1.calculate());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertNull(or3.calculate());
        // Leaves: ScrabbleInt, ScrabbleBinary
        assertNull(or4.calculate());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(or5.calculate());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(or6.calculate());

        // Leaves: ScrabbleString x2
        assertNull(or7.calculate());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(or8.calculate());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(or9.calculate());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(or2.calculate());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(or10.calculate());

        // Leaves: ScrabbleFloat x2
        assertNull(or11.calculate());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertNull(or12.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertNull(or13.calculate());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(or14.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(or15.calculate());

        // Leaves: ScrabbleBinary x2
        IScrabble expected = new Scrabble_Binary("11111111111111111111111111111111");
        assertEquals(expected, or16.calculate());
        assertEquals(expected.hashCode(), or16.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertNull(or17.calculate());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(or18.calculate());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(or19.calculate());
        // Leaves: ScrabbleBinary, ScrabbleBool
        IScrabble expected3 = new Scrabble_Binary("111111111");
        assertEquals(expected3, or20.calculate());
        assertEquals(expected3.hashCode(), or20.calculate().hashCode());

        // Leaves: ScrabbleBool x2
        IScrabble expected2 = new Scrabble_Bool(true);
        assertEquals(expected2, or21.calculate());
        assertEquals(expected2.hashCode(), or21.calculate().hashCode());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(or22.calculate());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(or23.calculate());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(or24.calculate());
        // Leaves: ScrabbleBool, ScrabbleBinary
        IScrabble expected12 = new Scrabble_Binary("111111111");
        assertEquals(expected12, or25.calculate());
        assertEquals(expected12.hashCode(), or25.calculate().hashCode());
    }

    @Test
    void toBinaryTest(){
        IScrabble expected = new Scrabble_Binary("11111111111111111111111111111111");
        IScrabble expected2 = new Scrabble_Binary("111111111");

        IScrabble[] expecting = {expected, expected2, expected2};
        toSBinaryTest(expecting, comps);
    }

    @Test
    void toIntTest(){
        IScrabble expected = new Scrabble_Int(-1);
        IScrabble expected2 = new Scrabble_Int(511);

        IScrabble[] expecting = {expected, expected2, expected2};
        toSIntTest(expecting, comps);
    }

    @Test
    void toFloatTest(){
        IScrabble expected = new Scrabble_Float(-1.0);
        IScrabble expected2 = new Scrabble_Float(511.0);

        IScrabble[] expecting = {expected, expected2, expected2};
        toSFloatTest(expecting, comps);
    }

    @Test
    void toStringTest(){
        IScrabble expected = new Scrabble_String("11111111111111111111111111111111");
        IScrabble expected2 = new Scrabble_String("111111111");
        IScrabble expected3 = new Scrabble_String("true");

        IScrabble[] expecting = {expected, expected2, expected3, expected2};
        toSStringTest(expecting, comps);
    }

    @Test
    void toBoolTest(){
        IScrabble expected = new Scrabble_Bool(true);

        IScrabble[] expecting = {expected};
        toSBoolTest(expecting, comps);
    }
}
