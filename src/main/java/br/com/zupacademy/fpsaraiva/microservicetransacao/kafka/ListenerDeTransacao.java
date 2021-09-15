package br.com.zupacademy.fpsaraiva.microservicetransacao.kafka;

import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.EventoDeTransacao;
import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.Transacao;
import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository repository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {

        Transacao transacao = eventoDeTransacao.toModel();
        repository.save(transacao);
    }

}