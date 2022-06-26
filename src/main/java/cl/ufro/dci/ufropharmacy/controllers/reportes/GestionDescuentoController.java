package cl.ufro.dci.ufropharmacy.controllers.reportes;


import cl.ufro.dci.ufropharmacy.models.sucursal.CuponSUC;
import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoDescuentoSUC;
import cl.ufro.dci.ufropharmacy.services.reportes.CuponServices;
import cl.ufro.dci.ufropharmacy.services.reportes.ProductoDescuentoServices;
import cl.ufro.dci.ufropharmacy.utils.reportes.CuponExporter;
import cl.ufro.dci.ufropharmacy.utils.reportes.ProductosDescuentosExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/reportes/")
public class GestionDescuentoController {

    @Autowired
    CuponServices cuponServicesR;
    @Autowired
    ProductoDescuentoServices productoDescuentoServicesR;
    @GetMapping("/cupones")
    public List<CuponSUC> listarCupones() {
        return cuponServicesR.obtenerTodosCupones();
    }
    @GetMapping("/cupones/{fechaInicio}/{fechaFinal}")
    public List<CuponSUC> buscarCuponesFecha(@PathVariable String fechaInicio,@PathVariable String fechaFinal){
        //se debe entregar la fecha en la forma de yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault());
        LocalDate fechaIni = LocalDate.parse(fechaInicio,formatter);
        LocalDate fechaTer = LocalDate.parse(fechaFinal,formatter);
        return cuponServicesR.buscarCuponesFecha(fechaIni,fechaTer);
    }

    @GetMapping("/productosdescuento")
    public List<ProductoDescuentoSUC> listarProductoDescuento(){ return productoDescuentoServicesR.obtenerTodosProductosDescuento(); }

    @GetMapping("/productosdescuento/{fechaInicio}/{fechaFinal}")
    public List<ProductoDescuentoSUC> buscarProductosDescuentoFechaExpiracion(@PathVariable String fechaInicio,@PathVariable String fechaFinal){
        //se debe entregar la fecha en la forma de yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault());
        LocalDate fechaIni = LocalDate.parse(fechaInicio,formatter);
        LocalDate fechaTer = LocalDate.parse(fechaFinal,formatter);
        return productoDescuentoServicesR.buscarProductosDescuentosExpiracion(fechaIni,fechaTer);
    }

    @GetMapping("/productosdescuento/export")
    public void exportarProductosDescuento(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=ProductosDescuento.xlsx";
        response.setHeader(headerKey,headerValue);
        List<ProductoDescuentoSUC> productoDescuentos = productoDescuentoServicesR.obtenerTodosProductosDescuento();
        ProductosDescuentosExporter exporter = new ProductosDescuentosExporter(productoDescuentos);
        exporter.export(response);
    }
    @GetMapping("/cupones/export")
    public void exportarCupones(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=Cupones.xlsx";
        response.setHeader(headerKey,headerValue);
        List<CuponSUC> cupones = cuponServicesR.obtenerTodosCupones();
        CuponExporter exporter = new CuponExporter(cupones);
        exporter.export(response);
    }

}
