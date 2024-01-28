package spring1516.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import spring1516.domain.Book;
import spring1516.domain.Manuscript;

import java.util.concurrent.ForkJoinPool;

@Service
@Slf4j
public class ManuscriptServiceImpl implements ManuscriptService {
    private static final Manuscript MANUSCRIPT1 = new Manuscript("1", "text1");

    private static final Manuscript MANUSCRIPT2 = new Manuscript("2", "text2");

    private static final Manuscript MANUSCRIPT3 = new Manuscript("3", "text3");

    private static final Manuscript MANUSCRIPT4 = new Manuscript("4", "text4");

    private static final Manuscript[] WORK = {MANUSCRIPT1, MANUSCRIPT2, MANUSCRIPT3, MANUSCRIPT4};

    private final PublishingHouseGateway publishingHouse;

    public ManuscriptServiceImpl(PublishingHouseGateway publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public void startPublishingHouseWork() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        for (int i = 1; i < 10; i++) {
            pool.execute(() -> {
                Manuscript manuscript = WORK[RandomUtils.nextInt(0, WORK.length)];
                log.info("New manuscript: {}", manuscript.getName());
                Book book = publishingHouse.process(manuscript);
                log.info("New Book: {}, {}, {}", book.getName(), book.getText(), book.getCover());
            });
            delay();
        }
    }

    private void delay() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
