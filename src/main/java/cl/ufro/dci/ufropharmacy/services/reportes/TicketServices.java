package cl.ufro.dci.ufropharmacy.services.reportes;

import cl.ufro.dci.ufropharmacy.dao.reportes.TicketRepository;
import cl.ufro.dci.ufropharmacy.models.casamatriz.ESTADO_TICKET;
import cl.ufro.dci.ufropharmacy.models.casamatriz.TicketCM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Component("ticketServicesR")
public class TicketServices {

    @Autowired
    TicketRepository ticketRepositoryR;

    public List<TicketCM> encontrarPorEstado(ESTADO_TICKET estado){
        return ticketRepositoryR.findByEstadoTicket(estado);
    }

    public List<TicketCM> encontrarPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFinal){
        return ticketRepositoryR.findByFechaCreacionBetween(fechaInicio,fechaFinal);
    }

    public List<TicketCM> listarTickets(){
        return ticketRepositoryR.findAll();
    }

}
