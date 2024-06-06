public abstract  class Poder {
    //atributos
    protected String tipo;
    protected Integer posicion;
    protected Integer sumaVida;
    protected Integer sumaVelocidad;
    protected Carro[] suscriptores;

    //getters y setters
    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getPosition(){
        return posicion;
    }

    public void setPosition(Integer posicion){
        this.posicion = posicion;
    }

    public int getSumaVida(){

        return sumaVida;
    }

    public void setSumaVida(Integer sumaVida){
        this.sumaVida = sumaVida;
    }

    public int getSumaVelocidad(){
        return sumaVelocidad;
    }

    public void setSumaVelocidad(Integer sumaVelocidad){
        this.sumaVelocidad = sumaVelocidad;
    }

    public Carro[] getSuscriptores(){
        return suscriptores;
    }

    public void setSuscriptores(Carro[] suscriptores){
        this.suscriptores = suscriptores;
    }

}
