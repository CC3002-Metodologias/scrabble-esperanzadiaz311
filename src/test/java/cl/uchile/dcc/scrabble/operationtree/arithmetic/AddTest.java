package cl.uchile.dcc.scrabble.operationtree.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SFloatFactory;
import cl.uchile.dcc.scrabble.model.factories.SIntFactory;
import cl.uchile.dcc.scrabble.model.factories.SStringFactory;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Add;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {
    private Add add1, add2;
    private Leaf l1, l2, l3;
    private SIntFactory intFactory;
    private SStringFactory stringFactory;

    @BeforeEach
    public void setUp(){
        stringFactory = new SStringFactory();
        intFactory = new SIntFactory();
        intFactory.setValue(25);
        l1 = new Leaf(intFactory.create());
        intFactory.setValue(-100);
        l2 = new Leaf(intFactory.create());
        add1 = new Add(l1, l2);
        stringFactory.setValue("testing");
        l3 = new Leaf(stringFactory.create());
        add2 = new Add(l3, l1);
    }

    @Test
    public void AddTest(){
        IScrabble expected = new Scrabble_Int(-75);
        assertEquals(expected, add1.calculate());
        assertEquals(expected.hashCode(), add1.calculate().hashCode());

        IScrabble expected2 = new Scrabble_String("testing25");
        assertEquals(expected2, add2.calculate());
        assertEquals(expected2.hashCode(), add2.calculate().hashCode());
    }
}
