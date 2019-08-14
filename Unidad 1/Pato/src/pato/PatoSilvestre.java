package pato;

/**
 *
 * @author Erick Andrade
 */
public class PatoSilvestre extends Pato
{
    /*public PatoSilvestre() //Metodo Original 
    {
        comportamientoQuack = new Quack();
        comportamientoVolar = new VolarConAlas();
    }*/
    
    /*//EN CASO DE EMERGENIA BORRAR DESDE AQUI*/
    private static PatoSilvestre instance;
    
    private PatoSilvestre()
    {
        comportamientoQuack = new Quack();
        comportamientoVolar = new VolarConAlas();
    }
    
    public static PatoSilvestre getInstance()
    {
        if(instance==null)
        {
            instance=new PatoSilvestre();
        }
        else
        {
            System.out.println("No se pueden crear mas patos silvestres");
        }
        return instance;
    }
    /*///////////////////////*///HASTA AQUI
    
    public void display()
    {
        System.out.println("Soy un Pato silvestre real");
    }
}
