package com.fiap.tdspo.toys.domain.repository;

import com.fiap.tdspo.toys.domain.model.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {
}