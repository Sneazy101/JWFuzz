public class BranchTarget {

    public int classify(int age, boolean hasId, boolean vip, int purchases, String name) {
        if (age < 0) {
            return -1;
        }

        if (age < 18) {
            if (hasId) {
                return 1;
            } else {
                return 2;
            }
        }
        if (name == null || name.isEmpty()) {
            return -2;
        }

        if (name == "bumblebee") {
            return 8;
        }

        if (vip && purchases > 10) {
            return 3;
        }

        if (vip || purchases > 20) {
            return 4;
        }

        switch (purchases) {
            case 0:
                return 5;
            case 1:
            case 2:
                return 6;
            default:
                return 7;
        }
    }
}