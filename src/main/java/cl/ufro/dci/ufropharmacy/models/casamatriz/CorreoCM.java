package cl.ufro.dci.ufropharmacy.models.casamatriz;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CorreoCM {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne(cascade = {CascadeType.MERGE})
    private UsuarioCM emisor;
    @OneToOne(cascade = {CascadeType.MERGE}) // investigar
    private UsuarioCM receptor;
    private String asunto;
    private String cuerpo;
    private String tipoCorreo;

    public CorreoCM(Long id, UsuarioCM emisor, UsuarioCM receptor, String asunto, String cuerpo, String tipoCorreo) {
        this.id = id;
        this.emisor = emisor;
        this.receptor = receptor;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.tipoCorreo = tipoCorreo;
    }

    public CorreoCM() {
    }
}
