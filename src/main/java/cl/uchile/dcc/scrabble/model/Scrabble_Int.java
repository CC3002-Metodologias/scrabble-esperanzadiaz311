package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Represents the int data type of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Int implements IScrabble_Type{
    public int n;

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
    public Scrabble_Float toFloat(){
        return new Scrabble_Float(Double.valueOf(this.toString()));
    }

    /** Returns the same Scrabble Int */
    public Scrabble_Int toInt(){
        return this;
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
