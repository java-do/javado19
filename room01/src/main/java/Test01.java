import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Test01 {

    public static void main(String[] args) {

        List<Student> studentList = List.of(new Student("taro yamada", "2-A", 35, 70, 83),
                new Student("hanako sato", "2-A", 10, 48, 95),
                new Student("sinzo abe", "2-A", 1, 0, 19));

//        List<Integer> englishScoreList = List.of(70, 48, 28);
//
//        englishScoreList.stream().mapToInt().average();

//        var average = studentList.stream().mapToInt(row -> row.englishScore()).average();
//        double averageAsDouble = average.getAsDouble();

        List<String> englishBadScoreList = studentList.stream()
//                .filter(student -> student.englishScore() < 60)
//                .map(row -> akaten(row, averageAsDouble))
                .map(row -> new JudgeScore(studentList).print(row))
                .toList();

        englishBadScoreList.forEach(row -> System.out.println(row));

    }

    static String akaten(Student row, double average) {
        // 英語が60点以上なら row.print() を返して、60点以下なら
        //row.print() + “赤点“;
//        if (row.englishScore() >= 60) {
        if (row.englishScore() >= average / 2) {
            return row.print();
        } else {
            return row.print() + "【赤点】";
        }
    }
}
