package cl.ufro.dci.ufropharmacy.models.casamatriz;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class InventarioCM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime fecha;
    @OneToMany
    private List<ProductoSUC> productos = new ArrayList<>();

    public InventarioCM(long id, LocalDateTime fecha, List<ProductoSUC> productos) {
        this.id = id;
        this.fecha = fecha;
        this.productos = productos;
    }


    public InventarioCM() {
    }
}






