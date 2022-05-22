import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test 
    public void testGetLinks() {
        String toTest1 = 
        "# Title [link1](https://something.com) [link2](some-thing.html)";

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        ArrayList<String> result = MarkdownParse.getLinks(toTest1);
        assertEquals(expected,result);
    }
    @Test 
    public void testGetLinks2() {
        String toTest2 = 
        "# Title2 [link](https://rando.org/file-name) [link2](https://google.com) [link3](rando.gov)";

        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://rando.org/file-name");
        expected.add("https://google.com");
        expected.add("rando.gov");
        ArrayList<String> result = MarkdownParse.getLinks(toTest2);
        assertEquals(expected,result);
    }
    @Test 
    public void testGetLinks3() {
        String toTest3 = 
        "[link]rando.com [link](rando.gov) [link](rando.org) link(rando.com)";

        ArrayList<String> expected = new ArrayList<>();
        expected.add("rando.gov");
        expected.add("rando.org");
        ArrayList<String> result = MarkdownParse.getLinks(toTest3);
        assertEquals(expected,result);
    }
    @Test 
    public void testGetLinks4() {
        String toTest = "";

        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> result = MarkdownParse.getLinks(toTest);
        assertEquals(expected,result);
    }

    @Test
    public void testGetLinks5() throws IOException {
        MarkdownParse test = new MarkdownParse();

        Path fileName = Path.of("/Users/jasonhu/Documents/GitHub/markdown-parser/test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = test.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-page.html");
        assertEquals(expected,links);
    }

    @Test
    public void testGetLinks6() throws IOException {
        MarkdownParse test = new MarkdownParse();

        Path fileName = Path.of("/Users/jasonhu/Documents/GitHub/markdown-parser/test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = test.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected,links);
    }

    @Test
    public void testGetLinks7() throws IOException {
        MarkdownParse test = new MarkdownParse();

        Path fileName = Path.of("/Users/jasonhu/Documents/GitHub/markdown-parser/test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = test.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected,links);
    }

    @Test
    public void testGetLinks8() throws IOException {
        MarkdownParse test = new MarkdownParse();

        Path fileName = Path.of("/Users/jasonhu/Documents/GitHub/markdown-parser/test-file7.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = test.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected,links);
    }

    @Test
    public void testGetLinks9() throws IOException {
        MarkdownParse test = new MarkdownParse();

        Path fileName = Path.of("/Users/jasonhu/Documents/GitHub/markdown-parser/test-file8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = test.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("a link on the first line");

        assertEquals(expected,links);

    }
    
    @Test
    public void MDPTestSnippet1() throws IOException{
        Path snippet1Path = Path.of("TestSnippet1.md");
        String snippet1Content = Files.readString(snippet1Path);
        ArrayList<String> links = MarkdownParse.getLinks(snippet1Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add("`google.com");
        result.add("google.com");
        result.add("ucsd.edu");
        assertEquals(result, links);
    }
    
    @Test
    public void MDPRTestSnippet2() throws IOException{
        File file = new File("TestSnippet2.md");
        Scanner s = new Scanner(file);
        ArrayList<String> links = MarkdownParseReview.getLinks(s);
        ArrayList<String> result = new ArrayList<String>();
        result.add("a.com");
        result.add("a.com(())");
        result.add("example.com");
        assertEquals(result, links);
    }
    
    @Test
    public void MDPRTestSnippet3() throws IOException{
        File file = new File("TestSnippet3.md");
        Scanner s = new Scanner(file);
        ArrayList<String> links = MarkdownParseReview.getLinks(s);
        ArrayList<String> result = new ArrayList<String>();
        result.add("https://www.twitter.com");
        result.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        result.add("https://cse.ucsd.edu/");
        assertEquals(result, links);
    }
}
