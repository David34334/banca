package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.EmpresaServicio;
import java.util.List;

public interface EmpresaDAO {
    
    public List<EmpresaServicio> findAllEmpresaServicios();
    
    public EmpresaServicio findEmpresaServicioByID(EmpresaServicio empresaServicio);
    
    public void insertEmpresaServicio(EmpresaServicio empresaServicio);
    
    public void updateEmpresaServicio(EmpresaServicio empresaServicio);
    
    public void deleteEmpresaServicio(EmpresaServicio empresaServicio);
    
    public EmpresaServicio findEmpresaServicioByReferenceNumber(EmpresaServicio empresaServicio);
    
}
