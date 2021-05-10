package cl.uchile.dcc.scrabble.model.scrabble_types;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Scrabble_FloatTest {
    private Scrabble_Float s_float;
    private double float1= 3.19;

    @BeforeEach
    void setUp() {
        s_float = new Scrabble_Float(float1);
    }

    @Test
    void constructorTest(){
        Scrabble_Float expected = new Scrabble_Float(3.19);
        assertEquals(expected, s_float);
        //assertEquals(expected.hashCode(), s_float.hashCode());
    }
}