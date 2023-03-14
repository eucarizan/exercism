class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder str = new StringBuilder();
        boolean dashflag = false;
        
        for (char ch : identifier.toCharArray()) {
            if (ch == ' ') {
                str.append("_");
            } else if (ch == '-') { 
                dashflag = true;
            } else if (Character.isISOControl(ch)) {
                str.append("CTRL");
            } else if (Character.isLetter(ch) && (ch < 'α' || ch >  'ω')) {
                if (dashflag) {
                    ch = Character.toUpperCase(ch);
                    dashflag = false;
                }
                str.append(ch);
            }
        }

        return str.toString();
    }
}
