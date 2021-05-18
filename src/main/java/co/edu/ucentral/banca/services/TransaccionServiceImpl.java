package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.database.TransaccionDAO;
import co.edu.ucentral.banca.models.Transaccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TransaccionServiceImpl implements TransaccionService {
    
    @Inject
    private TransaccionDAO transaDAO;

    @Override
    public List<Transaccion> listarTransaccions() {
        return transaDAO.findAllTransaccions();
    }

    @Override
    public Transaccion encontrarTransaccionPorID(Transaccion transaccion) {
        return transaDAO.findTransaccionByID(transaccion);
    }

    @Override
    public void guardarTransaccion(Transaccion transaccion) {
        transaDAO.insertTransaccion(transaccion);
    }

    @Override
    public void actualizarTransaccion(Transaccion transaccion) {
        transaDAO.updateTransaccion(transaccion);
    }

    @Override
    public void eliminarTransaccion(Transaccion transaccion) {
        transaDAO.deleteTransaccion(transaccion);
    }

}