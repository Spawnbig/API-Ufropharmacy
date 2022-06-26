package cl.ufro.dci.ufropharmacy.services.reportes;

import cl.ufro.dci.ufropharmacy.dao.reportes.DespachoSucursalRepository;
import cl.ufro.dci.ufropharmacy.models.casamatriz.distribucion.DespachoSucursalCM;
import cl.ufro.dci.ufropharmacy.models.casamatriz.distribucion.ESTADO_DESPACHO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
@Service
@Component("despachoSucursalServicesR")
public class DespachoSucursalServices {

    @Autowired
    DespachoSucursalRepository despachoSucursalRepositoryR;

    public List<DespachoSucursalCM> obtenerTodosDespachos(){
        return despachoSucursalRepositoryR.findAll();
    }

    public List<DespachoSucursalCM> obtenerPorEstado(ESTADO_DESPACHO estado){
        return despachoSucursalRepositoryR.findByEstadoDespacho(estado);
    }

    public List<DespachoSucursalCM> buscarDespachoFecha(Date fechaIni, Date fechaTer) {
        return despachoSucursalRepositoryR.findByFechaHoraDespachoBetween(fechaIni,fechaTer);
    }
}
