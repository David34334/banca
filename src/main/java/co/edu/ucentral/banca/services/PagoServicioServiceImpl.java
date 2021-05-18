package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.database.PagoServicioDAO;
import co.edu.ucentral.banca.models.PagoServicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PagoServicioServiceImpl implements PagoServicioService {
    
    @Inject
    private PagoServicioDAO pagoDAO;

    @Override
    public List<PagoServicio> listarPagoServicios() {
        return pagoDAO.findAllPagoServicios();
    }

    @Override
    public PagoServicio encontrarPagoServicioPorID(PagoServicio pagoServicio) {
        return pagoDAO.findPagoServicioByID(pagoServicio);
    }

    @Override
    public void guardarPagoServicio(PagoServicio pagoServicio) {
        pagoDAO.insertPagoServicio(pagoServicio);
    }

    @Override
    public void actualizarPagoServicio(PagoServicio pagoServicio) {
        pagoDAO.updatePagoServicio(pagoServicio);
    }

    @Override
    public void eliminarPagoServicio(PagoServicio pagoServicio) {
        pagoDAO.deletePagoServicio(pagoServicio);
    }

}