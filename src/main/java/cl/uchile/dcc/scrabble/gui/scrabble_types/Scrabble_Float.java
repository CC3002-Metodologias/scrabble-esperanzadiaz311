package cl.uchile.dcc.scrabble.gui.scrabble_types;

public class Scrabble_Float implements IScrabble_Type {
    public float f;
    public Scrabble_Float(float f){
        this.f=f;
    }

    @Override
    public String toString(){
        float num = this.getFloat();
        return Float.toString(num);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }



    public float getFloat() {
        return f;
    }

    public void setFloat(float f) {
        this.f = f;
    }


}
