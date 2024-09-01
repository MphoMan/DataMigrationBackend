package com.example.DataMigration.repository;

import com.example.DataMigration.model.PlanningData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanningDataRepository extends JpaRepository<PlanningData, UUID> {
    // Add a method to check if the checksum exists in the database
    boolean existsByFileChecksum(String fileChecksum);
}
