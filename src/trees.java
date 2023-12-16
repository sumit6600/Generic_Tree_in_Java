
    public class trees {
        public static void main(String[] args) {

            Treenode<Integer> root= new Treenode<Integer>(4);
            Treenode<Integer> node1= new Treenode<Integer>(5);
            Treenode<Integer> node2= new Treenode<Integer>(6);
            Treenode<Integer> node3= new Treenode<Integer>(9);
            root.children.add(node1);
            root.children.add(node2);
            node2.children.add(node3);
            System.out.println(root);
            System.out.println("This is root node");

        }

    }
