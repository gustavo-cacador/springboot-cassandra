package br.com.gustavo.cassandra.business;

import br.com.gustavo.cassandra.dto.ProductDTO;
import br.com.gustavo.cassandra.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductBusiness {

    private final ProductService productService;

    public ProductBusiness(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> buscarPorId(@PathVariable UUID id) {
        ProductDTO obj = productService.buscarPorId(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findByDepartment(
            @RequestParam(name = "department", defaultValue = "") String department) {
        List<ProductDTO> list = productService.findByDepartment(department);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/description")
    public ResponseEntity<List<ProductDTO>> findByDescription(
            @RequestParam(name = "text", defaultValue = "") String text) {
        List<ProductDTO> list = productService.findByDescription(text);
        return ResponseEntity.ok(list);
    }
}
