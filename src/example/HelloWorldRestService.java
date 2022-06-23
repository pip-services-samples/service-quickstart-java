package example;

import jakarta.ws.rs.HttpMethod;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.process.Inflector;
import org.pipservices3.commons.errors.ConfigException;
import org.pipservices3.commons.refer.Descriptor;
import org.pipservices3.commons.refer.IReferences;
import org.pipservices3.commons.refer.ReferenceException;
import org.pipservices3.rpc.services.RestService;

import java.util.ArrayList;
import java.util.HashMap;

public class HelloWorldRestService extends RestService {

    private HelloWorldController _controller;

    public HelloWorldRestService() {
        super();
        this._baseRoute = "/hello_world";
        this._dependencyResolver.put("controller", new Descriptor("hello-world", "controller", "*", "*", "1.0"));
    }

    @Override
    public void setReferences(IReferences references) throws ReferenceException, ConfigException {
        super.setReferences(references);
        this._controller = this._dependencyResolver.getOneRequired(HelloWorldController.class, "controller");
    }

    @Override
    public void register() {
        this.registerRoute(HttpMethod.GET, "/greeting", new Inflector<ContainerRequestContext, Response>() {
            @Override
            public Response apply(ContainerRequestContext req) {
                var name = req.getUriInfo().getQueryParameters().getOrDefault("name", new ArrayList<>()).stream().findFirst();
                try {
                    var result = _controller.greeting(name.orElse(null));
                    return sendResult(result);
                } catch (Exception ex) {
                    return sendError(ex);
                }
            }
        });
    }
}
