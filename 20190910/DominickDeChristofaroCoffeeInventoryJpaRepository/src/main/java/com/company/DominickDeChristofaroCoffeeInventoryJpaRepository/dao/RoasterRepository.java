package com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dao;
import com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster, Integer> {
}
