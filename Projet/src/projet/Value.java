
package projet;

public abstract class Value {
    // On rend certaines méthodes de Object abstraites
    // afin d'être sûr de les redéfinir dans les classes enfantes

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(
            Object o);

    @Override
    public abstract int hashCode();
}
