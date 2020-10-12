package quickstart_java;

import org.pipservices3.commons.config.ConfigParams;
import org.pipservices3.commons.config.IConfigurable;
import org.pipservices3.commons.errors.ApplicationException;
import org.pipservices3.commons.errors.ConfigException;
import org.pipservices3.commons.refer.IReferenceable;
import org.pipservices3.commons.refer.IReferences;
import org.pipservices3.commons.refer.ReferenceException;
import org.pipservices3.commons.run.*;
import org.pipservices3.components.log.CompositeLogger;

class HelloWorldController implements IConfigurable {
  var defaultName;
  HelloWorldController() {
    defaultName = "Pip User";
  }

  @Override
  void configure(ConfigParams config) {
    defaultName = config.getAsStringWithDefault("default_name", defaultName);
  }

  Future<String> greeting(name string) {
    return "Hello, " + (name ?? defaultName) + "!";
  }
}
