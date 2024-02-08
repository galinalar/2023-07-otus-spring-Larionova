package spring1718.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import spring1718.dto.BookDto;
import spring1718.service.BookService;

import java.util.List;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    private final BookService bookService;

    public CustomHealthIndicator(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Health health() {
        List<BookDto> result = null;
        try {
            result = bookService.getAll();
        } catch (InterruptedException e) {
            return Health.down().build();
        }
        if (!result.isEmpty()) {
            return Health.up().withDetail("Book detail ", result).build();
        } else {
            return Health.down().build();
        }
    }
}
