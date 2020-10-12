package org.pipservices.quickstart;

public class Program {

  public static void main(String[] args) {
    try {
      HelloWorldProcess process = new HelloWorldProcess();
      process.run(args);

    } catch (Exception ex) {
      System.err.println(ex);
    }
  }
}