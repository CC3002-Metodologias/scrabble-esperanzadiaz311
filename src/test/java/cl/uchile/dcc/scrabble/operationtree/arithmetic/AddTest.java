package cl.uchile.dcc.scrabble.operationtree.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.*;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Add;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Div;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Mult;
import cl.uchile.dcc.scrabble.operationtree.operators.arithmetic.Sub;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.And;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Not;
import cl.uchile.dcc.scrabble.operationtree.operators.logical.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AddTest {
    private Add add1, add2, add3, add4, add5, add6, add7, add8, add9, add10, add11, add12, add13, add14,
            add15, add16, add17, add18, add19, add20, add21, add22, add23, add24, add25, bigTree;
    private Leaf l1, l2, l3, l4, l5, l6, l7, l8 , l9, l10;
    private SIntFactory intFactory;
    private SStringFactory stringFactory;
    private SFloatFactory floatFactory;
    private SBinaryFactory binaryFactory;
    private SBoolFactory boolFactory;

    @BeforeEach
    public void setUp(){
        stringFactory = new SStringFactory();
        intFactory = new SIntFactory();
        floatFactory = new SFloatFactory();
        binaryFactory = new SBinaryFactory();
        boolFactory = new SBoolFactory();

        intFactory.setValue(25);
        l1 = new Leaf(intFactory.create());

        intFactory.setValue(-100);
        l2 = new Leaf(intFactory.create());

        stringFactory.setValue("testing");
        l3 = new Leaf(stringFactory.create());

        stringFactory.setValue("new testing");
        l4 = new Leaf(stringFactory.create());

        floatFactory.setValue(22.5);
        l5 = new Leaf(floatFactory.create());

        floatFactory.setValue(-902.345);
        l6 = new Leaf(floatFactory.create());

        binaryFactory.setValue("100011010"); // 282
        l7 = new Leaf(binaryFactory.create());

        binaryFactory.setValue("11111111111111111111111111100111"); // -25
        l8 = new Leaf(binaryFactory.create());

        boolFactory.setValue(true);
        l9 = new Leaf(boolFactory.create());

        boolFactory.setValue(false);
        l10 = new Leaf(boolFactory.create());

        add1 = new Add(l1, l2); // Leaves: ScrabbleInt x2
        add3 = new Add(l1, l5); // Leaves: ScrabbleInt, ScrabbleFloat
        add4 = new Add(l1, l7); // Leaves: ScrabbleInt, ScrabbleBinary
        add5= new Add(l1, l3);  // Leaves: ScrabbleInt, ScrabbleString
        add6 = new Add(l1, l9); // Leaves: ScrabbleInt, ScrabbleBool

        add7 = new Add(l3, l4); // Leaves: ScrabbleString x2
        add2 = new Add(l3, l1); // ScrabbleString and ScrabbleInt
        add8 = new Add(l3, l9); // Leaves: ScrabbleString, ScrabbleBool
        add9 = new Add(l3, l5); // Leaves: ScrabbleString, ScrabbleFloat
        add10 = new Add(l3, l7); // Leaves: ScrabbleString, ScrabbleBinary

        add11 = new Add(l5, l6); // Leaves: ScrabbleFloat x2
        add12 = new Add(l5, l1); // Leaves: ScrabbleFloat, ScrabbleInt
        add13 = new Add(l5, l7); // Leaves: ScrabbleFloat, ScrabbleBinary
        add14 = new Add(l5, l3); // Leaves: ScrabbleFloat, ScrabbleString
        add15 = new Add(l5, l9); // Leaves: ScrabbleFloat, ScrabbleBool

        add16 = new Add(l7, l8); // Leaves: ScrabbleBinary x2
        add17 = new Add(l7, l1); // Leaves: ScrabbleBinary, ScrabbleInt
        add18 = new Add(l7, l5); // Leaves: ScrabbleBinary, ScrabbleFloat
        add19 = new Add(l7, l3); // Leaves: ScrabbleBinary, ScrabbleString
        add20 = new Add(l7, l9); // Leaves: ScrabbleBinary, ScrabbleBool

        add21 = new Add(l9, l10); // Leaves: ScrabbleBool x2
        add22 = new Add(l9, l1); // Leaves: ScrabbleBool, ScrabbleInt
        add23 = new Add(l9, l5); // Leaves: ScrabbleBool, ScrabbleFloat
        add24 = new Add(l9, l3); // Leaves: ScrabbleBool, ScrabbleString
        add25 = new Add(l9, l7); // Leaves: ScrabbleBool, ScrabbleBinary

        bigTree = new Add(new Sub(l1, l2), new Mult(new Div(l5, l6), new Not(new Or(l7, new And(l7, l9)))));

    }

    @Test
    public void AddTest(){

        // Basic Add Tree (Leaf <- Add -> Leaf)

        // Leaves: ScrabbleInt x2
        IScrabble expected = new Scrabble_Int(-75);
        assertEquals(expected, add1.calculate());
        assertEquals(expected.hashCode(), add1.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        IScrabble expected2 = new Scrabble_Float(47.5);
        assertEquals(expected2, add3.calculate());
        assertEquals(expected2.hashCode(), add3.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        IScrabble expected3 = new Scrabble_Int(307);
        assertEquals(expected3, add4.calculate());
        assertEquals(expected3.hashCode(), add4.calculate().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(add5.calculate());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(add6.calculate());

        // Leaves: ScrabbleString x2
        IScrabble expected4 = new Scrabble_String("testingnew testing");
        assertEquals(expected4, add7.calculate());
        assertEquals(expected4.hashCode(), add7.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleBool
        IScrabble expected5 = new Scrabble_String("testingtrue");
        assertEquals(expected5, add8.calculate());
        assertEquals(expected5.hashCode(), add8.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleFloat
        IScrabble expected6 = new Scrabble_String("testing22.5");
        assertEquals(expected6, add9.calculate());
        assertEquals(expected6.hashCode(), add9.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleInt
        IScrabble expected7 = new Scrabble_String("testing25");
        assertEquals(expected7, add2.calculate());
        assertEquals(expected7.hashCode(), add2.calculate().hashCode());
        // Leaves: ScrabbleString, ScrabbleBinary
        IScrabble expected8 = new Scrabble_String("testing100011010");
        assertEquals(expected8, add10.calculate());
        assertEquals(expected8.hashCode(), add10.calculate().hashCode());

        // Leaves: ScrabbleFloat x2
        IScrabble expected9 = new Scrabble_Float(22.5-902.345);
        assertEquals(expected9, add11.calculate());
        assertEquals(expected9.hashCode(), add11.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        IScrabble expected10 = new Scrabble_Float(22.5+25);
        assertEquals(expected10, add12.calculate());
        assertEquals(expected10.hashCode(), add12.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        IScrabble expected11 = new Scrabble_Float(22.5+282);
        assertEquals(expected11, add13.calculate());
        assertEquals(expected11.hashCode(), add13.calculate().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(add14.calculate());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(add15.calculate());

        // Leaves: ScrabbleBinary x2
        IScrabble expected12 = new Scrabble_Binary("100000001");
        assertEquals(expected12, add16.calculate());
        assertEquals(expected12.hashCode(), add16.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        IScrabble expected13 = new Scrabble_Binary("100110011");
        assertEquals(expected13, add17.calculate());
        assertEquals(expected13.hashCode(), add17.calculate().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(add18.calculate());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(add19.calculate());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(add20.calculate());

        // Leaves: ScrabbleBool x2
        assertNull(add21.calculate());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(add22.calculate());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(add23.calculate());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(add24.calculate());
        // Leaves: ScrabbleBool, ScrabbleBinary
        assertNull(add25.calculate());

        // multiple operations tree
        IScrabble expectedValue = new Scrabble_Float(125+(22.5/-902.345)*229);
        assertEquals(expectedValue, bigTree.calculate());
        assertEquals(expectedValue.hashCode(), bigTree.calculate().hashCode());
    }
}
