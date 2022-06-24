package cl.ufro.dci.ufropharmacy.controllers.reportes;


import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import cl.ufro.dci.ufropharmacy.services.reportes.ProductosServices;
import cl.ufro.dci.ufropharmacy.utils.reportes.ProductosExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/reportes/productos")
public class ProductosController {

    @Autowired
    ProductosServices productosServicesR;

    @GetMapping
    public List<ProductoSUC> listarProductos(){
        return productosServicesR.obtenerTodosProductos();
    }

    @GetMapping("/export")
    public void exportarBoletas(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=Productos.xlsx";
        response.setHeader(headerKey,headerValue);
        List<ProductoSUC> productoSUCS = productosServicesR.obtenerTodosProductos();
        ProductosExporter exporter = new ProductosExporter(productoSUCS);
        exporter.export(response);
    }

}
