package cl.uchile.dcc.scrabble.operationtree.operators.arithmetic;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.Component;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

/** Node Div of an operation tree
 * @author Esperanza Díaz Adaro
 */
public class Div extends OperationTree{
    public Div(Component left, Component right){
        super(left, right);
    }

    @Override
    public IScrabble calculate(){
        IScrabble left = this.left.calculate();
        IScrabble right = this.right.calculate();
        return left.div(right);
    }

}
