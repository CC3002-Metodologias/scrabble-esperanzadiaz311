package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Subclass of BuiltCalledByString
 * Represents the binary data type of Scrabble
 * @author Esperanza Díaz Adaro.
 */
public class Scrabble_Binary extends BuiltWithString implements IScrabbleLogical, IScrabbleArithmetic{

    public Scrabble_Binary(String s){ super(s); }

    /** Returns a copy of the same Scrabble Binary */
    public Scrabble_Binary toBinary(){
        return new Scrabble_Binary(this.s);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.s);
    }

    /**
     * @return
     */
    public Scrabble_Int toInt() {
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
    @Override
    public Scrabble_Float toFloat(){
        return new Scrabble_Float( ((this.toInt()).toFloat()).getFloat() );
    }

    private int negativeBinaryToInt() {
        int n = 31;
        int w = -bitToInt(this.s.charAt(1)) * (int) Math.pow(2, n-1);
        for (int i = n-2, j = 2; i >= 0; i--, j++) {
            w -= (int) Math.pow(2, i) * (this.s.charAt(j) == '1' ? 1 : 0);
        }
        return w;
    }
    private int positiveBinToInt() {
        int w = 0;
        for (int i = this.getString().length() - 1, j = 0; i >= 0; i--, j++) {
            w += (int) Math.pow(2, i) * bitToInt(this.s.charAt(j));
        }
        return w;
    }
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    // inicio parte 2

    @Override
    public IScrabbleLogical or(IScrabbleLogical l){
        return l.orCalledByBinary(this);
    }

    @Override
    public IScrabbleLogical and(IScrabbleLogical l){
        return l.andCalledByBinary(this);
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
    public IScrabbleLogical orCalledByBoolean(Scrabble_Bool b){
        String result = this.getString();
        if(b.getBoolean()){
            result = result.replace('0', '1');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public IScrabbleLogical andCalledByBoolean(Scrabble_Bool b){
        String result = this.getString();
        if(!b.getBoolean()){
            result = result.replace('1', '0');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public IScrabbleLogical orCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public IScrabbleLogical andCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public IScrabbleArithmetic add(IScrabbleArithmetic a){
        return a.addCalledByBinary(this);
    }

    @Override
    public IScrabbleArithmetic sub(IScrabbleArithmetic s){
        return s.subCalledByBinary(this);
    }

    @Override
    public IScrabbleArithmetic mult(IScrabbleArithmetic mlt){
        return mlt.multCalledByBinary(this);
    }

    @Override
    public IScrabbleArithmetic div(IScrabbleArithmetic dv){
        return dv.divCalledByBinary(this);
    }

    @Override
    public IScrabbleArithmetic addCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.toInt().getInt() + i.getInt());
    }

    @Override
    public IScrabbleArithmetic addCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() + this.toInt().getInt());
    }

    @Override
    public IScrabbleArithmetic addCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.toInt().getInt() + bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabbleArithmetic subCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() - this.toInt().getInt());
    }

    @Override
    public IScrabbleArithmetic subCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() - this.toInt().getInt());
    }

    @Override
    public IScrabbleArithmetic subCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() - this.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabbleArithmetic multCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.toInt().getInt() * i.getInt());
    }

    @Override
    public IScrabbleArithmetic multCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() * this.toInt().getInt());
    }

    @Override
    public IScrabbleArithmetic multCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.toInt().getInt() *  bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabbleArithmetic divCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() / this.toInt().getInt());
    }

    @Override
    public IScrabbleArithmetic divCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() / this.toInt().getInt());
    }

    @Override
    public IScrabbleArithmetic divCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() / this.toInt().getInt());
        return result.toBinary();
    }

    // fin parte 2

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

