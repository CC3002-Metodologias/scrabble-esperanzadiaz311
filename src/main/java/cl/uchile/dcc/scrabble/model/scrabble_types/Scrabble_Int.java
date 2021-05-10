package cl.uchile.dcc.scrabble.model.scrabble_types;

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

    /**
     * @return
     */
    public Scrabble_Int toInt(){ return new Scrabble_Int(Integer.valueOf(this.toString())); }

    //public Scrabble_Binary toBinary(){};

    public int getN() {
        return n;
    }
}
