package main.javaUp.lesson_2;

import main.javaUp.lesson_2.rule.AbstractBasicRule;
import main.javaUp.lesson_2.rule.AlphabetLowerCaseRule;
import main.javaUp.lesson_2.rule.DigiBasicRule;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        AbstractBasicRule ruleAlphabet = new AlphabetLowerCaseRule(1);
        AbstractBasicRule ruleDigi = new DigiBasicRule(1);
        List<AbstractBasicRule> ruleList = new ArrayList<>();
        ruleList.add(ruleAlphabet);
        ruleList.add(ruleDigi);

        PasswordGenerator passwordGenerator = new PasswordGenerator(10);
        for (int i = 0; i < 5; i++) {
            String generate = passwordGenerator.generate(ruleList);
            System.out.println(generate);
        }
    }
}
