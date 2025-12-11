public class ClassObject extends UIControl {
    public String text; // Field

    public ClassObject() {
        super(true);
        System.out.println("ClassObject"); // Constructors
    }

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) { // Method
        this.text = text;
    }

    public void clearText() { // Method
        this.text = "";
    }
}
 