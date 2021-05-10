package cl.uchile.dcc.scrabble.model.scrabble_types;

import java.util.Objects;

public class Scrabble_Float implements IScrabble_Type {
    public double f;

    public Scrabble_Float(double f) {
        this.f = f;
    }

    @Override
    public String toString() {
        double num = this.getFloat();
        return Double.toString(num);
    }

    @Override
    public Scrabble_String toScrabbleString() {
        return new Scrabble_String(this.toString());
    }

    public Scrabble_Float toFloat() {
        return new Scrabble_Float(Float.valueOf(toString()));
    }

    public double getFloat() {
        return f;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scrabble_Float)) {
            return false;
        }
        final var o = (Scrabble_Float) obj;
        return this.getClass() == o.getClass() && this.getFloat() == o.getFloat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), getFloat());
    }
}