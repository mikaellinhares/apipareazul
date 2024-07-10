package bancocrudspringboot.repository;

import bancocrudspringboot.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    @Query(value="SELECT * FROM cartoes WHERE id_usuario = :id_usuario", nativeQuery = true)
    List<Cartao> findCardsByUser(@Param("id_usuario") Long id_usuario);
}