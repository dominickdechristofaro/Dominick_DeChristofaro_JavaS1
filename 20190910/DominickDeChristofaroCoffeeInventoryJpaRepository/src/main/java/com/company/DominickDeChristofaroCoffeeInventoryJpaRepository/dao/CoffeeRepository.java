package com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dao;
import com.company.DominickDeChristofaroCoffeeInventoryJpaRepository.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer>  {
    List<Coffee> findCoffeeByRoasterId(int roaster_id);
    List<Coffee> findCoffeeByType(String type);
    List<Coffee> findCoffeeByRoasterIdAndType(int roaster_id, String type);
}
