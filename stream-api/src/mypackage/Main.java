package mypackage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        Integer [] array = { 21, 8, 3, 5, 1, 13 };

        List<String> stringList = Arrays.stream(array)
                .filter(el -> el % 2 != 0)
                .map(el -> el + " " + getPoint(el))
                .collect(Collectors.toList());

        stringList.stream()
                .sorted((str1, str2) -> Integer.parseInt(str2.split(" ")[0]) - Integer.parseInt(str1.split(" ")[0]))
                .forEach(el -> System.out.print(el + " "));
    }

    public static String getPoint(int number) {
        String[] points = {
                "очко",
                "очка",
                "очков"
        };
        int mod = number % 100;
        if(mod >= 10 && mod <= 20) {
            return points[2];
        }
        mod = number % 10;
        if (mod == 0 || mod > 4) {
            return points[2];
        }
        if (mod > 1) {
            return points[1];
        }
        if (mod == 1) {
            return points[0];
        }
        return "";
    }
}
