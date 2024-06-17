package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    protected List<Tag> children;
    protected String body;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        String attrString = getAttributes().entrySet().stream()
                .map(entry -> String.format("%s=\"%s\"", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" "));

        String childrenString = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());

        return String.format("<%s%s>%s%s</%s>", getTagName(), attrString.isEmpty() ? "" : " " + attrString, body, childrenString, getTagName());
    }

}
// END
