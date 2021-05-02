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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuenta.findBySaldo", query = "SELECT c FROM Cuenta c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "Cuenta.findByEstadoCuenta", query = "SELECT c FROM Cuenta c WHERE c.estadoCuenta = :estadoCuenta"),
    @NamedQuery(name = "Cuenta.findByIdCliente", query = "SELECT c FROM Cuenta c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cuenta.findByIdTipoCuenta", query = "SELECT c FROM Cuenta c WHERE c.idTipoCuenta = :idTipoCuenta")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Cuenta")
    private Integer idCuenta;
    @Column(name = "saldo")
    private Integer saldo;
    @Column(name = "estado_cuenta")
    private Integer estadoCuenta;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_Cliente")
    private Cliente idCliente;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_TipoCuenta")
    private CuentaTipo idTipoCuenta;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(Integer estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public CuentaTipo getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(CuentaTipo idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.banca.models.Cuenta[ idCuenta=" + idCuenta + " ]";
    }
    
}
