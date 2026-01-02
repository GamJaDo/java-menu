package menu.domain;

import java.util.List;

public class Person {

    private String name;
    private List<String> dislikes;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDislikes(List<String> dislikes) {
        validateDislikesNumber(dislikes);
        this.dislikes = dislikes;
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 이름의 크기는 2~4 글자 까지만 가능합니다.");
        }
    }

    private void validateDislikesNumber(List<String> dislikes) {
        if (dislikes.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴의 개수는 2개까지만 가능합니다.");
        }
    }
}
