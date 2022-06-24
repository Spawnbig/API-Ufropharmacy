package cl.ufro.dci.ufropharmacy.services.reportes;

import cl.ufro.dci.ufropharmacy.dao.reportes.ProductoDescuentoSUCRepository;
import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoDescuentoSUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@Component("productoDescuentoServicesR")
public class ProductoDescuentoServices {

    @Autowired
    ProductoDescuentoSUCRepository productoDescuentoSUCRepositoryR;

    public List<ProductoDescuentoSUC> obtenerTodosProductosDescuento(){return productoDescuentoSUCRepositoryR.findAll();}
    public List<ProductoDescuentoSUC> buscarProductosDescuentosExpiracion(LocalDate fechaInicial, LocalDate fechaFinal) {
        return productoDescuentoSUCRepositoryR.findByFechaExpiracionBetween(fechaInicial,fechaFinal);
    }



}
