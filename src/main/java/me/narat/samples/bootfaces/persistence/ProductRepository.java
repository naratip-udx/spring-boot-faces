package me.narat.samples.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import me.narat.samples.bootfaces.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
