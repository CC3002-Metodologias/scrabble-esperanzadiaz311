package cl.uchile.dcc.scrabble.model.scrabble_types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Scrabble_FloatTest {
    private Scrabble_Float s_float;
    private Scrabble_Int s_int;
    private Scrabble_String s_str;
    private double float1= 3.19;
    private int int1 = 5;
    private String str1 = "3.19";

    @BeforeEach
    void setUp() {
        s_float = new Scrabble_Float(float1);
        s_int = new Scrabble_Int(int1);
        s_str = new Scrabble_String(str1);
    }

    @Test
    void constructorTest(){
        Scrabble_Float expected = new Scrabble_Float(3.19);
        assertEquals(expected, s_float);
        assertEquals(expected.hashCode(), s_float.hashCode());
        assertNotEquals(expected, s_int);
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
        assertEquals(expected.hashCode(), (s_float.toScrabbleString().hashCode()));
    }

    @Test
    void toFloatTest(){
        Scrabble_Float expected = new Scrabble_Float(3.19);
        assertEquals(expected, s_float.toFloat());
        assertEquals(expected.hashCode(), (s_float.toFloat()).hashCode());
    }
}