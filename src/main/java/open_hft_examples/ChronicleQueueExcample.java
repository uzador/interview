package open_hft_examples;

import net.openhft.chronicle.bytes.Bytes;
import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.ExcerptTailer;

public class ChronicleQueueExcample {
    public static void main(String[] args) {
        final String path = "C:\\Users\\WinUser\\IdeaProjects\\interview";

        try (final ChronicleQueue queue = ChronicleQueue.singleBuilder(path + "/trades").build()) {
            final ExcerptAppender appender = queue.acquireAppender();
            final String text = "My text to chronicle queue";

            appender.writeText(text);
            appender.writeText(text);
            appender.writeBytes(Bytes.allocateDirect(text.getBytes()));

            System.out.println(queue.dump());
        }

        System.out.println("READING ...");
        try (ChronicleQueue queue = ChronicleQueue.singleBuilder(path + "/trades").build()) {
            final ExcerptTailer tailer = queue.createTailer();

            tailer.readDocument(w-> System.out.println(w.asText()));

            System.out.println("1: " + tailer.readText());
            System.out.println("2: " + tailer.readText());
            System.out.println("3: " + tailer.readText());
            System.out.println("4: " + tailer.readText());
            System.out.println("5: " + tailer.readText());
        }
    }
}