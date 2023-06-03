package Enum;
public enum Mood {
    Happy("Счастливый"),
    Sad("Грустный");

    private final String mood;

    Mood(String mood) {
        this.mood = mood;
    }
    public String getWord(){
        return mood;
    }

}
