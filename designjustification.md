## Overview of Design Approach
The game is structured around a graph-based narrative model, where each node (DialogueNode) represents a distinct scene, and each edge (Choice) represents a meaningful player decision. This system is designed to support emotionally-driven branching while keeping the architecture modular, extensible, and easy to reason about.

The game’s architecture centers on the following classes:

GameEngine: Controls game flow, input/output, and transitions between nodes.

DialogueNode: Represents a single scene, encapsulating text, speaker, location, and available choices.

Choice: Encapsulates player decisions and defines how the PlayerState should update as a result.

PlayerState: Stores and updates player-specific data such as emotional variables (shame, selfIdentity), flags (e.g., grandmaSupport), and memories.

Character and Location: Support immersive storytelling by tagging nodes with narrative context.

GameData: Holds the map of all nodes, locations, and characters. It acts as the initializer of the narrative graph.

This structure enables a clear separation between narrative content and game state logic, allowing the narrative to evolve independently of the game loop mechanics.

## Justification for Design Choices
1. Node-Based Dialogue Graph
A node-based architecture is a natural fit for a choice-driven narrative game. It allows for:

Branching paths based on emotional and story-related triggers.

Nonlinear navigation, where the player’s choices determine which parts of the story they experience.

Easy editing and testing, since each node is modular and self-contained.

This model mirrors traditional "choose-your-own-adventure" structures while offering greater control over internal state progression.

2. PlayerState: Psychological and Emotional Tracking
Rather than using traditional inventory or combat systems, the game tracks abstract emotional states (shame, selfIdentity) to determine story progression and unlock specific dialogue paths.

This supports the game’s themes of trauma, memory, and growth:

shame increases with avoidance, denial, or harm.

selfIdentity increases with confrontation, reflection, or agency.

memories represent emotionally significant events and are used to trigger unique epilogues.

This design allows the game to reward emotional courage and punish deflection—not with points or endings, but with the texture of the story itself.

3. DialogueNode and Choice Encapsulation
Each DialogueNode includes its speaker and location, reinforcing immersion and supporting symbolic spatial storytelling. The Choice class includes embedded emotional impact and optional memory effects, allowing state updates to be fully tied to narrative decisions.

This encapsulation makes the system declarative, readable, and scalable. Writers or designers could author new scenes without editing the GameEngine logic, maintaining separation of concerns.

4. Minimalism in Command Handling
The game adopts a menu-driven approach rather than natural language parsing or open-world traversal. This was a deliberate trade-off to:

Prioritize emotional clarity over mechanical freedom.

Keep the interface accessible.

Reinforce the themes of constrained choice under emotional pressure.

Open-world or parser-based approaches were considered but dismissed because they would dilute the narrative's control over pacing and thematic focus.

## Alternative Designs Considered
1. Guava’s EventBus for Decoupled Communication
In a future redesign, I would consider using Guava’s EventBus to decouple game components. For example:

Game logic could raise events like NodeEnteredEvent, StateUpdatedEvent.

Separate subsystems (e.g., autosave, logging, UI transitions) could listen and react.

This would improve extensibility, enabling modular add-ons like achievements, inventory, or external analytics.

However, for a compact, emotionally focused game, this added abstraction was unnecessary. The current tightly coupled design is easier to manage during development.

nstead of using fixed dialogue nodes, an alternative design could assign each Character a dynamic personality module that determines their responses based on the player's current state and past interactions. Each character would have its own logic for emotional reactions, memory tracking, and dialogue selection.

Benefits:
- Adds depth and realism to characters
- Increases replayability through variable interactions
- Makes future expansion easier (new characters, more emergent behavior)

Why Not Chosen:
- Complicates debugging and testing
- Too complex for current project scope and deadline


## Tradeoffs and Rationale
This design favors readability and expressiveness over maximal generalization. While some OOP principles (e.g., inheritance in Character) are lightly used, composition and encapsulation take priority.

The cost of this choice is limited reusability of nodes in non-narrative contexts and lack of built-in persistence mechanisms. However, the benefits include:

High narrative clarity

Strong alignment between code and emotional story arcs

Smooth authoring process for additional content

## Extensibility
Additional state variables can be added to PlayerState without breaking existing code.

Choice can be extended to support inventory requirements, time locks, or relationship scores.

Nodes can be rearranged or conditionally displayed using flags.

However, as I neared the end of the project, I realized my current design, while functional, lacked true extensibility. Dialogue content and state effects were tightly coupled inside GameData, which made it difficult to update or expand paths without risk of breaking logic elsewhere. Only after reviewing the rubric again did I fully grasp how important extensibility was—not just for grading, but for maintaining and growing the game. By then, the structure was already locked in, and given the time left, I chose not to refactor major components.

In retrospect, I should have used Guava—particularly its EventBus—to improve modularity and reduce coupling between classes. At the time, I focused too heavily on just getting the basic functionality to work using what I am familiar with in homeworks and didn’t consider enough long-term structure. I now realize that introducing Guava would have allowed for much cleaner communication between components like Choice, PlayerState, and GameEngine.