package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SBinaryFactory;
import cl.uchile.dcc.scrabble.model.factories.SBoolFactory;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.And;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndTest {
    private And and;
    private Leaf l1, l2;
    private SBoolFactory boolFactory;
    private SBinaryFactory binaryFactory;

    @BeforeEach
    public void setUp(){
        boolFactory = new SBoolFactory();
        binaryFactory = new SBinaryFactory();
        boolFactory.setValue(false);
        binaryFactory.setValue("111111000");
        l1 = new Leaf(boolFactory.create());
        l2 = new Leaf(binaryFactory.create());
        and = new And(l1, l2);
    }

    @Test
    public void AndTest(){
        IScrabble expected = new Scrabble_Binary("000000000");
        assertEquals(expected, and.calculate());
        assertEquals(expected.hashCode(), and.calculate().hashCode());
    }
}
