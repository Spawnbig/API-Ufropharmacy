package cl.ufro.dci.ufropharmacy.models.casamatriz;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class DistribucionCM {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<ProductoSUC> productos = new ArrayList<>();


    public DistribucionCM(long id, List<ProductoSUC> productos) {
        this.id = id;
        this.productos = productos;
    }

    public DistribucionCM() {
    }
}
