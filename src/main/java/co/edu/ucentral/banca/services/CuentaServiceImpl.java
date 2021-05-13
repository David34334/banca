package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.database.CuentaDAO;
import co.edu.ucentral.banca.models.Cliente;
import co.edu.ucentral.banca.models.Cuenta;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CuentaServiceImpl implements CuentaService {
    
    @Inject
    private CuentaDAO cuentaDAO;

    @Override
    public List<Cuenta> listarCuentas() {
        return cuentaDAO.findAllCuentas();
    }

    @Override
    public Cuenta encontrarCuentaPorID(Cuenta cuenta) {
        return cuentaDAO.findCuentaByID(cuenta);
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        cuentaDAO.insertCuenta(cuenta);
    }

    @Override
    public void actualizarCuenta(Cuenta cuenta) {
        cuentaDAO.updateCuenta(cuenta);
    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
        cuentaDAO.deleteCuenta(cuenta);
    }

    @Override
    public List<Cuenta> listarCuentasCliente(Cliente cliente) {
        return cuentaDAO.findCuentaByIDClient(cliente);
    }

}