package me.khaoula.ecom.repositories;

import me.khaoula.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {

}
