package proyecto.clinica_dental_calderon.controlador_Metodos_Pago;

/**
 *
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Metodos_Pago {
    private int id;
    private String nombre_metodo;

    public Metodos_Pago() {
    }
    
    public Metodos_Pago(int id, String nombre_metodo) {
        this.id = id;
        this.nombre_metodo = nombre_metodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_metodo() {
        return nombre_metodo;
    }

    public void setNombre_metodo(String nombre_metodo) {
        this.nombre_metodo = nombre_metodo;
    }
}
