package practica04.pojos;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.Math;
import java.util.Scanner;
public class NewtonRaphson
{
    String f, fp;
    
    public NewtonRaphson(){
    }
    public NewtonRaphson(String f, String fp){
        this.f = f;
        this.fp = fp;
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
    
    public String toString(double x){
        double c = busca(x);
        return "Iteraciones: "+co+ "\nEncontrado\nX: "+c+"\t\t"+"F(x): "+f(c,f);
    }
    
    public void main(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("                      NEWTON-RAPSON");
        System.out.println("-------------------------------------------------------------");
        Scanner lee = new Scanner(System.in);
        System.out.println("Ingresa F(x)");
        String fx = lee.nextLine();
        System.out.println("Ingresa F'(x)");
        String fxp = lee.nextLine();
        System.out.println("Ingresa Xo");
        double x = Double.parseDouble(lee.nextLine());
        NewtonRaphson n = new NewtonRaphson(fx,fxp);
        System.out.println("\n\n-------------------------------------------------------------");
        System.out.println(n.toString(x));
        System.out.println("-------------------------------------------------------------\n\n");
        System.out.println("ENTER PARA CONTINUAR");
        String enter = lee.nextLine();
    }
}
