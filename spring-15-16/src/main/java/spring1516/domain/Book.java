package spring1516.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Book {
    private final String name;

    private final String text;

    private final Boolean cover;
}
