public class PoderFactory extends PolePositionFactory{
    /**
     * Crea un poder segun lo necesitado
     */
    @Override
    public Poder crearPoder(){
        Boolean logica;
        Poder poder;
        logica=true;

        if(logica){
            poder = new PoderVida(null, 0, 0);
        } else {
            poder = new PoderVelocidad(null, 0, 0);
        }
        return poder;
    }
}

