package models;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

        public static void main(String[] args) {
            staticFileLocation("/public");

            get("/", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "index.hbs");
            }, new HandlebarsTemplateEngine());

            get("/heroform", ((request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "heroform.hbs");
            }), new HandlebarsTemplateEngine());

            post("addHero", ((request, response) -> {
                Map<String, Object> model = new HashMap<>();
                String name = request.queryParams("name");
                int age = Integer.parseInt(request.queryParams("age"));
                String power = request.queryParams("power");
                String weakness = request.queryParams("weakness");
                Hero hero = new Hero(name, age, power, weakness);
                request.session().attribute("name", hero);
                model.put("hero", hero);
                return new ModelAndView(model, "successHero.hbs");
            }, new HandlebarsTemplateEngine());

        }
    }

