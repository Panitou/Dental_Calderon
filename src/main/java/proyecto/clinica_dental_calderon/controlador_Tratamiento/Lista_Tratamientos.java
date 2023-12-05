

package proyecto.clinica_dental_calderon.controlador_Tratamiento;

import java.util.ArrayList;

/**
 *
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Lista_Tratamientos {
    ArrayList<Tratamientos>lista;
    
    public Lista_Tratamientos(){
        lista=new ArrayList();
    }
    
    public void AgregarTratamiento (Tratamientos t){
        lista.add(t);
    }
}
