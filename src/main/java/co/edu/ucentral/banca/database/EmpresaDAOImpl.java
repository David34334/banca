package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.EmpresaServicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    @Override
    public EmpresaServicio findEmpresaServicioByReferenceNumber(EmpresaServicio empresaServicio) {

        try {
            TypedQuery<EmpresaServicio> empresa = manager.createNamedQuery("EmpresaServicio.findByNumeroReferencia", EmpresaServicio.class);
            empresa.setParameter("numeroReferencia", empresaServicio.getNumeroReferencia());
            EmpresaServicio result = empresa.getSingleResult();

            if (result != null) {
                return result;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

}
