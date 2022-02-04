package com.devpedrod.JavaTest.repository;

import com.devpedrod.JavaTest.domain.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {
    Frete findByCepDestinoAndCepOrigemAndNomeDestinatario(String cepDestino, String cepOrigem, String nomeDestinatario);
}
