package com.gerenciamento.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciamento.entities.Colaborador;
import com.gerenciamento.respository.ColaboradorRepository;

@Service
@Transactional
public class ColaboradorService {
	private final ColaboradorRepository colaboradorRepository;

	@Autowired
	public ColaboradorService(ColaboradorRepository colaboradorRepository) {
		this.colaboradorRepository = colaboradorRepository;
	}

	public Colaborador salvarColaborador(Colaborador colaborador) {
		System.out.println("teste");
		
		if(colaborador.getGerente()!=null) {
			if (colaboradorRepository.findById(colaborador.getGerente().getId()).isEmpty()) {
				throw new EntityNotFoundException("Colaborador nao encontrado");
			}
		}
		
		return colaboradorRepository.save(colaborador);
	}

	public void removerColaborador(Long id) {
		colaboradorRepository.deleteById(id);
	}

	public Colaborador atualizarColaborador(Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	}

	public List<Colaborador> buscarPorAnoAdmissao(int ano) {
		LocalDate dataInicial = LocalDate.of(ano, 1, 1);
		LocalDate dataFinal = LocalDate.of(ano, 12, 31);
		return colaboradorRepository.findByDataAdmissaoBetween(dataInicial, dataFinal);
	}

	public Optional<Colaborador> buscarPorId(Long id) {
		System.out.println("Teste");
		return colaboradorRepository.findById(id);

	}

	public List<Colaborador> buscarTodos() {
		return colaboradorRepository.findAll();
	}
}
