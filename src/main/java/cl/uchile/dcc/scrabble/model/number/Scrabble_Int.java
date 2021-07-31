package cl.uchile.dcc.scrabble.model.number;

import cl.uchile.dcc.scrabble.model.IScrabble;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_Bool;
import cl.uchile.dcc.scrabble.model.notnumber.Scrabble_String;

import java.util.Objects;

/**
 * Represents the int data model of Scrabble
 * @author Esperanza Díaz Adaro
 */
public class Scrabble_Int implements IScrabble{
    private int n;

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

    @Override
    public Scrabble_Float toFloat(){
        return new Scrabble_Float(Double.valueOf(this.toString()));
    }

    @Override
    public Scrabble_Int toInt(){
        return new Scrabble_Int(this.getInt());
    }

    @Override
    public Scrabble_Bool toBool() {
        return null;
    }

    @Override
    public Scrabble_Binary toBinary(){
        int abs_i = Math.abs(this.n);
        Scrabble_Binary b = positiveIntToBinary(abs_i);
        if (this.n < 0){
            b = twosComplement(b);
        }
        return b;
    }

    /** Trnasforms a positive int into a Scrabble Binary
     * @param num a positive int
     * @return the number transformed into a Scrabble Binary
     */
    private Scrabble_Binary positiveIntToBinary(int num){
        StringBuilder bin;
        if(num == 0){
            bin = new StringBuilder("0");
        }
        else {
            bin = new StringBuilder("1");
        }

        int index;
        int length = (int) (Math.log(num) / Math.log(2)) + 1;
        for(int i = 0; i<length-1;i++){
            bin=bin.append("0");}
        int cont = (int) (num - Math.pow(2, length-1));
        while (cont > 0){
            index = (int) (Math.log(cont) / Math.log(2));
            bin.setCharAt(length-index-1, '1');
            cont -= (int) Math.pow(2, index);
        }
        return new Scrabble_Binary(bin.toString());
    }

    /** Calculates two's complement of a Scrabble Binary
     * @param b a Scrabble Binary
     * @return the two's complement in a Scrabble String
     */
    private Scrabble_Binary twosComplement(Scrabble_Binary b){
        StringBuilder result = new StringBuilder(b.not().toString());
        for(int i = result.length()-1; i>=0; i--){
            if(result.charAt(i) == '0'){
                result.setCharAt(i, '1');
                break;
            }else{
                result.setCharAt(i, '0');
            }
        }
        StringBuilder fin = new StringBuilder("11111111111111111111111111111111");
        fin=fin.replace(32-result.length(), 32, result.toString());
        return new Scrabble_Binary(fin.toString());
    }

    @Override
    public IScrabble add(IScrabble a){
        return a.addCalledByInt(this);
    }

    @Override
    public IScrabble sub(IScrabble s){
        return s.subCalledByInt(this);
    }

    @Override
    public IScrabble mult(IScrabble mlt){
        return mlt.multCalledByInt(this);
    }

    @Override
    public IScrabble div(IScrabble dv){
        return dv.divCalledByInt(this);
    }

    @Override
    public IScrabble addCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.n + i.getInt());
    }

    @Override
    public IScrabble addCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.n + f.getFloat());
    }

    @Override
    public IScrabble addCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.n + bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public Scrabble_String addCalledByString(Scrabble_String str){
        return new Scrabble_String(str.getString() + this.n);
    }

    @Override
    public IScrabble subCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() - this.n);
    }

    @Override
    public IScrabble subCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() - this.n);
    }

    @Override
    public IScrabble subCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() - this.n);
        return result.toBinary();
    }

    @Override
    public IScrabble multCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(this.n * i.getInt());
    }

    @Override
    public IScrabble multCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(this.n * f.getFloat());
    }

    @Override
    public IScrabble multCalledByBinary(Scrabble_Binary bin){
        Scrabble_Int result = new Scrabble_Int(this.n * bin.toInt().getInt());
        return result.toBinary();
    }

    @Override
    public IScrabble divCalledByInt(Scrabble_Int i){
        return new Scrabble_Int(i.getInt() / this.n);
    }

    @Override
    public IScrabble divCalledByFloat(Scrabble_Float f){
        return new Scrabble_Float(f.getFloat() / this.n);
    }

    @Override
    public IScrabble divCalledByBinary(Scrabble_Binary bin){
        if(bin.toInt().getInt()<this.n){
            return new Scrabble_Binary("0");
        }
        Scrabble_Int result = new Scrabble_Int(bin.toInt().getInt() / this.n);
        return result.toBinary();
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
