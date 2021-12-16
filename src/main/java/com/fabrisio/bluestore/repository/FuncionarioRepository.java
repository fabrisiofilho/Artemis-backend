package com.fabrisio.bluestore.repository;

import com.fabrisio.bluestore.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, UUID> {

    Optional<FuncionarioEntity> findByNome(String nome);
    Optional<FuncionarioEntity> findByEmail(String email);

}
