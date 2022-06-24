package cl.ufro.dci.ufropharmacy.dao.reportes;

import cl.ufro.dci.ufropharmacy.models.sucursal.UsuarioSUC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component("usuarioSUCRepositoryR")
public interface UsuarioSUCRepository extends JpaRepository<UsuarioSUC,Long> {
}
