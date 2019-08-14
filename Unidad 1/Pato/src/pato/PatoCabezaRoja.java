package pato;

/**
 *
 * @author Erick Andrade
 */
public class PatoCabezaRoja extends Pato
{
    /*public PatoCabezaRoja()//Constructor Original
    {
        comportamientoVolar = new VolarConAlas();
        comportamientoQuack = new Quack();
    }*/
    
    /*//EN CASO DE EMERGENIA BORRAR DESDE AQUI*/
    private static PatoCabezaRoja instance;
    
    private PatoCabezaRoja()
    {
        comportamientoQuack = new Quack();
        comportamientoVolar = new VolarConAlas();
    }
    
    public static PatoCabezaRoja getInstance()
    {
        if(instance==null)
        {
            instance=new PatoCabezaRoja();
        }
        else
        {
            System.out.println("No se pueden crear mas patos de cabeza roja");
        }
        return instance;
    }
    /*///////////////////////*///HASTA AQUI
    
    public void display()
    {
        System.out.println("Soy un Pato de cabeza roja real");
    }
}
