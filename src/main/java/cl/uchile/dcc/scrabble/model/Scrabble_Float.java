package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Represents the float type data of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Float implements IScrabble {
    public double f;

    /** Creates a Scrabble Float from a double
     * @param f the number (double type) that's going the be used
     */
    public Scrabble_Float(double f){
        this.f = f;
    }

    @Override
    public String toString(){
        double num = this.getFloat();
        return Double.toString(num);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    /** Returns a copy of the same Scrabble Float */
    public Scrabble_Float toFloat(){
        return new Scrabble_Float(this.getFloat());
    }

    /** Returns the double used in the constructor */
    public double getFloat(){ return f; }

    //inicio parte 2

    public Scrabble_Float add(Scrabble_Int i){
        return new Scrabble_Float(this.getFloat() + i.getInt());
    }
    public Scrabble_Float add(Scrabble_Float f){
        return new Scrabble_Float(this.getFloat() + f.getFloat());
    }
    public Scrabble_Float add(Scrabble_Binary bin){ return new Scrabble_Float(this.getFloat() + (bin.toInt()).getInt()); };

    public Scrabble_Float sub(Scrabble_Int i){
        return new Scrabble_Float(this.getFloat() - i.getInt());
    }
    public Scrabble_Float sub(Scrabble_Float f){
        return new Scrabble_Float(this.getFloat() - f.getFloat());
    }
    public Scrabble_Float sub(Scrabble_Binary bin){ return new Scrabble_Float(this.getFloat() - (bin.toInt()).getInt()); };

    public Scrabble_Float mult(Scrabble_Int i){
        return new Scrabble_Float(this.getFloat() * i.getInt());
    }

    public Scrabble_Float mult(Scrabble_Float f){
        return new Scrabble_Float(this.getFloat() * f.getFloat());
    }
    public Scrabble_Float mult(Scrabble_Binary bin){
        return new Scrabble_Float(this.getFloat() * (bin.toFloat()).getFloat());
    }

    public Scrabble_Float div(Scrabble_Int i){
        return new Scrabble_Float(this.getFloat() / i.getInt());
    }

    public Scrabble_Float div(Scrabble_Float f){
        return new Scrabble_Float(this.getFloat() / f.getFloat());
    }

    public Scrabble_Float div(Scrabble_Binary bin){
        return new Scrabble_Float(this.getFloat() / bin.toInt().getInt());
    }

    //fin parte 2

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Scrabble_Float){
            var o = (Scrabble_Float) obj;
            double dif = Math.abs(this.getFloat() - o.getFloat());
            return this.getClass() == o.getClass();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClass(), getFloat());
    }
}

