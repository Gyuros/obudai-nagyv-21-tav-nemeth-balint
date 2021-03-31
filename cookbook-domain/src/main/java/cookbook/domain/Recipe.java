package cookbook.domain;

public class Recipe {

    private long id;
    private String name;
    private int servings;
    private String preparation;
    private Cook uploader;

    public Recipe(long id, String name, int servings, String preparation) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.preparation = preparation;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getServings() {
        return servings;
    }

    public String getPreparation() {
        return preparation;
    }

    public Cook getUploader() {
        return uploader;
    }
}
