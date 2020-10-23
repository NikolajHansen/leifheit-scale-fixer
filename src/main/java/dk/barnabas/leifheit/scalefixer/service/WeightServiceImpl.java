package dk.barnabas.leifheit.scalefixer.service;

import dk.barnabas.leifheit.scalefixer.model.jpa.Weight;
import dk.barnabas.leifheit.scalefixer.model.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class WeightServiceImpl implements WeightService {
    @Autowired
    WeightRepository weightRepository;

    public Weight registerWeight(
            String data) {
        System.out.println(data);
        Weight weight = new Weight();
        weight.setData(data);
        weight.setCreatedDate(new Date());
        weightRepository.save(weight);
        return weight;
    }

    @Override
    public Weight getWeight(Long id) {
        return weightRepository.getOne(id);
    }

}
