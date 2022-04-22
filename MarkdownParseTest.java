import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinks() {
        String tester1 = "[link1](https://something.com) [link2](some-thing.html)";
        assertEquals("https://something.com some-thing.html", MarkdownParse.getLinks(tester1));
    }
}