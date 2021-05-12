package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Represents the float type data of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Float implements IScrabble_Type{
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

    /** Returns the same Scrabble Float */
    public Scrabble_Float toFloat(){
        return this;
    }

    /** Returns the double used in the constructor */
    public double getFloat(){ return f; }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Scrabble_Float){
            var o = (Scrabble_Float) obj;
            return this.getClass() == o.getClass() && this.getFloat() == o.getFloat();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClass(), getFloat());
    }
}
