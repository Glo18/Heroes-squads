import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/heroform", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroform.hbs");
        }, new HandlebarsTemplateEngine());


        post("/addHero", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");

            Hero hero = new Hero(name, age, power, weakness);

            model.put("hero", hero);
            return new ModelAndView(model, "successhero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("addHeroes", Hero.getAll()); //displays hero
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squadform", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squadform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");

            Squad squad = new Squad(name, size, cause);

            model.put("squad", squad);
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squad", Squad.getMembers()); //displays squad created
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


    }
}



