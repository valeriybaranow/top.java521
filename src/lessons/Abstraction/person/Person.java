package lessons.Abstraction.person;

public class Person {

    // статический по умолчанию класс
    // enum класс набор констант
    public enum Gender {
        MALE, FEMALE
    }
    private Gender gender;

    private final Heart heart;
    private Test test;

    private static class Test {
        private int pulse = 80;

        public void goPulseFaster() {
            pulse += 10;
        }
    }

    // не статические они всегда приватные должны быть
    protected class Heart {
        private int pulse = 80;

        public void goPulseFaster() {
            pulse += 10;
        }
    }

    public Person(Gender gender) {
        this.gender = gender;
        this.heart = new Heart();
    }

    public void speak(boolean isFormal) {
        class Voice {
            private String greeting;

            Voice(String greating) {
                this.greeting = greeting;
            }

            void SayHello() {
                System.out.println("Hello!");
            }

            void whisper(String message) {
                System.out.println(" whisper: " + message);
            }
        }

        heart.goPulseFaster();

        if (isFormal) {
            Voice formalVoice = new Voice("Good morning");
            formalVoice.SayHello();
            formalVoice.whisper("I am glad to see you");
        } else {
            Voice formalVoice = new Voice("Hi");
            formalVoice.SayHello();
            formalVoice.whisper("No questions");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender + " pulse " + heart.pulse +
                '}';
    }
}
