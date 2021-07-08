package cl.uchile.dcc.scrabble.operationtree.operators.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

/** Node Add of an operation tree
 * @author Esperanza Díaz Adaro
 */
public class Add extends OperationTree {
    public Add(Component left, Component right){
        super(left, right);
    }

    @Override
    public IScrabble calculate(){
        IScrabble l = this.left.calculate();
        IScrabble r = this.right.calculate();
        return l.add(r);
    }
}
