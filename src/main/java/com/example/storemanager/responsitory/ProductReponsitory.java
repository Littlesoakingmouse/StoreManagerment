package com.example.storemanager.responsitory;
import com.example.storemanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReponsitory extends JpaRepository<Product, Integer>{
    @Query(value = "SELECT price FROM product ORDER BY price DESC LIMIT 1 OFFSET :offset", nativeQuery = true)
    Double findNthLargestPrice(@Param("offset") int offset);
}
