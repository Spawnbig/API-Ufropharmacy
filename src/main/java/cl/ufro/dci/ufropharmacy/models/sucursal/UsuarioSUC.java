package cl.ufro.dci.ufropharmacy.models.sucursal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "usuario_suc")
public class UsuarioSUC {
    @Id
    @GeneratedValue
    private long id;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private String genero;
    private String contrasena;
    private LocalDateTime fechaNacimiento;
    private String ciudad;
    private String direccion;
    @OneToOne
    private RolSUC rol;

    public UsuarioSUC(long id, String rut, String nombre, String apellido, String correo, String celular, String genero, String contrasena, LocalDateTime fechaNacimiento, String ciudad, String direccion, RolSUC rol) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.genero = genero;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.rol = rol;
    }

    public UsuarioSUC() {
    }
}
