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
        return null;
    }

    // inicio parte 2
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
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() / this.n);
        return result.toBinary();
    }
    // fin parte 2
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
