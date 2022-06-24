package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class AgendaSUC {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String codigo;
    private LocalDateTime fechaRetiro;
    @Enumerated(EnumType.STRING)
    private ESTADO_RETIRO estadoRetiro;

    public AgendaSUC(long id, String codigo, LocalDateTime fechaRetiro, ESTADO_RETIRO estadoRetiro) {
        this.id = id;
        this.codigo = codigo;
        this.fechaRetiro = fechaRetiro;
        this.estadoRetiro = estadoRetiro;
    }

    public AgendaSUC() {
    }
}

