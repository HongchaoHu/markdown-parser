import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest1 () {
        String tester1 = "[link1](https://something.com) [link2](some-thing.html)";
        assertEquals("https://something.com some-thing.html", MarkdownParse.getLinks(tester1));
    }

    @Test
    public void getLinksTest2() {
        String tester2 = "[stuff] paragraph (page.com)";
        assertEquals("page.com", MarkdownParse.getLinks(tester2));
    }
}