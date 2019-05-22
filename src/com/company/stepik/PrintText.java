package com.company.stepik;

class PrintText {
    public static void main(String[] args) {
        String[] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич", "Граф", "Граф2", "Граф с будуна", "Си Цзинь Пинь"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                "Граф:", "Граф2:", "Граф с будуна:",
                "Си Цзинь Пинь: Нихао.",
        };

        PrintText printText = new PrintText();
        System.out.println(printText.printTextPerRole(roles, textLines));

        ProcessBuilder processBuilder;
    }

    private String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < textLines.length + 1; i++) {
            textLines[i - 1] += i;
        }

        for (int i = 0; i < roles.length; i++) {

            String role = roles[i];
            stringBuilder.append(role + ":\n");

            int roleLength = role.length();
            int textLinesLength = 0;
            int j = 0;

            while (textLines.length != textLinesLength) {

                String text = textLines[j];
                int numLine = String.valueOf(Math.abs(j + 1)).length();
                int textLength = text.length();
                textLinesLength++;

                if (text.startsWith(role + ":")) {
                    stringBuilder.append((text.substring(textLength - numLine)) + ")" +
                            text.substring(roleLength + 1, (textLength - numLine)) + "\n");
                }
                j++;
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
