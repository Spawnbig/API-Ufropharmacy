package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Data
public class FormularioPedidoSUC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ArrayList<ProductoSUC> productos;

    public FormularioPedidoSUC(long id, ArrayList<ProductoSUC> productos) {
        this.id = id;
        this.productos = productos;
    }

    public FormularioPedidoSUC() {
    }
}
