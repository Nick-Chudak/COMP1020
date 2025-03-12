import java.io.*;

public class Main {
    public static void main(String[] args) {
        String FILE1_PATH = "C:\\Users\\nchud\\Desktop\\UofM\\COMP1020\\Homework\\W4\\Person1.txt";
        String FILE2_PATH = "C:\\Users\\nchud\\Desktop\\UofM\\COMP1020\\Homework\\W4\\Person2.txt";
        String OUTPUT_FILE_PATH = "C:\\Users\\nchud\\Desktop\\UofM\\COMP1020\\Homework\\W4\\Conversation.txt";

        int count1 = countLines(FILE1_PATH);
        int count2 = countLines(FILE2_PATH);

        if (count1 == 0 && count2 == 0) {
            return;
        }

        Message[] messages1 = new Message[count1];
        Message[] messages2 = new Message[count2];
        Message[] conversation = new Message[count1 + count2];

        count1 = readMessages(FILE1_PATH, messages1);
        count2 = readMessages(FILE2_PATH, messages2);

        writeConversation(OUTPUT_FILE_PATH, conversation);
    }

    public static int countLines(String fileName) {
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            System.err.println("Error: " + fileName);
        }
        return lines;
    }

    public static int readMessages(String fileName, Message[] messages) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Message message = parseMessage(line);
                if (message != null) {
                    messages[count++] = message;
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + fileName);
        }
        return count;
    }

    public static Message parseMessage(String line) {
        String[] parts = line.split(" ", 3);

        String senderName = parts[0].substring(1, parts[0].length() - 1);
        String timestamp = parts[1] + " " + parts[2].split(" ", 2)[0];
        String content = parts[2].split(" ", 2)[1];

        return new Message(new Person(senderName), new DateTime(timestamp), content);
    }

    public static int mergeMessages(Message[] messages1, int count1, Message[] messages2, int count2, Message[] conversation) {
        int i = 0, j = 0, k = 0;

        while (i < count1 && j < count2) {
            conversation[k++] = (messages1[i].compareTo(messages2[j]) <= 0) ? messages1[i++] : messages2[j++];
        }

        while (i < count1) {
            conversation[k++] = messages1[i++];
        }

        while (j < count2) {
            conversation[k++] = messages2[j++];
        }

        return k;
    }

    public static void writeConversation(String fileName, Message[] conversation) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Message message : conversation) {
                if (message == null) break;
                bw.write(message.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error: " + fileName);
        }
    }
}
