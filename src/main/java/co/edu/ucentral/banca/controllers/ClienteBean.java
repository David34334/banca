package co.edu.ucentral.banca.controllers;

import co.edu.ucentral.banca.models.Cliente;
import co.edu.ucentral.banca.services.ClienteService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("clienBean")
@RequestScoped
public class ClienteBean {
    
    @Inject
    private ClienteService clienteService;
    
    private List<Cliente> clientes;
    private Cliente cliente;
    private Cliente clienteSesion;
    
    public ClienteBean() {
        
    }
    @PostConstruct
    public void inicializar() {
        clientes = clienteService.listarClientes();
        cliente = new Cliente();
        clienteSesion = new Cliente();
    }
    
    public String guardarCliente() {
        this.clienteService.guardarCliente(cliente);
        clientes = this.clienteService.listarClientes();
        cliente = null;
        return "listadoClientes";
    }
    
    public String iniciarSesion(String nombreUsuario, String clave) {
        cliente = new Cliente();
        cliente.setNombreUsuario(nombreUsuario);
        cliente.setClave(clave);
        
        try {
            clienteSesion = clienteService.iniciarSesion(cliente);
            
            if (clienteSesion != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("cliente", clienteSesion);
                return "inicioBanca";
            } else {
                return "iniciarSesion";
            }
        } catch (Exception e) {
        }
        return "iniciarSesion";
    }
    
    public boolean verificarSesion() {
        boolean flag = true;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente") == null) {
            flag = false;
        }
        return flag;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSesion() {
        return clienteSesion;
    }

    public void setClienteSesion(Cliente clienteSesion) {
        this.clienteSesion = clienteSesion;
    }

}
