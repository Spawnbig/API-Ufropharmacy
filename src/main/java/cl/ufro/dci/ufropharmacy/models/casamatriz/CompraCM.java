package cl.ufro.dci.ufropharmacy.models.casamatriz;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CompraCM {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime fechaCompra;
    @OneToOne
    private ClienteCM cliente;
    @OneToMany
    private List<ProductoSUC> productos = new ArrayList<>();

    public CompraCM(long id, LocalDateTime fechaCompra, ClienteCM cliente, List<ProductoSUC> productos) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.cliente = cliente;
        this.productos = productos;
    }

    public CompraCM() {
    }
}
