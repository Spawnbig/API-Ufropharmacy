package cl.ufro.dci.ufropharmacy.models.casamatriz;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class LineaPedidoCM {
    @Id
    @GeneratedValue
    private long id;
}
