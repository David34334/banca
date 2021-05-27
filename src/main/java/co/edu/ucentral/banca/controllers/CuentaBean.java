package co.edu.ucentral.banca.controllers;

import co.edu.ucentral.banca.models.Cliente;
import co.edu.ucentral.banca.models.Cuenta;
import co.edu.ucentral.banca.models.EmpresaServicio;
import co.edu.ucentral.banca.models.Movimiento;
import co.edu.ucentral.banca.models.PagoServicio;
import co.edu.ucentral.banca.models.Transaccion;
import co.edu.ucentral.banca.services.ClienteService;
import co.edu.ucentral.banca.services.CuentaService;
import co.edu.ucentral.banca.services.EmpresaService;
import co.edu.ucentral.banca.services.MovimientoService;
import co.edu.ucentral.banca.services.PagoServicioService;
import co.edu.ucentral.banca.services.TransaccionService;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("cuentaBean")
@SessionScoped
public class CuentaBean implements Serializable {

    @Inject
    private CuentaService cuentaService;

    @Inject
    private ClienteService clienteService;

    @Inject
    private MovimientoService movimientoService;

    @Inject
    private TransaccionService transaccionService;
    
    @Inject
    private EmpresaService empresaService;
    
    @Inject
    private PagoServicioService pagoService;

    private Cuenta cuenta;
    private Cuenta cuentaDestino;
    private Integer valorATransferir;
    private Cliente cliente;
    private Integer idCuentaDestino;
    private List<Movimiento> movimientos;
    private List<Movimiento> movimientosCuenta;
    private Movimiento movimiento;
    private List<Transaccion> transacciones;
    private Transaccion transaccion;
    private List<EmpresaServicio> empresas;
    private EmpresaServicio empresa;
    private List<PagoServicio> servicios;
    private PagoServicio servicio;
    private Integer numeroReferencia;

    public CuentaBean() {
    }

    @PostConstruct
    public void inicializar() {
        cuenta = new Cuenta();
        cliente = new Cliente();
        cuentaDestino = new Cuenta();
        movimientos = movimientoService.listarMovimientos();
        movimiento = new Movimiento();
        transacciones = transaccionService.listarTransaccions();
        empresas = empresaService.listarEmpresaServicios();
        empresa = new EmpresaServicio();
        servicios = pagoService.listarPagoServicios();
        servicio = new PagoServicio();
        movimientosCuenta = null;
        transaccion = new Transaccion();
        valorATransferir = 0;
        idCuentaDestino = null;
    }

    public String transferirDinero(Integer idCuenta) {
        cuenta = new Cuenta();
        cuenta.setIdCuenta(idCuenta);
        cuenta = cuentaService.encontrarCuentaPorID(cuenta);
        return "pasarelaTransferencia";
    }

    public String transferirCuentaDestino(Integer idCuentaDest, Integer valorTransferir) {
        double saldo = 0;
        //Se crea el movimiento
        movimiento = new Movimiento();
        movimiento.setDescripcion("Transferencia desde " + cuenta.getIdTipoCuenta().getNombreCuenta());
        Random r = new Random();
        int n = r.nextInt(99999999 - 11111111 + 1) + 11111111;
        movimiento.setNumeroFacturacion(n);
        movimiento.setIdCuenta(cuenta);
        String valor = Integer.toString(valorTransferir);
        Double valorMovimiento = Double.parseDouble(valor);
        movimiento.setValorMovimiento(valorMovimiento);
        //Se crea la transacción a partir del movimiento
        transaccion = new Transaccion();
        //Se obtiene la fecha de la transaccion
        Date date = new Date();
        transaccion.setFecha(new SimpleDateFormat("dd-MM-yyyy").format(date));
        //Se envia el Movimiento
        transaccion.setIdMovimiento(movimiento);
        //Se envia la cuenta destino y el valor de la transferencia.
        cuentaDestino = new Cuenta();
        cuentaDestino.setIdCuenta(idCuentaDest);
        cuentaDestino = cuentaService.encontrarCuentaPorID(cuentaDestino);

        if (cuentaDestino != null) {
            //Si la cuenta existe continua la operación.
            transaccion.setNumeroCuentaDestino(cuenta.getIdCuenta());
            transaccion.setValor(valorTransferir);

            if (cuenta.getSaldo() < valorTransferir) {
                return "errorTransaccionFondos";
            } else if (valorTransferir < 1000) {
                return "errorValorTransferencia";
            }

            saldo = cuenta.getSaldo() - valorTransferir;
            cuenta.setSaldo(saldo);

            saldo = 0;

            saldo = cuentaDestino.getSaldo() + valorTransferir;
            cuentaDestino.setSaldo(saldo);

            valorATransferir = valorTransferir;
            
            this.cuentaService.actualizarCuenta(cuenta);
            this.cuentaService.actualizarCuenta(cuentaDestino);
            this.movimientoService.guardarMovimiento(movimiento);
            this.transaccionService.guardarTransaccion(transaccion);
            return "transferenciaRealizada";
        }

        return "errorCuentaDestino";
    }
    
