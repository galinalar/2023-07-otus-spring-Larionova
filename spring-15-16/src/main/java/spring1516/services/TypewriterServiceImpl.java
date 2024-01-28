package spring1516.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring1516.domain.Book;
import spring1516.domain.Manuscript;

@Service
@Slf4j
public class TypewriterServiceImpl implements TypewriterService {

    @Override
    public Book print(Manuscript manuscript) {
        log.info("Printing {}", manuscript.getName());
        delay();
        log.info("Printing {} done", manuscript.getName());
        return new Book(manuscript.getName(), manuscript.getText(), false);
    }

    private static void delay() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
