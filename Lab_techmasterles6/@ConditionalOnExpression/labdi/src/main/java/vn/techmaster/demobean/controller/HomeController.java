package vn.techmaster.demobean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.techmaster.demobean.entity.Car;
import vn.techmaster.demobean.interfaces.NotificationSender;

import javax.management.Notification;


@Controller
public class HomeController {
    @Autowired
    Car car;

    @Autowired
    @Qualifier("emailNotification")
    NotificationSender notificationSender;

    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHome() {
        return car.toString();
    }

    @ResponseBody
    @GetMapping(value = "/route", produces = MediaType.TEXT_HTML_VALUE)
    public String getRoute() {
        return car.navigate();
    }

    @ResponseBody
    @GetMapping(value = "/notification", produces = MediaType.TEXT_HTML_VALUE)
    public String getNotification() {
        return notificationSender.send("hachiko3179");
    }

}
