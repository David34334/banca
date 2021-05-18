package co.edu.ucentral.banca.services;

import co.edu.ucentral.banca.models.PagoServicio;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PagoServicioService {
    
    public List<PagoServicio> listarPagoServicios();
    
    public PagoServicio encontrarPagoServicioPorID(PagoServicio pagoServicio);
    
    public void guardarPagoServicio(PagoServicio pagoServicio);
    
    public void actualizarPagoServicio(PagoServicio pagoServicio);
    
    public void eliminarPagoServicio(PagoServicio pagoServicio);
    
}
