public class PoderVida extends Poder{
    //constructor
    public PoderVida(String tipo,Integer posicion,Integer sumaVida){
        
        this.tipo = tipo;
        this.posicion = posicion;
        this.sumaVida = sumaVida;
    }
    @Override
    public void onDestroy(){
        //logica para quitar el poder vida
    }

}

