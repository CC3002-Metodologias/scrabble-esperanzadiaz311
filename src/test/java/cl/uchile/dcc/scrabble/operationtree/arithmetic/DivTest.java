package cl.uchile.dcc.scrabble.operationtree.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SBinaryFactory;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Div;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivTest {
    private Div div;
    private Leaf l1, l2;
    private SBinaryFactory binaryFactory;

    @BeforeEach
    public void setUp(){
        binaryFactory = new SBinaryFactory();
        binaryFactory.setValue("111010");
        l1 = new Leaf(binaryFactory.create());
        binaryFactory.setValue("10101");
        l2 = new Leaf(binaryFactory.create());
        div = new Div(l1,l2);
    }

    @Test
    public void DivTest(){
        IScrabble expected = new Scrabble_Binary("10");
        assertEquals(expected, div.calculate());
        assertEquals(expected.hashCode(), div.calculate().hashCode());
    }
}
