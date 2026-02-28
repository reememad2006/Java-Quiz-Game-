public class Questions {
    // Making them private to prevent modification
    private String prompt;
    private String[] options;
    private int correctAnswer;

    // Data container for each question
    public Questions(String prompt, String[] options, int correctAnswer) {
        this.prompt = prompt;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // getters
    public String getPrompt() {
        return prompt;
    }

    public String[] getOpts() {
        return options;
    }

    public int getAns() {
        return correctAnswer;
    }
}