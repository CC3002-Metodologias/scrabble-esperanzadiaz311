package cl.uchile.dcc.scrabble.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Scrabble_BinaryTest {
    private Scrabble_Binary bin1;
    private Scrabble_Binary bin2;
    private Scrabble_Binary bin3;
    private Scrabble_Binary bin4;
    private Scrabble_String str1;
    private Scrabble_Bool t;
    private Scrabble_Bool f;
    private Scrabble_Float flt1;
    private Scrabble_Int int1;
    private final String value = "010110";
    private final String value2 = "101100001";
    private final String value3 = "10000000000000000000000000011110";
    private final String value4 = "00000000000000000000010011101010";
    private final double d = 22.0;
    private final boolean b1 = true;
    private final boolean b2 = false;
    private final int num = 564738;

    @BeforeEach
    void setUp(){
        bin1 = new Scrabble_Binary(value);
        bin2 = new Scrabble_Binary(value2);
        bin3 = new Scrabble_Binary(value3);
        bin4 = new Scrabble_Binary(value4);
        str1 = new Scrabble_String(value);
        t = new Scrabble_Bool(b1);
        f = new Scrabble_Bool(b2);
        flt1 = new Scrabble_Float(d);
        int1 = new Scrabble_Int(num);
    }

    @Test
    void constructorTest(){
        Scrabble_Binary expected = new Scrabble_Binary("010110");

        // same class and value
        assertEquals(expected, bin1);
        assertEquals(expected.hashCode(), bin1.hashCode());

        // different class
        assertNotEquals(expected, str1);
        assertNotEquals(expected.hashCode(), str1.hashCode());

        // same class, different value
        assertNotEquals(expected, bin2);
        assertNotEquals(expected.hashCode(), bin2.hashCode());

    }

    @Test
    void toStringTest(){
        String expected = "010110";
        assertEquals(expected, bin1.toString());
    }

    @Test
    void toScrabbleStringTest(){
        Scrabble_String expected = new Scrabble_String("010110");
        assertEquals(expected, bin1.toScrabbleString());
        assertEquals(expected.hashCode(), (bin1.toScrabbleString()).hashCode());
    }

    @Test
    void toBinaryTest(){
        Scrabble_Binary expected = new Scrabble_Binary("101100001");
        assertEquals(expected, bin2.toBinary());
        assertEquals(expected.hashCode(), (bin2.toBinary()).hashCode());
    }

    @Test
    void toIntTest(){
        Scrabble_Int expected1 = new Scrabble_Int(22);
        Scrabble_Int expected2 = new Scrabble_Int(-30);
        Scrabble_Int expected3 = new Scrabble_Int(1258);

        assertEquals(expected1, bin1.toInt());
        assertEquals(expected1.hashCode(), bin1.toInt().hashCode());

        assertEquals(expected2, bin3.toInt());
        assertEquals(expected2.hashCode(), bin3.toInt().hashCode());

        assertEquals(expected3, bin4.toInt());
        assertEquals(expected3.hashCode(), bin4.toInt().hashCode());
    }

    @Test
    void toFloatTest(){
        Scrabble_Float expected = new Scrabble_Float(d);
        assertEquals(expected, bin1.toFloat());
        assertEquals(expected.hashCode(), bin1.toFloat().hashCode());
    }

    @Test
    void orTest(){
        IScrabbleLogical expected = new Scrabble_Binary("11111111111111111111111111111111");
        IScrabbleLogical expected2 = new Scrabble_Binary(value4);
        // binary or boolean
            // true
        assertEquals(expected, bin4.or(t));
        assertEquals(expected.hashCode(), bin4.or(t).hashCode());
            // false
        assertEquals(expected2, bin4.or(f));
        assertEquals(expected2.hashCode(), bin4.or(f).hashCode());
        // binary or binary -> null
        assertNull(bin4.or(bin1));
    }

    @Test
    void andTest(){
        IScrabbleLogical expected = new Scrabble_Binary("000000");
        IScrabbleLogical expected2 = new Scrabble_Binary(value);
        // binary and boolean
            // true
        assertEquals(expected, bin1.and(f));
        assertEquals(expected.hashCode(), bin1.and(f).hashCode());
            // false
        assertEquals(expected2, bin1.and(t));
        assertEquals(expected2.hashCode(), bin1.and(t).hashCode());
        // binary and binary -> null
        assertNull(bin1.and(bin2));
    }

    @Test
    void notTest(){
        IScrabbleLogical expected = new Scrabble_Binary("11111111111111111111101100010101");
        assertEquals(expected, bin4.not());
        assertEquals(expected.hashCode(), bin4.not().hashCode());
    }

    @Test
    void addTest(){
        IScrabbleArithmetic expected1 = new Scrabble_Binary("10011001100");
        IScrabbleArithmetic expected2 = new Scrabble_Binary("10001001111101100011");
        // binary + binary
        assertEquals(expected1, bin3.add(bin4));
        assertEquals(expected1.hashCode(), bin3.add(bin4).hashCode());
        // binary + int
        assertEquals(expected2, bin2.add(int1));
        assertEquals(expected2.hashCode(), bin2.add(int1).hashCode());
        // binary + float -> null
        assertNull(bin1.add(flt1));
    }

    @Test
    void subTest(){
        IScrabbleArithmetic expected = new Scrabble_Binary("10000000000000000000000101001011");
        IScrabbleArithmetic expected2 = new Scrabble_Binary("10000000000010001001110010100001");
        // binary - binary
        assertEquals(expected, bin1.sub(bin2));
        assertEquals(expected.hashCode(), bin1.sub(bin2).hashCode());
        // binary - int
        assertEquals(expected2, bin2.sub(int1));
        assertEquals(expected2.hashCode(), bin2.sub(int1).hashCode());
        // binary - float -> null
        assertNull(bin4.sub(flt1));
    }

    @Test
    void multTest(){
        IScrabbleArithmetic expected = new Scrabble_Binary("1111001010110");
        IScrabbleArithmetic expected2 = new Scrabble_Binary("101111011001010000101100");
        // binary * binary
        assertEquals(expected, bin1.mult(bin2));
        assertEquals(expected.hashCode(), bin1.mult(bin2).hashCode());
        // binary - int
        assertEquals(expected2, bin1.mult(int1));
        assertEquals(expected2.hashCode(), bin1.mult(int1).hashCode());
        // binary - float -> null
        assertNull(bin4.mult(flt1));
    }

    @Test
    void divTest(){
        IScrabbleArithmetic expected = new Scrabble_Binary("10000");
        IScrabbleArithmetic expected2 = new Scrabble_Binary("0");
        // binary * binary
        assertEquals(expected, bin2.div(bin1));
        assertEquals(expected.hashCode(), bin2.div(bin1).hashCode());
        // binary - int
        assertEquals(expected2, bin1.div(int1));
        assertEquals(expected2.hashCode(), bin1.div(int1).hashCode());
        // binary - float -> null
        assertNull(bin4.div(flt1));
    }
}
