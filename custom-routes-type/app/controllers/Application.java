package controllers;

import java.math.BigInteger;

import play.mvc.Controller;
import play.mvc.Result;

import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result showBigInt(BigInteger num) {
        return ok(num + "");
    }

}
