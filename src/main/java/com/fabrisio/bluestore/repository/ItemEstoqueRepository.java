package com.fabrisio.bluestore.repository;

import com.fabrisio.bluestore.entity.ItemEstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemEstoqueRepository extends JpaRepository<ItemEstoqueEntity, UUID> {

    ItemEstoqueEntity findByIdProduto(UUID id);

}
