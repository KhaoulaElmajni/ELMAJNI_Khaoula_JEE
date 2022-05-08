package me.khaoula.ecom.service;

import me.khaoula.ecom.dtos.ProductDTO;
import me.khaoula.ecom.entities.Product;
import me.khaoula.ecom.mappers.CatalogMappers;
import me.khaoula.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CatalogMappers catalogMappers;

    @Override
    public ProductDTO save(ProductDTO productDTO){
      Product product = catalogMappers.fromProdcutDTO(productDTO);
      product.setId(UUID.randomUUID().toString());
      Product savedProduct = productRepository.save(product);
      return catalogMappers.fromProduct(savedProduct);
    }

    @Override
    public List<ProductDTO> lisProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS =
                products.stream().map(p->catalogMappers.fromProduct(p))
                        .collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public ProductDTO getProduct(String id) {
        Product product = productRepository.findById(id).
                orElseThrow(()->new RuntimeException("Product not found"));
        return catalogMappers.fromProduct(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = catalogMappers.fromProdcutDTO(productDTO);
        Product savedProduct = productRepository.save(product);
        return catalogMappers.fromProduct(savedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
