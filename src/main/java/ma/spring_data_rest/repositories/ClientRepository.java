package ma.spring_data_rest.repositories;


import ma.spring_data_rest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository  extends JpaRepository<Client, Long> {}
