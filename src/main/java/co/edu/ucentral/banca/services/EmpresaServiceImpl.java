package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.database.EmpresaDAO;
import co.edu.ucentral.banca.models.EmpresaServicio;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EmpresaServiceImpl implements EmpresaService {
    
    @Inject
    private EmpresaDAO empresaDAO;

    @Override
    public List<EmpresaServicio> listarEmpresaServicios() {
        return empresaDAO.findAllEmpresaServicios();
    }

    @Override
    public EmpresaServicio encontrarEmpresaServicioPorID(EmpresaServicio empresaServicio) {
        return empresaDAO.findEmpresaServicioByID(empresaServicio);
    }

    @Override
    public void guardarEmpresaServicio(EmpresaServicio empresaServicio) {
        empresaDAO.insertEmpresaServicio(empresaServicio);
    }

    @Override
    public void actualizarEmpresaServicio(EmpresaServicio empresaServicio) {
        empresaDAO.updateEmpresaServicio(empresaServicio);
    }

    @Override
    public void eliminarEmpresaServicio(EmpresaServicio empresaServicio) {
        empresaDAO.deleteEmpresaServicio(empresaServicio);
    }

}