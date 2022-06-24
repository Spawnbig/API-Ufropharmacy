package cl.ufro.dci.ufropharmacy.models.casamatriz;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class DespachoSucursalCM {
    @Id
    @GeneratedValue
    private long id;
    private Date fechaHoraDespacho;
    private Date fechaHoraLlegada;
    private Date fechaEstimadaEntrega;
    @Enumerated(EnumType.STRING)
    private ESTADO_DESPACHO estadoDespacho;
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "pedido_sucursal_cm_id", nullable = false)
    private PedidoSucursalCM pedidoSucursal;


    public DespachoSucursalCM() {
    }

    public DespachoSucursalCM(long id, Date fechaHoraDespacho, Date fechaHoraLlegada, Date fechaEstimadaEntrega, ESTADO_DESPACHO estadoDespacho, PedidoSucursalCM pedidoSucursal) {
        this.id = id;
        this.fechaHoraDespacho = fechaHoraDespacho;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
        this.estadoDespacho = estadoDespacho;
        this.pedidoSucursal = pedidoSucursal;
    }
}

