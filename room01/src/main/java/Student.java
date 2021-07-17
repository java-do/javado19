public record Student(String name, String className, int number, int englishScore, int mathScore) {
    String print() {
        return name + " " + className + " " + number + " " + englishScore + " " + mathScore;
    }
}
