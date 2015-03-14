package se.doodle.model.canvas.shapes;

public enum AvailableShapes {

    SQUARE("Square"),
    CIRCLE("Circle"),
    RECTANGLE("Rectangle");
	
    private final String text;

    private AvailableShapes(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
