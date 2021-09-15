package br.com.zupacademy.fpsaraiva.microservicetransacao.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
