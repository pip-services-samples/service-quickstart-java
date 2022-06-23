package example;

import org.pipservices3.commons.refer.Descriptor;
import org.pipservices3.components.build.Factory;

public class HelloWorldServiceFactory extends Factory {
    public HelloWorldServiceFactory() {
        super();
        this.registerAsType(
                new Descriptor("hello-world", "controller", "default", "*", "1.0"),
                HelloWorldController.class
        );
        this.registerAsType(
                new Descriptor("hello-world", "service", "http", "*", "1.0"),
                HelloWorldRestService.class
        );
    }
}
