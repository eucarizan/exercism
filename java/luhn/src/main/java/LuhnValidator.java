class LuhnValidator {
    private final int nums[] = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };

    boolean isValid(String candidate) {

        String num = candidate.replaceAll("\\s", "");

        if (num.length() < 2) {
            return false;
        }

        if (num.contains("-") || num.contains("#") || num.contains("$")) {
            return false;
        }

        if (!num.matches("\\d*")) {
            return false;
        }

        int sum = 0;

        for (int i = num.length() - 2; i >= 0; i -= 2) {
            int idx = Character.getNumericValue(num.charAt(i));
            sum += nums[idx];
        }

        for (int i = num.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(num.charAt(i));
        }

        return sum % 10 == 0;
    }
}
