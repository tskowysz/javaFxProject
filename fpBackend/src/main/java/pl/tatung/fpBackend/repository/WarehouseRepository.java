package pl.tatung.fpBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatung.fpBackend.entity.Warehouse;
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Long> {
}
