package com.me;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UserController {

  Map<Integer, Usuario> usuariosBancoDados = new HashMap<>();
  private Integer ids = 1;

  public UserController() {
    Usuario usuario = new Usuario("Zé", "ze@gmail.com", "ze123", ids++);
    usuariosBancoDados.put(usuario.getId(), usuario);
  }

  @GetMapping
  public ResponseEntity buscarUsuarios() {
    return ResponseEntity.ok(usuariosBancoDados.values());
  }

  @GetMapping("/{id}")
  public ResponseEntity buscarUsuario(@PathVariable Integer id) {
    Usuario usuario = usuariosBancoDados.get(id);
    if(null == usuario){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(usuario);
  }

  @PostMapping
  public ResponseEntity adicionarUsuario(@RequestBody Usuario usuario) throws URISyntaxException {
    usuario.setId(ids++);
    usuariosBancoDados.put(usuario.getId(), usuario);
    return ResponseEntity.created(new URI("/usuarios/" + usuario.getId())).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity updateUsuario(@PathVariable Integer id,@RequestBody Usuario usuario) {
    if (usuariosBancoDados.containsKey(id)) {
      usuario.setId(id);
      usuariosBancoDados.put(id, usuario);
    } else {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUsuario(@PathVariable Integer id) {
    if (usuariosBancoDados.containsKey(id)) {
      Usuario usuario = usuariosBancoDados.remove(id);
      if (null != usuario) {
        return ResponseEntity.ok(usuario);
      }
    }
    return ResponseEntity.notFound().build();
  }

}
