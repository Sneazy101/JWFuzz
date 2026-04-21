public class MiniCoverageTarget {

    public int sign(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        return 1;
    }

    public boolean login(boolean validPassword, boolean locked, boolean admin) {
        if (locked) return false;
        if (validPassword && admin) return true;
        if (validPassword) return true;
        return false;
    }

    public String bucket(int n) {
        if (n < 0) return "neg";
        if (n < 10) return "small";
        if (n < 100) return "medium";
        return "large";
    }

    public int mode(int x) {
        switch (x) {
            case 0: return 10;
            case 1: return 20;
            default: return 30;
        }
    }
}