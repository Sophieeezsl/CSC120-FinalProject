import java.util.*;

public class GameEngine {
    private PlayerState playerState;
    private DialogueNode currentNode;
    private Map<String, DialogueNode> allNodes;
    private Scanner scanner;

    public GameEngine() {
        this.playerState = new PlayerState();
        this.allNodes = GameData.createDialogueNodes();
        this.currentNode = allNodes.get("bedroom_wake");
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        while (true) {
            
            Character speaker = currentNode.getSpeaker();
            Location location = currentNode.getLocation();
            
            System.out.println("\n[" + location.getName() + "] " + speaker.getName());
            System.out.println(currentNode.getText());
            
            String textToDisplay = "\n[" + location.getName() + "] " + speaker.getName() + "\\" + currentNode.getText();

            if (currentNode.getId().startsWith("ending_")) {
                StringBuilder extra = new StringBuilder();
                
                if (playerState.hasMemory("Chocolate Incident")) {
                    extra.append("\n\nLater, in quieter moments, you still think of Eko.\nThe box, the packaging, the way the tape was half-peeled.\nYou never meant to hurt anyone. But meaning isn’t always enough.");
                }
                
                if (playerState.getFlag("relationship")) {
                    extra.append("\n\nSomewhere down the line, the two of you open a store.\nIt doesn’t sell anything useful. Just things that feel like they belong.\nThere’s a little sign on the door: No Shoes. No Small Talk. Snacks Welcome.");
                }
                
                if (playerState.getFlag("grandmaSupport")) {
                    extra.append("\n\nShe writes you letters. Neatly folded, gently worded.\nThere’s always a note about the money—\"use it well\"—and a line about the weather back home.");
                }
                
            textToDisplay += extra.toString();
            }                           
            System.out.println(textToDisplay);

            ArrayList<Choice> choices = currentNode.getChoices();
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((i + 1) + ". " + choices.get(i).getLabel());
            }

            System.out.print("> Choose: ");
            int input;
            
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            if (input < 1 || input > choices.size()) {
                System.out.println("Invalid choice number.");
                continue;
            }

            Choice selected = choices.get(input - 1);
            System.out.println("\n" + selected.getResultText());

            selected.applyEffect(playerState);

            String nextId = selected.getNextNodeId();
            if (!allNodes.containsKey(nextId)) {
                System.out.println("The path ends here.");
                break;
            }

            currentNode = allNodes.get(nextId);

            if (currentNode.getId().equals("grandma_support")) {
                playerState.setFlag("grandmaSupport", true);
            }

            if (currentNode.getId().equals("girl_connection") && playerState.getSelfIdentity() >= 3) {
                playerState.setFlag("relationship", true);
            }

            if (currentNode.getId().equals("future_decision")) {
                ArrayList<Choice> futureChoices = new ArrayList<>();
            
                if (playerState.getShame() >= 4) {
                    futureChoices.add(new Choice("Stay close to home", "You stay. The air is the same.", "ending_local",0,0,""));
                }
            
                // city always available
                futureChoices.add(new Choice("Move to the city", "You blend into the noise.", "ending_city",0,0,""));
            
                if (playerState.getFlag("grandmaSupport") && playerState.getSelfIdentity() >= 3) {
                    futureChoices.add(new Choice("Apply abroad", "You pack lightly. But leave heavily.", "ending_abroad",0,0,""));
                }
            
                // overwrite currentNode's choices
                currentNode.setChoices(futureChoices);
                continue;
            }
        }
        System.out.println("\n=== END ===");
    }
}