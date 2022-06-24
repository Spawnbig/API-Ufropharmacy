package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@NamedQueries({
        @NamedQuery(name = "ProductoSUC.findAll", query = "SELECT p FROM ProductoSUC p"),
        @NamedQuery(name = "ProductoSUC.findById", query = "SELECT p FROM ProductoSUC p WHERE p.id = :id"),
        @NamedQuery(name = "ProductoSUC.findByMarca", query = "SELECT p FROM ProductoSUC p WHERE p.marca =:marca"),
        @NamedQuery(name = "ProductoSUC.findfByCategoria", query = "SELECT p FROM ProductoSUC p WHERE p.categoria =:categoria"),
        @NamedQuery(name = "ProductoSUC.search", query = "SELECT p FROM ProductoSUC p WHERE p.nombre_producto LIKE :nombre_producto")
})
public class ProductoSUC {
    @Id
    @GeneratedValue
    private long id;
    private String marca;
    private String categoria;
    private double precio;
    private int cantidad;
    private String nombre_producto;
    private String razon_social_titular;
    private String condicion_de_venta;
    private String descirpcion;
    private int descuento;
    private String fechaTecnica;
    private String imagen;

    private boolean retiroTienda;

    public ProductoSUC(long id, String marca, String categoria, double precio, int cantidad, String nombre_producto, String razon_social_titular, String condicion_de_venta, String descirpcion, int descuento, String fechaTecnica, String imagen) {
        this.id = id;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre_producto = nombre_producto;
        this.razon_social_titular = razon_social_titular;
        this.condicion_de_venta = condicion_de_venta;
        this.descirpcion = descirpcion;
        this.descuento = descuento;
        this.fechaTecnica = fechaTecnica;
        this.imagen = imagen;
    }

    public ProductoSUC() {
    }
}