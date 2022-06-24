package cl.ufro.dci.ufropharmacy.controllers.reportes;


import cl.ufro.dci.ufropharmacy.models.sucursal.BoletaSUC;
import cl.ufro.dci.ufropharmacy.services.reportes.BoletaSUCService;
import cl.ufro.dci.ufropharmacy.utils.reportes.BoletaSUCExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/reportes/boletas")
public class BoletaSUCController {

    @Autowired
    BoletaSUCService boletaSUCServiceR;

    @GetMapping
    public List<BoletaSUC> obtenerBoletas(){
        return boletaSUCServiceR.obtenerTodasBoletas();
    }

    @GetMapping("/{fechaInicio}/{fechaFinal}")
    public List<BoletaSUC> obtenerBoletasFecha(@PathVariable String fechaInicio,@PathVariable String fechaFinal){
        //se debe entregar la fecha en la forma de yyyy-MM-dd'T'HH:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.getDefault());
        LocalDateTime fechaIni = LocalDateTime.parse(fechaInicio,formatter);
        LocalDateTime fechaTer = LocalDateTime.parse(fechaFinal,formatter);
        return boletaSUCServiceR.obtenerBoletasFecha(fechaIni,fechaTer);
    }


    @GetMapping("/export")
    public void exportarBoletas(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=Boletas.xlsx";
        response.setHeader(headerKey,headerValue);
        List<BoletaSUC> boletas = boletaSUCServiceR.obtenerTodasBoletas();
        BoletaSUCExporter exporter = new BoletaSUCExporter(boletas);
        exporter.export(response);
    }



}
