class ReverseString {

    String reverse(String inputString) {
        // StringBuilder str = new StringBuilder(inputString);
        // return str.reverse().toString();
        String str = "";
        String[] line = inputString.split("");

        for (int i=inputString.length()-1; i>=0; i--) {
            str+=line[i];
        }

        return str;
    }
  
}
