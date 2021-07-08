package cl.uchile.dcc.scrabble.model.number;

import cl.uchile.dcc.scrabble.model.BuiltWithString;
import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;

import java.util.Objects;

/**
 * Subclass of BuiltCalledByString
 * Represents the binary data model of Scrabble
 * @author Esperanza Díaz Adaro.
 */
public class Scrabble_Binary extends BuiltWithString{

    public Scrabble_Binary(String s){ super(s); }

    /** Transforms a negative Scrabble Binary into a Java int */
    private int negativeBinaryToInt() {
        int n = 31;
        int w = -2147483648;
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (this.s.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    /** Transforms a positive Scrabble Binary into a Java int */
    private int positiveBinToInt() {
        int w = 0;
        for (int i = this.getString().length() - 1, j = 0; i >= 0; i--, j++) {
            w += (int) Math.pow(2, i) * bitToInt(this.s.charAt(j));
        }
        return w;
    }
    /** Transforms a Java char into a Java int */
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /** Returns a copy of the same Scrabble Binary */
    @Override
    public Scrabble_Binary toBinary(){
        return new Scrabble_Binary(this.s);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.s);
    }

    /** Transforms a Scrabble Binary into a Scrabble Int
     * @return a new Scrabble Int with the value of the Scrabble Binary
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

    @Override
    public Scrabble_Bool toBool() {
        return null;
    }

    @Override
    public Scrabble_Float toFloat(){
        return new Scrabble_Float( ((this.toInt()).toFloat()).getFloat() );
    }

    @Override
    public IScrabble or(IScrabble l){
        return l.orCalledByBinary(this);
    }

    @Override
    public IScrabble and(IScrabble l){
        return l.andCalledByBinary(this);
    }

    @Override
    public IScrabble not(){
        String result = this.getString();
        result = result.replace('0', '#').replace('1', '%').replace
                ('#','1').replace('%', '0');
        return new Scrabble_Binary(result);
    }
    @Override
    public IScrabble orCalledByBoolean(Scrabble_Bool b){
        String result = this.getString();
        if(b.getBoolean()){
            result = result.replace('0', '1');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public IScrabble andCalledByBoolean(Scrabble_Bool b){
        String result = this.getString();
        if(!b.getBoolean()){
            result = result.replace('1', '0');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public IScrabble orCalledByBinary(Scrabble_Binary bin){
        StringBuilder result;
        int counter;
        if(bin.getString().length() <= this.s.length()){
            counter = bin.getString().length();
            result = new StringBuilder(this.s);
            for(int i = counter-1; i>=0; i--){
                if(this.s.charAt(i+(this.s.length() - counter))=='1' || bin.getString().charAt(i) == '1'){
                    result.setCharAt(i+(this.s.length() - counter), '1');
                }
            }
        }else{
            counter = this.s.length();
            result = new StringBuilder(bin.getString());
            for(int i = counter-1; i>=0; i--){
                if(this.s.charAt(i)=='1' || bin.getString().charAt(i+(bin.getString().length() - counter)) == '1'){
                    result.setCharAt(i+(bin.getString().length() - counter), '1');
                }
            }
        }

        return new Scrabble_Binary(result.toString());
    }

    @Override
    public IScrabble andCalledByBinary(Scrabble_Binary bin){
        StringBuilder result;
        int counter;
        if(bin.getString().length() <= this.s.length()){
            counter = bin.getString().length();
            result = new StringBuilder(bin.getString());
            for(int i = counter-1; i>=0; i--){
                if(this.s.charAt(i+(this.s.length() - counter))=='1' && bin.getString().charAt(i) == '1') {
                    result.setCharAt(i, '1');
                }else{
                    result.setCharAt(i, '0');
                }
            }
        }else{
            counter = this.s.length();
            result = new StringBuilder(this.s);
            for(int i = counter-1; i>=0; i--){
                if(this.s.charAt(i)=='1' && bin.getString().charAt(i+(bin.getString().length() - counter)) == '1'){
                    result.setCharAt(i, '1');
                }else{
                    result.setCharAt(i, '0');
                }
            }
        }
        return new Scrabble_Binary(result.toString());
    }

    @Override
    public IScrabble add(IScrabble a){
        return a.addCalledByBinary(this);
    }

    @Override
    public IScrabble sub(IScrabble s){
        return s.subCalledByBinary(this);
    }

    @Override
    public IScrabble mult(IScrabble mlt){
        return mlt.multCalledByBinary(this);
    }

    @Override
    public IScrabble div(IScrabble dv){
        return dv.divCalledByBinary(this);
    }

    @Override
    public IScrabble addCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.toInt().getInt() + i.getInt());
    }

    @Override
    public IScrabble addCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() + this.toInt().getInt());
    }

    @Override
    public IScrabble addCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.toInt().getInt() + bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabble subCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() - this.toInt().getInt());
    }

    @Override
    public IScrabble subCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() - this.toInt().getInt());
    }

    @Override
    public IScrabble subCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() - this.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabble multCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.toInt().getInt() * i.getInt());
    }

    @Override
    public IScrabble multCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() * this.toInt().getInt());
    }

    @Override
    public IScrabble multCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.toInt().getInt() *  bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabble divCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() / this.toInt().getInt());
    }

    @Override
    public IScrabble divCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() / this.toInt().getInt());
    }

    @Override
    public IScrabble divCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() / this.toInt().getInt());
        return result.toBinary();
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

