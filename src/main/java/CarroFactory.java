import java.util.ArrayList;

public class CarroFactory extends PolePositionFactory{
    private ArrayList<String> colores = new ArrayList<String>(){{add("rojo");add("morado");add("azul");add("blanco");}};

    @Override
    public Carro crearCarro(String color){
        if(colores.contains(color) ){
            colores.remove(color);
            return new CarroJugador(0,color);
        }else{
            return new CarroJugador(0,colores.get(0));
        }
    }

}

