package cl.ufro.dci.ufropharmacy.models.sucursal;

import cl.ufro.dci.ufropharmacy.models.casamatriz.TicketCM;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ClienteSUC {
    @Id
    @GeneratedValue
    private long id;
    private String institutoPrevision;
    @OneToOne
    @JoinColumn(name = "historialcomprasuc_id", nullable = false)
    private HistorialCompraSUC historialCompra;
    private boolean publicidad;
    private boolean estado;
    @OneToMany
    private List<TicketCM> tickets = new ArrayList<>();

    public ClienteSUC() {
    }

    public ClienteSUC(long id, String institutoPrevision, HistorialCompraSUC historialCompra, boolean publicidad, boolean estado) {
        this.id = id;
        this.institutoPrevision = institutoPrevision;
        this.historialCompra = historialCompra;
        this.publicidad = publicidad;
        this.estado = estado;
    }
}