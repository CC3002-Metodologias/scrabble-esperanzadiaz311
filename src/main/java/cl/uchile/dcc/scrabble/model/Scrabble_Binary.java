package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class Scrabble_Binary extends builtWithString{
    public Scrabble_Binary(String s){ super(s); }

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
