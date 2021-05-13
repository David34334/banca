package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.CuentaTipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CuentaTipoDAOImpl implements CuentaTipoDAO {
    
    @PersistenceContext(unitName = "BancoUP")
    EntityManager manager;

    @Override
    public List<CuentaTipo> findAllCuentaTipos() {
        return manager.createNamedQuery("CuentaTipo.findAll").getResultList();
    }

    @Override
    public CuentaTipo findCuentaTipoByID(CuentaTipo cuentaTipo) {
        return manager.find(CuentaTipo.class, cuentaTipo.getIdCuentaTipo());
    }

    @Override
    public void insertCuentaTipo(CuentaTipo cuentaTipo) {
        manager.persist(cuentaTipo);
    }

    @Override
    public void updateCuentaTipo(CuentaTipo cuentaTipo) {
        manager.merge(cuentaTipo);
    }

    @Override
    public void deleteCuentaTipo(CuentaTipo cuentaTipo) {
        manager.remove(manager.merge(cuentaTipo));
    }
 
}