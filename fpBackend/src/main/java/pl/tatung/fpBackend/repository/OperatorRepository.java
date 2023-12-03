package pl.tatung.fpBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatung.fpBackend.entity.Operator;

import java.util.Optional;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Long> {

    public Optional<Operator> findByLogin(String login);
}
