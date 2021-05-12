package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Represents the boolean (bool) data type of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Bool implements IScrabble_Type{
    public boolean b;

    /** Creates a Scrabble Bool from a boolean
     * @param b the boolean that's going to be used
     */
    public Scrabble_Bool(boolean b){
        this.b = b;
    }

    @Override
    public String toString(){
        return Boolean.toString(this.getBoolean());
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    /** Returns the same Scrabble Bool */
    public Scrabble_Bool toBool(){
        return this;
    }

    /** Returns the boolean used in the constructor */
    public boolean getBoolean(){
        return b;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Scrabble_Bool){
            var o = (Scrabble_Bool) obj;
            return this.getClass() == o.getClass() && this.getBoolean() == o.getBoolean();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClass(), getBoolean());
    }
}
