package co.edu.ucentral.banca.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cuenta_tipo")
@NamedQueries({
    @NamedQuery(name = "CuentaTipo.findAll", query = "SELECT c FROM CuentaTipo c"),
    @NamedQuery(name = "CuentaTipo.findByIdCuentaTipo", query = "SELECT c FROM CuentaTipo c WHERE c.idCuentaTipo = :idCuentaTipo"),
    @NamedQuery(name = "CuentaTipo.findByNombreCuenta", query = "SELECT c FROM CuentaTipo c WHERE c.nombreCuenta = :nombreCuenta")})
public class CuentaTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_CuentaTipo")
    private Integer idCuentaTipo;
    @Size(max = 50)
    @Column(name = "nombre_cuenta")
    private String nombreCuenta;

    public CuentaTipo() {
    }

    public CuentaTipo(Integer idCuentaTipo) {
        this.idCuentaTipo = idCuentaTipo;
    }

    public Integer getIdCuentaTipo() {
        return idCuentaTipo;
    }

    public void setIdCuentaTipo(Integer idCuentaTipo) {
        this.idCuentaTipo = idCuentaTipo;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaTipo != null ? idCuentaTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaTipo)) {
            return false;
        }
        CuentaTipo other = (CuentaTipo) object;
        if ((this.idCuentaTipo == null && other.idCuentaTipo != null) || (this.idCuentaTipo != null && !this.idCuentaTipo.equals(other.idCuentaTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.banca.models.CuentaTipo[ idCuentaTipo=" + idCuentaTipo + " ]";
    }
    
}
