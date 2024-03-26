package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParam("page") == null ? 0 : Integer.parseInt(ctx.queryParam("page"));
            var per = ctx.queryParam("per") == null ? 5 : Integer.parseInt(ctx.queryParam("per"));

            if (page == 0) {
                ctx.json(USERS.stream()
                        .limit(per)
                        .toList());
            } else {
                ctx.json(USERS.stream()
                        .skip((long) (page - 1) * per)
                        .limit(per)
                        .toList());
            }
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
