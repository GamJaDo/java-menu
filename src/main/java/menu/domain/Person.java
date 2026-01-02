package menu.domain;

import java.util.List;

public class Person {

    private String name;
    private List<String> dislikes;

    public Person(String name) {
        validateName(name);
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 이름의 크기는 2~4 글자 까지만 가능합니다.");
        }
    }
}
