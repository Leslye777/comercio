package com.gerenciamento.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.entities.Colaborador;
import com.gerenciamento.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorResource {

    @Autowired
    ColaboradorService colaboradorService;
    
    @PostMapping
    public ResponseEntity<Colaborador> adicionarColaborador(@RequestBody Colaborador colaborador) {
        Colaborador colaboradorSalvo = colaboradorService.salvarColaborador(colaborador);
        return new ResponseEntity<>(colaboradorSalvo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerColaborador(@PathVariable Long id) {
        colaboradorService.removerColaborador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador) {
    	colaborador.setId(id);
        Colaborador colaboradorAtualizado = colaboradorService.atualizarColaborador(colaborador);
        return new ResponseEntity<>(colaboradorAtualizado, HttpStatus.OK);
    }
    
    @GetMapping("/admitidos-no-ano/{ano}")
    public ResponseEntity<List<Colaborador>> buscarPorAnoAdmissao(@PathVariable int ano) {
        List<Colaborador> colaboradores = colaboradorService.buscarPorAnoAdmissao(ano);
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarPorId(@PathVariable Long id) {
        Colaborador colaborador = colaboradorService.buscarPorId(id).get();
        return new ResponseEntity<>(colaborador, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Colaborador>> encontrarTodos() {
        List<Colaborador> colaboradores = colaboradorService.buscarTodos();
        return new ResponseEntity<>(colaboradores, HttpStatus.OK);
    }
}
