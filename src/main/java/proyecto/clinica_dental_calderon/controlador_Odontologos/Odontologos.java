
package proyecto.clinica_dental_calderon.controlador_Odontologos;

/**
 *
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Odontologos {
    private int id;
    private String nombre_odontologo;

    public Odontologos() {
    }
    
    public Odontologos(int id, String nombre_odontologo) {
        this.id = id;
        this.nombre_odontologo = nombre_odontologo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_odontologo() {
        return nombre_odontologo;
    }

    public void setNombre_odontologo(String nombre_odontologo) {
        this.nombre_odontologo = nombre_odontologo;
    }
    
}
