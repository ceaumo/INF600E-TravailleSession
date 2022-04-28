
package projet;

public class IntValue
        extends Value {

    private int value;

    public IntValue(
            int value) {

        this.value = value;
    }

    public int getValue() {

        return this.value;
    }

    @Override
    public String toString() {

        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(
            Object o) {

        if (!(o instanceof IntValue)) {
            return false;
        }

        int i = ((IntValue) o).value;
        return i == this.value;
    }

    @Override
    public int hashCode() {

        return this.value;
    }
}
