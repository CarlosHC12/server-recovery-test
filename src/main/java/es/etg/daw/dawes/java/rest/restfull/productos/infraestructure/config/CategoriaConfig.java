package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.CreateCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.DeleteCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.EditCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.CreateCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.DeleteCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.EditCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria.FindCategoriaUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CategoriaConfig {
    
    private final CategoriaRepository categoriaRepository;

    @Bean
    public CreateCategoriaUseCase createCategoriaUseCase() {
        return new CreateCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public CreateCategoriaService createCategoriaService(){
        return new CreateCategoriaService(createCategoriaUseCase());
    }

    @Bean
    public FindCategoriaUseCase findCategoriaUseCase(){
        return new FindCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public FindCategoriaService findCategoriaService(){
        return new FindCategoriaService(findCategoriaUseCase());
    }

    @Bean
    public DeleteCategoriaUseCase deleteCategoriaUseCase(){
        return new DeleteCategoriaUseCase(categoriaRepository);
    }
    @Bean
    public DeleteCategoriaService deleteCategoriaService(){
        return new DeleteCategoriaService(deleteCategoriaUseCase());
    }

    @Bean
    public EditCategoriaUseCase editCategoriaUseCase() {
        return new EditCategoriaUseCase(categoriaRepository);
    }
    
    @Bean
    public EditCategoriaService editCategoriaService(){
        return new EditCategoriaService(editCategoriaUseCase());
    }    
}