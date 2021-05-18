package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.EmpresaServicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmpresaDAOImpl implements EmpresaDAO {
    
    @PersistenceContext(unitName = "BancoUP")
    EntityManager manager;

    @Override
    public List<EmpresaServicio> findAllEmpresaServicios() {
        return manager.createNamedQuery("EmpresaServicio.findAll").getResultList();
    }

    @Override
    public EmpresaServicio findEmpresaServicioByID(EmpresaServicio empresaServicio) {
        return manager.find(EmpresaServicio.class, empresaServicio.getIdEmpresa());
    }

    @Override
    public void insertEmpresaServicio(EmpresaServicio empresaServicio) {
        manager.persist(empresaServicio);
    }

    @Override
    public void updateEmpresaServicio(EmpresaServicio empresaServicio) {
        manager.merge(empresaServicio);
    }

    @Override
    public void deleteEmpresaServicio(EmpresaServicio empresaServicio) {
        manager.remove(manager.merge(empresaServicio));
    }

}
