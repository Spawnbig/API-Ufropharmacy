package cl.ufro.dci.ufropharmacy.controllers.reportes;

import cl.ufro.dci.ufropharmacy.models.casamatriz.ESTADO_TICKET;
import cl.ufro.dci.ufropharmacy.models.casamatriz.TicketCM;
import cl.ufro.dci.ufropharmacy.services.reportes.TicketServices;
import cl.ufro.dci.ufropharmacy.utils.reportes.TicketExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/reportes/tickets")
public class TicketController {

    @Autowired
    TicketServices ticketServicesR;

    @GetMapping
    public List<TicketCM> listarTicket(){
        return ticketServicesR.listarTickets();
    }

    @GetMapping("/{fechaInicio}/{fechaFinal}")
    public List<TicketCM> buscarTicketFecha(@PathVariable String fechaInicio, @PathVariable String fechaFinal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.getDefault());
        LocalDateTime fechaIni = LocalDateTime.parse(fechaInicio,formatter);
        LocalDateTime fechaTer = LocalDateTime.parse(fechaFinal,formatter);
        return ticketServicesR.encontrarPorFecha(fechaIni,fechaTer);
    }

    @GetMapping("/{estadoBusqueda}")
    public List<TicketCM> buscarTicketPorEstado(@PathVariable String estadoBusqueda){
        ESTADO_TICKET estado = ESTADO_TICKET.valueOf(estadoBusqueda);
        return ticketServicesR.encontrarPorEstado(estado);
    }


    @GetMapping("/export")
    public void exportarTickets(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=Tickets.xlsx";
        response.setHeader(headerKey,headerValue);
        List<TicketCM> tickets = ticketServicesR.listarTickets();
        TicketExporter exporter = new TicketExporter(tickets);
        exporter.export(response);
    }
}
