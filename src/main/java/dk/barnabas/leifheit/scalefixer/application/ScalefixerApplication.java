package dk.barnabas.leifheit.scalefixer.application;

import dk.barnabas.leifheit.scalefixer.model.jpa.Weight;
import dk.barnabas.leifheit.scalefixer.service.WeightService;
import dk.barnabas.leifheit.scalefixer.service.WeightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@EnableAutoConfiguration
@ComponentScan("dk.barnabas.leifheit.scalefixer.service")
@EntityScan("dk.barnabas.leifheit.scalefixer.model.jpa")
@EnableJpaRepositories("dk.barnabas.leifheit.scalefixer.model.repository")
@RequestMapping("/devicedataservice")
public class ScalefixerApplication {

    @Autowired
    private WeightService weightService;

    public static void main(String[] args) {
        SpringApplication.run(ScalefixerApplication.class, args);
    }

/*    @RequestMapping("/")
    @Produces({ MediaType.TEXT_HTML})
    public String getSlash() {
        return "Miller time ..";
    } */

    @RequestMapping(value= "/dataservice", method = RequestMethod.PUT)
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public ResponseEntity<?> registerWeight(@RequestParam(name = "data") String data) {
        System.out.print(data);
        Weight weight = weightService.registerWeight(data);

        return new ResponseEntity<>(weight, HttpStatus.OK);
    }

    @RequestMapping(value= "/dataservice", method = RequestMethod.GET)
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public ResponseEntity<?> getWeight(@RequestParam(name = "id") Long id) {

        Weight weight = weightService.getWeight(id);

        return new ResponseEntity<>(weight, HttpStatus.OK);
    }

}
