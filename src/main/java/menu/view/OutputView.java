package menu.view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;
import menu.domain.Person;

public class OutputView {

    public void menuRecommend(List<Person> persons) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<Category> categories = getCategory();
        printMenusByPerson(persons, categories);
    }

    private List<Category> getCategory() {
        StringBuilder resultCategory = new StringBuilder("[ 카테고리");
        List<Category> categories = new ArrayList<>();

        while (categories.size() < 5) {
            Category category = Category.getCategory(Randoms.pickNumberInRange(1, 5));
            int count = Collections.frequency(categories, category);

            if (count >= 2) {
                continue;
            }
            categories.add(category);
        }

        for(Category category : categories) {
            resultCategory.append(" | ").append(category.name());
        }
        resultCategory.append(" ]");

        System.out.println(resultCategory);

        return categories;
    }

    private void printMenusByPerson(List<Person> persons, List<Category> categories) {
        List<StringBuilder> resultMenus = new ArrayList<>();
        List<List<String>> personUsedMenusList = new ArrayList<>();

        for (Person person : persons) {
            resultMenus.add(new StringBuilder("[ " + person.getName()));
            personUsedMenusList.add(new ArrayList<>());
        }

        for (Category category : categories) {
            for (int i = 0; i < persons.size(); i++) {
                Person person = persons.get(i);
                String menu = pickMenu(category, person, personUsedMenusList.get(i));
                resultMenus.get(i).append(" | ").append(menu);
                personUsedMenusList.get(i).add(menu);
            }
        }

        for (StringBuilder resultMenu : resultMenus) {
            System.out.println(resultMenu + " ]");
        }
    }

    private String pickMenu(Category category, Person person, List<String> usedMenus) {
        while (true) {
            List<String> shuffledMenus = Randoms.shuffle(category.getMenus());
            String menu = shuffledMenus.get(0);

            if (person.getDislikes().contains(menu)) {
                continue;
            }
            if (usedMenus.contains(menu)) {
                continue;
            }

            return menu;
        }
    }
}