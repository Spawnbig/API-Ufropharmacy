package cl.ufro.dci.ufropharmacy.models.casamatriz;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rolCM")
public class RolCM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public RolCM() {
    }

    public RolCM(String nombre) {

        this.nombre = nombre;
    }

}

