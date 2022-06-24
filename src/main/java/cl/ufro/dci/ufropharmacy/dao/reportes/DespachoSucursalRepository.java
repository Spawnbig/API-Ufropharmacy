package cl.ufro.dci.ufropharmacy.dao.reportes;

import cl.ufro.dci.ufropharmacy.models.casamatriz.DespachoSucursalCM;
import cl.ufro.dci.ufropharmacy.models.casamatriz.ESTADO_DESPACHO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component("despachoSucursalRepositoryR")
public interface DespachoSucursalRepository extends JpaRepository<DespachoSucursalCM,Long> {

    List<DespachoSucursalCM> findByFechaHoraDespachoBetween(Date fechaInicio, Date fechaTermino);
    List<DespachoSucursalCM> findByEstadoDespacho(ESTADO_DESPACHO estado);


}
