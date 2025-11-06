package ma.spring_data_rest;

import ma.spring_data_rest.entities.Client;
import ma.spring_data_rest.entities.Compte;
import ma.spring_data_rest.entities.TypeCompte;
import ma.spring_data_rest.repositories.ClientRepository;
import ma.spring_data_rest.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class SpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository,
                            RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class);

            Client c1 = clientRepository.save(new Client(null, "Amal", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", null));

            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });

        };
    }
}
