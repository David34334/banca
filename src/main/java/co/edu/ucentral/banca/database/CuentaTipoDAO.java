package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.CuentaTipo;
import java.util.List;

public interface CuentaTipoDAO {
    
    public List<CuentaTipo> findAllCuentaTipos();
    
    public CuentaTipo findCuentaTipoByID(CuentaTipo cuentaTipo);
    
    public void insertCuentaTipo(CuentaTipo cuentaTipo);
    
    public void updateCuentaTipo(CuentaTipo cuentaTipo);
    
    public void deleteCuentaTipo(CuentaTipo cuentaTipo);
    
}
