package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("currentUser");
        var page = new MainPage(user);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var encryptedPassword = Security.encrypt(password);
        var user = UsersRepository.findByName(name).orElse(null);
        if (user != null && user.getName().equals(name) && user.getPassword().equals(encryptedPassword)) {
            ctx.sessionAttribute("currentUser", user.getName());
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            String error = "Wrong username or password";
            var page = new LoginPage(name, error);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
