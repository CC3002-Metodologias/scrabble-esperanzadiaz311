package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Represents the int data type of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Int implements IScrabble, IScrabbleArithmetic {
    private int n;

    /** Creates a Scrabble Int from a int
     * @param n the number (int) that is going to be used
     */
    public Scrabble_Int(int n){
        this.n = n;
    }

    @Override
    public String toString(){
        int num = this.getInt();
        return Integer.toString(num);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    /** Transforms the Scrabble Float into a Scrabble Int
     * @return a new Scrabble Float
     */
    @Override
    public Scrabble_Float toFloat(){
        return new Scrabble_Float(Double.valueOf(this.toString()));
    }

    /** Returns the same Scrabble Int */
    public Scrabble_Int toInt(){
        return new Scrabble_Int(this.getInt());
    }

    public Scrabble_Binary toBinary(){
        int abs_i = Math.abs(this.n);
        Scrabble_Binary b = positiveIntToBinary(abs_i);
        if (this.n < 0){
            b = twosComplement(b);
        }
        return b;
    }
    private Scrabble_Binary positiveIntToBinary(int num){
        StringBuilder bin = new StringBuilder("1");
        int index;
        int length = (int) (Math.log(num) / Math.log(2)) + 1;
        for(int i = 0; i<length-1;i++){
            bin=bin.append("0");}
        int cont = (int) (num - Math.pow(2, length-1));
        while (cont > 0){
            index = (int) (Math.log(cont) / Math.log(2));
            bin.setCharAt(length-index-1, '1');
            cont -= (int) Math.pow(2, index);
        }
        return new Scrabble_Binary(bin.toString());
    }
    private Scrabble_Binary twosComplement(Scrabble_Binary b){
        StringBuilder result = new StringBuilder(b.not().toString());
        for(int i = result.length()-1; i>=0; i--){
            if(result.charAt(i) == '0'){
                result.setCharAt(i, '1');
                break;
            }else{
                result.setCharAt(i, '0');
            }
        }
        StringBuilder fin = new StringBuilder("11111111111111111111111111111111");
        fin=fin.replace(32-result.length(), 32, result.toString());
        return new Scrabble_Binary(fin.toString());
    }

    @Override
    public IScrabbleArithmetic add(IScrabbleArithmetic a){
        return a.addCalledByInt(this);
    }

    @Override
    public IScrabbleArithmetic sub(IScrabbleArithmetic s){
        return s.subCalledByInt(this);
    }

    @Override
    public IScrabbleArithmetic mult(IScrabbleArithmetic mlt){
        return mlt.multCalledByInt(this);
    }

    @Override
    public IScrabbleArithmetic div(IScrabbleArithmetic dv){
        return dv.divCalledByInt(this);
    }

    @Override
    public IScrabbleArithmetic addCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.n + i.getInt());
    }

    @Override
    public IScrabbleArithmetic addCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.n + f.getFloat());
    }

    @Override
    public IScrabbleArithmetic addCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.n + bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public Scrabble_String addCalledByString(Scrabble_String str){
        return new Scrabble_String(str.getString() + this.n);
    }

    @Override
    public IScrabbleArithmetic subCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() - this.n);
    }

    @Override
    public IScrabbleArithmetic subCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() - this.n);
    }

    @Override
    public IScrabbleArithmetic subCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() - this.n);
        return result.toBinary();
    }

    @Override
    public IScrabbleArithmetic multCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.n * i.getInt());
    }

    @Override
    public IScrabbleArithmetic multCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.n * f.getFloat());
    }

    @Override
    public IScrabbleArithmetic multCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.n * bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabbleArithmetic divCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() / this.n);
    }

    @Override
    public IScrabbleArithmetic divCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() / this.n);
    }

    @Override
    public IScrabbleArithmetic divCalledByBinary(Scrabble_Binary bin){
        if(bin.toInt().getInt()<this.n){
            return new Scrabble_Binary("0");
        }
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() / this.n);
        return result.toBinary();
    }

    /** Returns the int used in the constructor */
    public int getInt(){
        return n;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Scrabble_Int){
            var o = (Scrabble_Int) obj;
            return this.getClass() == o.getClass() && this.getInt() == o.getInt();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClass(), getInt());
    }
}
