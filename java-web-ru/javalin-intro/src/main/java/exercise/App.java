package exercise;

import io.javalin.Javalin;
import org.eclipse.jetty.server.Server;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        return Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.jetty.defaultPort = 7070;
        });
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
        app.start(7070);
    }
}
