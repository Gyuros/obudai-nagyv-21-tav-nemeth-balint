package cookbook.service.dto;

public class RecipeDto {

    private long id;
    private CookDto uploader;

    public long getId() {
        return id;
    }

    public CookDto getUploader() {
        return uploader;
    }
}
