package quickstart_java;

class HelloWorldRestService extends RestService {
  HelloWorldController controller;

  HelloWorldRestService() {
    this._baseRoute = "/hello_world";
    this._dependencyResolver.put(
        "controller", Descriptor("hello-world", "controller", "*", "*", "1.0"));
  }

  @Override
  void setReferences(references) {
    super.setReferences(references);
    controller =
        dependencyResolver.getOneRequired<HelloWorldController>("controller");
  }

  @Override
  void register() {
    registerRoute("get", "/greeting", null,
        (angel.RequestContext req, angel.ResponseContext res) async{
      var name = req.queryParameters["name"];
      sendResult(req, res, null, await controller.greeting(name));
    });
  }
}
