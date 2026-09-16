package com.jeffssousa.inventory_service.repository;

import com.jeffssousa.inventory_service.entity.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LogisticsRepository extends JpaRepository<Logistics, Long> {


    Optional<Logistics> findByOrderId(Long id);

}
