package co.edu.ucentral.banca.database;

import co.edu.ucentral.banca.models.Cuenta;
import co.edu.ucentral.banca.models.Movimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MovimientoDAOImpl implements MovimientoDAO {
    
    @PersistenceContext(unitName = "BancoUP")
    EntityManager manager;

    @Override
    public List<Movimiento> findAllMovimientos() {
        return manager.createNamedQuery("Movimiento.findAll").getResultList();
    }

    @Override
    public Movimiento findMovimientoByID(Movimiento movimiento) {
        return manager.find(Movimiento.class, movimiento.getIdMovimientos());
    }

    @Override
    public void insertMovimiento(Movimiento movimiento) {
        manager.persist(movimiento);
    }

    @Override
    public void updateMovimiento(Movimiento movimiento) {
        manager.merge(movimiento);
    }

    @Override
    public void deleteMovimiento(Movimiento movimiento) {
        manager.remove(manager.merge(movimiento));
    }

    @Override
    public List<Movimiento> findMovimientoByIDAccount(Cuenta cuenta) {
        TypedQuery<Movimiento> movimientoCuenta = manager.createNamedQuery("Movimiento.findByIdCuenta", Movimiento.class);
        movimientoCuenta.setParameter("idCuenta", cuenta);
        List<Movimiento> movimientos = movimientoCuenta.getResultList();
        
        if (movimientos.size() > 0) {
            return movimientos;
        }
        return null;
    }
    
}
