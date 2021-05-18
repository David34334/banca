package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Transaccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TransaccionDAOImpl implements TransaccionDAO {
    
    @PersistenceContext(unitName = "BancoUP")
    EntityManager manager;

    @Override
    public List<Transaccion> findAllTransaccions() {
        return manager.createNamedQuery("Transaccion.findAll").getResultList();
    }

    @Override
    public Transaccion findTransaccionByID(Transaccion transaccion) {
        return manager.find(Transaccion.class, transaccion.getIdTransaccion());
    }

    @Override
    public void insertTransaccion(Transaccion transaccion) {
        manager.persist(transaccion);
    }

    @Override
    public void updateTransaccion(Transaccion transaccion) {
        manager.merge(transaccion);
    }

    @Override
    public void deleteTransaccion(Transaccion transaccion) {
        manager.remove(manager.merge(transaccion));
    }
    
}