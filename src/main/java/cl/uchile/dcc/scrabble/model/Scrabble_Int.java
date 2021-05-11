package cl.uchile.dcc.scrabble.model;

import java.util.Objects;

public class Scrabble_Int implements IScrabble_Type{
    public int n;
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

    public Scrabble_Float toFloat(){
        return new Scrabble_Float(Double.valueOf(this.toString()));
    }

    public Scrabble_Int toInt(){
        return new Scrabble_Int(Integer.valueOf(this.toString()));
    }

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
