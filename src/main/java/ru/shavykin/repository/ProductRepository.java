package ru.shavykin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.shavykin.model.Product;

import java.util.List;


@RepositoryRestResource
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Product> findByQuantityLessThan(Integer quantity);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    <S extends Product> S save(S s);
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    void deleteById(Long aLong);

    List<Product> findByName (String name);
    List<Product> findByBrand (String brand);

}


