package br.com.zupacademy.fpsaraiva.microservicetransacao.transacao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoDto {

    @NotBlank
    private String id;

    @NotBlank
    @Email
    private String email;

    @Deprecated
    public CartaoDto() {
    }

    public CartaoDto(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }

}
