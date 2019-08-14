package pato;

/**
 *
 * @author Erick Andrade
 */
public class PatoSeñuelo extends Pato
{
    /*public PatoSeñuelo()//Constructor Original
    {
        setComportamientoVolar(new NoPuedeVolar());
        setComportamientoQuack(new MuteQuack());
    }*/
    
    /*//EN CASO DE EMERGENIA BORRAR DESDE AQUI*/
    private static PatoSeñuelo instance;
    
    private PatoSeñuelo()
    {
        comportamientoQuack = new Quack();
        comportamientoVolar = new VolarConAlas();
    }
    
    public static PatoSeñuelo getInstance()
    {
        if(instance==null)
        {
            instance=new PatoSeñuelo();
        }
        else
        {
            System.out.println("No se pueden crear mas patos de Señuelo");
        }
        return instance;
    }
    /*///////////////////////*///HASTA AQUI
    
    public void display()
    {
        System.out.println("Soy un señuelo");
    }
}
