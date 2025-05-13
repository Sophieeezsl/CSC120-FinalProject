public class Choice {
    private String label;
    private String resultText;
    private String nextNodeId;

    private int shameEffect;
    private int selfIdentityEffect;
    private String memoryToAdd;

    public Choice(String label, String resultText, String nextNodeId, int shameEffect, int selfIdentityEffect, String memoryToAdd) {
        this.label = label;
        this.resultText = resultText;
        this.nextNodeId = nextNodeId;
        this.shameEffect = shameEffect;
        this.selfIdentityEffect = selfIdentityEffect;
        this.memoryToAdd = memoryToAdd;
    }

    public String getLabel() {
        return label;
    }

    public String getResultText() {
        return resultText;
    }

    public String getNextNodeId() {
        return nextNodeId;
    }

    public void applyEffect(PlayerState state) {
        if (shameEffect != 0) state.increaseShame(shameEffect);
        if (selfIdentityEffect != 0) state.increaseSelfIdentity(selfIdentityEffect);
        if (memoryToAdd != null && !memoryToAdd.isEmpty()) state.addMemory(memoryToAdd);
    }
}

