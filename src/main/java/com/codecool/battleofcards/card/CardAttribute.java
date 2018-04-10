public class CardAttribute {
    private final String LABEL;
    private final double VALUE;

    public CardAttribute(String label, double value) {
        this.LABEL = label;
        this.VALUE = value;
    }

    public String getLabel() {
        return this.LABEL;
    }

    public String getValue() {
        return this.VALUE;
    }
}