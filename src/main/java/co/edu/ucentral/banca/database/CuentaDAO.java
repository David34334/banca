package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Cliente;
import co.edu.ucentral.banca.models.Cuenta;
import java.util.List;

public interface CuentaDAO {
    
    public List<Cuenta> findAllCuentas();
    
    public Cuenta findCuentaByID(Cuenta cuenta);
    
    public void insertCuenta(Cuenta cuenta);
    
    public void updateCuenta(Cuenta cuenta);
    
    public void deleteCuenta(Cuenta cuenta);
    
    public List<Cuenta> findCuentaByIDClient(Cliente cliente);
    
}
