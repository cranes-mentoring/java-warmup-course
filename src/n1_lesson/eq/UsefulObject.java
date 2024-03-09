package n1_lesson.eq;

import java.util.Objects;

public class UsefulObject {

    private String testString;

    public UsefulObject() {}

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsefulObject)) return false;
        UsefulObject that = (UsefulObject) o;
        return Objects.equals(getTestString(), that.getTestString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTestString());
    }
}
