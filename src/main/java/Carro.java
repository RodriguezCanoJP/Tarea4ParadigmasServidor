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

    //Constructor
    public Carro(){
        this.vida = 3;
        this.velocidad = 0.0f;
        this.color = "rojo";
    }

    //metodos 
    public void acelerar(){};
    public void frenar(){};
    public void disparar(){};
    public void actualizar(){};

    //getters y setters
    public Integer getVida(){
        return vida;
    }
    public void setVida(Integer vida){
        if (vida >= 0){
            this.vida = vida;
        }
    }
    public Float  getVelocidad(){

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



