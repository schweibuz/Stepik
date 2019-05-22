package com.company.stepik.textAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {

    private String[] strings = new String[]{":(", "=(", ":|"};

    public NegativeTextAnalyzer() {
    }

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    @Override
    protected String[] getKeywords() {
        return strings;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
