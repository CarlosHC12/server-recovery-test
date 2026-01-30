package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "CATEGORIAS")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Relación One-to-Many: Lado no propietario
    // Mapeada por el campo "categoria" en la entidad Producto.
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoEntity> productos = new ArrayList<ProductoEntity>();

    // --- Constructores ---

    public CategoriaEntity() {
    }

    public CategoriaEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //Métodos auxiliares para sincronizra productos y categorias
    public void addProducto(ProductoEntity producto) {
        this.productos.add(producto);
        producto.setCategoria(this); // Sincroniza el lado Producto
    }

    public void removeProducto(ProductoEntity producto) {
        this.productos.remove(producto);
        producto.setCategoria(null); // Desvincula el Producto
    }
}