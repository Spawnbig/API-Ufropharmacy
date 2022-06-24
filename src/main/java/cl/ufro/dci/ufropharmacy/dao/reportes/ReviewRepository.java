package cl.ufro.dci.ufropharmacy.dao.reportes;


import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import cl.ufro.dci.ufropharmacy.models.sucursal.ReviewSUC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component("reviewRepositoryR")
public interface ReviewRepository extends JpaRepository<ReviewSUC,Integer> {
    List<ReviewSUC> findByCalificacion(String calificacion);

    List<ReviewSUC> findByProductos(ProductoSUC productoSUC);
}
