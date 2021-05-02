package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.models.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteService {
    
    public List<Cliente> listarClientes();
    
    public Cliente encontrarClientePorID(Cliente cliente);
    
    public void guardarCliente(Cliente cliente);
    
    public void actualizarCliente(Cliente cliente);
    
    public void eliminarCliente(Cliente cliente);
    
    public Cliente iniciarSesion(Cliente cliente);
    
}
