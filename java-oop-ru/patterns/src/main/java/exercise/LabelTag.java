package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private String text;
    private TagInterface InputTag;

    public LabelTag(String text, TagInterface inputTag) {
        this.text = text;
        InputTag = inputTag;
    }

    @Override
    public String render() {
        return "<label>" + text + InputTag.render() + "</label>";
    }
}
// END
