package menu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import menu.domain.Person;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public void menuRecommendationStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public List<Person> inputPersonNames() {
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String nameInput = scanner.nextLine();
        String[] names = nameInput.split(",");

        validatePersonNumber(names);

        List<Person> persons = new ArrayList<>();
        for (String name : names) {
            persons.add(new Person(name));
        }

        return persons;
    }

    public List<Person> inputDislikeByPerson(List<Person> personsNames) {
        List<Person> persons = new ArrayList<>();
        for (Person person : personsNames) {
            System.out.println();
            System.out.println(person.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String dislikeInput = scanner.nextLine();
            String[] dislikes = dislikeInput.split(",");
            person.setDislikes(new ArrayList<String>(Arrays.asList(dislikes)));

            persons.add(person);
        }

        return persons;
    }

    private void validatePersonNumber(String[] names) {
        if (names.length > 5 || names.length < 2) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명에서 5명 사이어야 합니다.");
        }
    }
}
