package br.com.gustavo.cassandra.business;

import br.com.gustavo.cassandra.dto.DepartmentDTO;
import br.com.gustavo.cassandra.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentBusiness {

    private final DepartmentService departmentService;

    public DepartmentBusiness(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> list = departmentService.findAll();
        return ResponseEntity.ok(list);
    }
}
