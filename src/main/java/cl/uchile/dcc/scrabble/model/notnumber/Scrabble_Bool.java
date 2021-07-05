package cl.uchile.dcc.scrabble.model.notnumber;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Binary;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Float;
import cl.uchile.dcc.scrabble.model.number.Scrabble_Int;

import java.util.Objects;

/**
 * Represents the boolean (bool) data model of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Bool implements IScrabble{
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

    @Override
    public IScrabble or(IScrabble b){
        return b.orCalledByBoolean(this);
    }

    @Override
    public IScrabble and(IScrabble b){
        return b.andCalledByBoolean(this);
    }

    @Override
    public IScrabble not(){
        IScrabble var = new Scrabble_Bool(!this.b);
        return var;
    }

    @Override
    public IScrabble orCalledByBoolean(Scrabble_Bool b){
        return new Scrabble_Bool(this.b || b.getBoolean());
    }

    @Override
    public IScrabble andCalledByBoolean(Scrabble_Bool b){
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

    @Override
    public Scrabble_Float toFloat() {
        return null;
    }

    @Override
    public IScrabble add(IScrabble a) {
        return null;
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

