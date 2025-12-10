public class ClassObject1 extends UIControl {
    public String text; // Field

    public ClassObject1() {
        super(true);
        System.out.println("ClassObject1 "); // Constructors
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
 
