package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.models.EmpresaServicio;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EmpresaService {
    
    public List<EmpresaServicio> listarEmpresaServicios();
    
    public EmpresaServicio encontrarEmpresaServicioPorID(EmpresaServicio empresaServicio);
    
    public void guardarEmpresaServicio(EmpresaServicio empresaServicio);
    
    public void actualizarEmpresaServicio(EmpresaServicio empresaServicio);
    
    public void eliminarEmpresaServicio(EmpresaServicio empresaServicio);
    
    public EmpresaServicio encontrarEmpresaPorNumeroReferencia(EmpresaServicio empresaServicio);
    
}
