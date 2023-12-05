package proyecto.clinica_dental_calderon.controlador_Metodos_Pago;

import java.util.ArrayList;
/**
 *
 * @author Panito
 * GitHub https://github.com/Panitou
 */
public class Lista_Metodos_Pago {

    ArrayList<Metodos_Pago> lista;
    
    public Lista_Metodos_Pago(){
        lista = new ArrayList();
    }
    
    public void Agregar_Metodos_Pago(Metodos_Pago mp){
        lista.add(mp);
    }
}
