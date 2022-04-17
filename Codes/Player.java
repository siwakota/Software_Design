public class Player 
{
   // Private data fields
    private String name;
    private String character;
    private int Score;

    
    // Getters and setters for the private data fields.
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return this.character;
    }

    public void setCharacter(String sym) {
        this.character=sym;
    }

    public int getScore() {
        return this.Score;
    }

    public void setScore(int score) {
        this.Score = score;
    }
    
}
