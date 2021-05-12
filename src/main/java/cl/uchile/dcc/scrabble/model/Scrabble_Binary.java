package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

/**
 * Subclass of builtWithString
 * Represents the binary data type of Scrabble
 * @author Esperanza Díaz Adaro.
 */
public class Scrabble_Binary extends builtWithString{

    public Scrabble_Binary(String s){ super(s); }

    public Scrabble_Binary toBinary(){
        return this;
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.getString());
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
