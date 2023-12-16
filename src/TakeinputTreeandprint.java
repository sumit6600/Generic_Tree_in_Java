import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeinputTreeandprint {
    /**
     Take Input of tree in recursivelt manner
     */
    public static Treenode<Integer> takeInput(Scanner s){
        System.out.println("Enter the next node:");
        int n = s.nextInt();
        Treenode<Integer> root = new Treenode<Integer>(n);
        System.out.println("Enter the number of children  for :" + n);
        int childrenCount = s.nextInt();

        for(int i =0 ; i< childrenCount ; i++){
            Treenode<Integer> child = takeInput(s);
            root.children.add(child);

        }
        return root;
    }

    /**
     * @param root
     * Print trees in recursively manner
     */
    public static void print(Treenode<Integer> root){
        String s = root.data + ":";
        for (int i =0 ;i<root.children.size();i++){
            s = s + root.children.get(i).data + ", ";
        }
       System.out.println(s);
        if(root.children.size()==0){
            s = s + "0";
        }
        for (int i =0 ;i<root.children.size();i++){
            print(root.children.get(i));
        }

    }

    /**
     * @param s
     * @return
     * Take Input in level wise manner
     */
    public static Treenode<Integer> takeInputLevelWise(Scanner s){
        System.out.println("Enter the next node : ");
        int rootdata = s.nextInt();
        Queue<Treenode<Integer>> pendingNodes = new LinkedList<>();
        Treenode<Integer> root = new Treenode<Integer>(rootdata);
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()){
            Treenode<Integer> rootInner;
            rootInner = pendingNodes.poll();
            System.out.println("Enter the number of childrens for " + rootInner.data);
            int childCount = s.nextInt();
            for (int i = 0 ;i< childCount;i++){
                System.out.println("Children for " + (i+1 ) + "postion :" + rootInner.data);
                int child = s.nextInt();
                Treenode<Integer> childNodes = new Treenode<>(child);
                rootInner.children.add(childNodes);
                pendingNodes.add(childNodes);
            }
        }

        return root;
    }

    /**
     * @param root
     * Print Input in level wise manner
     */
    public static void printLevelWise(Treenode<Integer> root){
        Queue<Treenode<Integer>> pendingNode = new LinkedList<>();
        Treenode<Integer> nullnode = new Treenode<Integer>(Integer.MIN_VALUE);
        pendingNode.add(root);
        pendingNode.add(nullnode);
        System.out.println(root);
        while (pendingNode.size()!=1){
            Treenode<Integer> innerRoot = pendingNode.poll();
            if(innerRoot==nullnode){
                pendingNode.add(innerRoot);
                System.out.println();
            }
            for (int i =0;i<innerRoot.children.size();i++){
                System.out.print(innerRoot.children.get(i).data);
                pendingNode.add(innerRoot.children.get(i));
            }
        }
    }

    /**
     *
     * @param root
     * @return
     * Return total number of nodes in tree
     */
    public static int numOfNodes(Treenode<Integer> root){
        if(root ==null){
            return 0;
        }
        int count =1;
        for(int i=0;i<root.children.size();i++){
            count+=numOfNodes(root.children.get(i));
        }
        return count;
    }

    /**
     * @param root
     * Sum of nodes
     */
    public static int sumOfNodes(Treenode<Integer> root){
        if(root==null){
            return 0;
        }
        int sum = root.data;
        for (int i=0;i<root.children.size();i++){
            sum+=sumOfNodes(root.children.get(i));
        }
        return sum;
    }

    /**
     * @param root
     * Node with tha largest data
     */
    public static int nodeLargestData(Treenode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;  //This is not the base case
        }
        int larnum = root.data;
        for (int i=0;i<root.children.size();i++){
            int largernumber = nodeLargestData(root.children.get(i));
            if(largernumber>larnum){
                larnum =largernumber;
            }
        }
        return larnum;
    }

    /*
     * @param root
     * Number of nodes which is greater then x element
     */

    public static int numGreaterThenX(Treenode<Integer> root ,int x){
        if (root==null){
            return 0;
        }
        int count =0;
        if(root.data>x){
            count++;
        }
        for (int i =0;i<root.children.size();i++){
            count+=numGreaterThenX(root.children.get(i) ,x);
        }
        return count;
    }

    /**
     * @param root
     * Find height of node in a tree
     */
    public static int heightOfTree(Treenode<Integer> root){
        if (root==null){
            return 0;
        }
        int height =0;
        for (int i=0;i<root.children.size();i++){
            int count = heightOfTree(root.children.get(i));
            if(count>height){
                height =count;
            }
        }
        return height+1;
    }

    /**
     *
     * @param root
     * print nodes at k depth of nodes
     */
    public static void depthOfNodesAtK(Treenode<Integer> root , int k){
        if(root==null){
            System.out.println("Tree is Empty");
            return;
        }
        if(k<0){
            System.out.println("K is in the wrong format");
            return;
        }
        if(k==0){
            System.out.print(root.data + " ");
        }

        for (int i=0;i<root.children.size();i++){
            depthOfNodesAtK(root.children.get(i) , k-1);
        }
    }

    /**
     * @param root
     * Count number of leaf nodes
     */
    public static int countLeafNode(Treenode<Integer> root){
        if(root==null){
            return 0;
        }
        int count =0;
        if(root.children.size()==0){
            count++;
        }
        for (int i=0;i<root.children.size();i++){
           count+= countLeafNode(root.children.get(i));
        }
        return count;
    }

    /**
     * @param root
     * Pre order traversal in tree
     */
    public static void preOrderTraversal(Treenode<Integer> root){
       if(root==null){
           System.out.println("Tree is empty.");
           return;
       }
       System.out.print(root.data + " ");
       for (int i=0;i<root.children.size();i++){
           preOrderTraversal(root.children.get(i));
       }
    }

    /*
     ** @param args
     * Post Order Traversal Tree
     */
    public static void postOrderTraversal(Treenode<Integer> root){
        if(root==null){
            System.out.println("Tree is empty.");
            return;
        }
//        Print leaf node only
//        if(root.children.size()==0){
//            System.out.print(root.data + " ");
//        }
        for (int i=0;i<root.children.size();i++){
            postOrderTraversal(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }
    /**
     * @param root
     */
    public static boolean checkIfTreeContainX(Treenode<Integer> root , int x){
        boolean ans = false;
        if(root==null){
            return ans;
        }
        if(root.data==x){
            return true;
        }
        for (int i=0;i<root.children.size();i++){
           boolean small_ans =  checkIfTreeContainX(root.children.get(i) , x);
        }
        return ans;
    }

    /**
     * @param root
     * Given a tree, find and return the node for which sum of data of all children and the node itself is maximum.
     * In the sum, data of node itself and data of immediate children is to be taken.
     */
    public static Treenode<Integer> maxSumNode(Treenode<Integer> root){
        int sum =root.data;
        for(int i =0;i<root.children.size();i++){
            sum+=root.children.get(i).data;
        }
        Treenode<Integer> ans = root;
        for(int i =0;i<root.children.size();i++){
            Treenode<Integer> newNode = maxSumNode(root.children.get(i));
            int sum2 = newNode.data;
            for (int j = 0;j<newNode.children.size();j++){
                sum2+=newNode.children.get(j).data;
            }
            if(sum2>sum){
                sum =sum2;
                ans = newNode;
            }
        }
        return ans;
    }

    /**
     * @param root
     */
    public static void replaceNodeWithDepth(Treenode<Integer> root){
        helperNodeDepth(root,0);
    }
    public static void helperNodeDepth(Treenode<Integer> root , int n){
        System.out.print(n + " ");
        for(int i =0;i<root.children.size();i++){
            helperNodeDepth(root , n+1);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        Treenode<Integer> rootdata = takeInput(s);
//        print(rootdata);
//        printLevelWise(rootdata);
        Treenode<Integer> rootdata = takeInputLevelWise(s);
        System.out.println("Total number of nodes: " + numOfNodes(rootdata));
        System.out.println("Total sum of nodes: " + sumOfNodes(rootdata));
        System.out.println("Largest nodes in tree: " + nodeLargestData(rootdata));
        System.out.println("Number of nodes greater then X: " + numGreaterThenX(rootdata , 76));
        System.out.println("Height of tree: " + heightOfTree(rootdata));
        System.out.println("Nodes at depth level of k" );
        depthOfNodesAtK(rootdata , 2);
        System.out.println(" ");
        System.out.println("Number of leaf nodes : "+countLeafNode(rootdata));
        preOrderTraversal(rootdata);
        System.out.println(" ");
        postOrderTraversal(rootdata);
        System.out.println("X element consist or not :" +checkIfTreeContainX(rootdata , 2));
        replaceNodeWithDepth(rootdata);

    }
}

//   INPUT :-
//    Enter the next node:
//        4
//        Enter the number of children :
//        3
//        Enter the next node:
//        2
//        Enter the number of children :
//        0
//        Enter the next node:
//        1
//        Enter the number of children :
//        2
//        Enter the next node:
//        5
//        Enter the number of children :
//        0
//        Enter the next node:
//        6
//        Enter the number of children :
//        0
//        Enter the next node:
//        3
//        Enter the number of children :
//        0

// OUTPUT :-
//        4:2, 1, 3,
//        2:
//        1:5, 6,
//        5:
//        6:
//        3: