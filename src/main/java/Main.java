public class Main {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\d.gulenkova\\IdeaProjects\\unit5\\javacode.java";
        new Searcher().keywordsSearcherByteStreams(fileName);
        new Searcher().keywordsSearcherCharStreams(fileName);
    }
}
