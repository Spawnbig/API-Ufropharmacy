package cl.ufro.dci.ufropharmacy.dao.reportes;


import cl.ufro.dci.ufropharmacy.models.sucursal.CuponSUC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component("cuponRepositoryR")
public interface CuponRepository extends JpaRepository<CuponSUC, Integer> {

    List<CuponSUC> findByFechaExpiracionBetween(LocalDateTime fechaInicio, LocalDateTime fechaTermino);

}
