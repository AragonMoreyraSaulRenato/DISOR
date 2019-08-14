package pato;

/**
 *
 * @author Erick Andrade
 */

/*
Con implementes se le dice que interfaz vamos a usar
*/

public class NoPuedeVolar implements ComportamientoVolar
{
    public void volar()
    {
        System.out.println("No puedo volar");
    }
}
