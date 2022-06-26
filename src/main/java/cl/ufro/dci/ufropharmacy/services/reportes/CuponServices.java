package cl.ufro.dci.ufropharmacy.services.reportes;

import cl.ufro.dci.ufropharmacy.dao.reportes.CuponRepository;
import cl.ufro.dci.ufropharmacy.models.sucursal.CuponSUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@Component("cuponServicesR")
public class CuponServices {

    @Autowired
    CuponRepository cuponRepositoryR;
    public List<CuponSUC> obtenerTodosCupones(){
        return cuponRepositoryR.findAll();
    }

    public List<CuponSUC> buscarCuponesFecha(LocalDate fechaInicio, LocalDate fechaTermino){
        return cuponRepositoryR.findByFechaExpiracionBetween(fechaInicio,fechaTermino);
    }

}
