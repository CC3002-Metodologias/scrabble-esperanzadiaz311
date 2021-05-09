package cl.uchile.dcc.scrabble.gui.scrabble_types;

public class Scrabble_Int implements IScrabble_Type {
    int n;
    public Scrabble_Int(int n){
        this.n = n;
    }
    @Override
    public String toString(){
        int num = this.getN();
        return Integer.toString(num);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    /**
     * @return a new Scrabble float
     */
    public Scrabble_Float toFloat(){
        return new Scrabble_Float(Float.valueOf(this.toString()));
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
