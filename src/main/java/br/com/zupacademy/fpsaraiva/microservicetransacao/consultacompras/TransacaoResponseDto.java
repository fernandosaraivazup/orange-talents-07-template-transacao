package br.com.zupacademy.fpsaraiva.microservicetransacao.consultacompras;

import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponseDto {

    private String id;

    private BigDecimal valor;

    private EstabelecimentoResponse estabelecimento;

    private CartaoResponse cartao;

    private LocalDateTime efetivadaEm;

    public TransacaoResponseDto(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
        this.cartao = new CartaoResponse(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public static Page<TransacaoResponseDto> toList(Page<Transacao> page){
        return page.map(TransacaoResponseDto::new);
    }

}
