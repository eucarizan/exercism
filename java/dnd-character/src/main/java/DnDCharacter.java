import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hp;

    public DnDCharacter() {
        this.strength = ability(rollDice());
        this.dexterity = ability(rollDice());
        this.constitution = ability(rollDice());
        this.intelligence = ability(rollDice());
        this.wisdom = ability(rollDice());
        this.charisma = ability(rollDice());
        this.hp = 10 + modifier(constitution);
    }

    int ability(List<Integer> scores) {
        return scores.stream()
            .sorted(Collections.reverseOrder())
            .limit(3)
            .reduce(0, Integer::sum);
    }

    List<Integer> rollDice() {
        List<Integer> out = new ArrayList<>();
        int dice;

        for (int i = 0; i < 4; i++) {
            dice = (int) (Math.random() * 6 + 1);
            out.add(dice);
        }

        return out;
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hp;
    }
}
