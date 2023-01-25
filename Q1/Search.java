import java.util.ArrayList;
import java.util.List;



public class Search {

    public static List<Node> getParents(Node rootNode, int valueToSearch) {
        List<Node> path = new ArrayList<>();
        findNode(rootNode, valueToSearch, path);
        return path;
    }

    private static boolean findNode(Node currentNode, int valueToSearch, List<Node> path) {
        if (currentNode.value == valueToSearch) {
        	path.add(currentNode);
            return true;
        }

        path.add(currentNode);
        for (Node child : currentNode.children) {
            if (findNode(child, valueToSearch, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
    Node root = new Node(2);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);
    Node n10 = new Node(10);								//1
    Node n11 = new Node(11);

    root.children.add(n7);
    root.children.add(n5);
    

    n2.children.add(n5);																//Best Case Tn=(2)=Ω(1)
    n2.children.add(n6);
    n5.children.add(n9);
    n6.children.add(n5);
    n6.children.add(n11);
    n9.children.add(n4);
    n7.children.add(n6);
    n7.children.add(n2);
    
    List<Node> path = Search.getParents(root, 11);

    System.out.println("Path from root to node 11:");
    for (Node node : path) {								// 1
        System.out.println(node.value);
    }
    }
}
