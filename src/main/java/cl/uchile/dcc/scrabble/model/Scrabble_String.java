package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class Scrabble_String extends builtWithString{
    private String s;

    /**
     * @param s
     */
    public Scrabble_String(String s){ super(s);}

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Scrabble_String){
            var o = (Scrabble_String) obj;
            return this.getClass() == o.getClass() && (this.getString().equals(o.getString()));
        }
        return false;
    }

    @Override
    public int hashCode(){ return Objects.hash(getClass(), getString());}
}
