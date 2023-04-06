import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        // String[] array = rnaSequence.split("(?<=\\G...)");
        
        // return Arrays.stream(array).map(w -> getValue(w)).takeWhile(w -> !w.equals("STOP")).collect(Collectors.toList());
        return Arrays.stream(rnaSequence.split("(?<=\\G...)"))
                .map(this::getValue)
                .takeWhile(w -> !w.equals("STOP"))
                .collect(Collectors.toList());
    }

    private String getValue(String str) {
        return switch (str) {
            case "AUG" -> "Methionine";
            case "UUU", "UUC" -> "Phenylalanine";
            case "UUA", "UUG" -> "Leucine";
            case "UCU", "UCC", "UCA", "UCG" -> "Serine";
            case "UAU", "UAC" -> "Tyrosine";
            case "UGU", "UGC" -> "Cysteine";
            case "UGG" -> "Tryptophan";
            case "UAA", "UAG", "UGA" -> "STOP";
            default -> throw new IllegalArgumentException("Invalid sequence: " + str);
        };

        // return out;
    }

    // public static void main(String[] args) {
    //     ProteinTranslator ptr = new ProteinTranslator();
    //     ptr.translate("AUGUUUUCUUAAAUG").forEach(System.out::println);
    // }

}

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

// class ProteinTranslator {
//     final String STOP = "STOP";
//     HashMap<String, String> proteinMap = new HashMap<String, String>();
//     public ProteinTranslator(){
//         multiPut("Methionine", "AUG");
//         multiPut("Phenylalanine", "UUU", "UUC");
//         multiPut("Leucine", "UUA", "UUG");
//         multiPut("Serine", "UCU", "UCC", "UCA", "UCG");
//         multiPut("Tyrosine", "UAU", "UAC");
//         multiPut("Cysteine", "UGU", "UGC");
//         multiPut("Tryptophan","UGG");
//         multiPut(STOP, "UAA", "UAG", "UGA");
//     }
//     //Other answers used maps, so I decided to try that approach instead of the endless if-else if chain.
//     // I found it to be exactly as tedious, so I decided to write a helper function
//     // to skip writing some of the many Map.put calls, since the values are repeated multiple times.
//     // In addition to being a lot less tedious, the code is (at least to me)
//     // a lot easier to follow.
//     String multiPut(String value, String... keys){
//         for(String key : keys){
//             proteinMap.put(key, value);
//         }
//         return value;
//     }
//     List<String> translate(String rnaSequence) throws IllegalArgumentException {
//         ArrayList<String> proteins = new ArrayList<String>();
//         String codon, protein;
//         for(int i = 0; i < rnaSequence.length()-2; i += 3){
//             codon = rnaSequence.substring(i, i+3);
//             protein = proteinMap.get(codon);
//             if(protein == STOP) break;
//             if(protein == null) throw new IllegalArgumentException("codon must be an accepted codon.");
//             proteins.add(protein);
//         }
//         return proteins;
//     }
// }
