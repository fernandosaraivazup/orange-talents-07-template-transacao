package br.com.zupacademy.fpsaraiva.microservicetransacao.consultacompras;

import br.com.zupacademy.fpsaraiva.microservicetransacao.config.ApiErroException;
import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.Cartao;
import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public String listarTransacoes(@PathVariable("id") String id) {

        Optional<Cartao> cartaoBuscado = cartaoRepository.findById(id);
        if(cartaoBuscado.isEmpty()) {
            throw new ApiErroException(HttpStatus.NOT_FOUND, "Não foi encontrado nenhum cartão com o ID informado.");
        }

        return "Cartao encontrado";
    }

}
