package br.com.zupacademy.fpsaraiva.microservicetransacao.transacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    @NotBlank
    private String id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private EstabelecimentoDto estabelecimento;

    @NotNull
    private CartaoDto cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoDeTransacao() {
    }

    public EventoDeTransacao(String id, BigDecimal valor, EstabelecimentoDto estabelecimento, CartaoDto cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(this.id, this.valor, this.estabelecimento.toModel(), this.cartao.toModel(), this.efetivadaEm);
    }

}
