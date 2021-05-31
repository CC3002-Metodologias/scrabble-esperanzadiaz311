package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.model.Scrabble_Int;
import cl.uchile.dcc.scrabble.model.Scrabble_String;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Scrabble_StringTest {
    private Scrabble_String str1;
    private Scrabble_String str2;
    private Scrabble_Int int1;
    private final String s = "testing";
    private final String s2 = "new testing";
    private final int num = 4532;

    @BeforeEach
    void setUp(){
        str1 = new Scrabble_String(s);
        str2 = new Scrabble_String(s2);
        int1 = new Scrabble_Int(num);
    }

    @Test
    void constructorTest(){
        Scrabble_String expected = new Scrabble_String("testing");

        // same class and value
        assertEquals(expected, str1);
        assertEquals(expected.hashCode(), str1.hashCode());

        // same class, different value
        assertNotEquals(expected, str2);
        assertNotEquals(expected.hashCode(), str2.hashCode());

        // different class
        assertNotEquals(expected, int1);
        assertNotEquals(expected.hashCode(), int1.hashCode());
    }

    @Test
    void toStringTest(){
        String expected = "testing";
        assertEquals(expected, str1.toString());
    }

    @Test
    void toScrabbleStringTest(){
        Scrabble_String expected = new Scrabble_String("testing");
        assertEquals(expected, str1.toScrabbleString());
        assertEquals(expected.hashCode(), (str1.toScrabbleString()).hashCode());
    }
}
