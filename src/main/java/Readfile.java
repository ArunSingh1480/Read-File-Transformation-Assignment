import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Readfile {
    public static void main(String [] args) throws IOException {
        FileWriter myWriter = new FileWriter("filename.txt");
        myWriter.write("Java 8 is the latest release for Java that contains new features, enhancements and bug fixes to improve efficiency to develop and run Java programs.");
        myWriter.close();

        String filename = "filename.txt";
        List<String> stringList = Files.lines(Paths.get(filename))
                .collect(Collectors.toList());
        //read from file
        String str = stringList.stream().collect(Collectors.joining("."));
        System.out.println(str);
        //count word frequency

        List <String> list = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());

        Map<String, Integer > wordCounter = list.stream()
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

        System.out.println(wordCounter);

    }
    }

