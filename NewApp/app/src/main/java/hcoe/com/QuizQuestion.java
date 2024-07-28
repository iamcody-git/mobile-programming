package hcoe.com;

public class QuizQuestion {
    private int questionId;
    private boolean answer;
    private boolean hasCheated;

    public QuizQuestion(int questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
        this.hasCheated = false;
    }


    public boolean isAnswer() {
        return answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isHasCheated() {
        return hasCheated;
    }

    public void setHasCheated(boolean hasCheated) {
        this.hasCheated = hasCheated;
    }
}
