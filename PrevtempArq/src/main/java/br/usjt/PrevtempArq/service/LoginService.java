package br.usjt.PrevtempArq.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.PrevtempArq.model.Usuario;
import br.usjt.PrevtempArq.repository.UsuarioRepository;



@Service
public class LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public boolean logar(Usuario usuario) {
        return usuarioRepository.findOneByLoginAndSenha(usuario.getLogin(), usuario.getSenha()) != null;
    }

}
