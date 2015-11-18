package exTeoricas;

public interface Iterator<E>    // Interface a ser implementada pelos iteradores
{
    boolean hasNext();
    E next();           // gera excepção caso não exista
    void remove();      // gera excepção se não é possível
}