package br.com.gustavo.cassandra.services;

import br.com.gustavo.cassandra.bean.Product;
import br.com.gustavo.cassandra.dto.ProductDTO;
import br.com.gustavo.cassandra.repositories.ProductRepository;
import br.com.gustavo.cassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO buscarPorId(UUID id) {
        Product entity = getById(id);
        return new ProductDTO(entity);
    }

    private Product getById(UUID id) {
        Optional<Product> result = productRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }
}
