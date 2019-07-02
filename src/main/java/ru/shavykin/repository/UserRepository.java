package ru.shavykin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.shavykin.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}

