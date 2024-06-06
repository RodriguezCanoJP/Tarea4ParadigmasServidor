import java.util.ArrayList;

public class CarroFactory extends PolePositionFactory{
    private ArrayList<String> colores = new ArrayList<String>(){{add("rojo");add("morado");add("azul");add("blanco");}};

    /**
     * 
     * @param String color
     * @return un carro con el color seleccionado si esta disponible 
     */
    @Override
    public Carro crearCarro(String color){
        if(colores.contains(color) ){
            colores.remove(color);
            return new CarroJugador(0.0f,color);
        }else{
            return new CarroJugador(0.0f,colores.get(0));
        }
    }

}

