import java.util.HashMap;
import java.util.Map;

class Character {
    private char value;
    private String font;
    private int size;

    public Character(char value, String font, int size) {
        this.value = value;
        this.font = font;
        this.size = size;
    }

    public void display(int x, int y) {
        System.out.println("Displaying '" + value + "' at (" + x + ", " + y + ") with font " + font + " and size " + size);
    }
}

class CharacterFactory {
    private Map<String, Character> characterPool = new HashMap<>();

    public Character getCharacter(char value, String font, int size) {
        String key = value + font + size;
        if (!characterPool.containsKey(key)) {
            characterPool.put(key, new Character(value, font, size));
        }
        return characterPool.get(key);
    }

    public int getPoolSize() {
        return characterPool.size();
    }
}

class TextEditor {
    private CharacterFactory characterFactory = new CharacterFactory();

    public void insertText(String text, String font, int size) {
        int x = 0, y = 0; // Example coordinates
        for (char c : text.toCharArray()) {
            Character character = characterFactory.getCharacter(c, font, size);
            character.display(x, y);
            x += 10; // Move x-coordinate for the next character
        }
    }

    public int getFlyweightPoolSize() {
        return characterFactory.getPoolSize();
    }
}

class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        System.out.println("Inserting text...");
        editor.insertText("hello world", "Arial", 12);
        editor.insertText("hello flyweight", "Arial", 12);

        System.out.println("\nFlyweight pool size: " + editor.getFlyweightPoolSize());
    }
}
