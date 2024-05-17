package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private final String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        if (index <0 || index >= length()) {
            throw new IndexOutOfBoundsException();
        }
        return new StringBuilder(text).reverse().toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start <0 || end > length() || start > end) {
            throw new IndexOutOfBoundsException();
        }
        return new ReversedSequence(text.substring(length() - end, length() - start));
    }

    @Override
    public String toString() {
        return new StringBuilder(text).reverse().toString();
    }
}
// END
