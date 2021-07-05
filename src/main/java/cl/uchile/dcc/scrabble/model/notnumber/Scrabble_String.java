package cl.uchile.dcc.scrabble.model.notnumber;

import cl.uchile.dcc.scrabble.model.BuiltWithString;
import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

import java.util.Objects;

/**
 * Subclass of BuiltWithString
 * Represents the string data model of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_String extends BuiltWithString {
    public Scrabble_String(String s){ super(s);}

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.getString());
    }

    @Override
    public Scrabble_Float toFloat() {
        return null;
    }

    public Scrabble_String add(IScrabble s){
        return s.addCalledByString(this);
    }

    @Override
    public IScrabble sub(IScrabble s) {
        return null;
    }

    @Override
    public IScrabble mult(IScrabble mlt) {
        return null;
    }

    @Override
    public IScrabble div(IScrabble dv) {
        return null;
    }

    @Override
    public IScrabble addCalledByInt(Scrabble_Int i) {
        return null;
    }

    @Override
    public IScrabble addCalledByFloat(Scrabble_Float f) {
        return null;
    }

    @Override
    public IScrabble addCalledByBinary(Scrabble_Binary bin) {
        return null;
    }

    @Override
    public IScrabble subCalledByInt(Scrabble_Int i) {
        return null;
    }

    @Override
    public IScrabble subCalledByFloat(Scrabble_Float f) {
        return null;
    }

    @Override
    public IScrabble subCalledByBinary(Scrabble_Binary bin) {
        return null;
    }

    @Override
    public IScrabble multCalledByInt(Scrabble_Int i) {
        return null;
    }

    @Override
    public IScrabble multCalledByFloat(Scrabble_Float f) {
        return null;
    }

    @Override
    public IScrabble multCalledByBinary(Scrabble_Binary bin) {
        return null;
    }

    @Override
    public IScrabble divCalledByInt(Scrabble_Int i) {
        return null;
    }

    @Override
    public IScrabble divCalledByFloat(Scrabble_Float f) {
        return null;
    }

    @Override
    public IScrabble divCalledByBinary(Scrabble_Binary bin) {
        return null;
    }

    @Override
    public IScrabble or(IScrabble l) {
        return null;
    }

    @Override
    public IScrabble and(IScrabble l) {
        return null;
    }

    @Override
    public IScrabble not() {
        return null;
    }

    @Override
    public IScrabble orCalledByBoolean(Scrabble_Bool b) {
        return null;
    }

    @Override
    public IScrabble andCalledByBoolean(Scrabble_Bool b) {
        return null;
    }

    @Override
    public IScrabble orCalledByBinary(Scrabble_Binary bin) {
        return null;
    }

    @Override
    public IScrabble andCalledByBinary(Scrabble_Binary bin) {
        return null;
    }

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

