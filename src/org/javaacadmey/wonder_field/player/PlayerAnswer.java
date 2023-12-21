package org.javaacadmey.wonder_field.player;

public class PlayerAnswer {
    private String answerType;
    private String answer;

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerType() {
        return answerType;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "PlayerAnswer{" +
                "answerType='" + answerType + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
