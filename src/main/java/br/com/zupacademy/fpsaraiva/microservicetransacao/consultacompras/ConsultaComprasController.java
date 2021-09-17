package br.com.zupacademy.fpsaraiva.microservicetransacao.consultacompras;

import br.com.zupacademy.fpsaraiva.microservicetransacao.compartilhado.ApiErroException;
import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.Cartao;
import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.Transacao;
import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ConsultaComprasController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/cartoes/{id}")
    public ResponseEntity<?> listarTransacoes(@PathVariable("id") String id,
                                              @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, size = 10) Pageable pageable  ) {

        Optional<Cartao> cartaoBuscado = cartaoRepository.findById(id);
        if(cartaoBuscado.isEmpty()) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum cartão com o ID informado.");
        }

        Page<Transacao> transacoes = transacaoRepository.findByCartaoId(id, pageable);

        return ResponseEntity.ok(TransacaoResponseDto.toList(transacoes));
    }

}
