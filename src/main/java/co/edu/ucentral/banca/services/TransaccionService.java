package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.models.Transaccion;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TransaccionService {
    
    public List<Transaccion> listarTransaccions();
    
    public Transaccion encontrarTransaccionPorID(Transaccion transaccion);
    
    public void guardarTransaccion(Transaccion transaccion);
    
    public void actualizarTransaccion(Transaccion transaccion);
    
    public void eliminarTransaccion(Transaccion transaccion);
    
}
