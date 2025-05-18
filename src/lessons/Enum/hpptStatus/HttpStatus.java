package lessons.Enum.hpptStatus;

public enum HttpStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found");

    private final int code;
    private final String description;


    HttpStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
