package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class CuponSUC {
    @Id
    @GeneratedValue
    private long id;
    private String codigo;
    private double porcentajeDescuento;

    private String especificacion;
    private LocalDate fechaExpiracion;

    public CuponSUC() {
    }

    public CuponSUC(long id, String codigo, double porcentajeDescuento, String especificacion, LocalDate fechaExpiracion) {
        this.id = id;
        this.codigo = codigo;
        this.porcentajeDescuento = porcentajeDescuento;
        this.especificacion = especificacion;
        this.fechaExpiracion = fechaExpiracion;
    }
}

