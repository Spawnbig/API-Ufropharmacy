package cl.ufro.dci.ufropharmacy.models.casamatriz;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@Entity
@Data
//@Table(name = "usuarios")
public class UsuarioCM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rut;
    private String clave;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String ciudad;
    private String direccion;
    private short enable;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuariosCM_roles",
            joinColumns = @JoinColumn(name = "usuarioCM_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
    )
    private Collection<RolCM> rol;
    public UsuarioCM() {
    }

    public UsuarioCM(Long id, String rut, String clave, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, LocalDate fechaNacimiento, String ciudad, String direccion, short enable, Collection<RolCM> rol) {
        this.id = id;
        this.rut = rut;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.enable = enable;
        this.rol = rol;
    }
}
