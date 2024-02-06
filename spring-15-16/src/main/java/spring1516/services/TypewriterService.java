package spring1516.services;

import spring1516.domain.Book;
import spring1516.domain.Manuscript;

public interface TypewriterService {
    Book print(Manuscript manuscript);
}
