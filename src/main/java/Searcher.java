import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher {

    private static final String PATTERN = "(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|" +
        "default|do|double|else|enum|extends|final|finally|float|for|goto|" +
        "if|implements|import|instanseof|int|interface|long|native|new|" +
        "package|private|protected|public|return|short|static|strictfp|super|switch|" +
        "synchronized|this|throw|throws|transient|try|void|volatile|while)([ ;,\n])";

    public void keywordsSearcherByteStreams(String fileName) {
        try {
            int count = 0;
            int bytes = 0;
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream outputStream = new FileOutputStream("keywords_byte.txt");
            StringBuilder stringsFromFile = new StringBuilder();
            StringBuilder textForOutput = new StringBuilder();

            while (bytes != -1) {
                stringsFromFile.append((char) bytes);
                bytes = inputStream.read();
            }
            inputStream.close();

            Matcher matcher = Pattern.compile(PATTERN).matcher(stringsFromFile);
            while (matcher.find()) {
                textForOutput.append(matcher.group(1)).append(" ");
                count++;
            }
            textForOutput.append("\nКолличество ключевых слов: ").append(count);
            outputStream.write(textForOutput.toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void keywordsSearcherCharStreams(String fileName) {

        try {
            int count = 0;
            int chars = 0;
            FileWriter outputStream = new FileWriter("keywords_char.txt");
            StringBuilder stringsFromFile = new StringBuilder();
            StringBuilder textForOutput = new StringBuilder();

            FileReader fileReader = new FileReader(fileName);

            while (fileReader.ready()) {
                stringsFromFile.append((char) chars);
                chars = fileReader.read();

            }

            Matcher matcher = Pattern.compile(PATTERN).matcher(stringsFromFile);
            while (matcher.find()) {
                textForOutput.append(matcher.group(1)).append(" ");
                count++;
            }

            textForOutput.append("\nКолличество ключевых слов: ").append(count);
            outputStream.write(textForOutput.toString());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

