package cl.ufro.dci.ufropharmacy.controllers.reportes;


import cl.ufro.dci.ufropharmacy.models.casamatriz.DespachoSucursalCM;
import cl.ufro.dci.ufropharmacy.models.casamatriz.ESTADO_DESPACHO;
import cl.ufro.dci.ufropharmacy.services.reportes.DespachoSucursalServices;
import cl.ufro.dci.ufropharmacy.utils.reportes.DespachoExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reportes/despachos")
public class DespachoController {
    @Autowired
    DespachoSucursalServices despachoSucursalServicesR;

    @GetMapping
    public List<DespachoSucursalCM> listarDespachos(){
        return despachoSucursalServicesR.obtenerTodosDespachos();
    }

    @GetMapping("/{estadoInput}")
    public List<DespachoSucursalCM> buscarPorEstado(@PathVariable String estadoInput){
        ESTADO_DESPACHO estado = ESTADO_DESPACHO.valueOf(estadoInput);
        return despachoSucursalServicesR.obtenerPorEstado(estado);
    }

    @GetMapping("/{fechaInicial}/{fechaTermino}")
    public List<DespachoSucursalCM> buscarDespachoFecha(@PathVariable String fechaInicial, @PathVariable String fechaTermino ){

        Date fechaIni, fechaTer;
        try {
            fechaIni = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicial);
            fechaTer = new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicial);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return despachoSucursalServicesR.buscarDespachoFecha(fechaIni,fechaTer);
    }

    @GetMapping("/export")
    public void exportarDespachos(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=Despachos.xlsx";
        response.setHeader(headerKey,headerValue);
        List<DespachoSucursalCM> despachos = despachoSucursalServicesR.obtenerTodosDespachos();
        DespachoExporter exporter = new DespachoExporter(despachos);
        exporter.export(response);
    }



}
