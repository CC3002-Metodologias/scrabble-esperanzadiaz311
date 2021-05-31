package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.model.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.Scrabble_Int;
import cl.uchile.dcc.scrabble.model.Scrabble_String;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Scrabble_FloatTest {
    private Scrabble_Float s_float;
    private Scrabble_Float s_float2;
    private Scrabble_Int s_int;
    private final double float1 = 3.19;
    private final double float2 = 4367.786401;
    private final int int1 = 5;

    @BeforeEach
    void setUp(){
        s_float = new Scrabble_Float(float1);
        s_float2 = new Scrabble_Float(float2);
        s_int = new Scrabble_Int(int1);
    }

    @Test
    void constructorTest(){
        Scrabble_Float expected = new Scrabble_Float(3.19);

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
        String expected = "3.19";
        assertEquals(expected, s_float.toString());
    }

    @Test
    void toScrabbleStringTest(){
        Scrabble_String expected = new Scrabble_String("3.19");
        assertEquals(expected, s_float.toScrabbleString());
        assertEquals(expected.hashCode(), (s_float.toScrabbleString()).hashCode());
    }

    @Test
    void toFloatTest(){
        Scrabble_Float expected = new Scrabble_Float(4367.786401);
        assertEquals(expected, s_float2.toFloat());
        assertEquals(expected.hashCode(), (s_float2.toFloat()).hashCode());
    }

    @Test
    void addTest(){
        Scrabble_Float expected1 = new Scrabble_Float(8.19);
        Scrabble_Float expected2 = new Scrabble_Float(4370.976401);
        // ScrabbleFloat + ScrabbleInt
        assertEquals(expected1, s_float.add(s_int));
        assertEquals(expected1.hashCode(), s_float.add(s_int).hashCode());

        // ScrabbleFloat + ScrabbleFloat
        assertEquals(expected2, s_float2.add(s_float));
        assertEquals(expected2.hashCode(), s_float2.add(s_float).hashCode());

        // ScrabbleFloat + ScrabbleBinary
    }

    @Test
    void subTest(){
        Scrabble_Float expected1 = new Scrabble_Float(-4364.596401);
        Scrabble_Float expected2 = new Scrabble_Float(-1.810);
        // ScrabbleFloat - ScrabbleInt
        assertEquals(expected2, s_float.sub(s_int));
        assertEquals(expected2.hashCode(), s_float.sub(s_int).hashCode());
        // ScrabbleFloat - ScrabbleFloat
        assertEquals(expected1, s_float.sub(s_float2));
        assertEquals(expected1.hashCode(), s_float.sub(s_float2).hashCode());
        // ScrabbleFloat - ScrabbleBinary
    }
}
