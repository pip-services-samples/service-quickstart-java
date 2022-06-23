import example.HelloWorldProcess;

public class Program {
    public static void main(String[] args) {
        try {
            new HelloWorldProcess().run(args);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
