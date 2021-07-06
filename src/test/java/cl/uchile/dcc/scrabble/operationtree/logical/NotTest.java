package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SBoolFactory;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Not;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotTest {
    private Not no;
    private Leaf l1;
    private SBoolFactory boolFactory;

    @BeforeEach
    public void setUp(){
        boolFactory = new SBoolFactory();
        boolFactory.setValue(true);
        l1 = new Leaf(boolFactory.create());
        no = new Not(l1);
    }

    @Test
    public void NotTest(){
        IScrabble expected = new Scrabble_Bool(false);
        assertEquals(expected, no.calculate());
        assertEquals(expected.hashCode(), no.calculate().hashCode());
    }
}
