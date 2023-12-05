
package proyecto.clinica_dental_calderon.controlador_Tratamiento;

/**
 *
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Tratamientos {
    private int id;
    private String nombre_tratamiento;

    public Tratamientos() {
    }
    
    public Tratamientos(int id, String nombre_tratamiento) {
        this.id = id;
        this.nombre_tratamiento = nombre_tratamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_tratamiento() {
        return nombre_tratamiento;
    }

    public void setNombre_tratamiento(String nombre_tratamiento) {
        this.nombre_tratamiento = nombre_tratamiento;
    }
}
