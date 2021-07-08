package cl.uchile.dcc.scrabble.operationtree.operators.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

public class Sub extends OperationTree {
    public Sub(Component left, Component right){
        super(left, right);
    }

    @Override
    public IScrabble calculate(){
        IScrabble left = this.left.calculate();
        IScrabble right = this.right.calculate();
        return left.sub(right);
    }
}
