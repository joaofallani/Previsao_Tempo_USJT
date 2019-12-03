package br.usjt.PrevtempArq.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.PrevtempArq.model.Usuario;





public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findOneByLoginAndSenha (String login, String senha);

}
