package controllers;

import com.google.inject.Inject;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import services.UserService;

public class Users extends Controller {

    @Inject
    UserService userService;

    public Result getUser(long userId) {
        return ok(Json.toJson(userService.getUser(userId)));
    }
}
