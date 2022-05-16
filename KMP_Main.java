package KMP_String_matching;

class KMP_Algo{
    String text;
    String pattern;

    public KMP_Algo(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }
    public void CalculateLPS(int[] LPS, int m){
        int len = 0;
        int i=1;
        LPS[0] = 0;

        while (i < m){
            if (pattern.charAt(len) == pattern.charAt(i) ){
                LPS[i] = len+1;
                len++;
                i++;
            }
            else {
                if (len != 0){
                    len = LPS[len-1];
                }
                else {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
//        System.out.println(Arrays.toString(LPS));
    }

    public void KMP(){
        int n = text.length();
        int m = pattern.length();

        int[] LPS = new int[m];
        CalculateLPS(LPS, m);

        int i=0;
        int j = 0;
        while (i < n){
//            Match
            if (text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }

//            Not match
            else {
                if (j != 0){
                    j = LPS[j-1];
                }
                else {
                    i++;
                }
            }
//            j == m
            if (j == m){
                int matchedIndex = i-j;
                System.out.println("Match found at: "+ matchedIndex + " index");
                j = LPS[j-1];
            }
        }
    }
}
public class KMP_Main {
    public static void main(String[] args) {
        String text = "ABABDCABCABABABD";
        String pattern = "ABABD";
        KMP_Algo kmp = new KMP_Algo(text, pattern);
        kmp.KMP();

    }
}
