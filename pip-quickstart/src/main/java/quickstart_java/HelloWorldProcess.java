
package quickstart_java;

import org.pipservices3.container.ProcessContainer;

class HelloWorldProcess extends ProcessContainer {
  HelloWorldProcess() {
  super("hello-world", "HelloWorld microservice"); 
    this._configPath = "./config.yml";
    this._factories.add(new HelloWorldServiceFactory());
    this._factories.add(new DefaultRpcFactory());
  }
}
