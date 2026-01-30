package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.ProductoEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductoJpaRepositoryImpl implements ProductoRepository{

    private final ProductoEntityJpaRepository repository;

    @Override
    public Producto save(Producto t) {

        ProductoEntity prod = ProductoMapper.toEntity(t);
        return ProductoMapper.toDomain(repository.save(prod));
    }

    @Override
    public List<Producto> getAll() {
        return ProductoMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Producto> getById(ProductoId id) {
        Optional<Producto> producto = null;
        Optional<ProductoEntity> pe = repository.findById(id.getValue());

        if(pe.isEmpty()){
            producto = Optional.empty();
        }else{
            producto = Optional.of(ProductoMapper.toDomain(pe.get()));
        }

        return producto;
    }


    @Override
    public void deleteById(ProductoId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

    @Override
    public Optional<Producto> getByName(String name) {
        ProductoEntity prod = repository.findByNombre(name);
        if(prod!=null)
            return Optional.of(ProductoMapper.toDomain(prod));
        else
            return Optional.empty() ;
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.
}