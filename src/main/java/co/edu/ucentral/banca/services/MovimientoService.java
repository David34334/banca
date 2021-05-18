package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.models.Cuenta;
import co.edu.ucentral.banca.models.Movimiento;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MovimientoService {
    
    public List<Movimiento> listarMovimientos();
    
    public Movimiento encontrarMovimientoPorID(Movimiento movimiento);
    
    public void guardarMovimiento(Movimiento movimiento);
    
    public void actualizarMovimiento(Movimiento movimiento);
    
    public void eliminarMovimiento(Movimiento movimiento);
    
    public List<Movimiento> encontrarMovimientoPorIDCuenta(Cuenta cuenta);
    
}
