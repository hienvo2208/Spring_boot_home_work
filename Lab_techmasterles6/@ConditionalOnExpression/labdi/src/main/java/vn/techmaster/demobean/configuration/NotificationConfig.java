package vn.techmaster.demobean.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demobean.entity.EmailNotification;
import vn.techmaster.demobean.entity.SmsNotification;
import vn.techmaster.demobean.interfaces.NotificationSender;

@Configuration
public class NotificationConfig {
    @Bean(name = "emailNotification")
    @ConditionalOnProperty(prefix = "notification", name = "service")
    public NotificationSender notificationSender() {
        return new EmailNotification();
    }

    @Bean(name = "smsNotification")
    @ConditionalOnProperty(prefix = "notification", name = "service", havingValue = "sms")
    public NotificationSender notificationSender2() {
        return new SmsNotification();
    }
}
