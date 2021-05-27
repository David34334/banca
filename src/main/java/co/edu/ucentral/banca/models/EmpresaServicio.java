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
@Table(name = "empresa_servicio")
@NamedQueries({
    @NamedQuery(name = "EmpresaServicio.findAll", query = "SELECT e FROM EmpresaServicio e"),
    @NamedQuery(name = "EmpresaServicio.findByIdEmpresa", query = "SELECT e FROM EmpresaServicio e WHERE e.idEmpresa = :idEmpresa"),
    @NamedQuery(name = "EmpresaServicio.findByNombreEmpresa", query = "SELECT e FROM EmpresaServicio e WHERE e.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "EmpresaServicio.findByNombreServicio", query = "SELECT e FROM EmpresaServicio e WHERE e.nombreServicio = :nombreServicio"),
    @NamedQuery(name = "EmpresaServicio.findByNumeroReferencia", query = "SELECT e FROM EmpresaServicio e WHERE e.numeroReferencia = :numeroReferencia"),
    @NamedQuery(name = "EmpresaServicio.findByEstadoEmpresa", query = "SELECT e FROM EmpresaServicio e WHERE e.estadoEmpresa = :estadoEmpresa"),
    @NamedQuery(name = "EmpresaServicio.findByValor", query = "SELECT e FROM EmpresaServicio e WHERE e.valor = :valor"),
    @NamedQuery(name = "EmpresaServicio.findByLogoEmpresa", query = "SELECT e FROM EmpresaServicio e WHERE e.logoEmpresa = :logoEmpresa")})
public class EmpresaServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Empresa")
    private Integer idEmpresa;
    @Size(max = 50)
    @Column(name = "nombre_Empresa")
    private String nombreEmpresa;
    @Size(max = 50)
    @Column(name = "nombre_Servicio")
    private String nombreServicio;
    @Column(name = "numero_Referencia")
    private Integer numeroReferencia;
    @Column(name = "estado_empresa")
    private Integer estadoEmpresa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Size(max = 255)
    @Column(name = "logoEmpresa")
    private String logoEmpresa;

    public EmpresaServicio() {
    }

    public EmpresaServicio(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Integer getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(Integer numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public Integer getEstadoEmpresa() {
        return estadoEmpresa;
    }

    public void setEstadoEmpresa(Integer estadoEmpresa) {
        this.estadoEmpresa = estadoEmpresa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(String logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaServicio)) {
            return false;
        }
        EmpresaServicio other = (EmpresaServicio) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.ucentral.banca.models.EmpresaServicio[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
