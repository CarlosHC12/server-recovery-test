package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.ProductoEntity;

@Repository
public interface ProductoEntityJpaRepository extends JpaRepository<ProductoEntity, Integer>{
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

    public ProductoEntity findByNombre(String nombre);
}