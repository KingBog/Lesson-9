package Lesson_9;

public enum Simbol {
    X("|X|"), O("|O|"), EMPTY("|_|"),DRAW("Ничья");
    String psevdo;

    Simbol(String psevdo) {
        this.psevdo = psevdo;
    }

    @Override
    public String toString() {
        return psevdo;
    }
}