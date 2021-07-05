package cl.uchile.dcc.scrabble.operationtree;

import cl.uchile.dcc.scrabble.model.IScrabble;

public abstract class OperationTree implements Component {
    protected Component left, right;
    public OperationTree(Component left, Component right){
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract IScrabble calculate();

}
