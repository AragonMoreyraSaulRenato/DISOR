package pato;

/**
 *
 * @author Erick Andrade
 */
public class ModeloPato extends Pato
{
    public ModeloPato()
    {
        comportamientoVolar = new NoPuedeVolar();
        comportamientoQuack = new Quack();
    }
    
    public void display()
    {
        System.out.println("Soy un modelo de pato");
    }
}
