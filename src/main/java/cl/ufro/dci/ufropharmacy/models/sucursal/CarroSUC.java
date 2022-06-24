package cl.ufro.dci.ufropharmacy.models.sucursal;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CarroSUC {
    @Id
    @GeneratedValue
    private int ordenCompra;

    @OneToOne(targetEntity = UsuarioSUC.class)
    private UsuarioSUC idUsuario;

    @OneToMany(targetEntity = ProductoSUC.class, cascade = CascadeType.ALL)
    private List<ProductoSUC> productos = new ArrayList<>();

    private int precioFinal;

    private int descuentoAplicado;

    private int precioSinDescuento;
}