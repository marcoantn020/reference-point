package marcoantn020.referencepoint.config;

import marcoantn020.referencepoint.entity.PintOfInterest;
import marcoantn020.referencepoint.repository.PointOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {
    @Autowired
    private PointOfInterestRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.save(new PintOfInterest("Lanchonete", 27L, 12L));
        repository.save(new PintOfInterest("Posto", 31L, 18L));
        repository.save(new PintOfInterest("Joalheria", 15L, 12L));
        repository.save(new PintOfInterest("Floricultura", 19L, 21L));
        repository.save(new PintOfInterest("Pub", 12L, 8L));
        repository.save(new PintOfInterest("Supermercado", 23L, 6L));
        repository.save(new PintOfInterest("Churrascaria", 28L, 2L));
    }
}
