package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Subclass of BuiltWithString
 * Represents the binary data type of Scrabble
 * @author Esperanza Díaz Adaro.
 */
public class Scrabble_Binary extends BuiltWithString implements IScrabbleLogical{

    public Scrabble_Binary(String s){ super(s); }

    /** Returns a copy of the same Scrabble Binary */
    public Scrabble_Binary toBinary(){
        return new Scrabble_Binary(this.getString());
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.getString());
    }

    /**
     * @return
     */
    public Scrabble_Int toInt() {
       /* if ((bitToInt(this.getString().charAt(0)) == 0 && this.getString().length()==32) || this.getString().length()<32) {
            return new Scrabble_Int(this.positiveBinToInt());
        }if(bitToInt(this.getString().charAt(0)) == 1 && this.getString().length() == 32){
            return new Scrabble_Int(this.negativeBinaryToInt());
        }*/
        if(this.getString().length() == 32){
            if(bitToInt(this.getString().charAt(0)) == 0) {
                return new Scrabble_Int(this.positiveBinToInt());
            } else{
                return new Scrabble_Int(this.negativeBinaryToInt());
            }
        } else{
            return new Scrabble_Int(this.positiveBinToInt());
        }
    }

    /**
     * @return
     */
    public Scrabble_Float toFloat(){
        return new Scrabble_Float( ((this.toInt()).toFloat()).getFloat() );
    }

    private int negativeBinaryToInt() {
        int n = 31;
        int w = -bitToInt(this.getString().charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (this.getString().charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }
    private int positiveBinToInt() {
        int w = 0;
        for (int i = this.getString().length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(this.getString().charAt(i));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    @Override
    public IScrabbleLogical or(IScrabbleLogical l){
        return l.orWithBinary(this);
    }

    @Override
    public IScrabbleLogical and(IScrabbleLogical l){
        return l.andWithBinary(this);
    }

    @Override
    public IScrabbleLogical not(){
        char var[] = this.getString().toCharArray();
        for(int i = 0; i<this.getString().length(); i++){
            if(var[i] == 1){
                var[i] = 0;
            }else{
                var[i] = 1;
            }
        }
        return new Scrabble_Binary(var.toString());
    }
    @Override
    public IScrabbleLogical orWithBoolean(Scrabble_Bool b){
        String result = this.getString();
        if(b.getBoolean()){
            result.replace('0', '1');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public IScrabbleLogical andWithBoolean(Scrabble_Bool b){
        String result = this.getString();
        if(!b.getBoolean()){
            result.replace('1', '0');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public IScrabbleLogical orWithBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public IScrabbleLogical andWithBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Scrabble_Binary){
            var o = (Scrabble_Binary) obj;
            return this.getClass() == o.getClass() && (this.getString()).equals(o.getString());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClass(), getString());
    }
}

