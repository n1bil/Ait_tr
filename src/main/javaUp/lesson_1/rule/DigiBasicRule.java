package main.javaUp.lesson_1.rule;

public class DigiBasicRule extends AbstractBasicRule{

    public DigiBasicRule(int length) {
        super(length);
    }

    @Override
    protected void setupValidCarters() {
        this.validCharters = "0123456789";
    }
}
