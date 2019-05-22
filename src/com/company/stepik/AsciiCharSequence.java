package com.company.stepik;

class AsciiCharSequence implements CharSequence {

    public static void main(String[] args) {

        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(array);
        System.out.println("Length: " + asciiCharSequence.length());
        System.out.println("charAt: " + asciiCharSequence.charAt(2));
        System.out.println("charAt: " + asciiCharSequence.charAt(1));
        System.out.println("charAt: " + asciiCharSequence.charAt(3));
        System.out.println("charAt: " + asciiCharSequence.charAt(4));
        System.out.println("subSequence: " + asciiCharSequence.subSequence(1, 6).toString());

    }

    static byte[] array = {'d', 2, 'e', ',', 'F', '3', 's', 8};
    static byte[] charArray;

    public AsciiCharSequence(byte[] charArray) {
        this.charArray = charArray;
    }

    @Override
    public int length() {
        return charArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char) charArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subSequence = new byte[end - start];
        for (int i = start; i < end; i++)
            subSequence[i - start] += charArray[i];

        return new AsciiCharSequence(subSequence);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(charArray.length);
        for (int i = 0; i < charArray.length; i++) {
            result.append((char) charArray[i]);
        }
        return result.toString();
    }
}
