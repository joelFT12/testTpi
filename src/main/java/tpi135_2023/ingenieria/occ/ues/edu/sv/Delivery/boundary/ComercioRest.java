package tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.boundary;
import tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.boundary.RestResourcePattern;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.boundary.ComercioBean;
import tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.boundary.ComercioBean;
import tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.boundary.ComercioBean;
import tpi135_2023.ingenieria.occ.ues.edu.sv.Delivery.entity.Comercio;

/**
 *
 * @author CENTRA
 */
@Path("comercio")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComercioRest {

    @Inject
    ComercioBean comerciobean;

    @GET
    public List<Comercio> listAll() {
        return comerciobean.ListAll();
    }

    @POST
    public Response Insertar(Comercio comercio) {
        if (comercio != null) {
            try {
                comerciobean.InsertarComercio(comercio);
                return Response.status(Response.Status.CREATED).entity(comercio).build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/{id}")
    public Response FindID(@PathParam("id") Long id) {
        try {
            Comercio nuevo = new Comercio(id);
            Comercio encontrado = comerciobean.findcomercioById(nuevo);
            if (encontrado == null) {
                return Response.status(Response.Status.NOT_FOUND).header(RestResourcePattern.ID_NOT_FOUND, Collections.EMPTY_LIST).build();
            }
            return Response.ok().entity(encontrado).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).header(RestResourcePattern.WRONG_PARAMETER, Collections.EMPTY_LIST).build();
        }

    }
}
