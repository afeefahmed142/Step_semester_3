public class NicknameTag {
    static final class NameTag {
        private final String firstName;
        private final char lastInitial;

        NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            firstName = parts[0];
            lastInitial = parts[1].charAt(0);
        }

        String getNickname() {
            return firstName + " " + lastInitial + ".";
        }
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}