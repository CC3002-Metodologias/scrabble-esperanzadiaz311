package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Scrabble_StringTest {
    private Scrabble_String str1;
    private Scrabble_String str2;
    private Scrabble_Int int1;
    private Scrabble_Binary bin1;
    private Scrabble_Float flt1;
    private Scrabble_Bool bool1;
    private final String s = "testing";
    private final String s2 = "new testing";
    private final String s3 = "10011101010111";
    private final int num = 4532;
    private final double d = 5748.211;
    private final boolean b = true;

    @BeforeEach
    void setUp(){
        str1 = new Scrabble_String(s);
        str2 = new Scrabble_String(s2);
        int1 = new Scrabble_Int(num);
        bin1 = new Scrabble_Binary(s3);
        flt1 = new Scrabble_Float(d);
        bool1 = new Scrabble_Bool(b);
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

    @Test
    void addTest(){
        Scrabble_String expected = new Scrabble_String(s + s2);
        Scrabble_String expected2 = new Scrabble_String(s + s3);
        Scrabble_String expected3 = new Scrabble_String(s + num);
        Scrabble_String expected4 = new Scrabble_String(s + b);
        Scrabble_String expected5 = new Scrabble_String(s + d);
        // Scrabble String + Scrabble String
        assertEquals(expected, str1.add(str2));
        assertEquals(expected.hashCode(), str1.add(str2).hashCode());
        // Scrabble String + Scrabble Binary
        assertEquals(expected2, str1.add(bin1));
        assertEquals(expected2.hashCode(), str1.add(bin1).hashCode());
        // Scrabble String + Scrabble Int
        assertEquals(expected3, str1.add(int1));
        assertEquals(expected3.hashCode(), str1.add(int1).hashCode());
        // Scrabble String + Scrabble Bool
        assertEquals(expected4, str1.add(bool1));
        assertEquals(expected4.hashCode(), str1.add(bool1).hashCode());
        // Scrabble String + Scrabble Float
        assertEquals(expected5, str1.add(flt1));
        assertEquals(expected5.hashCode(), str1.add(flt1).hashCode());
    }

    @Test
    void toFloatTest(){
        assertNull(str2.toFloat());
    }

    @Test
    void subTest(){
        assertNull(str1.sub(str2));
        assertNull(str1.sub(int1));
        assertNull(str1.sub(flt1));
        assertNull(str1.sub(bool1));
    }

    @Test
    void multTest(){
        assertNull(str1.mult(str2));
        assertNull(str1.mult(int1));
        assertNull(str1.mult(flt1));
        assertNull(str1.mult(bool1));
    }

    @Test
    void divTest(){
        assertNull(str1.div(str2));
        assertNull(str1.div(int1));
        assertNull(str1.div(flt1));
        assertNull(str1.div(bool1));
    }

    @Test
    void orTest(){
        assertNull(str1.or(str2));
        assertNull(str1.or(int1));
        assertNull(str1.or(flt1));
        assertNull(str1.or(bool1));
    }

    @Test
    void andTest(){
        assertNull(str1.and(str2));
        assertNull(str1.and(int1));
        assertNull(str1.and(flt1));
        assertNull(str1.and(bool1));
    }

    @Test
    void notTest(){
        assertNull(str1.not());
    }
}
