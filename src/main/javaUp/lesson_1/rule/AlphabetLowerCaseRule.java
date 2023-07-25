package main.javaUp.lesson_1.rule;

import main.javaUp.lesson_1.util.StringUtil;

public class AlphabetLowerCaseRule extends AbstractBasicRule {

    public AlphabetLowerCaseRule(int length) {
        super(length);
    }

    @Override
    protected void setupValidCarters() {
        this.validCharters = StringUtil.generateLowerCharters();
    }


}
