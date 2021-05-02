package co.edu.ucentral.banca.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "pago_servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PagoServicio.findAll", query = "SELECT p FROM PagoServicio p"),
    @NamedQuery(name = "PagoServicio.findByFacturaServicio", query = "SELECT p FROM PagoServicio p WHERE p.facturaServicio = :facturaServicio"),
    @NamedQuery(name = "PagoServicio.findByNombreServicio", query = "SELECT p FROM PagoServicio p WHERE p.nombreServicio = :nombreServicio"),
    @NamedQuery(name = "PagoServicio.findByNumeroReferencias", query = "SELECT p FROM PagoServicio p WHERE p.numeroReferencias = :numeroReferencias"),
    @NamedQuery(name = "PagoServicio.findByValor", query = "SELECT p FROM PagoServicio p WHERE p.valor = :valor"),
    @NamedQuery(name = "PagoServicio.findByEstadoPago", query = "SELECT p FROM PagoServicio p WHERE p.estadoPago = :estadoPago"),
    @NamedQuery(name = "PagoServicio.findByFecha", query = "SELECT p FROM PagoServicio p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PagoServicio.findByIdMovimiento", query = "SELECT p FROM PagoServicio p WHERE p.idMovimiento = :idMovimiento"),
    @NamedQuery(name = "PagoServicio.findByIdEmpresa", query = "SELECT p FROM PagoServicio p WHERE p.idEmpresa = :idEmpresa")})
public class PagoServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "factura_servicio")
    private Integer facturaServicio;
    @Size(max = 30)
    @Column(name = "nombre_servicio")
    private String nombreServicio;
    @Column(name = "numero_referencias")
    private Integer numeroReferencias;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "estado_pago")
    private Integer estadoPago;
    @Size(max = 20)
    @Column(name = "fecha")
    private String fecha;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_movimiento")
    private Movimiento idMovimiento;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_Empresa")
    private EmpresaServicio idEmpresa;

    public PagoServicio() {
    }

    public PagoServicio(Integer facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    public Integer getFacturaServicio() {
        return facturaServicio;
    }

    public void setFacturaServicio(Integer facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Integer getNumeroReferencias() {
        return numeroReferencias;
    }

    public void setNumeroReferencias(Integer numeroReferencias) {
        this.numeroReferencias = numeroReferencias;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Integer estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Movimiento getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Movimiento idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public EmpresaServicio getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaServicio idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaServicio != null ? facturaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoServicio)) {
            return false;
        }
        PagoServicio other = (PagoServicio) object;
        if ((this.facturaServicio == null && other.facturaServicio != null) || (this.facturaServicio != null && !this.facturaServicio.equals(other.facturaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.banca.models.PagoServicio[ facturaServicio=" + facturaServicio + " ]";
    }
    
}
