package cl.ufro.dci.ufropharmacy.models.casamatriz;

import cl.ufro.dci.ufropharmacy.models.sucursal.ClienteSUC;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class TicketCM {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private ClienteSUC cliente;
    @Enumerated(EnumType.STRING)
    private CATEGORIA categoria;
    private String asunto;
    private String descripcion;
    private String archivoSolicitud;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private ESTADO_TICKET estadoTicket;
    @OneToMany
    private List<MensajeCM> mensajes;


    public TicketCM(long id, ClienteSUC cliente, CATEGORIA categoria, String asunto, String descripcion, String archivoSolicitud, LocalDateTime fechaCreacion, ESTADO_TICKET estadoTicket, List<MensajeCM> mensajes) {
        this.id = id;
        this.cliente = cliente;
        this.categoria = categoria;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.archivoSolicitud = archivoSolicitud;
        this.fechaCreacion = fechaCreacion;
        this.estadoTicket = estadoTicket;
        this.mensajes = mensajes;
    }

    public TicketCM() {
    }
}