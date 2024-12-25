package itmo.proga.entity.character.characters;

import itmo.proga.entity.character.Character;

import java.util.HashMap;
import java.util.Map;

public class Shorty extends Character{
    private Map<String, Character> characters;

    @Override
    public boolean isCanDrive() {
        return false;
    }

    public Shorty(String name) {
        super(name);
        this.characters = new HashMap<>();
    }

    public void addCharacter(Character character) {
        characters.put(character.getName(), character);
    }

    public Character getCharacter(String name) {
        return characters.get(name);
    }

    public void removeCharacter(String name) {
        characters.remove(name);
    }

    public void printCharacters() {
        for (Map.Entry<String, Character> entry : characters.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}