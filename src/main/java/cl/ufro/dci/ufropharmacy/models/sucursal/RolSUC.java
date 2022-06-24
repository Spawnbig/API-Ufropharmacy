package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RolSUC {
    @Id
    @GeneratedValue
    private long id;
    private String nombreRol;

    public RolSUC() {
    }

    public RolSUC(long id, String nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;
    }
}
