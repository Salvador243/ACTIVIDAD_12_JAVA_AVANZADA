package net.codejava.repositories;

import net.codejava.entity.Product;
import net.codejava.entity.Triangulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrRepository extends JpaRepository<Triangulo, Long>{
}
