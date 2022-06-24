package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Data
public class BoletaSUC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ArrayList<ProductoSUC> productos;
    @OneToOne
    private UsuarioSUC usuario;
    private String tipoPago;
    private LocalDateTime fecha;
    private double precioTotal;

    public BoletaSUC(int id, ArrayList<ProductoSUC> productos, UsuarioSUC usuario, String tipoPago, LocalDateTime fecha, double precioTotal) {
        this.id = id;
        this.productos = productos;
        this.usuario = usuario;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
    }

    public BoletaSUC() {
    }
}
