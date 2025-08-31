import java.util.LinkedHashSet;
import java.util.*;

public class Patry {
    private final Set<String> vip = new LinkedHashSet<>();
    private final Set<String> regular = new LinkedHashSet<>();

    public static GuestType resolveType(String code) {
        return Character.isDigit(code.charAt(0)) ? GuestType.VIP : GuestType.REGULAR;
    }

    public void addReservation(String code) {
        if (resolveType(code) == GuestType.VIP) vip.add(code); else regular.add(code);
    }
    public void arrive(String code) {
        if (!vip.remove(code)) {
            regular.remove(code);
        }
    }
    public int absentCount() { return vip.size() + regular.size(); }
    public Iterable<String> absentVip() { return vip::iterator; }
    public Iterable<String> absentRegular() { return regular::iterator; }
}
