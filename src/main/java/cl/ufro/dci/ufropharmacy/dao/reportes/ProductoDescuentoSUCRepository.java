package cl.ufro.dci.ufropharmacy.dao.reportes;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoDescuentoSUC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Component("productoDescuentoSUCRepositoryR")
public interface ProductoDescuentoSUCRepository extends JpaRepository<ProductoDescuentoSUC,Integer> {

    List<ProductoDescuentoSUC> findByFechaExpiracionBetween(LocalDate fechaInicial, LocalDate fechaFinal);

}
