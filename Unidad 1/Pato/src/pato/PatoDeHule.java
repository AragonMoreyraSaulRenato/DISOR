package pato;

/**
 *
 * @author Erick Andrade
 */
public class PatoDeHule extends Pato
{
    /*public PatoDeHule()//Constructor Original
    {
        comportamientoVolar = new NoPuedeVolar();
        comportamientoQuack = new Squeak();
    }*/
    
    /*//EN CASO DE EMERGENIA BORRAR DESDE AQUI*/
    private static PatoDeHule instance;
    
    private PatoDeHule()
    {
        comportamientoQuack = new Quack();
        comportamientoVolar = new VolarConAlas();
    }
    
    public static PatoDeHule getInstance()
    {
        if(instance==null)
        {
            instance=new PatoDeHule();
        }
        else
        {
            System.out.println("No se pueden crear mas patos de Hule");
        }
        return instance;
    }
    /*///////////////////////*///HASTA AQUI
    
    public void display()
    {
        System.out.println("Soy un pato de Hule");
    }
}
