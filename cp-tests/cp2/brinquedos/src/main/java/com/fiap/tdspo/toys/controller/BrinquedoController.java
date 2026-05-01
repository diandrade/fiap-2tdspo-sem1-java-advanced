package com.fiap.tdspo.toys.controller;

import com.fiap.tdspo.toys.model.Brinquedo;
import com.fiap.tdspo.toys.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository repository;

    @GetMapping
    public List<Brinquedo> listarBrinquedos() {
        return repository.findAll();
    }

    @PostMapping
    public Brinquedo criarBrinquedo(@RequestBody Brinquedo brinquedo) {
        return repository.save(brinquedo);
    }

    @PutMapping("/{id}")
    public Brinquedo atualizarBrinquedo(@PathVariable Long id, @RequestBody Brinquedo brinquedo) {
        Brinquedo brinquedoExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Brinquedo não encontrado com ID: " + id));

        brinquedoExistente.setNome(brinquedo.getNome());
        brinquedoExistente.setTipo(brinquedo.getTipo());
        brinquedoExistente.setClassificacao(brinquedo.getClassificacao());
        brinquedoExistente.setTamanho(brinquedo.getTamanho());
        brinquedoExistente.setPreco(brinquedo.getPreco());

        return repository.save(brinquedoExistente);
    }

    @DeleteMapping("/{id}")
    public void excluirBrinquedo(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Brinquedo consultarBrinquedoPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Brinquedo não encontrado com ID: " + id));
    }
}