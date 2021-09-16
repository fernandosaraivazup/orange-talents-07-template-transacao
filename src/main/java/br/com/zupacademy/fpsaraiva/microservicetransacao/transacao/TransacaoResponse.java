package br.com.zupacademy.fpsaraiva.microservicetransacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;

    private BigDecimal valor;

    private Estabelecimento estabelecimento;

    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento();
        this.cartao = transacao.getCartao();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

}
