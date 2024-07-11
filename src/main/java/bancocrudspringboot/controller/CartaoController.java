package bancocrudspringboot.controller;

import bancocrudspringboot.model.Cartao;
import bancocrudspringboot.model.Usuario;
import bancocrudspringboot.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CartaoController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CartaoRepository cartaoRepository;

	@GetMapping("/cartoes")
	@ResponseStatus(HttpStatus.OK)
	public List<Cartao> buscarCartoesUsuario(@RequestBody Usuario usuario) {
		return this.cartaoRepository.findCartaoByUsuario(usuario.getId());
	}

	@PostMapping("/cartoes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cartao adicionarCartao(@RequestBody Cartao cartao){
		return this.cartaoRepository.save(cartao);
	}
}