public class App {
    public static void main(String[] args) throws Exception {
        String name = "John Doe";
        name = name.replace('h', 'd');
        System.out.println(name);

        String replaced = name.replaceAll("Doe", "Smith");

        System.out.println(replaced);
    }
}
