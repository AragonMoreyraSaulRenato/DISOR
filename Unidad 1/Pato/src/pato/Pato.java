package pato;

/**
 *
 * @author Erick Andrade
 */

/*
Las clases abstractas permiten crear metodos generales que recrean un comportamieto comun,
algunas de sus caracteristicas son que, algunos de sus metodos no tienen cuerpo 
quiere decir que no tienen nada dentro de '{}' y deben de tener la palabra 'abstract'
estas clases no pueden ser instanciadas, su unico fin es ser heredadas.
Las clases en las que son usadas deben de implemntar/usar todos sus metodos abstractos.
*/

public abstract class Pato
{
    ComportamientoVolar comportamientoVolar;
    ComportamientoQuack comportamientoQuack;
    
    public Pato()
    {}
    
    abstract void display();
    
    public void ejecutaVolar()
    {
        comportamientoVolar.volar();
    }
    
    public void ejecutaQuack()
    {
        comportamientoQuack.quack();
    }
    
    public void nadar()
    {
        System.out.println("Todos los patos flotan, incluso los señuelos!!");
    }
    
    public void setComportamientoVolar(ComportamientoVolar cv)
    {
        comportamientoVolar = cv;
    }
    
    public void setComportamientoQuack(ComportamientoQuack cq)
    {
        comportamientoQuack = cq;
    }
}