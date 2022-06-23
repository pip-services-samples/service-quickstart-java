package example;

import org.pipservices3.commons.config.ConfigParams;
import org.pipservices3.commons.config.IConfigurable;
import org.pipservices3.commons.errors.ConfigException;

public class HelloWorldController implements IConfigurable {
    private String _defaultName;

    public HelloWorldController() {
        this._defaultName = "Pip User";
    }


    @Override
    public void configure(ConfigParams config) throws ConfigException {
        this._defaultName = config.getAsStringWithDefault("default_name", this._defaultName);
    }

    public String greeting(String name) {
        return "Hello, " + (name != null ? name : this._defaultName) + "!";
    }
}
