# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?

 I began with a narrative-first mindset, outlining the emotional trajectory and symbolic structure of the story before thinking about the technical architecture. Once I had the story mapped out using a node graph, I designed a minimal set of classes (e.g., DialogueNode, Choice, PlayerState) to support the branching flow. My coding process followed a content-first, system-second approach: I often wrote the dialogue content first and retrofitted the system logic to support it.

 - What **new thing(s)** did you learn / figure out in completing this project?

 I deepened my understanding of object-oriented programming by applying class design not just to game mechanics, but also to story architecture. I realized how state tracking (via shame, self-identity, flags, etc.) could be woven into interactive fiction in a meaningful, non-mechanical way.

 - Is there anything that you wish you had **implemented differently**?

 Yes—I now wish I had used Guava’s EventBus from the start to decouple my components. Instead, I relied on tight coupling between GameEngine, PlayerState, and Choice, which made the system harder to modify later. I also wish I had built a more flexible command-handling interface, instead of limiting the player to numerical menu choices. (see more in justification file)
 
 - If you had **unlimited time**, what additional features would you implement?
 Dynamic AI-like character responses based on personality profiles. At first I did wanted each character (e.g., Mom, Grandma, Girl) to have their own internal emotional state that reacts to your choices across the game—effectively giving each character a persistent memory of your relationship with them. It is just too complicated.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 The most helpful feedback is when I design the story and how to make things turn into a game my friend helped me with the design.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 Give yourself more time to plan out classes and how things work. By that it means to try multiple plans, discuss it with others and figure out the best logic before start to code. 

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
/