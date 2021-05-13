package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.models.Cliente;
import co.edu.ucentral.banca.models.Cuenta;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CuentaService {
    
    public List<Cuenta> listarCuentas();
    
    public Cuenta encontrarCuentaPorID(Cuenta cuenta);
    
    public void guardarCuenta(Cuenta cuenta);
    
    public void actualizarCuenta(Cuenta cuenta);
    
    public void eliminarCuenta(Cuenta cuenta);
    
    public List<Cuenta> listarCuentasCliente(Cliente cliente);
    
}
