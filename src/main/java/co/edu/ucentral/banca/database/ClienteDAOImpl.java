package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ClienteDAOImpl implements ClienteDAO {
    
    @PersistenceContext(unitName = "BancoUP")
    EntityManager manager;

    @Override
    public List<Cliente> findAllClientes() {
        return manager.createNamedQuery("Cliente.findAll").getResultList();
    }

    @Override
    public Cliente findClienteByID(Cliente cliente) {
        return manager.find(Cliente.class, cliente.getId());
    }

    @Override
    public void insertCliente(Cliente cliente) {
        manager.persist(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        manager.merge(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        manager.remove(manager.merge(cliente));
    }

    @Override
    public Cliente logIn(Cliente cliente) {
        TypedQuery<Cliente> nombreUsuario = manager.createNamedQuery("Cliente.findByNombreUsuario", Cliente.class);
        nombreUsuario.setParameter("nombreUsuario", cliente.getNombreUsuario());
        Cliente verificar = nombreUsuario.getSingleResult();
        
        if (verificar != null) {
            if(verificar.getClave().equals(cliente.getClave())) {
                return verificar;
            }
        }
        
        return null;   
    }
    
}
