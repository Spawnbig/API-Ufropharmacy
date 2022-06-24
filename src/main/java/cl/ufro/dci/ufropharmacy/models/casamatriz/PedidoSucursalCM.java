package cl.ufro.dci.ufropharmacy.models.casamatriz;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class PedidoSucursalCM {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    private ESTADO_PEDIDO estadoPedido;
    @OneToMany
    private List<ProductoSUC> productos;


    public PedidoSucursalCM() {
    }


    public PedidoSucursalCM(long id, ESTADO_PEDIDO estadoPedido, List<ProductoSUC> productos) {
        this.id = id;
        this.estadoPedido = estadoPedido;
        this.productos = productos;
    }
}
