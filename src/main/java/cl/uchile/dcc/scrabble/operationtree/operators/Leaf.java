package cl.uchile.dcc.scrabble.operationtree.operators;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.operationtree.OperationTree;

/** Leaf of an operation tree
 * @author Esperanza Díaz Adaro
 */
public class Leaf extends OperationTree  {
    IScrabble scrabble;

    public Leaf(IScrabble scrabble) {
        super(null, null);
        this.scrabble = scrabble;
    }

    public IScrabble calculate(){
        return this.scrabble;
    }

}

