package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class ReviewSUC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre_usuario;
    private LocalDateTime fecha_review;
    private boolean calificacion;
    @ManyToOne
    private ProductoSUC productos;


    public ReviewSUC() {
    }

    public ReviewSUC(long id, String nombre_usuario, LocalDateTime fecha_review, boolean calificacion, ProductoSUC productos) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.fecha_review = fecha_review;
        this.calificacion = calificacion;
        this.productos = productos;
    }
}
