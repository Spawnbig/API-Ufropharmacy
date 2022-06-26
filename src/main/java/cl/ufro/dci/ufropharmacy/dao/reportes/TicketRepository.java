package cl.ufro.dci.ufropharmacy.dao.reportes;

import cl.ufro.dci.ufropharmacy.models.casamatriz.ESTADO_TICKET;
import cl.ufro.dci.ufropharmacy.models.casamatriz.TicketCM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component("ticketRepositoryR")
public interface TicketRepository extends JpaRepository<TicketCM,Long>{

    List<TicketCM> findByEstadoTicket(ESTADO_TICKET estado);

    List<TicketCM> findByFechaCreacionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFinal);

}
