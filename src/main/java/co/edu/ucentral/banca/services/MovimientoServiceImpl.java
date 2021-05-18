package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.database.MovimientoDAO;
import co.edu.ucentral.banca.models.Cuenta;
import co.edu.ucentral.banca.models.Movimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MovimientoServiceImpl implements MovimientoService {
    
    @Inject
    private MovimientoDAO movimientoDAO;

    @Override
    public List<Movimiento> listarMovimientos() {
        return movimientoDAO.findAllMovimientos();
    }

    @Override
    public Movimiento encontrarMovimientoPorID(Movimiento movimiento) {
        return movimientoDAO.findMovimientoByID(movimiento);
    }

    @Override
    public void guardarMovimiento(Movimiento movimiento) {
        movimientoDAO.insertMovimiento(movimiento);
    }

    @Override
    public void actualizarMovimiento(Movimiento movimiento) {
        movimientoDAO.updateMovimiento(movimiento);
    }

    @Override
    public void eliminarMovimiento(Movimiento movimiento) {
        movimientoDAO.deleteMovimiento(movimiento);
    }

    @Override
    public List<Movimiento> encontrarMovimientoPorIDCuenta(Cuenta cuenta) {
        return movimientoDAO.findMovimientoByIDAccount(cuenta);
    }

}