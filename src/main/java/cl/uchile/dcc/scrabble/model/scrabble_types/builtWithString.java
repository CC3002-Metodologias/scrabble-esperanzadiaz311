package cl.uchile.dcc.scrabble.model.scrabble_types;

public abstract class builtWithString implements IScrabble_Type {
    private String s;
    public builtWithString(String s){
        this.s = s;
    }

    @Override
    public String toString(){
        String str = this.getString();
        return str;
    }

    @Override
    public Scrabble_String toScrabbleString(){
        return new Scrabble_String(this.toString());
    }

    public String getString() {
        return s;
    }
}

