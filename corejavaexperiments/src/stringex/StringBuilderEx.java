package stringex;

public class StringBuilderEx {

    public static void main(String args[]) {
        StringBuilderEx demo = new StringBuilderEx();
        String result = demo.concatNumbersTill10();
        System.out.println(result);

        StringBuilder builder = new StringBuilder();
        builder.append("hello");
        builder.replace(1,3,"at");
        System.out.println(builder);
    }

    StringBuilder convertToStringBuilder(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        return builder;
    }

    String concatNumbersTill10() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            builder.append(i);
        }
        String result = builder.toString();
        return result;
    }
}
