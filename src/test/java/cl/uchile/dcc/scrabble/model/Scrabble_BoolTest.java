package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.model.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.Scrabble_String;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Scrabble_BoolTest {
    private Scrabble_Bool s_bool;
    private Scrabble_Bool s_bool2;
    private Scrabble_Bool s_bool3;
    private Scrabble_Bool s_bool4;
    private Scrabble_String s_str;
    private Scrabble_Binary bin1;
    private final boolean b = true;
    private final boolean b2 = false;
    private final String str = "true";
    private final String str2 = "1011001";

    @BeforeEach
    void setUp(){
        s_bool = new Scrabble_Bool(b);
        s_bool2 = new Scrabble_Bool(b2);
        s_bool3 = new Scrabble_Bool(b2);
        s_bool4 = new Scrabble_Bool(b);
        s_str = new Scrabble_String(str);
        bin1 = new Scrabble_Binary(str2);
    }

    @Test
    void constructorTest(){
        Scrabble_Bool expected = new Scrabble_Bool(true);

        // same class and value
        assertEquals(expected, s_bool);
        assertEquals(expected.hashCode(), s_bool.hashCode());

        // same class, different value
        assertNotEquals(expected, s_bool2);
        assertNotEquals(expected.hashCode(), s_bool2.hashCode());

        // different class
        assertNotEquals(expected, s_str);
        assertNotEquals(expected.hashCode(), s_str.hashCode());
    }

    @Test
    void toStringTest(){
        String expected = "true";
        assertEquals(expected, s_bool.toString());
    }

    @Test
    void toScrabbleString(){
        Scrabble_String expected = new Scrabble_String("true");
        assertEquals(expected, s_bool.toScrabbleString());
        assertEquals(expected.hashCode(), (s_bool.toScrabbleString()).hashCode());
    }

    @Test
    void toBoolTest(){
        Scrabble_Bool expected = new Scrabble_Bool(true);
        assertEquals(expected, s_bool.toBool());
        assertEquals(expected.hashCode(), (s_bool.toBool()).hashCode());
    }

    @Test
    void orTest(){
        Scrabble_Bool expected1 = new Scrabble_Bool(true);
        Scrabble_Binary expected2 = new Scrabble_Binary("1111111");
        Scrabble_Binary expected3 = new Scrabble_Binary("1011001");
        Scrabble_Bool expected4 = new Scrabble_Bool(false);
        // result true (true || false)
        assertEquals(expected1, s_bool.or(s_bool2));
        assertEquals(expected1.hashCode(), s_bool.or(s_bool2).hashCode());
        // result false (false || false)
        assertEquals(expected4, s_bool2.or(s_bool3));
        assertEquals(expected4.hashCode(), s_bool2.or(s_bool3).hashCode());
        // result true (true || true)
        assertEquals(expected1, s_bool.or(s_bool4));
        assertEquals(expected1.hashCode(), s_bool.or(s_bool4).hashCode());
        // result true (false || true)
        assertEquals(expected1, s_bool3.or(s_bool4));
        assertEquals(expected1.hashCode(), s_bool3.or(s_bool4).hashCode());
        // between true and binary
        assertEquals(expected2, s_bool.or(bin1));
        assertEquals(expected2.hashCode(), s_bool.or(bin1).hashCode());
        // between false and binary
        assertEquals(expected3, s_bool2.or(bin1));
        assertEquals(expected3.hashCode(), s_bool2.or(bin1).hashCode());
    }

    @Test
    void andTest(){
        Scrabble_Bool expected1 = new Scrabble_Bool(true);
        Scrabble_Binary expected2 = new Scrabble_Binary("0000000");
        Scrabble_Binary expected3 = new Scrabble_Binary("1011001");
        Scrabble_Bool expected4 = new Scrabble_Bool(false);
        // result false (true && false)
        assertEquals(expected4, s_bool.and(s_bool2));
        assertEquals(expected4.hashCode(), s_bool.and(s_bool2).hashCode());
        // result false (false && false)
        assertEquals(expected4, s_bool2.and(s_bool3));
        assertEquals(expected4.hashCode(), s_bool2.and(s_bool3).hashCode());
        // result true (true && true)
        assertEquals(expected1, s_bool.and(s_bool4));
        assertEquals(expected1.hashCode(), s_bool.and(s_bool4).hashCode());
        // result false (false && true)
        assertEquals(expected4, s_bool3.and(s_bool4));
        assertEquals(expected4.hashCode(), s_bool3.and(s_bool4).hashCode());
        // between true and binary
        assertEquals(expected3, s_bool.and(bin1));
        assertEquals(expected3.hashCode(), s_bool.and(bin1).hashCode());
        // between false and binary
        assertEquals(expected2, s_bool2.and(bin1));
        assertEquals(expected2.hashCode(), s_bool2.and(bin1).hashCode());
    }

    @Test
    void negationTest(){
        Scrabble_Bool expected1 = new Scrabble_Bool(true);
        Scrabble_Bool expected2 = new Scrabble_Bool(false);

        assertEquals(expected2, s_bool.not());
        assertEquals(expected2.hashCode(), s_bool.not().hashCode());

        assertEquals(expected1, s_bool2.not());
        assertEquals(expected1.hashCode(), s_bool2.not().hashCode());
    }
}