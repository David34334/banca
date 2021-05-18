package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.PagoServicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PagoServicioDAOImpl implements PagoServicioDAO {
    
    @PersistenceContext(unitName = "BancoUP")
    EntityManager manager;

    @Override
    public List<PagoServicio> findAllPagoServicios() {
        return manager.createNamedQuery("PagoServicio.findAll").getResultList();
    }

    @Override
    public PagoServicio findPagoServicioByID(PagoServicio pagoServicio) {
        return manager.find(PagoServicio.class, pagoServicio.getFacturaServicio());
    }

    @Override
    public void insertPagoServicio(PagoServicio pagoServicio) {
        manager.persist(pagoServicio);
    }

    @Override
    public void updatePagoServicio(PagoServicio pagoServicio) {
        manager.merge(pagoServicio);
    }

    @Override
    public void deletePagoServicio(PagoServicio pagoServicio) {
        manager.remove(manager.merge(pagoServicio));
    }

}
