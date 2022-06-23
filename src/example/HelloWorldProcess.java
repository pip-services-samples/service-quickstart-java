package example;

import org.pipservices3.container.ProcessContainer;
import org.pipservices3.rpc.build.DefaultRpcFactory;

public class HelloWorldProcess extends ProcessContainer {
    public HelloWorldProcess() {
        super("hello-world", "HelloWorld microservice");
        this._configPath = "./config.yml";
        this._factories.add(new HelloWorldServiceFactory());
        this._factories.add(new DefaultRpcFactory());
    }
}
