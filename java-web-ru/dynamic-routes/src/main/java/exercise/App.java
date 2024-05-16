package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });


        app.get("/companies/{id}", ctx -> {
            var companyId = ctx.pathParamAsClass("id", String.class).get();

            Optional<Map<String, String>> optionalMap = COMPANIES.stream()
                    .filter(map -> map.get("id").equals(companyId))
                    .findAny();

            if (optionalMap.isEmpty()) {
                throw new NotFoundResponse("Company not found");
            }

            ctx.json(optionalMap.get());
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
