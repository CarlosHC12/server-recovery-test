package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.ProductoEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoResponse;


public class ProductoMapper {

    public static ProductoEntity toEntity(Producto p){

        // Defino la categoría
        CategoriaEntity cat = new CategoriaEntity();
        cat.setId(p.getCategoria().getValue());
        ProductoId id = p.getId();
        return ProductoEntity.builder().id(id!=null?id.getValue():null)
                                        .nombre(p.getNombre())
                                       .precio(new BigDecimal(p.getPrecio()))
                                       .fechaCreacion(p.getCreatedAt())
                                       .categoria(cat)
                                       .build();

    }

    public static CreateProductoCommand toCommand(ProductoRequest req){
        return new CreateProductoCommand(req.nombre(), req.precio(), new CategoriaId(req.categoriaId()));
    }

    public static EditProductoCommand toCommand(int id, ProductoRequest req){
        return new EditProductoCommand(new ProductoId(id), req.nombre(), req.precio(), new CategoriaId(req.categoriaId()));
    }

    public static ProductoResponse toResponse(Producto p){
        return new ProductoResponse(p.getId().getValue(), p.getNombre(), p.getPrecio(), p.getCreatedAt(), p.getCategoria().getValue());
    }

    public static Producto toDomain(ProductoEntity p){
        return Producto.builder().id(new ProductoId(p.getId()))
                                 .nombre(p.getNombre())
                                 .precio(p.getPrecio().doubleValue())
                                 .createdAt(p.getFechaCreacion())
                                 .categoria(new CategoriaId(p.getCategoria().getId()))
                                 .build();

    }

    public static List<Producto> toDomain(List<ProductoEntity> lista){
        List<Producto> lp = new ArrayList<>();
        for(ProductoEntity pe: lista){
            lp.add(toDomain(pe));
        }
        return lp;
    }
}
