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
        Department entity = getById(id);
        return new DepartmentDTO(entity);
    }

    private Department getById(UUID id) {
        Optional<Department> result = departmentRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

    public DepartmentDTO inserir(DepartmentDTO dto) {
        Department entity = new Department();
        entity.setId(UUID.randomUUID());
        copyDtoToEntity(dto, entity);
        entity = departmentRepository.save(entity);
        return new DepartmentDTO(entity);
    }

    public DepartmentDTO atualizar(UUID id, DepartmentDTO dto) {
        Department entity = getById(id);
        copyDtoToEntity(dto, entity);
        entity = departmentRepository.save(entity);
        return new DepartmentDTO(entity);
    }

    public void deletarPorId(UUID id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id inexistente");
        }
        departmentRepository.deleteById(id);
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
        entity.setName(dto.getName());
    }
}
