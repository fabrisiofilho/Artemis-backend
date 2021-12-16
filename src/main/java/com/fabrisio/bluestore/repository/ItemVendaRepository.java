package com.fabrisio.bluestore.repository;

import com.fabrisio.bluestore.entity.ItemVendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVendaEntity, UUID> {
}
