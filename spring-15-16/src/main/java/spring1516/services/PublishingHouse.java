package spring1516.services;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import spring1516.domain.Book;
import spring1516.domain.Manuscript;

@MessagingGateway
public interface PublishingHouse {

    @Gateway(requestChannel = "manuscriptChannel", replyChannel = "bookChannel")
    Book process(Manuscript manuscript);
}
