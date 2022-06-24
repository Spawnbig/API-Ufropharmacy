package cl.ufro.dci.ufropharmacy.dao.reportes;

import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component("productosSUCRepositoryR")
public interface ProductosSUCRepository extends JpaRepository<ProductoSUC,Long> {

}
