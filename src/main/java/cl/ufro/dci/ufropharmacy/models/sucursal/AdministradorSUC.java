package cl.ufro.dci.ufropharmacy.models.sucursal;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class AdministradorSUC {
    @Id
    @GeneratedValue
    private long id;

}
