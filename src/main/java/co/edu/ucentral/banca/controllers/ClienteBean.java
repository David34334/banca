package co.edu.ucentral.banca.controllers;

import co.edu.ucentral.banca.models.Cliente;
import co.edu.ucentral.banca.models.Cuenta;
import co.edu.ucentral.banca.models.CuentaTipo;
import co.edu.ucentral.banca.services.ClienteService;
import co.edu.ucentral.banca.services.CuentaService;
import co.edu.ucentral.banca.services.CuentaTipoService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("clienBean")
@SessionScoped
public class ClienteBean implements Serializable {
    
    @Inject
    private ClienteService clienteService;
    
    @Inject
    private CuentaService cuentaService;
    
    @Inject
    private CuentaTipoService cuentaTipoService;
    
    private List<Cliente> clientes;
    private Cliente cliente;
    private List<Cuenta> cuentas;
    private List<Cuenta> cuentasCliente;
    private Cuenta cuenta;
    private CuentaTipo cuentaTipo;
    private Cliente clienteSesion;
    
    public ClienteBean() {
        
    }
    @PostConstruct
    public void inicializar() {
        clientes = clienteService.listarClientes();
        cliente = new Cliente();
        clienteSesion = new Cliente();
        
        cuentas = cuentaService.listarCuentas();
        cuenta = new Cuenta();
        
        cuentaTipo = new CuentaTipo();
        
        cuentasCliente = null;
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
    
    //SECCIÓN DE CUENTA AHORROS / CORRIENTE
    public String crearCuentaAhorros() {
        //Se trae el objeto tipoCuenta que corresponde a Cuenta de Ahorros (ID = 1)
        cuentaTipo = new CuentaTipo();
        //Le colocamos manualmente el ID 1 para que después traiga todo el objeto completo a partir de ese ID
        cuentaTipo.setIdCuentaTipo(1);
        cuentaTipo = cuentaTipoService.encontrarCuentaTipoPorID(cuentaTipo);
        //Se crea la cuenta
        cuenta = new Cuenta();
        
        cliente = new Cliente();
        cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        
        cuenta.setIdCliente(cliente);
        //El 1 indica que la cuenta está activa, en caso contrario sería 0.
        cuenta.setEstadoCuenta(1);
        cuenta.setIdTipoCuenta(cuentaTipo);
        //Por default el saldo es 0.
        cuenta.setSaldo(0);
        this.cuentaService.guardarCuenta(cuenta);
        
        return "productosBanca";
    }
    
    public String crearCuentaCorriente() {
        //Se trae el objeto tipoCuenta que corresponde a Cuenta Corriente (ID = 2)
        cuentaTipo = new CuentaTipo();
        //Le colocamos manualmente el ID 2 para que después traiga todo el objeto completo a partir de ese ID
        cuentaTipo.setIdCuentaTipo(2);
        cuentaTipo = cuentaTipoService.encontrarCuentaTipoPorID(cuentaTipo);
        //Se crea la cuenta
        cuenta = new Cuenta();
        
        cliente = new Cliente();
        cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        
        cuenta.setIdCliente(cliente);
        //El 1 indica que la cuenta está activa, en caso contrario sería 0.
        cuenta.setEstadoCuenta(1);
        cuenta.setIdTipoCuenta(cuentaTipo);
        //Por default el saldo es 0.
        cuenta.setSaldo(0);
        this.cuentaService.guardarCuenta(cuenta);
        
        return "productosBanca";
    }
    
    public boolean verificarCuentaCliente() {
        boolean flag = false;
        cuenta = new Cuenta();
        cliente = new Cliente();
        cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cliente");
        cuentasCliente = cuentaService.listarCuentasCliente(cliente);
        if(cuentasCliente.size() > 0) {
            flag = true;
        }
        return flag;
    }
    
    public String verInfoCuenta(Integer idCuenta) {
        cuenta = new Cuenta();
        cuenta.setIdCuenta(idCuenta);
        cuenta = cuentaService.encontrarCuentaPorID(cuenta);
        return "infoCuenta";
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

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaTipo getCuentaTipo() {
        return cuentaTipo;
    }

    public void setCuentaTipo(CuentaTipo cuentaTipo) {
        this.cuentaTipo = cuentaTipo;
    }

    public List<Cuenta> getCuentasCliente() {
        return cuentasCliente;
    }

    public void setCuentasCliente(List<Cuenta> cuentasCliente) {
        this.cuentasCliente = cuentasCliente;
    }

}
