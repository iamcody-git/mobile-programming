package hcoe.com;

public class Question {
    private int QuestionId;
    private boolean answer;



    public Question(int questionId, boolean answer){
        this.QuestionId = getQuestionId();
        this.answer=answer;
    }

        public int getQuestionId() {
            return QuestionId;
        }

        public boolean isAnswer() {
            return answer;
        }




}
