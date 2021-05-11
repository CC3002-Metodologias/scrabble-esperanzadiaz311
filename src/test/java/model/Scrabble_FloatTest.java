package model;

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
    private double float1 = 3.19;
    private double float2 = 4367.786401;
    private int int1 = 5;

    @BeforeEach
    void setUp(){
        s_float = new Scrabble_Float(float1);
        s_float2 = new Scrabble_Float(float2);
        s_int = new Scrabble_Int(int1);
    }

    @Test
    void constructorTest(){
        Scrabble_Float expected = new Scrabble_Float(3.19);

        assertEquals(expected, s_float);
        assertEquals(expected.hashCode(), s_float.hashCode());

        assertNotEquals(expected, s_int);
        assertNotEquals(expected.hashCode(), s_int.hashCode());

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
}
