package eapli.base.surveymanagement.domain;

public class VerifyQuestionType {

    public String questionType;

    public VerifyQuestionType(String questionType) {
        if(questionType.isBlank()){
            this.questionType=null;
        }
        else {
            if (!questionType.equalsIgnoreCase("Free-text") && !questionType.equalsIgnoreCase("Multiple-Choice") && !questionType.equalsIgnoreCase("Multiple-Choice with input value")
            && !questionType.equalsIgnoreCase(QuestionType.NUMERIC.name()) && !questionType.equalsIgnoreCase("Scaling Options") && !questionType.equalsIgnoreCase("Single-Choice")
            && !questionType.equalsIgnoreCase("Single-Choice with input value") && !questionType.equalsIgnoreCase("Sorting Options"))
                throw new IllegalArgumentException("Invalid question type!");

            this.questionType = questionType;
        }
    }

    public VerifyQuestionType() {

    }

    public String questionType() {
        return questionType;
    }

    @Override
    public String toString() {
        return questionType;
    }
}
