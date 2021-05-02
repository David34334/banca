package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Cliente;
import java.util.List;

public interface ClienteDAO {
    
    public List<Cliente> findAllClientes();
    
    public Cliente findClienteByID(Cliente cliente);
    
    public void insertCliente(Cliente cliente);
    
    public void updateCliente(Cliente cliente);
    
    public void deleteCliente(Cliente cliente);
    
    public Cliente logIn(Cliente cliente);
    
}
