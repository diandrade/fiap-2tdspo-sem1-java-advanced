package com.fiap.tdspo.toys.api.controller;

import com.fiap.tdspo.toys.api.dto.request.BrinquedoRequestDTO;
import com.fiap.tdspo.toys.api.dto.response.BrinquedoResponseDTO;
import com.fiap.tdspo.toys.domain.service.BrinquedoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService service;

    @GetMapping
    public ResponseEntity<List<BrinquedoResponseDTO>> listarBrinquedos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrinquedoResponseDTO> consultarBrinquedoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<BrinquedoResponseDTO> criarBrinquedo(@RequestBody @Valid BrinquedoRequestDTO dto) {
        BrinquedoResponseDTO response = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrinquedoResponseDTO> atualizarBrinquedo(
            @PathVariable Long id,
            @RequestBody @Valid BrinquedoRequestDTO dto) {
        BrinquedoResponseDTO response = service.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirBrinquedo(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}