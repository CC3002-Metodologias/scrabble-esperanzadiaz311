package cl.uchile.dcc.scrabble.operationtree.operators.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

/** Node Or of an operation tree
 * @author Esperanza Díaz Adaro
 */
public class Or extends OperationTree {
    public Or(Component left, Component right){
        super(left, right);
    }

    @Override
    public IScrabble calculate() {
        IScrabble l = this.left.calculate();
        IScrabble r = this.right.calculate();
        return l.or(r);
    }
}
