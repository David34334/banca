package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.database.CuentaTipoDAO;
import co.edu.ucentral.banca.models.CuentaTipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CuentaTipoServiceImpl implements CuentaTipoService {
    
    @Inject
    private CuentaTipoDAO cuentaTDAO;

    @Override
    public List<CuentaTipo> listarCuentaTipos() {
        return cuentaTDAO.findAllCuentaTipos();
    }

    @Override
    public CuentaTipo encontrarCuentaTipoPorID(CuentaTipo cuentaTipo) {
        return cuentaTDAO.findCuentaTipoByID(cuentaTipo);
    }

    @Override
    public void guardarCuentaTipo(CuentaTipo cuentaTipo) {
        cuentaTDAO.insertCuentaTipo(cuentaTipo);
    }

    @Override
    public void actualizarCuentaTipo(CuentaTipo cuentaTipo) {
        cuentaTDAO.updateCuentaTipo(cuentaTipo);
    }

    @Override
    public void eliminarCuentaTipo(CuentaTipo cuentaTipo) {
        cuentaTDAO.deleteCuentaTipo(cuentaTipo);
    }
 
}
