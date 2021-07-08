package cl.uchile.dcc.scrabble.operationtree;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.factories.*;
import cl.uchile.dcc.scrabble.operationtree.operators.Leaf;

/** This class was created just for making it easier for setting up tests for operation trees
 * @author Esperanza Díaz Adaro
 */
public abstract class TreeTest {
    protected Leaf l1, l2, l3, l4, l5, l6, l7, l8 , l9, l10;
    protected SIntFactory intFactory;
    protected SStringFactory stringFactory;
    protected SFloatFactory floatFactory;
    protected SBinaryFactory binaryFactory;
    protected SBoolFactory boolFactory;

    protected void SetUp(){
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
    }

    protected abstract void toSBinaryTest(IScrabble[] expected, Component[] comp);

    protected abstract void toSIntTest(IScrabble[] expected, Component[] comp);

    protected abstract void toSFloatTest(IScrabble[] expected, Component[] comp);

    protected abstract void toSStringTest(IScrabble[] expected, Component[] comp);

    protected abstract void toSBoolTest(IScrabble[] expected, Component[] comp);
}
