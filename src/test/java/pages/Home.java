package pages;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Home {

    private static final AtomicLong heartCounter = new AtomicLong();

    String heart;
    String familyMotto = "Be happy with what you have, while working for what you want";
    List<Member> family = new LinkedList<>();
    List<Member> visitors = new LinkedList<>();
    List<Member> studySubjects = new LinkedList<>();

    public Home() {
        heart = String.valueOf(heartCounter.getAndIncrement());
    }

    public String getFamilyMotto() {
        return familyMotto;
    }

    public void setFamilyMotto(String familyMotto) {
        this.familyMotto = familyMotto;
    }

    public boolean addFamilyMember(FamilyMember familyMember) {
        if (!family.isEmpty()) {
            String familySymbol = ((FamilyMember) family.get(0)).getFamilySymbol();
            if (!familyMember.getFamilySymbol().equals(familySymbol)) return false;
        }
        family.add(familyMember);
        return true;
    }

    public List<Member> getFamilyMembers() {
        return family;
    }

    public void addVisitor(Member guest) {
        visitors.add(guest);
    }

    public List<Member> getVisitors() {
        return visitors;
    }

    public String toString() {
        Map<String,List<Member>> all = new LinkedHashMap<>();
        all.put("Family: ", family);
        all.put("Visitors: ", visitors);
        all.put("Study subjects: ", studySubjects);
        StringBuilder strBuilder = new StringBuilder();
        all.forEach((k,v) -> { strBuilder.append(k);
                               for (Member member : v) strBuilder.append(member).append(" ");
                               strBuilder.append("\n");
                             });
        return strBuilder.toString();
    }
}
