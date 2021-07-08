package cl.uchile.dcc.scrabble.operationtree.operators.logical;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

/** Node Not of an operation tree
 * @author Esperanza Díaz Adaro
 */
public class Not extends OperationTree {
    public Not(Component left){
        super(left, null);
    }

    @Override
    public IScrabble calculate(){
        IScrabble l = this.left.calculate();
        return l.not();
    }
}
