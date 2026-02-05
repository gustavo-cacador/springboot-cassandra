package br.com.gustavo.cassandra.business;

import br.com.gustavo.cassandra.dto.DepartmentDTO;
import br.com.gustavo.cassandra.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("departments")
public class DepartmentBusiness {

    private final DepartmentService departmentService;

    public DepartmentBusiness(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> buscarTodos() {
        List<DepartmentDTO> list = departmentService.buscarTodos();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> buscarPorId(@PathVariable UUID id) {
        DepartmentDTO obj = departmentService.buscarPorId(id);
        return ResponseEntity.ok(obj);
    }
}
