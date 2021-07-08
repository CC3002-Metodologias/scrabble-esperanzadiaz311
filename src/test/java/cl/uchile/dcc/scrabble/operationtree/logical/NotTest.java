package cl.uchile.dcc.scrabble.operationtree.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.SBoolFactory;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.TreeTest;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.And;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Not;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotTest extends TreeTest {
    private Not not1, not2, not3, not4, not5, bigTree;

    @BeforeEach
    public void setUp(){
        SetUp();

        not1 = new Not(l1);
        not2 = new Not(l3);
        not3 = new Not(l5);
        not4 = new Not(l7);
        not5 = new Not(l9);
    }

    @Test
    public void NotTest(){
    }

    @Override
    protected void toSBinaryTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSIntTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSFloatTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSStringTest(IScrabble[] expected, Component[] comp) {

    }

    @Override
    protected void toSBoolTest(IScrabble[] expected, Component[] comp) {

    }
}
