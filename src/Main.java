public class Main {

    static class Node {
        int val;
        Node next=null;

        Node(int x){
            val=x;
        }
    }

    public static void main(String[] args) {

        Node root                                   = new Node(1);
        root.next                               = new Node(3);
        root.next.next                          = new Node(4);

        Node node                               = new Node(5);
        root.next.next.next                     = node;

        root.next.next.next.next                = new Node(7);
        root.next.next.next.next.next           = new Node(9);
        root.next.next.next.next.next.next      = new Node(11);

        root.next.next.next.next.next.next.next = node;


//        Node root                               = new Node(1);
//        root.next                               = new Node(3);
//
//        Node node                               = new Node(5);
//        root.next.next                          = node;
//
//        root.next.next.next                     = new Node(7);
//        root.next.next.next.next                = new Node(9);
//        root.next.next.next.next.next           = new Node(11);
//
//        root.next.next.next.next.next.next      = node;

//            Node root                               = new Node(1);
//        root.next                               = new Node(3);
//
//        Node node                               = new Node(5);
//        root.next.next                          = node;
//
//        root.next.next.next                     = new Node(7);
//        root.next.next.next.next                = new Node(9);
//
//        root.next.next.next.next.next      = node;

//        Node root                               = new Node(1);
//        root.next                               = new Node(3);
//        root.next.next                          = new Node(4);
//
//        Node node                               = new Node(5);
//        root.next.next.next                     = node;
//
//        root.next.next.next.next                = new Node(7);
//        root.next.next.next.next.next           = new Node(9);
//
//        root.next.next.next.next.next.next = node;

        System.out.println(detectBeginningOfCycle(root));

    }

    public static int detectBeginningOfCycle (Node root) {

        Node slow = root;
        Node fast = root.next;//handle edge case here

        int cycle=0;

        while(slow!=fast) {

            if(fast==null || fast.next==null){break;}

            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) {

                do{

//                    slow = slow.next;
//                    fast = fast.next.next;

                    //OR

                    fast = fast.next;

                    cycle++;

                }while(slow!=fast);

            }
        } // after while loop we have length of cycle [4 here]

        // now we gotta find node where cycle starts

        Node cycleNode=root;

        while(cycle>0){
            cycleNode = cycleNode.next;
            cycle--;
        }

        Node iter=root;

        while(iter!=cycleNode){
            iter=iter.next;
            cycleNode=cycleNode.next;
        }

        return iter.val;

    }

}
