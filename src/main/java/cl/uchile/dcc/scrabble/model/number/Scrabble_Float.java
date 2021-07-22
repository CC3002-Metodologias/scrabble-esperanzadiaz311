package cl.uchile.dcc.scrabble.model.number;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;

import java.util.Objects;

/**
 * Represents the float model data of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Float implements IScrabble{
    private double f;

    /** Creates a Scrabble Float from a double
     * @param f the number (double model) that's going the be used
     */
    public Scrabble_Float(double f){
        this.f = f;
    }

    @Override
    public String toString(){
        double num = this.f;
        return Double.toString(num);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    @Override
    public Scrabble_Float toFloat(){
        return new Scrabble_Float(this.getFloat());
    }

    @Override
    public Scrabble_Binary toBinary() {
        return null;
    }

    @Override
    public Scrabble_Int toInt() {
        return null;
    }

    @Override
    public Scrabble_Bool toBool() {
        return null;
    }

    /** Returns the double used in the constructor */
    public double getFloat(){ return f; }

    @Override
    public IScrabble add(IScrabble a){
        return a.addCalledByFloat(this);
    }

    @Override
    public IScrabble sub(IScrabble s){
        return s.subCalledByFloat(this);
    }

    @Override
    public IScrabble mult(IScrabble mlt){
        return mlt.multCalledByFloat(this);
    }

    @Override
    public IScrabble div(IScrabble dv){
        return dv.divCalledByFloat(this);
    }

    @Override
    public IScrabble addCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(this.f + i.getInt());
    }

    @Override
    public IScrabble addCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.f + f.getFloat());
    }

    @Override
    public IScrabble addCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public Scrabble_String addCalledByString(Scrabble_String str){
        return new Scrabble_String(str.getString() + this.f);
    }

    @Override
    public IScrabble subCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(i.getInt() - this.f);
    }

    @Override
    public IScrabble subCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() - this.f);
    }

    @Override
    public IScrabble subCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public IScrabble multCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(this.f * i.getInt());
    }

    @Override
    public IScrabble multCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.f * f.getFloat());
    }

    @Override
    public IScrabble multCalledByBinary(Scrabble_Binary bin){
        return null;
    }

    @Override
    public IScrabble divCalledByInt(Scrabble_Int i){
        return new Scrabble_Float(i.getInt() / this.f);
    }

    @Override
    public IScrabble divCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() / this.f);
    }

    @Override
    public IScrabble divCalledByBinary(Scrabble_Binary bin){
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
        if (obj instanceof Scrabble_Float){
            var o = (Scrabble_Float) obj;
            return this.getClass() == o.getClass() && Double.compare(this.f, o.getFloat()) == 0;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getClass(), getFloat());
    }
}

