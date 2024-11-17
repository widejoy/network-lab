import java.util.Comparator; 
import java.util.PriorityQueue; 
import java.util.Scanner; 
  
class Huffman { 
  
    public static void printCode(HuffmanNode root, String s) { 
        if (root.left == null && root.right == null && Character.isLetter(root.c)) { 
            System.out.println(root.c + ":" + s); 
            return; 
        } 
        printCode(root.left, s + "0"); 
        printCode(root.right, s + "1");
 
    } 
  
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        
        // Taking input for the number of characters
        System.out.print("Enter the number of characters: ");
        int n = scanner.nextInt();
        
        // Arrays to store characters and their frequencies
        char[] charArray = new char[n];
        int[] charfreq = new int[n];
        
        // Taking input for characters and their frequencies
        for (int i = 0; i < n; i++) { 
            System.out.print("Enter character " + (i + 1) + ": ");
            charArray[i] = scanner.next().charAt(0);  // Read character
            
            System.out.print("Enter frequency for " + charArray[i] + ": ");
            charfreq[i] = scanner.nextInt();  // Read frequency
        }
        
        // Creating a priority queue (min-heap) with custom comparator
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator()); 
        
        // Adding nodes to the priority queue
        for (int i = 0; i < n; i++) { 
            HuffmanNode hn = new HuffmanNode(); 
            hn.c = charArray[i]; 
            hn.data = charfreq[i]; 
            hn.left = null; 
            hn.right = null; 
            q.add(hn); 
        } 
  
        HuffmanNode root = null; 
  
        // Building the Huffman tree
        while (q.size() > 1) { 
            HuffmanNode x = q.peek(); 
            q.poll(); 
            HuffmanNode y = q.peek(); 
            q.poll(); 
  
            HuffmanNode f = new HuffmanNode(); 
            f.data = x.data + y.data; 
            f.c = '-'; 
            f.left = x; 
            f.right = y; 
            root = f; 
            q.add(f); 
        } 
  
        // Printing the Huffman codes
        printCode(root, ""); 
    } 
} 
  
class HuffmanNode { 
    int data; 
    char c; 
    HuffmanNode left; 
    HuffmanNode right; 
} 
  
class MyComparator implements Comparator<HuffmanNode> { 
    public int compare(HuffmanNode x, HuffmanNode y) { 
        return x.data - y.data; 
    } 
}