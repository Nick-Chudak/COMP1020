public class Message {
    private Person person;
    private DateTime dateTime;
    private String content;

    // public static void main(String[] args) {
    //     String testOutput = "testOutput.txt";
    //     Message[] messages = new Message[2];
    //     messages[0] = new Message(new Person("Person1"), new DateTime("2024-03-04 09:00:00"), "Hello");
    //     messages[1] = new Message(new Person("Person2"), new DateTime("2024-03-04 09:05:00"), "Hi there!");
    //     Main.writeConversation(testOutput, messages);
    // }

    public Message(Person person, DateTime dateTime, String content) {
        this.person = person;
        this.dateTime = dateTime;
        this.content = content;
    }

    public int compareTo(Message other) {
        return (this.getDateTime().compareTo(other.getDateTime()));
    }

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public String getContent() {
        return this.content;
    }

    public Person getSender() {
        return this.person;
    }

    public String toString() {
        return String.format("[%s] %s %s", this.person.getName(), this.dateTime, this.content);
    }
}
