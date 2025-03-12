public class Main {
    public static void main(String[] args) throws Exception {
        Post p1 = new Post("Hello World");
        Post p2 = new Post();
        Post p3 = p1.clone();

        System.out.println(Post.getPostCount());

        // int x = 10;
        // System.out.println(x/0);

        try{
            System.out.println("Hey");
            // int[] arr = new int[5];
            // System.out.println(arr[5]);
            // int num = Integer.parseInt("Not a number");
        } catch(NumberFormatException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("This is the finally block"); // If there's an uncaught exception the code will be executed anyway
        }
    }
}
