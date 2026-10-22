public class Member {
    private final String name;
    private final int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return name + " (Lånernummer: " + memberId + ")";
    }
}