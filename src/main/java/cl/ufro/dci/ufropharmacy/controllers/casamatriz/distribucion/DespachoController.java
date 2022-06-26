package cl.ufro.dci.ufropharmacy.controllers.casamatriz.distribucion;

import cl.ufro.dci.ufropharmacy.dao.casamatriz.distribucion.DespachoSucursalCMRepository;
import cl.ufro.dci.ufropharmacy.models.casamatriz.distribucion.DespachoSucursalCM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("distribucion/despacho")
public class DespachoController {

    @Autowired
    private DespachoSucursalCMRepository despachoRepository;

    @GetMapping
    public ResponseEntity<List<DespachoSucursalCM>> getAll(){
        return new ResponseEntity<>(despachoRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    private ResponseEntity<DespachoSucursalCM> get(@PathVariable Long id) {
        Optional<DespachoSucursalCM> optDespacho = despachoRepository.findById(id);
        return optDespacho.map(
                        DespachoSucursalCM -> new ResponseEntity<>(DespachoSucursalCM, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private ResponseEntity<DespachoSucursalCM> newDespacho(@RequestBody DespachoSucursalCM despacho) {
        // prevenir modificación usando id en 0
        // TODO: se podría utilizar DTOs
        despacho.setId(0L);
        despachoRepository.save(despacho);
        return new ResponseEntity<>(despacho,HttpStatus.OK);
    }

    @PutMapping("{id}")
    private ResponseEntity<DespachoSucursalCM> editDespacho(@PathVariable Long id ,@RequestBody DespachoSucursalCM despacho){
        if(despachoRepository.existsById(id)){
            despacho.setId(id);
            despachoRepository.save(despacho);
            return new ResponseEntity<>(despacho,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<String> delete(@PathVariable Long id) {
        if (despachoRepository.existsById(id)) {
            despachoRepository.deleteById(id);
            return new ResponseEntity<>("Despacho eliminado correctamente (id:" + id + ')', HttpStatus.OK);
        } else {
            return new ResponseEntity<>("La id dada no existe (id: " + id + ')', HttpStatus.NOT_FOUND);
        }
    }
}
