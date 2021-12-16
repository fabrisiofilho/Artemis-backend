package com.fabrisio.bluestore.datamining.core.repository;

import com.fabrisio.bluestore.datamining.core.VendaMensaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaMensaisRepository extends JpaRepository<VendaMensaisEntity, UUID> {
}
