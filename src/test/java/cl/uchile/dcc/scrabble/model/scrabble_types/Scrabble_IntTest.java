package cl.uchile.dcc.scrabble.model.scrabble_types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Scrabble_IntTest {
    private Scrabble_Int s_int;
    private Scrabble_Binary s_bin;
    private int value = 101219;
    private String str = "101219";

    @BeforeEach
    void setUp(){
        s_int = new Scrabble_Int(value);
        s_bin = new Scrabble_Binary(str);
    }

    @Test
    void constructorTest(){
        Scrabble_Int expected = new Scrabble_Int(101219);
        assertEquals(expected, s_int);
        assertEquals(expected.hashCode(), s_int.hashCode());
        assertNotEquals(expected, s_bin);
        assertNotEquals(expected.hashCode(), s_bin.hashCode());
    }

    @Test
    void toStringTest(){
        String expected = "101219";
        assertEquals(expected, s_int.toString());
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
       Scrabble_Int expected = new Scrabble_Int(101219);
       assertEquals(expected, s_int.toInt());
       assertEquals(expected.hashCode(), (s_int.toInt()).hashCode());
    }
}
