package stringex;


/*
Class Source
Method-public StringBuilder convert(String string)
Find all the vowels in string and convert into ‘b’ in all the vowels and should return on StringBuilder.
 */
public class StringBuilderEx2 {


    public static void main(String args[]) {
        StringBuilderEx2 demo = new StringBuilderEx2();
        String input = "halao";
        StringBuilder result1 = demo.convert1(input);
        System.out.println(result1);

        StringBuilder result2 = demo.convert2(input);
        System.out.println("result2=" + result2);
    }

    StringBuilder convert1(String input) {
        StringBuilder builder = new StringBuilder();
        builder.append(input);
        for (int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);
            if (ch == 'a' || ch == 'A' || ch == 'o' || ch == 'O') {
                builder.setCharAt(i, 'b');
            }
        }
        return builder;

    }

    StringBuilder convert2(String input) {
        input = input.replace('a', 'b');
        input = input.replace('A', 'b');
        input = input.replace('o', 'b');
        input = input.replace('O', 'b');

        StringBuilder builder = new StringBuilder();
        builder.append(input);
        return builder;
    }
}
