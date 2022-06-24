package cl.ufro.dci.ufropharmacy.services.reportes;


import cl.ufro.dci.ufropharmacy.dao.reportes.ProductosSUCRepository;
import cl.ufro.dci.ufropharmacy.dao.reportes.ReviewRepository;
import cl.ufro.dci.ufropharmacy.models.sucursal.ProductoSUC;
import cl.ufro.dci.ufropharmacy.models.sucursal.ReviewSUC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component("reviewServiceR")
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepositoryR;
    @Autowired
    ProductosSUCRepository productosSUCRepositoryR;

    public List<ReviewSUC> obtenerTodosReviews(){
        return reviewRepositoryR.findAll();
    }

    public List<ReviewSUC> buscarReviewsCalificacion(String calificacion){
        return reviewRepositoryR.findByCalificacion(calificacion);
    }

    public List<ReviewSUC> buscarReviewsPorIdProducto(long id) {
        Optional<ProductoSUC> producto = productosSUCRepositoryR.findById(id);
        return reviewRepositoryR.findByProductos(producto.get());
    }
}
