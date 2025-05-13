import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerState {
    private int shame = 0;
    private int selfIdentity = 0;
    private Map<String, Boolean> flags = new HashMap<>();
    private ArrayList<String> memories = new ArrayList<>();

    public void increaseShame(int amount) {
        shame += amount;
    }

    public int getShame() {
        return shame;
    }

    public void increaseSelfIdentity(int amount) {
        selfIdentity += amount;
    }

    public int getSelfIdentity() {
        return selfIdentity;
    }

    public boolean getFlag(String key) {
        return flags.getOrDefault(key, false);
    }

    public void setFlag(String key, boolean value) {
        flags.put(key, value);
    }

    public void addMemory(String memory) {
        if (!memories.contains(memory)) {
            memories.add(memory);
        }
    }

    public boolean hasMemory(String memory) {
        return memories.contains(memory);
    }

}
