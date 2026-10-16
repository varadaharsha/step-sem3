
abstract class Question {
    abstract double grade(
        String correctAnswer,
        String studentAnswer,
        double points
    );
}

class MCQ extends Question {
    @Override
    double grade(String correctAnswer, String studentAnswer, double points) {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }
}

class TrueFalse extends Question {
    @Override
    double grade(String correctAnswer, String studentAnswer, double points) {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
    }
}

class Essay extends Question {
    @Override
    double grade(String correctAnswer, String studentAnswer, double points) {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class QuestionGraderDemo {
    public static void main(String[] args) {
        Question[] questions = {
            new MCQ(),
            new TrueFalse(),
            new Essay(),
            new Essay()
        };

        String[] types = {"MCQ", "TF", "ESSAY", "ESSAY"};

        String[] correctAnswers = {
            "Paris",
            "False",
            "Inheritance, Polymorphism, Encapsulation",
            "Abstraction, Composition"
        };

        String[] studentAnswers = {
            "Paris",
            "True",
            "Polymorphism is one.",
            "I talked about abstraction."
        };

        double[] points = {10, 5, 20, 15};
        double total = 0;

        for (int i = 0; i < questions.length; i++) {
            double score = questions[i].grade(
                correctAnswers[i],
                studentAnswers[i],
                points[i]
            );

            System.out.printf("%s: %.2f%n", types[i], score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
