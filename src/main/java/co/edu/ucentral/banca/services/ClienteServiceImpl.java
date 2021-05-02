package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.database.ClienteDAO;
import co.edu.ucentral.banca.models.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ClienteServiceImpl implements ClienteService {
    
    @Inject
    private ClienteDAO clienteDAO;

    @Override
    public List<Cliente> listarClientes() {
        return clienteDAO.findAllClientes();
    }

    @Override
    public Cliente encontrarClientePorID(Cliente cliente) {
        return clienteDAO.findClienteByID(cliente);
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDAO.insertCliente(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        clienteDAO.updateCliente(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteDAO.deleteCliente(cliente);
    }

    @Override
    public Cliente iniciarSesion(Cliente cliente) {
        return clienteDAO.logIn(cliente);
    }

}
