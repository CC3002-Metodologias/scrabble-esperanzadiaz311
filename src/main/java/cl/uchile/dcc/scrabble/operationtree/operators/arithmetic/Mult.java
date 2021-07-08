package cl.uchile.dcc.scrabble.operationtree.operators.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

/** Node Mult of an operation tree
 * @author Esperanza Díaz Adaro
 */
public class Mult extends OperationTree {
    public Mult(Component left, Component right){
        super(left, right);
    }

    @Override
    public IScrabble calculate(){
        IScrabble left = this.left.calculate();
        IScrabble right = this.right.calculate();
        return left.mult(right);
    }

}
