package br.com.gustavo.cassandra.services;

import br.com.gustavo.cassandra.bean.Department;
import br.com.gustavo.cassandra.dto.DepartmentDTO;
import br.com.gustavo.cassandra.repositories.DepartmentRepository;
import br.com.gustavo.cassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDTO> buscarTodos() {
        List<Department> list = departmentRepository.findAll();
        return list
                .stream()
                .map(DepartmentDTO::new)
                .collect(Collectors.toList());
    }

    public DepartmentDTO buscarPorId(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new DepartmentDTO(department);
    }
}
