package org.example.services;

import org.example.entities.Usuario;
import org.example.repositorio.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void saveUsuario(Usuario usuario) {
        // Cifrar la contraseña antes de guardarla
        String encodedPassword = passwordEncoder.encode(usuario.getContraseña());
        usuario.setContraseña(encodedPassword);
        usuarioRepository.saveUsuario(usuario);
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.getUsuarioById(id);
    }

    public Usuario login(String email, String password) throws Exception {
        Usuario usuario = usuarioRepository.getUsuarioByEmail(email);
        if (usuario == null || !passwordEncoder.matches(password, usuario.getContraseña())) {
            throw new Exception("Credenciales incorrectas");
        }
        return usuario;
    }
}
