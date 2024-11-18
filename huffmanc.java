import java.util.*;
class HuffmanNode{
    int data;
    HuffmanNode left;
    HuffmanNode right;
    char c;
}
class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) { 
        return x.data - y.data; 
    } 
}
public class huffmanc {
    static HashMap<Character,String> encode = new HashMap<>();
    static HashMap<String,Character> decode = new HashMap<>();
        public static void printCode(HuffmanNode root, String s) { 
            if (root.left == null && root.right == null && Character.isLetter(root.c)) { 
                System.out.println(root.c + ":" + s); 
                encode.put(root.c, s);
                decode.put(s, root.c);
                return; 
        } 
        printCode(root.left, s+"0");
        printCode(root.right, s+"1");
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of characters:");
        n = sc.nextInt();
        char[] charArray = new char[n];
        int[] freqArray = new int[n];
        for(int i = 0;i<n;i++){
            System.out.println("Enter the "+ i +"th character:");
            charArray[i] = sc.next().charAt(0);
            System.out.println("Enter the "+ i +"th character's frequency:");
            freqArray[i] = sc.nextInt();
        }
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator()); 
        for(int i = 0;i<n;i++){
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = freqArray[i];
            hn.left = null;
            hn.right = null;
            q.add(hn); 
        }
        HuffmanNode root = null; 
        while(q.size()>1){
            HuffmanNode f = new HuffmanNode();
            HuffmanNode x = q.peek();
            q.poll();
            HuffmanNode y = q.peek();
            q.poll();
            f.data = x.data+y.data;
            f.left = x;
            f.right = y;
            f.c = '-';
            root = f;
            q.add(f);
        }
        sc.nextLine();
        printCode(root, "");
        System.out.println("Enter String to encode:");
        String s = sc.nextLine();
        for(int i = 0;i<s.length();i++){
            System.out.print(encode.get(s.charAt(i)));
        }
        System.out.println("Enter String to decode:");
        s = sc.nextLine();
        String buffer = "";
        for(int i = 0;i<s.length();i++){
            buffer+=s.charAt(i);
            if(decode.containsKey(buffer)){
                System.out.print(decode.get(buffer));
                buffer = "";
            }
        }

    }
    
}
