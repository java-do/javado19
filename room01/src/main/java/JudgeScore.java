import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class JudgeScore {
    private final List<Student> allStudents;
    private final double englishAverage;
    private final double mathAverage;

    JudgeScore(List<Student> allStudents) {
        this.allStudents = allStudents;
        this.mathAverage = getMathAverage();
        this.englishAverage = getEnglishAverage();
    }

    double getAverage(IntStream stream) {
        OptionalDouble average = stream.average();
        double asDouble = average.orElse(0);
        return asDouble;
    }

    double getMathAverage() {
        IntStream intStream = allStudents.stream().mapToInt(Student::mathScore);
        return getAverage(intStream);
    }

    double getEnglishAverage() {
        IntStream intStream = allStudents.stream().mapToInt(Student::englishScore);
        return getAverage(intStream);
    }

    boolean isAkaten(int score, double average) {
        return score < average;
    }

    String getAkatenStatus(Student student) {
        boolean mathAkaten = isAkaten(student.mathScore(), mathAverage);
        boolean englishAkaten = isAkaten(student.englishScore(), englishAverage);

        String status;

        if (mathAkaten && englishAkaten) {
            status = "【留年】";
        } else if (mathAkaten || englishAkaten) {
            status = "【再試験】";
        } else {
            status = "【合格】";
        }

        return status;
    }

    String print(Student student) {
        return student.name() + " " + student.englishScore() + " " + student.mathScore() + " " + getAkatenStatus(student);
    }
}