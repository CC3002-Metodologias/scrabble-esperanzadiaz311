package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SBoolFactory;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.TreeTest;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.And;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Not;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NotTest extends TreeLogicalTest {
    private Not not1, not2, not3, not4, not5, bigTree;

    @BeforeEach
    void setUp(){
        SetUp();

        not1 = new Not(l1);
        not2 = new Not(l3);
        not3 = new Not(l5);
        not4 = new Not(l7);
        not5 = new Not(l9);
    }

    @Test
    void NotTest(){
        // ScrabbleInt
        assertNull(not1.calculate());
        // ScrabbleString
        assertNull(not2.calculate());
        // ScrabbleFloat
        assertNull(not3.calculate());
        // ScrabbleBinary
        IScrabble expected = new Scrabble_Binary("011100101");
        assertEquals(expected, not4.calculate());
        assertEquals(expected.hashCode(), not4.calculate().hashCode());
        // ScrabbleBool
        IScrabble expected2 = new Scrabble_Bool(false);
        assertEquals(expected2, not5.calculate());
        assertEquals(expected2.hashCode(), not5.calculate().hashCode());
    }

    @Test
    void toBinaryTest(){
        // ScrabbleInt
        assertNull(not1.toSBinary());
        // ScrabbleString
        assertNull(not2.toSBinary());
        // ScrabbleFloat
        assertNull(not3.toSBinary());
        // ScrabbleBinary
        IScrabble expected = new Scrabble_Binary("011100101");
        assertEquals(expected, not4.toSBinary());
        assertEquals(expected.hashCode(), not4.toSBinary().hashCode());
        // ScrabbleBool
        assertNull(not5.toSBinary());

    }

    @Test
    void toIntTest(){
        // ScrabbleInt
        assertNull(not1.toSInt());
        // ScrabbleString
        assertNull(not2.toSInt());
        // ScrabbleFloat
        assertNull(not3.toSInt());
        // ScrabbleBinary
        IScrabble expected = new Scrabble_Int(229);
        assertEquals(expected, not4.toSInt());
        assertEquals(expected.hashCode(), not4.toSInt().hashCode());
        // ScrabbleBool
        assertNull(not5.toSInt());

    }

    @Test
    void toFloatTest(){
        // ScrabbleInt
        assertNull(not1.toSFloat());
        // ScrabbleString
        assertNull(not2.toSFloat());
        // ScrabbleFloat
        assertNull(not3.toSFloat());
        // ScrabbleBinary
        IScrabble expected = new Scrabble_Float(229.0);
        assertEquals(expected, not4.toSFloat());
        assertEquals(expected.hashCode(), not4.toSFloat().hashCode());
        // ScrabbleBool
        assertNull(not5.toSFloat());
    }

    @Test
    void toStringTest(){
        // ScrabbleInt
        assertNull(not1.toSString());
        // ScrabbleString
        assertNull(not2.toSString());
        // ScrabbleFloat
        assertNull(not3.toSString());
        // ScrabbleBinary
        IScrabble expected = new Scrabble_String("011100101");
        assertEquals(expected, not4.toSString());
        assertEquals(expected.hashCode(), not4.toSString().hashCode());
        // ScrabbleBool
        IScrabble expected2 = new Scrabble_String("false");
        assertEquals(expected2, not5.toSString());
        assertEquals(expected2.hashCode(), not5.toSString().hashCode());

    }

    @Test
    void toBoolTest(){
        // ScrabbleInt
        assertNull(not1.toSBool());
        // ScrabbleString
        assertNull(not2.toSBool());
        // ScrabbleFloat
        assertNull(not3.toSBool());
        // ScrabbleBinary
        assertNull(not4.toSBool());
        // ScrabbleBool
        IScrabble expected = new Scrabble_Bool(false);
        assertEquals(expected, not5.toSBool());
        assertEquals(expected.hashCode(), not5.toSBool().hashCode());

    }


}
