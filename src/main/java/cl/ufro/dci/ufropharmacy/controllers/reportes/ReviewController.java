package cl.ufro.dci.ufropharmacy.controllers.reportes;


import cl.ufro.dci.ufropharmacy.models.sucursal.ReviewSUC;
import cl.ufro.dci.ufropharmacy.services.reportes.ReviewService;
import cl.ufro.dci.ufropharmacy.utils.reportes.ReviewSUCExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/reportes/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewServiceR;

    @GetMapping
    public List<ReviewSUC> listaReviews(){
        return reviewServiceR.obtenerTodosReviews();
    }

    @GetMapping("/export")
    public void exportarReviews(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=Reviews.xlsx";
        response.setHeader(headerKey,headerValue);
        List<ReviewSUC> cupones = reviewServiceR.obtenerTodosReviews();
        ReviewSUCExporter exporter = new ReviewSUCExporter(cupones);
        exporter.export(response);
    }
    @GetMapping("/id/{idProducto}")
    public List<ReviewSUC> buscarPorIdProducto(@PathVariable String idProducto) {
        long id = Long.parseLong(idProducto);
        return reviewServiceR.buscarReviewsPorIdProducto(id);
    }

}
