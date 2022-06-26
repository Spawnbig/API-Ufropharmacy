package cl.ufro.dci.ufropharmacy.models.casamatriz;

import cl.ufro.dci.ufropharmacy.models.casamatriz.distribucion.ESTADO_PEDIDO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PedidoCM {
    @Id
    @GeneratedValue
    private int id_pedido;
    private ESTADO_PEDIDO estado;
    private int id_producto;

}
