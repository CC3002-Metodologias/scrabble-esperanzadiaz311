package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SBinaryFactory;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrTest {
    private Or or;
    private Leaf l1, l2;
    private SBinaryFactory binaryFactory;

    @BeforeEach
    public void setUp(){
        binaryFactory = new SBinaryFactory();
        binaryFactory.setValue("0110011110");
        l1 = new Leaf(binaryFactory.create());
        binaryFactory.setValue("11001");
        l2 = new Leaf(binaryFactory.create());
        or = new Or(l1, l2);
    }

    @Test
    public void OrTest(){
        IScrabble expected = new Scrabble_Binary("0110011111");
        assertEquals(expected, or.calculate());
        assertEquals(expected.hashCode(), or.calculate().hashCode());
    }
}
