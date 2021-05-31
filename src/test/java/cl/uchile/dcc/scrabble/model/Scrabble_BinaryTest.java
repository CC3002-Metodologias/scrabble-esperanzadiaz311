package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.gui.Scrabble;
import cl.uchile.dcc.scrabble.model.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.Scrabble_Int;
import cl.uchile.dcc.scrabble.model.Scrabble_String;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Scrabble_BinaryTest {
    private Scrabble_Binary bin1;
    private Scrabble_Binary bin2;
    private Scrabble_Binary bin3;
    private Scrabble_Binary bin4;
    private Scrabble_String str1;
    private final String value = "010110";
    private final String value2 = "101100001";
    private final String value3 = "10000000000000000000000000011110";
    private final String value4 = "00000000000000000000010011101010";

    @BeforeEach
    void setUp(){
        bin1 = new Scrabble_Binary(value);
        bin2 = new Scrabble_Binary(value2);
        bin3 = new Scrabble_Binary(value3);
        bin4 = new Scrabble_Binary(value4);
        str1 = new Scrabble_String(value);
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

        assertEquals(expected1, bin1.toInt());
        assertEquals(expected1.hashCode(), bin1.toInt().hashCode());

        assertEquals(expected2, bin3.toInt());
        assertEquals(expected2.hashCode(), bin3.toInt().hashCode());
    }
}
