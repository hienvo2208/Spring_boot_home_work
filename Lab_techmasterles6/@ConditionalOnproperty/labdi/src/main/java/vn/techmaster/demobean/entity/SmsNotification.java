package vn.techmaster.demobean.entity;

import vn.techmaster.demobean.interfaces.NotificationSender;

public class SmsNotification implements NotificationSender {
    @Override
    public String send(String message) {
        return "SMS Notification: " + message;
    }
}
