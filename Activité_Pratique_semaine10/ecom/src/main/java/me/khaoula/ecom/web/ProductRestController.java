package me.khaoula.ecom.web;

import me.khaoula.ecom.dtos.ProductDTO;
import me.khaoula.ecom.entities.Product;
import me.khaoula.ecom.repositories.ProductRepository;
import me.khaoula.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    /**
     * Restful API 5 regles
     * 1 les URI
     * 2 les methodes http comme identifiant des operations (GET/PUT/POST/PUT/DELETE/PATCH)
     * PATCH ==> modifier que les shamps mentionnés
    * */
    @GetMapping("/products")
    public List<ProductDTO> productList(){
        return productService.lisProducts();
    }

    /**
     *
    * */
    @GetMapping("/products/{id}")
    public  Product getProduct(@PathVariable(name="id") String id){
        return productRepository.findById(id).get();
    }

    @PostMapping("/products")
    public  ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping("/products/{id}")
    public  Product updateProduct(@RequestBody Product product,@PathVariable String id){
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id){
         productRepository.deleteById(id);
    }
}
