package br.com.gustavo.cassandra.repositories;

import br.com.gustavo.cassandra.bean.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
