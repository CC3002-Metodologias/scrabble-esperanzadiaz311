package cl.uchile.dcc.scrabble.gui.scrabble_types;

public class Scrabble_Boolean implements IScrabble_Type {
    public boolean b;
    public Scrabble_Boolean(boolean b){
        this.b = b;
    }

    @Override
    public String toString(){
        boolean tof = this.getBoolean();
        return Boolean.toString(tof);
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    public boolean getBoolean() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}
