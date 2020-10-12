package quickstart_java;

import org.pipservices3.components.build.Factory;
import org.pipservices3.commons.refer.*;

class HelloWorldServiceFactory extends Factory {
  HelloWorldServiceFactory() {
    registerAsType(
        new Descriptor("hello-world", "controller", "default", "*", "1.0"),
        HelloWorldController.class);
    registerAsType(new Descriptor("hello-world", "service", "http", "*", "1.0"),
        HelloWorldRestService.class);
  }
}
