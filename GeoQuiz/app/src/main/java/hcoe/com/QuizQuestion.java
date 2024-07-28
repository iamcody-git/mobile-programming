package hcoe.com;

public class QuizQuestion {
    private int questionId;
    private boolean answer;
    public QuizQuestion(int questionId, boolean answer){
        this.questionId = questionId;
        this.answer =answer;

    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isAnswer() {
        return answer;
    }
}
