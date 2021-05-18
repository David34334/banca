package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Cuenta;
import co.edu.ucentral.banca.models.Movimiento;
import java.util.List;

public interface MovimientoDAO {
    
    public List<Movimiento> findAllMovimientos();
    
    public Movimiento findMovimientoByID(Movimiento movimiento);
    
    public void insertMovimiento(Movimiento movimiento);
    
    public void updateMovimiento(Movimiento movimiento);
    
    public void deleteMovimiento(Movimiento movimiento);
    
    public List<Movimiento> findMovimientoByIDAccount(Cuenta cuenta);
    
}
