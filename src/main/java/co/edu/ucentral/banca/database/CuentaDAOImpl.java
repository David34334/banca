package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Cliente;
import co.edu.ucentral.banca.models.Cuenta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CuentaDAOImpl implements CuentaDAO {

    @PersistenceContext(unitName = "BancoUP")
    EntityManager manager;

    @Override
    public List<Cuenta> findAllCuentas() {
        return manager.createNamedQuery("Cuenta.findAll").getResultList();
    }

    @Override
    public Cuenta findCuentaByID(Cuenta cuenta) {
        return manager.find(Cuenta.class, cuenta.getIdCuenta());
    }

    @Override
    public void insertCuenta(Cuenta cuenta) {
        manager.persist(cuenta);
    }

    @Override
    public void updateCuenta(Cuenta cuenta) {
        manager.merge(cuenta);
    }

    @Override
    public void deleteCuenta(Cuenta cuenta) {
        manager.remove(manager.merge(cuenta));
    }

    @Override
    public List<Cuenta> findCuentaByIDClient(Cliente cliente) {
        TypedQuery<Cuenta> cuentaCliente = manager.createNamedQuery("Cuenta.findByIdCliente", Cuenta.class);
        cuentaCliente.setParameter("idCliente", cliente);
        List<Cuenta> cuenta = cuentaCliente.getResultList();
        
        if(cuenta != null) {
            return cuenta;
        }
        return null;
    }
    
}