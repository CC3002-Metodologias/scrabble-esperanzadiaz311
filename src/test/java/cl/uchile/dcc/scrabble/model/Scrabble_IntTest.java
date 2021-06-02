package cl.uchile.dcc.scrabble.model;

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
    private final int i1 = 101219;
    private final int i2 = 456724;
    private final int binToInt = -2147318104;
    private final String str = "101219";
    private final String bin = "10000000000000101000011010101000"; // -2147318104
    private final double float1 = 7152.47;

    @BeforeEach
    void setUp(){
        s_int = new Scrabble_Int(i1);
        s_int2 = new Scrabble_Int(i2);
        s_int3 = new Scrabble_Int(binToInt);
        s_bin = new Scrabble_Binary(str);
        s_bin2 = new Scrabble_Binary(bin);
        s_float = new Scrabble_Float(float1);

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
        IScrabbleArithmetic expected1 = new Scrabble_Int(i1 + i2);
        IScrabbleArithmetic expected2 = new Scrabble_Float(i1 + float1);
        IScrabbleArithmetic expected3 = new Scrabble_Int(i1 + binToInt);
        // ScrabbleInt + ScrabbleInt
        assertEquals(expected1, s_int.add(s_int2));
        assertEquals(expected1.hashCode(), s_int.add(s_int2).hashCode());

        // ScrabbleInt + ScrabbleFloat
        assertEquals(expected2, s_int.add(s_float));
        assertEquals(expected2.hashCode(), s_int.add(s_float).hashCode());

        // ScrabbleInt + ScrabbleBinary
        assertEquals(expected3, s_int.add(s_bin2));
        assertEquals(expected3.hashCode(), s_int.add(s_bin2).hashCode());

    }

    @Test
    void subTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Int(i1 - i2);
        IScrabbleArithmetic expected2 = new Scrabble_Float(i1 - float1);
        IScrabbleArithmetic expected3 = new Scrabble_Int(i1 - binToInt);
        // ScrabbleInt - ScrabbleInt
        assertEquals(expected1, s_int.sub(s_int2));
        assertEquals(expected1.hashCode(), s_int.sub(s_int2).hashCode());

        // ScrabbleInt - ScrabbleFloat
        assertEquals(expected2, s_int.sub(s_float));
        assertEquals(expected2.hashCode(), s_int.sub(s_float).hashCode());

        // ScrabbleInt - ScrabbleBinary
        assertEquals(expected3, s_int.sub(s_bin2));
        assertEquals(expected3.hashCode(), s_int.sub(s_bin2).hashCode());
    }

    @Test
    void multTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Int(i1 * i2);
        IScrabbleArithmetic expected2 = new Scrabble_Float(i1 * float1);
        IScrabbleArithmetic expected3 = new Scrabble_Int(i1 * binToInt);
        // ScrabbleInt * ScrabbleInt
        assertEquals(expected1, s_int.mult(s_int2));
        assertEquals(expected1.hashCode(), s_int.mult(s_int2).hashCode());

        // ScrabbleInt * ScrabbleFloat
        assertEquals(expected2, s_int.mult(s_float));
        assertEquals(expected2.hashCode(), s_int.mult(s_float).hashCode());

        // ScrabbleInt * ScrabbleBinary
        assertEquals(expected3, s_int.mult(s_bin2));
        assertEquals(expected3.hashCode(), s_int.mult(s_bin2).hashCode());
    }

    @Test
    void divTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Int(i1 / i2);
        IScrabbleArithmetic expected2 = new Scrabble_Float(i1 / float1);
        IScrabbleArithmetic expected3 = new Scrabble_Int(i1 / binToInt);
        // ScrabbleInt / ScrabbleInt
        assertEquals(expected1, s_int.div(s_int2));
        assertEquals(expected1.hashCode(), s_int.div(s_int2).hashCode());

        // ScrabbleInt / ScrabbleFloat
        assertEquals(expected2, s_int.div(s_float));
        assertEquals(expected2.hashCode(), s_int.div(s_float).hashCode());

        // ScrabbleInt / ScrabbleBinary
        assertEquals(expected3, s_int.div(s_bin2));
        assertEquals(expected3.hashCode(), s_int.div(s_bin2).hashCode());
    }

}
