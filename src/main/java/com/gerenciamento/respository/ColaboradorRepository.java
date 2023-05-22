package com.gerenciamento.respository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciamento.entities.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    List<Colaborador> findByDataAdmissaoBetween(LocalDate dataInicial, LocalDate dataFinal);

    @Query("SELECT c.id FROM Colaborador c WHERE c.cpf = :cpf")
    Long findGerenteIdByCpf(@Param("cpf") String cpf);
}