    public String verMovimientosCuenta(Integer idCuenta) {
        cuenta = new Cuenta();
        cuenta.setIdCuenta(idCuenta);
        cuenta = cuentaService.encontrarCuentaPorID(cuenta);
        movimientosCuenta = movimientoService.encontrarMovimientoPorIDCuenta(cuenta);
        return "movimientosCuenta";
    }
    
    public String realizarPagoServicio(Integer idCuenta) {
        cuenta = new Cuenta();
        cuenta.setIdCuenta(idCuenta);
        cuenta = cuentaService.encontrarCuentaPorID(cuenta);

        return "irPagoServicio";
    }
    
    public String irPagarServicio(Integer idEmpresa) {
        empresa = new EmpresaServicio();
        empresa.setIdEmpresa(idEmpresa);
        empresa = empresaService.encontrarEmpresaServicioPorID(empresa);
        return "pasarelaPagoServicio";
    }
    
    public String reciboServicio(Integer numeroReferencia) {
        empresa = new EmpresaServicio();
        empresa.setNumeroReferencia(numeroReferencia);
        empresa = empresaService.encontrarEmpresaPorNumeroReferencia(empresa);
        
        if(empresa != null) {
            movimiento = new Movimiento();
            Random r = new Random();
            int n = r.nextInt(99999999 - 11111111 + 1) + 11111111;
            movimiento.setNumeroFacturacion(n);
            movimiento.setDescripcion("Pago de Servicio Público: " + empresa.getNombreServicio());
            movimiento.setIdCuenta(cuenta);
            movimiento.setValorMovimiento(empresa.getValor());
            
            servicio = new PagoServicio();
            servicio.setIdEmpresa(empresa);
            servicio.setIdMovimiento(movimiento);
            servicio.setNombreServicio("Servicio: " + empresa.getNombreServicio());
            Date date = new Date();
            servicio.setFecha(new SimpleDateFormat("dd-MM-yyyy").format(date));
            servicio.setNumeroReferencias(empresa.getNumeroReferencia());
            servicio.setEstadoPago(0);
            servicio.setValor(empresa.getValor());
            
            return "pagoServicio";
        }
        
        return "errorNumeroReferencia";
    }
    
    public String pagarServicio() {
        double saldoFinal;
        if(cuenta.getSaldo() >= empresa.getValor()) {
            saldoFinal = cuenta.getSaldo() - empresa.getValor();
            cuenta.setSaldo(saldoFinal);
            servicio.setEstadoPago(1);
            this.cuentaService.actualizarCuenta(cuenta);
            this.movimientoService.guardarMovimiento(movimiento);
            this.pagoService.guardarPagoServicio(servicio);
            return "reciboPagado";
        }   
        return "errorPagoServicio";
    }
    

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Integer getValorATransferir() {
        return valorATransferir;
    }

    public void setValorATransferir(Integer valorATransferir) {
        this.valorATransferir = valorATransferir;
    }

    public Integer getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(Integer idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public List<Movimiento> getMovimientosCuenta() {
        return movimientosCuenta;
    }

    public void setMovimientosCuenta(List<Movimiento> movimientosCuenta) {
        this.movimientosCuenta = movimientosCuenta;
    }

    public List<EmpresaServicio> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpresaServicio> empresas) {
        this.empresas = empresas;
    }

    public EmpresaServicio getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaServicio empresa) {
        this.empresa = empresa;
    }

    public List<PagoServicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<PagoServicio> servicios) {
        this.servicios = servicios;
    }

    public PagoServicio getServicio() {
        return servicio;
    }

    public void setServicio(PagoServicio servicio) {
        this.servicio = servicio;
    }

    public Integer getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(Integer numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

}
