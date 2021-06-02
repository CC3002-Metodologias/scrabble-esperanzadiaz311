package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Scrabble_FloatTest {
    private Scrabble_Float s_float;
    private Scrabble_Float s_float2;
    private Scrabble_Int s_int;
    private Scrabble_Binary bin;
    private final double float1 = 3.19;
    private final double float2 = 4367.786401;
    private final int int1 = 5;
    private final String str = "3.19";
    private final String str2 = "1111101000000";
    private final int binToInt = 8000;

    @BeforeEach
    void setUp(){
        s_float = new Scrabble_Float(float1);
        s_float2 = new Scrabble_Float(float2);
        s_int = new Scrabble_Int(int1);
        bin = new Scrabble_Binary(str2);
    }

    @Test
    void constructorTest(){
        Scrabble_Float expected = new Scrabble_Float(float1);

        // same class and value
        assertEquals(expected, s_float);
        assertEquals(expected.hashCode(), s_float.hashCode());

        // different class
        assertNotEquals(expected, s_int);
        assertNotEquals(expected.hashCode(), s_int.hashCode());

        // same class, different value
        assertNotEquals(expected, s_float2);
        assertNotEquals(expected.hashCode(), s_float2.hashCode());

    }
    @Test
    void toStringTest(){
        String expected = str;
        assertEquals(expected, s_float.toString());
    }

    @Test
    void toScrabbleStringTest(){
        Scrabble_String expected = new Scrabble_String(str);
        assertEquals(expected, s_float.toScrabbleString());
        assertEquals(expected.hashCode(), (s_float.toScrabbleString()).hashCode());
    }

    @Test
    void toFloatTest(){
        Scrabble_Float expected = new Scrabble_Float(float2);
        assertEquals(expected, s_float2.toFloat());
        assertEquals(expected.hashCode(), (s_float2.toFloat()).hashCode());
    }

    @Test
    void addTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Float(float1 + int1);
        IScrabbleArithmetic expected2 = new Scrabble_Float(float1 + float2);
        IScrabbleArithmetic expected3 = new Scrabble_Float(float1 + binToInt);
        // ScrabbleFloat + ScrabbleInt
        assertEquals(expected1, s_float.add(s_int));
        assertEquals(expected1.hashCode(), s_float.add(s_int).hashCode());

        // ScrabbleFloat + ScrabbleFloat
        assertEquals(expected2, s_float2.add(s_float));
        assertEquals(expected2.hashCode(), s_float2.add(s_float).hashCode());

        // ScrabbleFloat + ScrabbleBinary
        assertEquals(expected3, s_float.add(bin));
        assertEquals(expected3.hashCode(), s_float.add(bin).hashCode());

    }

    @Test
    void subTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Float(float1 - int1);
        IScrabbleArithmetic expected2 = new Scrabble_Float(float1 - float2);
        IScrabbleArithmetic expected3 = new Scrabble_Float(float1 - binToInt);
        // ScrabbleFloat - ScrabbleInt
        assertEquals(expected1, s_float.sub(s_int));
        assertEquals(expected1.hashCode(), s_float.sub(s_int).hashCode());

        // ScrabbleFloat - ScrabbleFloat
        assertEquals(expected2, s_float.sub(s_float2));
        assertEquals(expected2.hashCode(), s_float.sub(s_float2).hashCode());

        // ScrabbleFloat - ScrabbleBinary
        assertEquals(expected3, s_float.sub(bin));
        assertEquals(expected3.hashCode(), s_float.sub(bin).hashCode());
    }

    @Test
    void multTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Float(float1 * int1);
        IScrabbleArithmetic expected2 = new Scrabble_Float(float1 * float2);
        IScrabbleArithmetic expected3 = new Scrabble_Float(float1 * binToInt);
        // ScrabbleFloat * ScrabbleInt
        assertEquals(expected1, s_float.mult(s_int));
        assertEquals(expected1.hashCode(), s_float.mult(s_int).hashCode());

        // ScrabbleFloat * ScrabbleFloat
        assertEquals(expected2, s_float2.mult(s_float));
        assertEquals(expected2.hashCode(), s_float2.mult(s_float).hashCode());

        // ScrabbleFloat * ScrabbleBinary
        assertEquals(expected3, s_float.mult(bin));
        assertEquals(expected3.hashCode(), s_float.mult(bin).hashCode());
    }

    @Test
    void divTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Float(float1 / int1);
        IScrabbleArithmetic expected2 = new Scrabble_Float(float1 / float2);
        IScrabbleArithmetic expected3 = new Scrabble_Float(float1 / binToInt);
        // ScrabbleFloat / ScrabbleInt
        assertEquals(expected1, s_float.div(s_int));
        assertEquals(expected1.hashCode(), s_float.div(s_int).hashCode());

        // ScrabbleFloat / ScrabbleFloat
        assertEquals(expected2, s_float.div(s_float2));
        assertEquals(expected2.hashCode(), s_float.div(s_float2).hashCode());

        // ScrabbleFloat / ScrabbleBinary
        assertEquals(expected3, s_float.div(bin));
        assertEquals(expected3.hashCode(), s_float.div(bin).hashCode());
    }
}
