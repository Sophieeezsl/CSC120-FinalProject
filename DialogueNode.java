import java.util.ArrayList;

public class DialogueNode {
    private String id;
    private String text;
    private ArrayList<Choice> choices;
    private Character speaker;
    private Location location;

    public DialogueNode(String id, String text, ArrayList<Choice> choices, Character speaker, Location location) {
        this.id = id;
        this.text = text;
        this.choices = choices;
        this.speaker = speaker;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> newChoices) {
        this.choices = newChoices;
    }

    public Character getSpeaker() {
        return speaker;
    }

    public Location getLocation() {
        return location;
    }
}
