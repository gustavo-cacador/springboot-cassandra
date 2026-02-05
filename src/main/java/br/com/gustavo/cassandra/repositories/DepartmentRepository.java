package br.com.gustavo.cassandra.repositories;

import br.com.gustavo.cassandra.bean.Department;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface DepartmentRepository extends CassandraRepository<Department, UUID> {
}
