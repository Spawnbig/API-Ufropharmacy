package cl.ufro.dci.ufropharmacy.models.sucursal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "productos_descuento")
public class ProductoDescuentoSUC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productos_descuento_seq")
    private long id;
    private double porcentajeDescuento;
    private LocalDate fechaInicioDescuento;
    private LocalDate fechaExpiracion;
    private String categoria;
    private String marca;

    @ManyToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductoSUC productoSUC;

    public ProductoDescuentoSUC() {
    }

    public ProductoDescuentoSUC(long id, LocalDate fechaInicioDescuento, LocalDate fechaExpiracion, double porcentajeDescuento, ProductoSUC productoSUC) {
        this.id = id;
        this.fechaInicioDescuento = fechaInicioDescuento;
        this.fechaExpiracion = fechaExpiracion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.productoSUC = productoSUC;
    }

    public ProductoDescuentoSUC(long id, LocalDate fechaInicioDescuento, LocalDate fechaExpiracion, String categoria, String marca, double porcentajeDescuento) {
        this.id = id;
        this.fechaInicioDescuento = fechaInicioDescuento;
        this.fechaExpiracion = fechaExpiracion;
        this.categoria = categoria;
        this.marca = marca;
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
