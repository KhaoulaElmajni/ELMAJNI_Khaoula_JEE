package me.khaoula.ecom.repositories;

import me.khaoula.ecom.entities.Category;
import me.khaoula.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
