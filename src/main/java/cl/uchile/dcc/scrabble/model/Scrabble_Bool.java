package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Represents the boolean (bool) data type of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Bool implements IScrabble, IScrabbleLogical {
    private boolean b;

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

    /** Returns a copy of the same Scrabble Bool */
    public Scrabble_Bool toBool(){
        return new Scrabble_Bool(this.getBoolean());
    }

    /** Returns the boolean used in the constructor */
    public boolean getBoolean(){
        return b;
    }

    /**
     * @param b
     * @return
     */
    // inicio parte 2
    @Override
    public IScrabbleLogical or(IScrabbleLogical b){
        return b.orCalledByBoolean(this);
    }

    @Override
    public IScrabbleLogical and(IScrabbleLogical b){
        return b.andCalledByBoolean(this);
    }

    @Override
    public IScrabbleLogical not(){
        IScrabbleLogical var = new Scrabble_Bool(!this.b);
        return var;
    }

    @Override
    public IScrabbleLogical orCalledByBoolean(Scrabble_Bool b){
        return new Scrabble_Bool(this.b || b.getBoolean());
    }

    @Override
    public IScrabbleLogical andCalledByBoolean(Scrabble_Bool b){
        return new Scrabble_Bool( this.b && b.getBoolean());
    }

    @Override
    public Scrabble_Binary orCalledByBinary(Scrabble_Binary bin){
        String result = bin.getString();
        if(this.b){
            result = result.replace('0', '1');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public Scrabble_Binary andCalledByBinary(Scrabble_Binary bin){
        String result = bin.getString();
        if(!this.b){
            result = result.replace('1', '0');
        }
        return new Scrabble_Binary(result);
    }

    @Override
    public Scrabble_String addCalledByString(Scrabble_String str){
        return new Scrabble_String(str.getString() + this.b);
    }
    //fin parte 2*/

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

