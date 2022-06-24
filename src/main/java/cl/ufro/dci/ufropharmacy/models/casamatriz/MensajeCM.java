package cl.ufro.dci.ufropharmacy.models.casamatriz;

import cl.ufro.dci.ufropharmacy.models.sucursal.UsuarioSUC;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class MensajeCM {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private UsuarioSUC usuario;
    private String mensaje;
    private String archivoMensaje;

    public MensajeCM(long id, UsuarioSUC usuario, String mensaje, String archivoMensaje) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.archivoMensaje = archivoMensaje;
    }

    public MensajeCM() {
    }
}