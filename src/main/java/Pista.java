import java.util.ArrayList;

public class Pista {

    private Integer numSecciones;
    private Float[] largoSeccion;
    private Float[] curvaSeccion;
    public ArrayList<Carro> carros;
    private ArrayList<Poder> poderes;
    private static PolePositionFactory factory;
   
    //Constructor
    public Pista(Integer numSecciones){
        this.numSecciones = numSecciones;
        this.largoSeccion = new Float[numSecciones];
        this.curvaSeccion = new Float[numSecciones];
    }

    //Setters y getters
    public void addLargo(Float largo, Integer seccion){
        this.largoSeccion[seccion] = largo;
    }

    public void addCurva(Float curva, Integer seccion){
        this.curvaSeccion[seccion] = curva;
    }

    public Float[] getLargos(){
        return this.largoSeccion;
    }

    public Float[] getCurvas(){
        return this.curvaSeccion;
    }

    public Integer getNumSecciones(){
        return this.numSecciones;
    }

    public synchronized void agregaCarro(String color){
        factory = new CarroFactory();
        this.carros.add(factory.crearCarro(color));
    }

    public void colocarHueco(){}
    public void colocarTurbo(){}
    public void crear_auto(){}
    public void actualizarPosiciones(){}

}
