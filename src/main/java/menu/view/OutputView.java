package menu.view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;

public class OutputView {

    public void menuRecommend() {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(getCategory());

    }

    private String getCategory() {
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
        resultCategory.append("]");

        return resultCategory.toString();
    }
}