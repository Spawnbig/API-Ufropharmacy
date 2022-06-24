package cl.ufro.dci.ufropharmacy.services.reportes;

import cl.ufro.dci.ufropharmacy.dao.reportes.ProductosSUCRepository;
import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("productosServicesR")
public class ProductosServices {
    @Autowired
    ProductosSUCRepository productosSUCRepositoryR;
    public List<ProductoSUC> obtenerTodosProductos(){ return productosSUCRepositoryR.findAll(); }

}

