
package proyecto.clinica_dental_calderon.controlador_Odontologos;

import java.util.ArrayList;

/**
 *
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Lista_Odontologos {
    ArrayList<Odontologos>lista;
    
    public Lista_Odontologos(){
        lista = new ArrayList();
    }
    
    public void Agregar_Odontologos(Odontologos o){
        lista.add(o);
    }
}
