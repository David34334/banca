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

@Entity
@Table(name = "movimientos")
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByIdMovimientos", query = "SELECT m FROM Movimiento m WHERE m.idMovimientos = :idMovimientos"),
    @NamedQuery(name = "Movimiento.findByNumeroFacturacion", query = "SELECT m FROM Movimiento m WHERE m.numeroFacturacion = :numeroFacturacion"),
    @NamedQuery(name = "Movimiento.findByDescripcion", query = "SELECT m FROM Movimiento m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Movimiento.findByIdCuenta", query = "SELECT m FROM Movimiento m WHERE m.idCuenta = :idCuenta")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Movimientos")
    private Integer idMovimientos;
    @Column(name = "numero_facturacion")
    private Integer numeroFacturacion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor_Movimiento")
    private Double valorMovimiento;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_Cuenta")
    private Cuenta idCuenta;

    public Movimiento() {
    }

    public Movimiento(Integer idMovimientos) {
        this.idMovimientos = idMovimientos;
    }

    public Integer getIdMovimientos() {
        return idMovimientos;
    }

    public void setIdMovimientos(Integer idMovimientos) {
        this.idMovimientos = idMovimientos;
    }

    public Integer getNumeroFacturacion() {
        return numeroFacturacion;
    }

    public void setNumeroFacturacion(Integer numeroFacturacion) {
        this.numeroFacturacion = numeroFacturacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValorMovimiento() {
        return valorMovimiento;
    }

    public void setValorMovimiento(Double valorMovimiento) {
        this.valorMovimiento = valorMovimiento;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimientos != null ? idMovimientos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idMovimientos == null && other.idMovimientos != null) || (this.idMovimientos != null && !this.idMovimientos.equals(other.idMovimientos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.banca.models.Movimiento[ idMovimientos=" + idMovimientos + " ]";
    }
    
}
