package cl.ufro.dci.ufropharmacy.models.casamatriz;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class ClienteCM {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String DNI;
    @OneToOne
    private CompraCM compra;

    public ClienteCM(long id, String nombre, String direccion, String telefono, String email, String DNI, CompraCM compra) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.DNI = DNI;
        this.compra = compra;
    }

    public ClienteCM() {
    }

}