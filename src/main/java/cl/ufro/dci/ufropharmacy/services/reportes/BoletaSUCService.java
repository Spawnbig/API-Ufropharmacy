package cl.ufro.dci.ufropharmacy.services.reportes;


import cl.ufro.dci.ufropharmacy.dao.reportes.BoletaSUCRepository;
import cl.ufro.dci.ufropharmacy.dao.reportes.UsuarioSUCRepository;
import cl.ufro.dci.ufropharmacy.models.sucursal.BoletaSUC;
import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import cl.ufro.dci.ufropharmacy.models.sucursal.UsuarioSUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("boletaSUCServiceR")
public class BoletaSUCService {

    @Autowired
    BoletaSUCRepository boletaSUCRepositoryR;

    @Autowired
    UsuarioSUCRepository usuarioSUCRepositoryR;
    public List<BoletaSUC> obtenerTodasBoletas(){
        return transformObjectoToBoleta(boletaSUCRepositoryR.findAllBoletas());
    }

    public List<BoletaSUC> obtenerBoletasFecha(LocalDateTime fechaInicio, LocalDateTime fechaFinal){
        return transformObjectoToBoleta(boletaSUCRepositoryR.findByFechas(fechaInicio,fechaFinal));
    }

    private List<BoletaSUC> transformObjectoToBoleta(List<Object[]> objects){
        ArrayList<ProductoSUC> productos = new ArrayList<>();
        List<BoletaSUC> boletas = new ArrayList<>();
        for (Object[] o : objects){
            int id = ((BigInteger)o[0]).intValue();
            LocalDateTime time = LocalDateTime.ofInstant(((Timestamp)o[1]).toInstant(), ZoneOffset.ofHours(0));
            Double precioTotal = ((Double)o[2]);
            String tipoPago = (String)o[3];
            long idUser = ((BigInteger)o[4]).longValue();
            Optional<UsuarioSUC> user = usuarioSUCRepositoryR.findById(idUser);
            boletas.add(new BoletaSUC(id,productos,user.get(),tipoPago,time,precioTotal));
        }
        return boletas;
    }

}
