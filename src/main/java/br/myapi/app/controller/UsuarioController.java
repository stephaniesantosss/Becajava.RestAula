package br.myapi.app.controller;

import br.myapi.app.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@PostMapping
	public ResponseEntity criar(@RequestBody Usuario usuario) {
		if (usuario.getEndereco() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço não informado.");
		else if (usuario.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
		else if (usuario.getIdade() < 18)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("O usuário não poderá ser uma pessoa menor de idade.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
	}

	@GetMapping
	public ResponseEntity listar() {

		List<Usuario> lista = new ArrayList<Usuario>();

		Usuario u = new Usuario();
		u.setNome("João");
		u.setIdade(69);
		u.setEndereco("Rua xyz, 900");
		lista.add(u);

		u = new Usuario();
		u.setNome("Maria");
		u.setIdade(59);
		u.setEndereco("Rua abc, 200");
		lista.add(u);

		u = new Usuario();
		u.setNome("Eduarda está dormindo");
		u.setIdade(29);
		u.setEndereco("Rua não sei, 100");
		lista.add(u);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Usuario u = new Usuario();
		u.setNome("Eduarda está dormindo");
		u.setIdade(29);
		u.setEndereco("Rua não sei, 100");

		return ResponseEntity.status(HttpStatus.OK).body(u);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
