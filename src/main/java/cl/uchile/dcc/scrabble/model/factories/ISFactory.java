package cl.uchile.dcc.scrabble.model.factories;

import cl.uchile.dcc.scrabble.model.IScrabble;

public interface ISFactory {
    /**
     * @return an IScrabble, which depends of the Factory that's calling it.
     */
    IScrabble create();
}
