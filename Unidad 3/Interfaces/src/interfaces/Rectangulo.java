package interfaces;

public class Rectangulo {
    private double base = 100, altura = 50;
    public Rectangulo(){}

    public void setBase(double base) {
        this.base = base;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }
    
    public double getBase() {
        return base;
    }
    
    public double getArea(){
        return base*altura;
    }
    
    public double getPerimetro(){
        return base+base+altura+altura;
    }
    
    public void cuadrar(){
        altura = base;
    }
}
