public abstract class Carro {
    //atributos
    protected Float distancia;
    protected Float velocidad;
    protected Float posicion;
    protected Integer seccion;
    protected Integer posx;
    protected Float curvatura;
    protected Integer vida;
    protected String color;

    //metodos
    public abstract void acelerar();
    public abstract void frenar();
    public abstract void disparar();
    public abstract void actualizar();


    public Carro(){
        this.vida = 3;
        this.velocidad = 0.0f;
        this.color = "rojo";
    }

    public void recibirDisparo(){
        //if de que si la bala esta en la posicion del carro 
        //entonces vida -1 
    }
    public void pasarHueco(){
        //if si esta en el rango del hueco una vida menos y velocidad=0
    }

    //getters y setters
    public Integer getVida(){
        return vida;
    }
    public void setVida(Integer vida){
        if (vida >= 0){
            this.vida = vida;
        }
    }
    public float getVelocidad(){

        return velocidad;
    }
    public void setVelocidad(Float velocidad){

        if(velocidad >= 0){
            this.velocidad = velocidad;
        }
        
    }
    public String getColor(){

        return color;
    }
    public void setColor(String color){

        this.color = color;
    }
    
}



