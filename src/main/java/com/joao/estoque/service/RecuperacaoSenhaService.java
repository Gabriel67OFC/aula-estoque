package com.joao.estoque.service;

import com.joao.estoque.model.Usuario;
import com.joao.estoque.model.UsuarioDAO;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;
import java.util.Random;

public class RecuperacaoSenhaService {
    private Usuario usuarioAlvo;

    private String codigoGerado;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public RecuperacaoSenhaService() {
    }

    public String solicitarRecuperacao(String email) {

        Optional<Usuario> usuarioEncontrado = usuarioDAO.buscarPorEmail(email);
        if (usuarioEncontrado.isEmpty()) {
            return null;
        }

        this.codigoGerado = gerarCodigo();
        this.usuarioAlvo = usuarioEncontrado.get();

        return this.codigoGerado;
    }

    private String gerarCodigo() {
        int codigo = new Random().nextInt(900_000) + 100_00;
        return String.valueOf(codigo);
    }

    public boolean validarCodigo(String codigoDigitado) {
        return codigoGerado != null && usuarioAlvo != null && codigoGerado.equals(codigoDigitado);
    }

    public boolean redefinirSenha(String novaSenha) {
        if (usuarioAlvo == null) {
            return false;
        }

        return BCrypt.checkpw(novaSenha, usuarioAlvo.getSenha());
    }

    public void encerrarFluxo() {
        this.usuarioAlvo = null;
        this.codigoGerado = null;
    }
}
