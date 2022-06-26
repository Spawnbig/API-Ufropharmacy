package cl.ufro.dci.ufropharmacy.controllers.casamatriz.distribucion;

import cl.ufro.dci.ufropharmacy.dao.casamatriz.distribucion.PedidoSucursalCMRepository;
import cl.ufro.dci.ufropharmacy.models.casamatriz.distribucion.PedidoSucursalCM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("distribucion/pedido")
public class PedidoSucursalCMController {

    // utilizaremos el repositorio directamente hasta implementar una lógica añadida en service
    @Autowired
    private PedidoSucursalCMRepository pedidoSucursalCMRepository;

    @GetMapping
    private ResponseEntity<List<PedidoSucursalCM>> getAll() {
        return new ResponseEntity<>(pedidoSucursalCMRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    private ResponseEntity<PedidoSucursalCM> getById(@PathVariable Long id) {
        Optional<PedidoSucursalCM> optPedido = pedidoSucursalCMRepository.findById(id);
        return optPedido.map(
                pedidoSucursalCM -> new ResponseEntity<>(pedidoSucursalCM, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    private ResponseEntity<PedidoSucursalCM> newPedido(@RequestBody PedidoSucursalCM pedido) {
        // prevenir modificación usando id en 0
        // TODO: se podría utilizar DTOs
        pedido.setId(0L);
        pedidoSucursalCMRepository.save(pedido);
        return new ResponseEntity<>(pedido,HttpStatus.OK);
    }

    @PutMapping("{id}")
    private ResponseEntity<PedidoSucursalCM> editById(@PathVariable Long id , @RequestBody PedidoSucursalCM pedido) {
        if (pedidoSucursalCMRepository.existsById(id)) {
            pedido.setId(id);
            pedidoSucursalCMRepository.save(pedido);
            return new ResponseEntity<>(pedido,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<String> delete(@PathVariable Long id) {
        if (pedidoSucursalCMRepository.existsById(id)) {
            pedidoSucursalCMRepository.deleteById(id);
            return new ResponseEntity<>("Pedido eliminado correctamente (id:" + id + ')', HttpStatus.OK);
        } else {
            return new ResponseEntity<>("La id dada no existe (id: " + id + ')', HttpStatus.NOT_FOUND);
        }

    }
}
