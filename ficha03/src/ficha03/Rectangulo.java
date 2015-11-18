package ficha03;

public class Rectangulo extends Figura
{
    private final int largura;
    private final int altura;

    public Rectangulo(int largura, int altura)
    {
        this.largura = largura;
        this.altura = altura;
    }

    public int getLargura() 
    {
        return largura;
    }

    public int getAltura() 
    {
        return altura;
    }

    @Override
    public int getArea()
    {
        return largura * altura;
    }
}