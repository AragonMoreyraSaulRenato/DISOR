package pato;

/**
 *
 * @author Erick Andrade
 */
public class MiniDuckSimulator 
{
    public static void main(String [] args)
    {
        //Pato silvestre = new PatoSilvestre();
        Pato silvestre = PatoSilvestre.getInstance();
        silvestre.display();
        silvestre.ejecutaQuack();
        silvestre.ejecutaVolar();
        Pato silvestre2 = PatoSilvestre.getInstance();
        
        /*Pato hule = new PatoDeHule();
        //ComportamientoVolar volarc = new VolarImpulsadoCohete();
        hule.display();
        hule.ejecutaVolar();
        hule.setComportamientoVolar(new VolarImpulsadoCohete());//volarc);
        hule.ejecutaVolar();*/
    }
}
