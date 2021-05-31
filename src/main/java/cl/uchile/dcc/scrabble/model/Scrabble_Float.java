package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Represents the float type data of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Float implements IScrabble, IScrabbleArithmetic {
    private double f;

    /** Creates a Scrabble Float from a double
     * @param f the number (double type) that's going the be used
     */
    public Scrabble_Float(double f){
        this.f = f;
    }

    @Override
    public String toString(){
        double num = this.f;
        return Double.toString(num);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    /** Returns a copy of the same Scrabble Float */
    @Override
    public Scrabble_Float toFloat(){
        return new Scrabble_Float(this.getFloat());
    }

    /** Returns the double used in the constructor */
    public double getFloat(){ return f; }

    //inicio parte 2

    @Override
    public IScrabbleArithmetic add(IScrabbleArithmetic a){
        return a.addCalledByFloat(this);
    }

    @Override
    public IScrabbleArithmetic sub(IScrabbleArithmetic s){
        return s.subCalledByFloat(this);
    }

    @Override
    public IScrabbleArithmetic mult(IScrabbleArithmetic mlt){
        return mlt.multCalledByFloat(this);
    }

    @Override
    public IScrabbleArithmetic div(IScrabbleArithmetic dv){
        return dv.divCalledByFloat(this);
    }

    @Override
    public IScrabbleArithmetic addCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(this.f + i.getInt());
    }

    @Override
    public IScrabbleArithmetic addCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.f + f.getFloat());
    }

    @Override
    public IScrabbleArithmetic addCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public Scrabble_String addCalledByString(Scrabble_String str){
        return new Scrabble_String(str.getString() + this.f);
    }

    @Override
    public IScrabbleArithmetic subCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(i.getInt() - this.f);
    }

    @Override
    public IScrabbleArithmetic subCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() - this.f);
    }

    @Override
    public IScrabbleArithmetic subCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public IScrabbleArithmetic multCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(this.f * i.getInt());
    }

    @Override
    public IScrabbleArithmetic multCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.f * f.getFloat());
    }

    @Override
    public IScrabbleArithmetic multCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public IScrabbleArithmetic divCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(i.getInt() / this.f);
    }

    @Override
    public IScrabbleArithmetic divCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() / this.f);
    }

    @Override
    public IScrabbleArithmetic divCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    //fin parte 2

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Scrabble_Float){
            var o = (Scrabble_Float) obj;
            return this.getClass() == o.getClass() && Double.compare(this.f, o.getFloat()) == 0;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClass(), getFloat());
    }
}

