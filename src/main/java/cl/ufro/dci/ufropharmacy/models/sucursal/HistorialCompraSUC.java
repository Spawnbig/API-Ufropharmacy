package cl.ufro.dci.ufropharmacy.models.sucursal;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Entity
@Data
@Transactional
@Table(name = "historial_compra")
public class HistorialCompraSUC {
    @Id
    @Column(name = "id_historial", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorial;


    @OneToOne
    @JoinColumn(name = "id_historial")
    private ClienteSUC clienteSUC;

    @Column(name = "historial_idCompra",nullable = false)
    private int idCompra;

    @Column(name = "historial_fechaCompra",nullable = false)
    private LocalDateTime fechaCompra;

    @Column(name = "historial_precioCompra",nullable = false)
    private double precioCompra;

    @Column(name = "historial_formaPago",nullable = false)

    private String formaPago;
    @Column(name = "historial_idCliente",nullable = false)
    private int idCliente;


    public HistorialCompraSUC(int idHistorial, ClienteSUC clienteSUC, int idCompra, LocalDateTime fechaCompra, double precioCompra, String formaPago, int idCliente) {
        this.idHistorial = idHistorial;
        this.clienteSUC = clienteSUC;
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
        this.precioCompra = precioCompra;
        this.formaPago = formaPago;
        this.idCliente = idCliente;
    }

    public HistorialCompraSUC() {
    }
}

