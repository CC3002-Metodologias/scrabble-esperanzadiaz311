package cl.uchile.dcc.scrabble.operationtree.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SIntFactory;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Mult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultTest {
    private Mult mult;
    private Leaf l1, l2;
    private SIntFactory intFactory;

    @BeforeEach
    public void setUp(){
        intFactory = new SIntFactory();
        intFactory.setValue(1965);
        l1 = new Leaf(intFactory.create());
        intFactory.setValue(-337);
        l2 = new Leaf(intFactory.create());
        mult = new Mult(l1, l2);
    }

    @Test
    public void MultTest(){
        IScrabble expected = new Scrabble_Int(1965 * -337);
        assertEquals(expected, mult.calculate());
        assertEquals(expected.hashCode(), mult.calculate().hashCode());
    }
}
