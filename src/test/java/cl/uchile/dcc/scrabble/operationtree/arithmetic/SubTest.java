package cl.uchile.dcc.scrabble.operationtree.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SFloatFactory;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Sub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubTest {
    private Sub sub;
    private Leaf l1, l2;
    private SFloatFactory floatFactory;

    @BeforeEach
    public void setUp(){
        floatFactory = new SFloatFactory();
        floatFactory.setValue(8.31);
        l1 = new Leaf(floatFactory.create());
        floatFactory.setValue(1.69);
        l2 = new Leaf(floatFactory.create());
        sub = new Sub(l1, l2);
    }

    @Test
    public void SubTest(){
        IScrabble expected = new Scrabble_Float(8.31 - 1.69);
        assertEquals(expected, sub.calculate());
        assertEquals(expected.hashCode(), sub.calculate().hashCode());
    }
}
