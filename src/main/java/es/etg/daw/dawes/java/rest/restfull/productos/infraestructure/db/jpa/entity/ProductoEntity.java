package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "PRODUCTOS")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Basic(optional=true)
    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "peso", precision = 10, scale = 3)
    private BigDecimal peso;

    @Column(name = "altura", precision = 10, scale = 2)
    private BigDecimal altura;

    @Column(name = "anchura", precision = 10, scale = 2)
    private BigDecimal anchura;

    @Column(name = "profundidad", precision = 10, scale = 2)
    private BigDecimal profundidad;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    // Relación Many-to-One: Es el lado propietario (tendrá la FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false) // Columna de clave foránea en la tabla PRODUCTO
    private CategoriaEntity categoria;

    // --- Constructores ---
    public ProductoEntity() {
    }

    // Constructor con campos (simplificado)
    public static Producto toDomain(ProductoEntity e) {
    return Producto.builder()
            .id(e.getId() != null ? new ProductoId(e.getId()) : null)
            .nombre(e.getNombre())
            .precio(e.getPrecio().doubleValue())
            .createdAt(e.getFechaCreacion())
            .categoria(new CategoriaId(e.getCategoria().getId()))
            .build();
}
    
}