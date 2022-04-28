
package projet;

public class StringValue
        extends Value {

    private String value;

    public StringValue(
            String value) {

        this.value = value;
    }

    public String getValue() {

        return this.value;
    }

    @Override
    public String toString() {

        return this.value;
    }

    @Override
    public boolean equals(
            Object o) {

        if (!(o instanceof StringValue)) {
            return false;
        }

        String s = ((StringValue) o).value;
        return s.equals(this.value);
    }

    @Override
    public int hashCode() {

        return this.value.hashCode();
    }
}
