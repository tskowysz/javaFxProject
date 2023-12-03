package pl.tatung.fpBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatung.fpBackend.entity.QuantityType;
@Repository
public interface QuantityTypeRepository extends JpaRepository<QuantityType,Long> {
}
