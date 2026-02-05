package br.com.gustavo.cassandra.services;

import br.com.gustavo.cassandra.bean.Department;
import br.com.gustavo.cassandra.dto.DepartmentDTO;
import br.com.gustavo.cassandra.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDTO> findAll() {
        List<Department> list = departmentRepository.findAll();
        return list.stream().map(DepartmentDTO::new).collect(Collectors.toList());
    }
}
