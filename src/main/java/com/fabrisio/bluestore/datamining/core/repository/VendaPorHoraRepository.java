package com.fabrisio.bluestore.datamining.core.repository;

import com.fabrisio.bluestore.datamining.core.VendaPorHoraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaPorHoraRepository extends JpaRepository<VendaPorHoraEntity, UUID> {
}
