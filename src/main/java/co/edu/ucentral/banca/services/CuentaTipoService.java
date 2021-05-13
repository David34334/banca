package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.models.CuentaTipo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CuentaTipoService {
    
    public List<CuentaTipo> listarCuentaTipos();
    
    public CuentaTipo encontrarCuentaTipoPorID(CuentaTipo cuentaTipo);
    
    public void guardarCuentaTipo(CuentaTipo cuentaTipo);
    
    public void actualizarCuentaTipo(CuentaTipo cuentaTipo);
    
    public void eliminarCuentaTipo(CuentaTipo cuentaTipo);
    
}
