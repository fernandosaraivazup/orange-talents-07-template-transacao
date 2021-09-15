package br.com.zupacademy.fpsaraiva.microservicetransacao.consultacompras;

import br.com.zupacademy.fpsaraiva.microservicetransacao.transacao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findById(String id);
}
