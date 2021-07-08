package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Scrabble_IntTest {
    private Scrabble_Int s_int;
    private Scrabble_Int s_int2;
    private Scrabble_Int s_int3;
    private Scrabble_Binary s_bin;
    private Scrabble_Binary s_bin2;
    private Scrabble_Float s_float;
    private Scrabble_String string;
    private Scrabble_Bool bool;
    private final int i1 = 101219;
    private final int i2 = 456724;
    private final int binToInt = -2147318104;
    private final String str = "101219";
    private final String bin = "10000000000000101000011010101000"; // -2147318104
    private final String string_val = "testing";
    private final double float1 = 7152.47;
    private final boolean t = true;

    @BeforeEach
    void setUp(){
        s_int = new Scrabble_Int(i1);
        s_int2 = new Scrabble_Int(i2);
        s_int3 = new Scrabble_Int(binToInt);
        s_bin = new Scrabble_Binary(str);
        s_bin2 = new Scrabble_Binary(bin);
        s_float = new Scrabble_Float(float1);
        string = new Scrabble_String(string_val);
        bool = new Scrabble_Bool(t);

    }

    @Test
    void constructorTest(){
        Scrabble_Int expected = new Scrabble_Int(101219);

        // same class and value
        assertEquals(expected, s_int);
        assertEquals(expected.hashCode(), s_int.hashCode());

        // same class, different value
        assertNotEquals(expected, s_int2);
        assertNotEquals(expected.hashCode(), s_int2.hashCode());

        // different class
        assertNotEquals(expected, s_bin);
        assertNotEquals(expected.hashCode(), s_bin.hashCode());
    }

    @Test
    void toScrabbleString(){
        Scrabble_String expected = new Scrabble_String("101219");
        assertEquals(expected, s_int.toScrabbleString());
        assertEquals(expected.hashCode(), (s_int.toScrabbleString()).hashCode());
    }

    @Test
    void toFloatTest(){
        Scrabble_Float expected = new Scrabble_Float(101219.0);
        assertEquals(expected, s_int.toFloat());
        assertEquals(expected.hashCode(), (s_int.toFloat()).hashCode());
    }

    @Test
    void toIntTest(){
        Scrabble_Int expected = new Scrabble_Int(i1);
        assertEquals(expected, s_int.toInt());
        assertEquals(expected.hashCode(), (s_int.toInt()).hashCode());
    }

    @Test
    void toBinaryTest(){
        Scrabble_Binary expected = new Scrabble_Binary("11000101101100011");
        Scrabble_Binary expected2 = new Scrabble_Binary("10000000000000101000011010101000");
        assertEquals(expected, s_int.toBinary());
        assertEquals(expected.hashCode(), s_int.toBinary().hashCode());
        assertEquals(expected2, s_int3.toBinary());
        assertEquals(expected2.hashCode(), s_int3.toBinary().hashCode());
    }

    @Test
    void addTest(){
        IScrabble expected1 = new Scrabble_Int(i1 + i2);
        IScrabble expected2 = new Scrabble_Float(i1 + float1);
        IScrabble expected3 = new Scrabble_Int(i1 + binToInt);
        // ScrabbleInt + ScrabbleInt
        assertEquals(expected1, s_int.add(s_int2));
        assertEquals(expected1.hashCode(), s_int.add(s_int2).hashCode());

        // ScrabbleInt + ScrabbleFloat
        assertEquals(expected2, s_int.add(s_float));
        assertEquals(expected2.hashCode(), s_int.add(s_float).hashCode());

        // ScrabbleInt + ScrabbleBinary
        assertEquals(expected3, s_int.add(s_bin2));
        assertEquals(expected3.hashCode(), s_int.add(s_bin2).hashCode());

        // ScrabbleInt * ScrabbleString
        assertNull(s_int3.add(string));

        // ScrabbleInt * ScrabbleBool
        assertNull(s_int3.add(bool));

    }

    @Test
    void subTest(){
        IScrabble expected1 = new Scrabble_Int(i1 - i2);
        IScrabble expected2 = new Scrabble_Float(i1 - float1);
        IScrabble expected3 = new Scrabble_Int(i1 - binToInt);
        // ScrabbleInt - ScrabbleInt
        assertEquals(expected1, s_int.sub(s_int2));
        assertEquals(expected1.hashCode(), s_int.sub(s_int2).hashCode());

        // ScrabbleInt - ScrabbleFloat
        assertEquals(expected2, s_int.sub(s_float));
        assertEquals(expected2.hashCode(), s_int.sub(s_float).hashCode());

        // ScrabbleInt - ScrabbleBinary
        assertEquals(expected3, s_int.sub(s_bin2));
        assertEquals(expected3.hashCode(), s_int.sub(s_bin2).hashCode());

        // ScrabbleInt * ScrabbleString
        assertNull(s_int3.sub(string));

        // ScrabbleInt * ScrabbleBool
        assertNull(s_int3.sub(bool));
    }

    @Test
    void multTest(){
        IScrabble expected1 = new Scrabble_Int(i1 * i2);
        IScrabble expected2 = new Scrabble_Float(i1 * float1);
        IScrabble expected3 = new Scrabble_Int(i1 * binToInt);
        // ScrabbleInt * ScrabbleInt
        assertEquals(expected1, s_int.mult(s_int2));
        assertEquals(expected1.hashCode(), s_int.mult(s_int2).hashCode());

        // ScrabbleInt * ScrabbleFloat
        assertEquals(expected2, s_int.mult(s_float));
        assertEquals(expected2.hashCode(), s_int.mult(s_float).hashCode());

        // ScrabbleInt * ScrabbleBinary
        assertEquals(expected3, s_int.mult(s_bin2));
        assertEquals(expected3.hashCode(), s_int.mult(s_bin2).hashCode());

        // ScrabbleInt * ScrabbleString
        assertNull(s_int3.mult(string));

        // ScrabbleInt * ScrabbleBool
        assertNull(s_int3.mult(bool));
    }

    @Test
    void divTest(){
        IScrabble expected1 = new Scrabble_Int(i1 / i2);
        IScrabble expected2 = new Scrabble_Float(i1 / float1);
        IScrabble expected3 = new Scrabble_Int(i1 / binToInt);
        // ScrabbleInt / ScrabbleInt
        assertEquals(expected1, s_int.div(s_int2));
        assertEquals(expected1.hashCode(), s_int.div(s_int2).hashCode());

        // ScrabbleInt / ScrabbleFloat
        assertEquals(expected2, s_int.div(s_float));
        assertEquals(expected2.hashCode(), s_int.div(s_float).hashCode());

        // ScrabbleInt / ScrabbleBinary
        assertEquals(expected3, s_int.div(s_bin2));
        assertEquals(expected3.hashCode(), s_int.div(s_bin2).hashCode());

        // ScrabbleInt * ScrabbleString
        assertNull(s_int3.div(string));

        // ScrabbleInt * ScrabbleBool
        assertNull(s_int3.div(bool));
    }

    @Test
    void andTest(){
        // ScrabbleInt && ScrabbleBinary
        assertNull(s_int3.and(s_bin));

        // ScrabbleInt && ScrabbleBool
        assertNull(s_int3.and(s_bin));
    }

    @Test
    void orTest(){
        // ScrabbleInt || ScrabbleBinary
        assertNull(s_int3.or(s_bin));

        // ScrabbleInt || ScrabbleBool
        assertNull(s_int3.or(s_bin));
    }

    @Test
    void notTest(){
        assertNull(s_int3.not());
    }
}
