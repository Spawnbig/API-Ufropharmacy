package cl.ufro.dci.ufropharmacy.models.casamatriz.distribucion;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class PedidoSucursalCM {

    @Id
    @GeneratedValue
    private long id;
    private int cantidad;
    private Date fecha_pedido;

    @Enumerated(EnumType.STRING)
    private ESTADO_PEDIDO estadoPedido;

    @OneToMany
    private List<ProductoSUC> productos;
    //Evaluar, cambiar List<Productos> por producto

    public PedidoSucursalCM() {}

    public PedidoSucursalCM(long id, int cantidad, Date fecha_pedido, ESTADO_PEDIDO estadoPedido, List<ProductoSUC> productos) {
        this.id = id;
        this.cantidad = cantidad;
        this.fecha_pedido = fecha_pedido;
        this.estadoPedido = estadoPedido;
        this.productos = productos;
    }
}
