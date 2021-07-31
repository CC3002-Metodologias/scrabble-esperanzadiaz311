package cl.uchile.dcc.scrabble.operationtree;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

/** Abstract class for all the elements of an operation tree
 * @author Esperanza Díaz Adaro
 */
public abstract class OperationTree implements Component {
    protected Component left, right;
    public OperationTree(Component left, Component right){
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract IScrabble calculate();

    /** Verifies if an element of a node is null or not
     * @return a boolean checking if a element is null
     */
    protected boolean nullCheck(){
        return this.calculate() == null;
    }

    @Override
    public Scrabble_Binary toSBinary(){
        if(!this.nullCheck()){
            return this.calculate().toBinary();
        }
        else{
            return null;
        }
    }

    @Override
    public Scrabble_Int toSInt() {
        if(!this.nullCheck()){
            return this.calculate().toInt();
        }
        else{
            return null;
        }
    }

    @Override
    public Scrabble_String toSString() {
        if(!this.nullCheck()){
            return this.calculate().toScrabbleString();
        }
        else{
            return null;
        }
    }

    @Override
    public Scrabble_Float toSFloat() {
        if(!this.nullCheck()){
            return this.calculate().toFloat();
        }
        else{
            return null;
        }
    }

    @Override
    public Scrabble_Bool toSBool() {
        if(!this.nullCheck()){
            return this.calculate().toBool();
        }
        else{
            return null;
        }
    }
}
