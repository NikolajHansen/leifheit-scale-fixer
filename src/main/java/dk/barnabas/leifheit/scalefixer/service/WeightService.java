package dk.barnabas.leifheit.scalefixer.service;

import dk.barnabas.leifheit.scalefixer.model.jpa.Weight;
import org.jvnet.hk2.annotations.Service;
import org.springframework.context.annotation.Bean;

public interface WeightService {
    public Weight registerWeight(String data);

    public Weight getWeight(Long id);
}
