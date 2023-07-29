package main.javaUp.lesson_2.rule;

import main.javaUp.lesson_2.util.StringUtil;

public class AlphabetLowerCaseRule extends AbstractBasicRule {

    public AlphabetLowerCaseRule(int length) {
        super(length);
    }

    @Override
    protected void setupValidCarters() {
        this.validCharters = StringUtil.generateLowerCharters();
    }
}
