package controllers;

import com.google.inject.Inject;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import services.AdminService;

public class Admins extends Controller {

    @Inject
    AdminService adminService;

    public Result getUser(long userId) {
        return ok(Json.toJson(adminService.getUser(userId)));
    }
}
