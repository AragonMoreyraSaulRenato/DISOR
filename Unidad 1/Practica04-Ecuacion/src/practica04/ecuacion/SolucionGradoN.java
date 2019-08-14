/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04.ecuacion;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author drone
 */
public class SolucionGradoN implements ModoSolucion{
    String f, fp;
    double Xo;
    
    public SolucionGradoN(double [][] _Fx, double [][] _dFx, double _x0){
        this.f = toFunction(_Fx);
        this.fp = toFunction(_dFx);
        this.Xo = _x0;
        
    }
    
    @Override
    public double[] solucion(double[] coef) {
        double c = this.busca(Xo);
        return new double[]{c,f(c,f)};
    }
    
    private String toFunction(double [][] x){
        String func = "";
        for(int i=0; i<x[0].length; i++){
            func += "+ ("+ x[0][i] + " * Math.pow(x,"+ x[1][i] +")" +")";
        }
        return func;
    }
    
    private double f(double x, String func)
    {
        Object o = null;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
              engine.eval("function myFunction(x){var output = '';"
                  + "{output = "+func+";"
                  + "  } return output;}");
              Invocable invokeEngine = (Invocable) engine;
              o = invokeEngine.invokeFunction("myFunction", x);
        } catch (NoSuchMethodException e) {
          System.err.println(e);
        } catch (ScriptException e) {
          System.err.println(e);
        }
        return (double)o;
    }
    
    private double xi(double X){
        return X-(f(X,f)/f(X,fp));
    }
    
    private double errorRelativo(double Xo,double Xop){
        return (Math.abs(Xo-Xop))/Xop;
    }
    int co = 0;
    private double busca(double Xo){
        double err =0.000001;
        do{            
            co++;
            double Xi = xi(Xo);
            double fXi = f(Xi,f);
            if(fXi ==0)
                return fXi; 
            else{
                double fpXi = f(Xi,fp);
                double Xip = xi(Xi);
                if(errorRelativo(Xi, Xip)<err)
                    return Xip;
                else 
                    Xo = Xip;
            }
        }while(true);
    }
}
