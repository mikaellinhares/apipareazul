package bancocrudspringboot.controller;

import bancocrudspringboot.model.Cartao;
import bancocrudspringboot.repository.CartaoRepository;
import bancocrudspringboot.model.Usuario;
import bancocrudspringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CartaoRepository cartaoRepository;

	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getAllCadastros() {
		return this.usuarioRepository.findAll();
	}

	//
	public class AdicionarSaldoRequest {
		private Long usuario;
		private Long cartao;
		private Double valor;
	
		// Getters e Setters
		// Usuario
		public Long getUsuario() {
			return usuario;
		}
	
		public void setUsuario(Long usuario) {
			this.usuario = usuario;
		}

		// Cartao
		public Long getCartao() {
			return cartao;
		}
	
		public void setCartao(Long cartao) {
			this.cartao = cartao;
		}
		
		// Valor
		public Double getValor() {
			return valor;
		}
	
		public void setValor(Double valor) {
			this.valor = valor;
		}
	}

	@PutMapping("/usuarios/saldo/adicionar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Usuario> adicionarSaldo(@RequestBody AdicionarSaldoRequest dados){
		Optional<Usuario> usuario = this.usuarioRepository.findById(dados.usuario);
		Optional<Cartao> cartao = this.cartaoRepository.findById(dados.cartao);

		List<Cartao> cartoesUsuario = this.cartaoRepository.findCartaoByUsuario(dados.usuario);

		if (cartoesUsuario.contains(cartao) != true) {
			System.out.println("Cartão não cadastrado para o usuário");
		}
		
		usuario.setSaldo(dados.valor);
		ResponseEntity.ok(this.cartaoRepository.save(cadastro));
		
		return this.usuarioRepository.save(cartao);
	}
}