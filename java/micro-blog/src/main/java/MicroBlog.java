class MicroBlog {
    public String truncate(String input) {
        // StringBuilder str = new StringBuilder(input);
        // int end = input.length() < 6 ? 5 : input.length();
        // return str.substring(0, end).toString();
        return input.length() < 6 ? input : input.substring(0, input.offsetByCodePoints(0, 5));
    }
}
