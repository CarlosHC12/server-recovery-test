package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.CategoriaRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.CategoriaResponse;

public class CategoriaMapper {

    public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest){
        return new CreateCategoriaCommand(categoriaRequest.nombre());
    }
    public static EditCategoriaCommand toCommand(int id, CategoriaRequest categoriaRequest){
        return new EditCategoriaCommand(new CategoriaId(id),categoriaRequest.nombre());
    }
    public static CategoriaResponse toResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getId().getValue(),
                                      categoria.getNombre(),
                                      categoria.getCreatedAt());
    }
    
}



