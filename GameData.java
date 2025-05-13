import java.util.ArrayList;
import java.util.HashMap;


public class GameData {

    public static HashMap<String, DialogueNode> createDialogueNodes() {
        HashMap<String, DialogueNode> nodes = new HashMap<>();

        // ----- Characters -----
        Character narrator = new Character("Narrator");
        Character mother = new Character("Mother");
        Character boy = new Character("Boy");
        Character girl = new Character("Girl");
        Character grandma = new Character("Grandma");
    
        // ----- Locations -----
        Location bedroom = new Location("Bedroom", "Your familiar bedroom, still dim and quiet.");
        Location kitchen = new Location("Kitchen", "Sink running. Cold floor tiles. Familiar air.");
        Location garden = new Location("Garden", "A small enclosed garden behind the house.");
        Location park = new Location("Street", "Empty sidewalk. Late afternoon light.");
        Location porch = new Location("Porch", "Old wooden steps, the scent of mint and thyme.");
    

// --- bedroom_wake ---
ArrayList<Choice> wakeChoices = new ArrayList<>();
wakeChoices.add(new Choice(
    "Write in your journal", 
    "You reach for the journal on your nightstand and open to a blank page.", 
    "bedroom_journal", 
    0, 0, ""
));
wakeChoices.add(new Choice(
    "Go find your mother", 
    "You get up, your feet cold on the floor. The hallway is quiet.", 
    "mother_start",
    0, 0, ""
));
wakeChoices.add(new Choice(
    "Go to the garden", 
    "The air outside feels different today. You need to move.", 
    "garden_start",
    0, 0, ""
));

DialogueNode bedroomWake = new DialogueNode(
    "bedroom_wake", 
    "You wake up in your bedroom. The light filters through the curtains like memory—soft and fading. The world outside is awake, but you feel slightly behind.", 
    wakeChoices, narrator, bedroom);
nodes.put("bedroom_wake", bedroomWake);

// --- bedroom_journal ---
ArrayList<Choice> journalChoices = new ArrayList<>();
journalChoices.add(new Choice("Close the journal and go find your mother", "You run your fingers over the page, then close the cover.", "mother_start",0,0,""));
journalChoices.add(new Choice("Go to the garden", "You leave the journal open. You need air.", "garden_start",0,0,""));
DialogueNode bedroomJournal = new DialogueNode("bedroom_journal", "You write:\n“Someone left me in my dream. I don’t know who. I don’t know if I asked them to stay.”", journalChoices, narrator, bedroom);
nodes.put("bedroom_journal", bedroomJournal);

// --- mother_start ---
ArrayList<Choice> motherChoices = new ArrayList<>();
motherChoices.add(new Choice("Avoid the subject", "You stand in the doorway, unsure if she knows.", "flashback_pet_intro",0,0,""));
motherChoices.add(new Choice("Deny your role in what happened", "“I didn’t mean to,” you say before she even asks anything.", "flashback_pet_intro", 0,-1,""));
DialogueNode motherStart = new DialogueNode("mother_start", "Your mother is in the kitchen, washing dishes. She doesn’t turn when you enter. You can hear water, breath, silence.", motherChoices, mother, kitchen);
nodes.put("mother_start", motherStart);

// --- flashback_pet_intro ---
ArrayList<Choice> petIntroChoices = new ArrayList<>();
petIntroChoices.add(new Choice("You found him first", "The light in the hallway was too bright. His mouth was foaming.", "flashback_pet_discovery", 2,0,""));
petIntroChoices.add(new Choice("You don’t remember everything", "You still dream about the sound he made.", "bedroom_after_mother", 0, 0, ""));
DialogueNode flashbackIntro = new DialogueNode("flashback_pet_intro", "You see it again. The box was left near the door. The chocolate was supposed to be for someone else. He must’ve thought it was for him.\nYou remember the crinkle of torn foil, then the stillness.", petIntroChoices, narrator, bedroom);
nodes.put("flashback_pet_intro", flashbackIntro);

// --- flashback_pet_discovery ---
ArrayList<Choice> petDiscoveryChoices = new ArrayList<>();
petDiscoveryChoices.add(new Choice("Let the memory play out", "You sit with it. The guilt doesn’t lessen.", "bedroom_after_mother", 0,0,""));
DialogueNode petDiscovery = new DialogueNode("flashback_pet_discovery", "He had pulled the package apart. There were scratches on the floor. You called his name, but he didn’t move. You didn’t scream, not then.", petDiscoveryChoices, narrator, bedroom);
nodes.put("flashback_pet_discovery", petDiscovery);

// --- bedroom_after_mother ---
ArrayList<Choice> afterMotherChoices = new ArrayList<>();
afterMotherChoices.add(new Choice("Go to the garden", "You need to breathe.", "garden_start",0,0,""));
// grandma_start not unlocked yet, added in logic
DialogueNode bedroomAfterMother = new DialogueNode("bedroom_after_mother", "Back in your room, you sit on the edge of the bed. The silence is not emptiness. It’s weight.", afterMotherChoices, narrator, bedroom);
nodes.put("bedroom_after_mother", bedroomAfterMother);


// --- garden_start ---
ArrayList<Choice> gardenChoices = new ArrayList<>();
gardenChoices.add(new Choice("Let yourself remember", "The leaves shimmer, and for a moment you feel smaller.", "garden_memory",0,0,""));
DialogueNode gardenStart = new DialogueNode("garden_start", "You step into the garden. The sun filters through the branches, casting strange shadows. This place still smells like early mornings and something lost.", gardenChoices, narrator, garden);
nodes.put("garden_start", gardenStart);

// --- garden_memory ---
ArrayList<Choice> gardenMemoryChoices = new ArrayList<>();
gardenMemoryChoices.add(new Choice("Stay in the memory", "A figure is there. You can’t remember meeting him before.", "boy_first_meeting",0,0,""));
DialogueNode gardenMemory = new DialogueNode("garden_memory", "You remember chasing Eko between the hedges. You remember crying in the soil. The garden keeps secrets longer than people do.", gardenMemoryChoices, narrator, garden);
nodes.put("garden_memory", gardenMemory);

// --- boy_first_meeting ---
ArrayList<Choice> boyMeetingChoices = new ArrayList<>();
boyMeetingChoices.add(new Choice("Deny how you feel", "You look away. He doesn't press you.", "boy_stay_in_silence", 0,-1,""));
boyMeetingChoices.add(new Choice("Deflect with a joke", "He smiles faintly, but doesn't reply.", "boy_stay_in_silence", 0, +1, "")); 
boyMeetingChoices.add(new Choice("Say nothing", "Silence stretches between you like a wire.", "boy_stay_in_silence",0,0,""));
DialogueNode boyFirstMeeting = new DialogueNode("boy_first_meeting", "A boy stands near the old tree. You don't know if he's real. He asks, 'Do you come here a lot?' His voice is quiet, not invasive.", boyMeetingChoices, boy, garden);
nodes.put("boy_first_meeting", boyFirstMeeting);

// --- boy_stay_in_silence ---
ArrayList<Choice> boySilentChoices = new ArrayList<>();
boySilentChoices.add(new Choice("Leave the garden", "You step back through the gate, the grass brushing your legs.", "bedroom_after_boy",0,0,""));
DialogueNode boyStayInSilence = new DialogueNode("boy_stay_in_silence", "He doesn’t say goodbye. But he doesn’t seem angry. Just... faded. You’re not sure if he’ll be here next time.", boySilentChoices, boy, garden);
nodes.put("boy_stay_in_silence", boyStayInSilence);

// --- bedroom_after_boy ---
ArrayList<Choice> afterBoyChoices = new ArrayList<>();
afterBoyChoices.add(new Choice("Go see Grandma", "You wonder if she remembers things your mother doesn’t say.", "grandma_start",0,0,""));
afterBoyChoices.add(new Choice("Go for a walk", "You don’t know where your feet are taking you.", "girl_meet",0,0,""));
DialogueNode bedroomAfterBoy = new DialogueNode("bedroom_after_boy", "You sit down, brush dirt from your palms. The silence returns, but something in it has shifted.", afterBoyChoices, narrator, bedroom);
nodes.put("bedroom_after_boy", bedroomAfterBoy);

// --- girl_meet ---
ArrayList<Choice> girlMeetChoices = new ArrayList<>();
girlMeetChoices.add(new Choice("“I’m escaping.”", "She nods, like it’s not the first time she’s heard that.", "girl_continue",0,0,""));
girlMeetChoices.add(new Choice("“None of your business.”", "“Obviously,” she says. “I’m not the cops.”", "girl_continue",0,0,""));
DialogueNode girlMeet = new DialogueNode("girl_meet", "She’s sitting backwards on a park bench, chewing the last of her iced coffee. The school jacket she’s wearing is too big, sleeves rolled halfway to her elbows. Her ears are red from the cold. You were going to walk past her. She says: “You don’t look like you’re out for a walk.”", girlMeetChoices, girl, park);
nodes.put("girl_meet", girlMeet);

// --- girl_continue ---
ArrayList<Choice> girlContinueChoices = new ArrayList<>();
girlContinueChoices.add(new Choice("“My dog died.”", "She stops. The chewing pauses. She looks down. “I had a bird. It flew away.”", "girl_mutual_dead_pet",0,0,""));
girlContinueChoices.add(new Choice("“I should go.”", "“You already arrived,” she says. “You’re just missing the ticket.”", "girl_unresolved",0,0,""));
DialogueNode girlContinue = new DialogueNode("girl_continue", "You’re standing. She’s still sitting, looking up at you like she’s sizing up a cat she doesn’t really want. She says, “There’s fresh dirt on your shoes. You’ve been somewhere with roots.” You say, “Do you always observe strangers like this?” She doesn’t answer. Just keeps chewing ice, slowly.", girlContinueChoices, girl, park);
nodes.put("girl_continue", girlContinue);

// --- girl_mutual_dead_pet ---
ArrayList<Choice> girlMutualChoices = new ArrayList<>();
girlMutualChoices.add(new Choice("Say nothing", "She sets her empty cup...", "bedroom_before_future",0,0,""));
DialogueNode girlMutual = new DialogueNode("girl_mutual_dead_pet", "Neither of you ask for names...", girlMutualChoices, girl, park);
nodes.put("girl_mutual_dead_pet", girlMutual);

// --- girl_unresolved ---
ArrayList<Choice> girlUnresolvedChoices = new ArrayList<>();
girlUnresolvedChoices.add(new Choice("Go home", "You stay where you are. She walks. You don’t watch her go.", "bedroom_before_future",0,0,""));
DialogueNode girlUnresolved = new DialogueNode("girl_unresolved", "She stretches her arms and stands. “I’m going this way,” she says. You stay where you are. She walks. You don’t watch her go.", girlUnresolvedChoices, girl, park);
nodes.put("girl_unresolved", girlUnresolved);


// --- boy_return ---
ArrayList<Choice> boyReturnChoices = new ArrayList<>();
boyReturnChoices.add(new Choice("Walk up", "You didn’t plan to say anything. You just found yourself closer.", "boy_near_touch",0,0,""));
boyReturnChoices.add(new Choice("Turn around", "He says your name—not loud, but sharp like broken glass.", "boy_leaves_silent",0,0,""));
DialogueNode boyReturn = new DialogueNode("boy_return", "You weren’t planning to come this way. But somehow you’re behind the gym again. When you see him, your stomach twists like spoiled milk. The air is warm. But your arms feel cold.", boyReturnChoices, boy, garden);
nodes.put("boy_return", boyReturn);

// --- boy_near_touch ---
ArrayList<Choice> boyNearTouchChoices = new ArrayList<>();
boyNearTouchChoices.add(new Choice("Hit him", "You didn’t think about where to hit. It wasn’t a decision.", "boy_hit_reject", 0,0,""));
boyNearTouchChoices.add(new Choice("Say 'Don’t'", "You say it like someone else said it for you.", "boy_accept_then_leave",0,0,""));
DialogueNode boyNearTouch = new DialogueNode("boy_near_touch", "You’re too close. Not to him—to the memory. He starts to smile. You knew he would. You even knew which side of his mouth. You’ve laughed earlier than him. You’ve cried earlier too. Now you do neither.", boyNearTouchChoices, boy, garden);
nodes.put("boy_near_touch", boyNearTouch);

// --- boy_hit_reject ---
ArrayList<Choice> boyHitChoices = new ArrayList<>();
boyHitChoices.add(new Choice("Leave", "You don’t remember if you were breathing. Only that your shoes were moving.", "bedroom_before_future", 2, 0, ""));
DialogueNode boyHitReject = new DialogueNode("boy_hit_reject", "You hit him. Not hard. But something popped in your knuckles. He doesn’t hit back. He could have. He didn’t. You say: 'You think that was just a touch?' He says: 'You didn’t pull away either.' Your breath is out of order. You dig your nails into your arm. It helps.", boyHitChoices, boy, garden);
nodes.put("boy_hit_reject", boyHitReject);

// --- boy_accept_then_leave ---
ArrayList<Choice> boyAcceptChoices = new ArrayList<>();
boyAcceptChoices.add(new Choice("Stand still", "You stood there for a long time. Not thinking. Just being.", "bedroom_before_future", 0, 2, ""));
DialogueNode boyAcceptThenLeave = new DialogueNode("boy_accept_then_leave", "Your back is too straight. Like when your mom scolds you. He doesn’t talk again. You hear a bird. A plastic bag. An ant moves near your foot. You suddenly think he’s just an object. Not a person. He walks away like someone who just took out the trash.", boyAcceptChoices, boy, garden);
nodes.put("boy_accept_then_leave", boyAcceptThenLeave);

// --- boy_leaves_silent ---
ArrayList<Choice> boySilentChoices2 = new ArrayList<>();
boySilentChoices2.add(new Choice("Keep walking", "You don’t look back. But you know he didn’t follow. Or maybe you were just too fast.", "bedroom_before_future", 0, 0, ""));
DialogueNode boyLeavesSilent = new DialogueNode("boy_leaves_silent", "You don’t stop. You don’t run either. But your ears ring like something almost happened.", boySilentChoices2, boy, garden);
nodes.put("boy_leaves_silent", boyLeavesSilent);

// --- bedroom_before_future ---
ArrayList<Choice> beforeFutureChoices = new ArrayList<>();
beforeFutureChoices.add(new Choice("Stand up", "You get to your feet. Slowly, but without help.", "future_decision", 0, 0, ""));
DialogueNode bedroomBeforeFuture = new DialogueNode("bedroom_before_future", "You lie on the floor.\nNot to cry. Not to rest.\nJust to be low, to feel the ground hold your weight.\nThe future isn't waiting. It's already walking toward you.", beforeFutureChoices, narrator, bedroom);
nodes.put("bedroom_before_future", bedroomBeforeFuture);

// --- grandma_start ---
ArrayList<Choice> grandmaStartChoices = new ArrayList<>();
grandmaStartChoices.add(new Choice("You always keep your hands busy.", "She looks at her fingers and doesn't answer right away.", "grandma_reflect",0,0,""));
grandmaStartChoices.add(new Choice("Do you want me to help?", "She shakes her head, but pats the seat beside her.", "grandma_reflect",0,0,""));
DialogueNode grandmaStart = new DialogueNode("grandma_start", "Your grandmother is on the porch, sorting dried herbs into little jars.\nShe doesn’t ask why you’re there. She just pats the chair beside her.\nThe wind smells like mint and old stone.", grandmaStartChoices, grandma, porch);
nodes.put("grandma_start", grandmaStart);

// --- grandma_reflect ---
ArrayList<Choice> grandmaReflectChoices = new ArrayList<>();
grandmaReflectChoices.add(new Choice("She never answers mine anyway.", "Her hands pause, then resume sorting.", "grandma_neutral",0,0,""));
grandmaReflectChoices.add(new Choice("Do you think she wanted to?", "She tilts her head a little, considering.", "grandma_observe",0,0,""));
DialogueNode grandmaReflect = new DialogueNode("grandma_reflect", "She holds up a sprig of thyme.\n“Your mother used to help. Before you were born.\nShe stopped the year she stopped asking questions.”\nShe looks at you now, like she’s asking something wordlessly.", grandmaReflectChoices, grandma, porch);
nodes.put("grandma_reflect", grandmaReflect);

// --- grandma_neutral ---
ArrayList<Choice> grandmaNeutralChoices = new ArrayList<>();
grandmaNeutralChoices.add(new Choice("Go back inside", "You leave without a sound.", "bedroom_after_grandma",0,0,""));
DialogueNode grandmaNeutral = new DialogueNode("grandma_neutral", "She nods, without smiling.\n“She’s trying in her own broken way.”\nThen she continues sorting herbs like you were never there.\nThe chair creaks once as you stand.", grandmaNeutralChoices, grandma, porch);
nodes.put("grandma_neutral", grandmaNeutral);

// --- grandma_observe ---
ArrayList<Choice> grandmaObserveChoices = new ArrayList<>();
grandmaObserveChoices.add(new Choice("I'm not tired yet.", "You pull the chair closer and sit down.", "grandma_support",0,0,""));
grandmaObserveChoices.add(new Choice("It's getting cold.", "She doesn’t stop you when you stand.", "grandma_neutral",0,0,""));
DialogueNode grandmaObserve = new DialogueNode("grandma_observe", "She doesn’t answer right away.\nThen: “Sometimes I wonder if I passed that on.”\nShe brushes crumbs from her skirt.\n“Most people I love get tired of me talking.”", grandmaObserveChoices, grandma, porch);
nodes.put("grandma_observe", grandmaObserve);

// --- grandma_support ---
ArrayList<Choice> grandmaSupportChoices = new ArrayList<>();
grandmaSupportChoices.add(new Choice("You sit with her a little longer.", "The two of you don’t speak again, but something rests between you.", "bedroom_after_grandma",0,0,""));
DialogueNode grandmaSupport = new DialogueNode("grandma_support", "She doesn’t smile. But she exhales, slow and full.\nThen: “If you ever need to leave, there’s a small box in my room.\nBehind the second drawer. You won’t owe me anything.”\nThe wind shifts, but you’re warm.", grandmaSupportChoices, grandma, porch);
// Remember to setFlag("grandmaSupport", true) in GameEngine when this node is reached
nodes.put("grandma_support", grandmaSupport);

// --- bedroom_after_grandma ---
ArrayList<Choice> afterGrandmaChoices = new ArrayList<>();
afterGrandmaChoices.add(new Choice("Keep moving", "You step outside your room again.", "girl_meet", 0, 0, ""));
DialogueNode bedroomAfterGrandma = new DialogueNode("bedroom_after_grandma", "You sit in your room, the scent of herbs still caught in your sleeve.\nYou don't know if anything changed.\nBut something shifted weight.", afterGrandmaChoices, narrator, bedroom);
nodes.put("bedroom_after_grandma", bedroomAfterGrandma);

// --- girl_waits ---
ArrayList<Choice> girlWaitsChoices = new ArrayList<>();
girlWaitsChoices.add(new Choice("I kept the box after.", "She raises an eyebrow, but doesn’t joke.", "girl_connection", 0, 0, "")); // conditional flag set in engine
girlWaitsChoices.add(new Choice("Doesn’t matter now.", "She looks away, then shrugs.", "girl_flat", 0, 0, ""));
DialogueNode girlWaits = new DialogueNode("girl_waits", "She kicks at a rock. Misses on purpose.\n“Don’t worry. I’m not fishing for tragic poetry or whatever.”\nShe glances at you.\n“But if you were going to say something... I’d probably listen.”", girlWaitsChoices, girl, park);
nodes.put("girl_waits", girlWaits);

// --- girl_connection ---
ArrayList<Choice> girlConnectChoices = new ArrayList<>();
girlConnectChoices.add(new Choice("You imagine the sign above the door.", "You don’t say yes. But you don’t say no.", "bedroom_before_future", 0, 2, ""));
DialogueNode girlConnection = new DialogueNode("girl_connection", "She whistles low. “That’s gross. And sweet. Mostly gross.”\nShe pauses, then:\n“You ever wanna open something? Like a weird shop or a fake library or something?”\nShe grins without showing teeth.\n“We’d have rules. No shoes. No small talk. Yes to snacks.”", girlConnectChoices, girl, park);
// IMPORTANT: setFlag("relationship", true) in GameEngine if selfIdentity >= 3
nodes.put("girl_connection", girlConnection);

// --- girl_flat ---
ArrayList<Choice> fixedGirlFlatChoices = new ArrayList<>();
fixedGirlFlatChoices.add(new Choice("Go home", "You turn back before she does.", "bedroom_before_future",0,0,""));
DialogueNode fixedGirlFlat = new DialogueNode("girl_flat", "She shrugs. “Okay.”\\nThen: “If you ever do wanna say more, maybe say it like that.\\nLike it already happened. Like it’s done being dangerous.”", fixedGirlFlatChoices, girl, park);
nodes.put("girl_flat", fixedGirlFlat);


// --- future_decision ---
ArrayList<Choice> futureChoices = new ArrayList<>();
futureChoices.add(new Choice("Stay close to home", "You close the application. There's comfort in staying.", "ending_local",0,0,""));
futureChoices.add(new Choice("Move to the city", "You type your name, almost automatically.", "ending_city",0,0,""));
futureChoices.add(new Choice("Apply abroad", "You don’t know what you'll say in the essay. You apply anyway.", "ending_abroad",0,0,""));

DialogueNode futureDecision = new DialogueNode("future_decision", "You sit by the window, the application still open.\nYou try to picture a map.\nNone of the places have names yet. But they pull anyway.", futureChoices, narrator, bedroom);
nodes.put("future_decision", futureDecision);

// --- ending_local ---
ArrayList<Choice> endingLocalChoices = new ArrayList<>();
endingLocalChoices.add(new Choice("...", "You reach for the curtain, then let it go.", "end",0,0,""));
DialogueNode endingLocal = new DialogueNode("ending_local", "You stay.\nThe room remains the same. The window sticks a little when you open it.\nOutside, familiar noises. Inside, an unfinished box of chocolates.\nYou still haven’t thrown it away.", endingLocalChoices, narrator, bedroom);
nodes.put("ending_local", endingLocal);

// --- ending_city ---
ArrayList<Choice> endingCityChoices = new ArrayList<>();
endingCityChoices.add(new Choice("Step outside", "The street smells different. Maybe better.", "end",0,0,""));
DialogueNode endingCity = new DialogueNode("ending_city", "You move to the city.\nIt’s not a clean break. You carry more than your boxes.\n\nSome nights, the sidewalks echo like the garden used to.\nAnd sometimes, that’s enough.", endingCityChoices, narrator, park);
nodes.put("ending_city", endingCity);

// --- ending_abroad ---
ArrayList<Choice> endingAbroadChoices = new ArrayList<>();
endingAbroadChoices.add(new Choice("Board the plane", "You take the window seat. You always do.", "end",0,0,""));
DialogueNode endingAbroad = new DialogueNode("ending_abroad", "You leave the country.\nThe air is different—not just the temperature, but the weight.\nYou remember your grandmother’s hands on your shoulder, her voice saying, \"It’s time you chose for yourself.\"", endingAbroadChoices, narrator, bedroom);
nodes.put("ending_abroad", endingAbroad);

return nodes;

    }
}