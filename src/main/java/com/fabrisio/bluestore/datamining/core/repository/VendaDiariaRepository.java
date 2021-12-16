package com.fabrisio.bluestore.datamining.core.repository;

import com.fabrisio.bluestore.datamining.core.VendaDiariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaDiariaRepository extends JpaRepository<VendaDiariaEntity, UUID> {

}
