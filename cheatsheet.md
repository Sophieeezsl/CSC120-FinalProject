
## 🧭 Basic Gameplay

- You begin in your bedroom.
- At every scene, you will be presented with **choices**.
- Your **choices affect internal attributes** such as:
  - `shame`
  - `selfIdentity`
  - `memories`
  - and several hidden `flags` (e.g., `grandmaSupport`, `relationship`)
- Depending on your stats and flags, **different endings** will become available.
- **There is no “right” or “wrong” path**—but your decisions shape the story.

---

## 💡 Available Commands

- Enter a **number** (1, 2, 3…) to choose a dialogue option.
- You can enter **`C` (capital C)** at any time to view your current stats:
  - Self Identity
  - Shame
  - Unlocked memories
  - Flags like grandma support or relationship status

---

## 🌍 World Layout (Physical Locations)

```
         +--------------+
         |   Bedroom    |
         +------+-------+
                |
     +----------+-----------+
     |                      |
 [Kitchen]              [Garden]
     |                      |
 [Porch (Grandma)]     [Boy appears here]
                            |
                      [Street (Girl)]
```

- All routes begin and end in the **bedroom**, which serves as your central hub.
- **Garden** leads to meeting the **boy**.
- **Street** (via a walk) leads to meeting the **girl**.
- **Porch** unlocks after certain choices, where you can talk to **Grandma**.

---

## 🔓 Unlock Conditions for Hidden Paths

| Path / Option | Unlock Condition |
|---------------|------------------|
| Visit Grandma | Reach the `bedroom_after_boy` node |
| “Apply Abroad” ending | `selfIdentity ≥ 3` and `grandmaSupport == true` |
| “Open a shop together” (Girl Relationship Ending) | Reach `girl_connection` and `selfIdentity ≥ 3` |
| Chocolate Memory | Trigger flashback → choose memory → unlock “Chocolate Incident” |

---

## 🎭 Endings

### 1. **Stay close to home**
- Triggered if:
  - You reach `future_decision`
  - And your `shame ≥ 4`
  Found him first → Discovery (+2 Shame)
  Hit him → +2 Shame

### 2. **Move to the city**
- Always available

### 3. **Apply abroad**
- Only appears if:
  - `grandmaSupport == true`
  - `selfIdentity ≥ 3`
  Deny role(-1 Self-Identity)
  First Boy Meeting Deny feelings → Silence Path (-1 Self-Identity)
  Boy's joke deflection (+1)
  Girl connection (+2)
  Boy's silent acceptance (+2)

### 🌱 Ending Flavors
Each ending includes **epilogues** based on:
- Whether you remembered the **Chocolate Incident**
- Whether you connected with the **Girl**
- Whether you earned **Grandma’s support**

---

## 🧩 Optional Narrative Paths

| Optional Path | How to Access |
|---------------|----------------|
| Flashback (Eko) | Talk to mother and don’t deny your role |
| Boy conflict | Stay in garden memory → interact with boy → revisit him later |
| Girl friendship | Walk from bedroom → choose emotionally open answers |
| Grandma support | Sit with her, choose thoughtful questions |

