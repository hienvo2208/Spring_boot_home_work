package vn.techmaster.demobean.entity;

import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.demobean.configuration.NotificationConfig;
import vn.techmaster.demobean.interfaces.NotificationSender;

public class EmailNotification implements NotificationSender {


    @Override
    public String send(String message) {
        return "Email Notification: " + message;
    }
}
