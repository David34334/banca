package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Transaccion;
import java.util.List;

public interface TransaccionDAO {
    
    public List<Transaccion> findAllTransaccions();
    
    public Transaccion findTransaccionByID(Transaccion transaccion);
    
    public void insertTransaccion(Transaccion transaccion);
    
    public void updateTransaccion(Transaccion transaccion);
    
    public void deleteTransaccion(Transaccion transaccion);
    
}
