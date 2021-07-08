package cl.uchile.dcc.scrabble.operationtree.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.TreeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeArithmeticTest extends TreeTest {

    @Override
    protected void toSBinaryTest(IScrabble[] expected, Component[] comp){
        
        // Leaves: ScrabbleInt x2
        assertEquals(expected[0], comp[0].toSBinary());
        assertEquals(expected[0].hashCode(), comp[0].toSBinary().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertNull(comp[2].toSBinary());
        // Leaves: ScrabbleInt, ScrabbleBinary
        assertEquals(expected[1], comp[3].toSBinary());
        assertEquals(expected[1].hashCode(), comp[3].toSBinary().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(comp[4].toSBinary());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(comp[5].toSBinary());

        // Leaves: ScrabbleString x2
        assertNull(comp[6].toSBinary());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(comp[7].toSBinary());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(comp[8].toSBinary());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(comp[1].toSBinary());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(comp[9].toSBinary());

        // Leaves: ScrabbleFloat x2
        assertNull(comp[10].toSBinary());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertNull(comp[11].toSBinary());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertNull(comp[12].toSBinary());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(comp[13].toSBinary());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(comp[14].toSBinary());

        // Leaves: ScrabbleBinary x2
        assertEquals(expected[2], comp[15].toSBinary());
        assertEquals(expected[2].hashCode(), comp[15].toSBinary().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertEquals(expected[3], comp[16].toSBinary());
        assertEquals(expected[3].hashCode(), comp[16].toSBinary().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(comp[17].toSBinary());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(comp[18].toSBinary());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(comp[19].toSBinary());

        // Leaves: ScrabbleBool x2
        assertNull(comp[20].toSBinary());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[21].toSBinary());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(comp[22].toSBinary());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(comp[23].toSBinary());
        // Leaves: ScrabbleBool, ScrabbleBinary
        assertNull(comp[24].toSBinary());
    }

    @Override
    protected void toSIntTest(IScrabble[] expected, Component[] comp) {
        // Leaves: ScrabbleInt x2
        assertEquals(expected[0], comp[0].toSInt());
        assertEquals(expected[0].hashCode(), comp[0].toSInt().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertNull(comp[2].toSInt());
        // Leaves: ScrabbleInt, ScrabbleBinary
        assertEquals(expected[1], comp[3].toSInt());
        assertEquals(expected[1].hashCode(), comp[3].toSInt().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(comp[4].toSInt());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(comp[5].toSInt());

        // Leaves: ScrabbleString x2
        assertNull(comp[6].toSInt());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(comp[7].toSInt());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(comp[8].toSInt());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(comp[1].toSInt());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(comp[9].toSInt());

        // Leaves: ScrabbleFloat x2
        assertNull(comp[10].toSInt());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertNull(comp[11].toSInt());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertNull(comp[12].toSInt());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(comp[13].toSInt());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(comp[14].toSInt());

        // Leaves: ScrabbleBinary x2
        assertEquals(expected[2], comp[15].toSInt());
        assertEquals(expected[2].hashCode(), comp[15].toSInt().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertEquals(expected[3], comp[16].toSInt());
        assertEquals(expected[3].hashCode(), comp[16].toSInt().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(comp[17].toSInt());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(comp[18].toSInt());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(comp[19].toSInt());

        // Leaves: ScrabbleBool x2
        assertNull(comp[20].toSInt());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[21].toSInt());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(comp[22].toSInt());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(comp[23].toSInt());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[24].toSInt());
    }

    @Override
    protected void toSFloatTest(IScrabble[] expected, Component[] comp) {
        // Leaves: ScrabbleInt x2
        assertEquals(expected[0], comp[0].toSFloat());
        assertEquals(expected[0].hashCode(), comp[0].toSFloat().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertEquals(expected[1], comp[2].toSFloat());
        assertEquals(expected[1].hashCode(), comp[2].toSFloat().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        assertEquals(expected[2], comp[3].toSFloat());
        assertEquals(expected[2].hashCode(), comp[3].toSFloat().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(comp[4].toSFloat());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(comp[5].toSFloat());

        // Leaves: ScrabbleString x2
        assertNull(comp[6].toSFloat());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(comp[7].toSFloat());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(comp[8].toSFloat());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(comp[1].toSFloat());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(comp[9].toSFloat());

        // Leaves: ScrabbleFloat x2
        assertEquals(expected[3], comp[10].toSFloat());
        assertEquals(expected[3].hashCode(), comp[10].toSFloat().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertEquals(expected[4], comp[11].toSFloat());
        assertEquals(expected[4].hashCode(), comp[11].toSFloat().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertEquals(expected[5], comp[12].toSFloat());
        assertEquals(expected[5].hashCode(), comp[12].toSFloat().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(comp[13].toSFloat());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(comp[14].toSFloat());

        // Leaves: ScrabbleBinary x2
        assertEquals(expected[6], comp[15].toSFloat());
        assertEquals(expected[6].hashCode(), comp[15].toSFloat().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertEquals(expected[7], comp[16].toSFloat());
        assertEquals(expected[7].hashCode(), comp[16].toSFloat().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(comp[17].toSFloat());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(comp[18].toSFloat());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(comp[19].toSFloat());

        // Leaves: ScrabbleBool x2
        assertNull(comp[20].toSFloat());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[21].toSFloat());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(comp[22].toSFloat());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(comp[23].toSFloat());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[24].toSFloat());
    }

    @Override
    protected void toSStringTest(IScrabble[] expected, Component[] comp) {
        // Leaves: ScrabbleInt x2
        assertEquals(expected[0], comp[0].toSString());
        assertEquals(expected[0].hashCode(), comp[0].toSString().hashCode());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertEquals(expected[1], comp[2].toSString());
        assertEquals(expected[1].hashCode(), comp[2].toSString().hashCode());
        // Leaves: ScrabbleInt, ScrabbleBinary
        assertEquals(expected[2], comp[3].toSString());
        assertEquals(expected[2].hashCode(), comp[3].toSString().hashCode());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(comp[4].toSString());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(comp[5].toSString());

        // Leaves: ScrabbleString x2
        assertNull(comp[6].toSString());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(comp[7].toSString());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(comp[8].toSString());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(comp[1].toSString());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(comp[9].toSString());

        // Leaves: ScrabbleFloat x2
        assertEquals(expected[3], comp[10].toSString());
        assertEquals(expected[3].hashCode(), comp[10].toSString().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertEquals(expected[4], comp[11].toSString());
        assertEquals(expected[4].hashCode(), comp[11].toSString().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertEquals(expected[5], comp[12].toSString());
        assertEquals(expected[5].hashCode(), comp[12].toSString().hashCode());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(comp[13].toSString());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(comp[14].toSString());

        // Leaves: ScrabbleBinary x2
        assertEquals(expected[6], comp[15].toSString());
        assertEquals(expected[6].hashCode(), comp[15].toSString().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertEquals(expected[7], comp[16].toSString());
        assertEquals(expected[7].hashCode(), comp[16].toSString().hashCode());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(comp[17].toSString());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(comp[18].toSString());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(comp[19].toSString());

        // Leaves: ScrabbleBool x2
        assertNull(comp[20].toSString());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[21].toSString());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(comp[22].toSString());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(comp[23].toSString());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[24].toSString());
    }

    @Override
    protected void toSBoolTest(IScrabble[] expected, Component[] comp) {
        // Leaves: ScrabbleInt x2
        assertNull(comp[0].toSBool());
        // Leaves: ScrabbleInt, ScrabbleFloat
        assertNull(comp[2].toSBool());
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertNull(comp[3].toSBool());
        // Leaves: ScrabbleInt, ScrabbleString
        assertNull(comp[4].toSBool());
        // Leaves: ScrabbleInt, ScrabbleBool
        assertNull(comp[5].toSBool());

        // Leaves: ScrabbleString x2
        assertNull(comp[6].toSBool());
        // Leaves: ScrabbleString, ScrabbleBool
        assertNull(comp[7].toSBool());
        // Leaves: ScrabbleString, ScrabbleFloat
        assertNull(comp[8].toSBool());
        // Leaves: ScrabbleString, ScrabbleInt
        assertNull(comp[1].toSBool());
        // Leaves: ScrabbleString, ScrabbleBinary
        assertNull(comp[9].toSBool());

        // Leaves: ScrabbleFloat x2
        assertNull(comp[10].toSBool());
        // Leaves: ScrabbleFloat, ScrabbleInt
        assertNull(comp[11].toSBool());;
        // Leaves: ScrabbleFloat, ScrabbleBinary
        assertNull(comp[12].toSBool());
        // Leaves: ScrabbleFloat, ScrabbleString
        assertNull(comp[13].toSBool());
        // Leaves: ScrabbleFloat, ScrabbleBool
        assertNull(comp[14].toSBool());

        // Leaves: ScrabbleBinary x2
        assertNull(comp[15].toSBool());
        // Leaves: ScrabbleBinary, ScrabbleInt
        assertNull(comp[16].toSBool());
        // Leaves: ScrabbleBinary, ScrabbleFloat
        assertNull(comp[17].toSBool());
        // Leaves: ScrabbleBinary, ScrabbleString
        assertNull(comp[18].toSBool());
        // Leaves: ScrabbleBinary, ScrabbleBool
        assertNull(comp[19].toSBool());

        // Leaves: ScrabbleBool x2
        assertNull(comp[20].toSBool());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[21].toSBool());
        // Leaves: ScrabbleBool, ScrabbleFloat
        assertNull(comp[22].toSBool());
        // Leaves: ScrabbleBool, ScrabbleString
        assertNull(comp[23].toSBool());
        // Leaves: ScrabbleBool, ScrabbleInt
        assertNull(comp[24].toSBool());
    }
}
