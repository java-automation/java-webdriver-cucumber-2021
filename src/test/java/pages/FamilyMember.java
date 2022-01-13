package pages;

public class FamilyMember implements Member {

    private Member member;
    private String familySymbol;

    public FamilyMember(Member member) {
        this.member = member.setGroup("family");
        familySymbol = new String(Character.toChars( 0x1F7E7)); // orange square
    }

    @Override
    public Member setGroup(String group) {
        return member.setGroup(group);
    }

    @Override
    public String getGroup() {
        return member.getGroup();
    }

    @Override
    public Member setName(String name) {
        return member.setName(name);
    }

    @Override
    public String getName() {
        return member.getName();
    }

    @Override
    public String toString() {
        return member.toString() + "of" + familySymbol;
    }

    public String getFamilySymbol() {
        return familySymbol;
    }

    public void setFamilySymbol(String familySymbol) {
        this.familySymbol = familySymbol;
    }
}
