package dk.barnabas.leifheit.scalefixer.service;

import dk.barnabas.leifheit.scalefixer.exception.WeightNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WeightNotFoundHandler implements ExceptionMapper<WeightNotFoundException> {
        public Response toResponse(WeightNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
}
