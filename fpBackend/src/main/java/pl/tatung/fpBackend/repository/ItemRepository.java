package pl.tatung.fpBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatung.fpBackend.entity.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
