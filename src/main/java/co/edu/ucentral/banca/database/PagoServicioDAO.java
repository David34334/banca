package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.PagoServicio;
import java.util.List;

public interface PagoServicioDAO {
    
    public List<PagoServicio> findAllPagoServicios();
    
    public PagoServicio findPagoServicioByID(PagoServicio pagoServicio);
    
    public void insertPagoServicio(PagoServicio pagoServicio);
    
    public void updatePagoServicio(PagoServicio pagoServicio);
    
    public void deletePagoServicio(PagoServicio pagoServicio);
    
}
