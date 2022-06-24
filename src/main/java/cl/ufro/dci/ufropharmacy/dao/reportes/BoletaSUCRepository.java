package cl.ufro.dci.ufropharmacy.dao.reportes;

import cl.ufro.dci.ufropharmacy.models.sucursal.BoletaSUC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component("boletaSUCRepositoryR")
public interface BoletaSUCRepository extends JpaRepository<BoletaSUC,Long> {

    @Query(value = "SELECT id,fecha,precio_total,tipo_pago,usuario_id FROM boletasuc " +
            "WHERE fecha BETWEEN ? AND ? ORDER BY id ASC",
            nativeQuery = true)

    List<Object[]> findByFechas(LocalDateTime fechaInicio, LocalDateTime fechaFinal);
    @Query(value = "SELECT id,fecha,precio_total,tipo_pago,usuario_id FROM boletasuc ORDER BY id ASC",
            nativeQuery = true)
    List<Object[]> findAllBoletas();
}
