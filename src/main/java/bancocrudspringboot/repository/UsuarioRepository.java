package bancocrudspringboot.repository;

import bancocrudspringboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    // @Query(value="select * from usuario_sistema", nativeQuery = true)
    // List<UsuarioEntity>findAll();

    // @Query(value="select u.* from usuario u where email like concat(:email, '%')", nativeQuery = true)
    // List<UsuarioEntity>findUsuarioByEmail(@Param("email")String email);
}
