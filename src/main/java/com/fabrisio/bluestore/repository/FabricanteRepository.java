package com.fabrisio.bluestore.repository;

import com.fabrisio.bluestore.entity.FabricanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FabricanteRepository extends JpaRepository<FabricanteEntity, UUID> {
    List<FabricanteEntity> findByNomeIsContaining(String query);
}
