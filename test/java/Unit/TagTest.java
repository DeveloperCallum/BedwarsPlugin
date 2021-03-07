package Unit;

import TagAPI.DefualtTags.DateTag;
import TagAPI.Exceptions.TagNotFoundException;
import TagAPI.Exceptions.TagNotSupported;
import TagAPI.Handler.TagAPI;
import TagAPI.Handler.Tag.TagData;
import Unit.MockClasses.MockTags.NameTag;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.fail;

public class TagTest {
    private final Date date = new Date();
    private final TagAPI messages;

    public TagTest() {
        this.messages = new TagAPI();
        messages.getTagHandler().addTag(new DateTag("DateTag"));
        messages.addMessage("TestParse", "<DateTag> is current date!");
    }

    @Test
    public void TagNotFound() {
        try {
            messages.formatMessage("test", this);
        } catch (TagNotFoundException ignored) {
        } catch (Exception e) {
            fail("Should have thrown " + TagNotFoundException.class);
        }
    }

    @Test
    public void MatchResults() {
        String expected = (date.toString() + " is current date!"); //this is what i expect
        String actual = messages.formatMessage("TestParse", this); // this is what was returned
        if (!actual.toLowerCase().equals(expected.toLowerCase())) {
            fail("Expected & Actual results to not match. \nExpected: " + expected + " \nActual: " + actual);
        }
    }

    @Test
    public void MatchResultsCaseTest() {
        String expected = (date.toString() + " is current date!");
        String actual = messages.formatMessage("TeStPaRsE", this);
        if (!actual.toLowerCase().equals(expected.toLowerCase())) {
            fail("Expected & Actual results to not match. \nExpected: " + expected + " \nActual: " + actual);
        }
    }

    @Test
    public void TagEscaped() {
        String raw = "</datetag> this is the date";
        messages.addMessage("escaped", raw);
        String actual = messages.formatMessage("escaped", this).toLowerCase();
        String expected = raw.toLowerCase().replaceAll("/", "").toLowerCase();

        assert  actual.equals(expected);
    }

    @Test
    public void NoSupport() {
        try {
            messages.formatMessage("TestParse", new Object());
        } catch (TagNotSupported ignored) {
        } catch (Exception e) {
            fail("Should have thrown " + TagNotSupported.class + "\nThrown: " + e.getClass());
        }
    }

    @Test
    public void TagNotRegisteredException() {
        try {
            messages.addMessage("TestParse1", "<DateTag> is current date! <NameTag>");
            //messages.getTagHandler().addTag(new NameTag("NameTag"));
            System.out.println(messages.formatMessage("TestParse1", this));
        } catch (TagNotFoundException e) {
        } catch (Exception e) {
            fail("Tag should have thrown " + TagNotFoundException.class);
        }

    }

    @Test
    public void MultiTagSupport() {
        String raw = "<DateTag> is current date! <NameTag>";
        messages.addMessage("TestParse1", raw);
        messages.getTagHandler().addTag(new NameTag("NameTag"));

        String expected = (raw.toLowerCase().replaceAll("<datetag>", getDateTag().toString()).replaceAll("<nametag>", getNameTag())).toLowerCase();
        String actual = messages.formatMessage("TestParse1", this).toLowerCase();

        assert  expected.equals(actual);

    }

    @TagData
    public Date getDateTag() {
        return date;
    }

    @TagData
    public String getNameTag() {
        return "YesLOL";
    }
}

//It allows for dynamic tags. so <tag123> becomes banana

//this is a <tag123>
//beomes this is a banana. theses tags can be moved, created and you can have multiple.