/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerexamen;

/**
 *
 * @author drone
 */
public class DisplayGasolina implements Observador, Displayelemento{
    //private float litrosg, litrosa;
    float litros, litrosold;
    public DisplayGasolina(Automovil auto){
        litros = auto.getLitros();
        litrosold = litros;
        auto.registartObservador(this);
    }

    @Override
    public void actualizar(float litrosg, float rendimiento, float cuentakm) {
            litros = litros - (cuentakm / rendimiento);
            double porcen = (litros * 100) / litrosold;
            //System.out.println("Porcentaje  "+porcen);
            if(porcen < 10) display();
    }

    @Override
    public void display() {
        System.out.println("Carga Gasolina!!");
    }
    
}
