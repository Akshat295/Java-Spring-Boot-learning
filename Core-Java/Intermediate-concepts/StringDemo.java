public class StringDemo {
    public static void main(String[] args) {

        // String (immutable)
        String s1 = "Hello";
        s1 = s1 + " World";
        System.out.println("String: " + s1);

        // StringBuilder (mutable)
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder: " + sb);

        // StringBuffer (thread-safe)
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer: " + sbf);
    }
}