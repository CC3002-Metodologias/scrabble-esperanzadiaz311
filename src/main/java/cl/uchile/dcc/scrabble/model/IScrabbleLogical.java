package cl.uchile.dcc.scrabble.model;

public interface IScrabbleLogical {
    /**
     * @param l the scrabble type that is going to be compared
     * @return the result of the 'or' operation
     */
    IScrabbleLogical or(IScrabbleLogical l);

    /**
     * @param l
     * @return
     */
    IScrabbleLogical and(IScrabbleLogical l);

    /**
     * @return
     */
    IScrabbleLogical not();

    /**
     * @param b
     * @return
     */
    IScrabbleLogical orWithBoolean(Scrabble_Bool b);

    /**
     * @param b
     * @return
     */
    IScrabbleLogical andWithBoolean(Scrabble_Bool b);

    /**
     * @param bin
     * @return
     */
    IScrabbleLogical orWithBinary(Scrabble_Binary bin);

    /**
     * @param bin
     * @return
     */
    IScrabbleLogical andWithBinary(Scrabble_Binary bin);
}