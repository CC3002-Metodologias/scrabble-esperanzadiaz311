package cl.uchile.dcc.scrabble.operationtree.operators.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

/** Node And of an operation tree
 * @author Esperanza Díaz Adaro
 */
public class And extends OperationTree {
    public And(Component left, Component right){
        super(left, right);
    }

    @Override
    public IScrabble calculate(){
        IScrabble left = this.left.calculate();
        IScrabble right = this.right.calculate();
        return left.and(right);
    }
}
