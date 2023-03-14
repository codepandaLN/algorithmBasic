package 贪心算法;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Huffman {
        public static HuffmanTreeNode buildHuffmanTree(List<HuffmanTreeNode> nodes){
            int n = nodes.size();
            //n-1次
            for(int i=1;i<n;i++){
                Collections.sort(nodes);

                HuffmanTreeNode min1 = nodes.remove(0);
                HuffmanTreeNode min2 = nodes.remove(0);
                HuffmanTreeNode newNode = new HuffmanTreeNode(min1.getWeight()+min2.getWeight());
                newNode.setLeftChild(min1);
                newNode.setRightChild(min2);
                nodes.add(newNode);
            }
            return nodes.get(0);
        }

        public static void generateHuffmanCode(HuffmanTreeNode root){
            if(root.getLeftChild() != null){
                root.getLeftChild().setCode(root.getCode() + "0");
                generateHuffmanCode(root.getLeftChild());
            }

            if(root.getRightChild() != null){
                root.getRightChild().setCode(root.getCode() + "1");
                generateHuffmanCode(root.getRightChild());
            }
        }

        public static void main(String[] args) {
            HuffmanTreeNode node1 = new HuffmanTreeNode(3);
            node1.setContent("3");
            HuffmanTreeNode node2 = new HuffmanTreeNode(5);
            node2.setContent("5");
            HuffmanTreeNode node3 = new HuffmanTreeNode(7);
            node3.setContent("7");
            HuffmanTreeNode node4 = new HuffmanTreeNode(8);
            node4.setContent("8");
            HuffmanTreeNode node5 = new HuffmanTreeNode(11);
            node5.setContent("11");
            HuffmanTreeNode node6 = new HuffmanTreeNode(14);
            node6.setContent("14");
            HuffmanTreeNode node7 = new HuffmanTreeNode(23);
            node7.setContent("23");
            HuffmanTreeNode node8 = new HuffmanTreeNode(29);
            node8.setContent("29");

            List<HuffmanTreeNode>nodes = new LinkedList<HuffmanTreeNode>();
            nodes.add(node1);
            nodes.add(node2);
            nodes.add(node3);
            nodes.add(node4);
            nodes.add(node5);
            nodes.add(node6);
            nodes.add(node7);
            nodes.add(node8);

            List<HuffmanTreeNode>nodeCopy = new ArrayList<HuffmanTreeNode>();
            nodeCopy.addAll(nodes);


            HuffmanTreeNode root = buildHuffmanTree(nodes);
            generateHuffmanCode(root);


            for(HuffmanTreeNode node:nodeCopy){
                System.out.println(node.getContent() + "的编码：" + node.getCode());
            }
        }

    public static class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public HuffmanTreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(HuffmanTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public HuffmanTreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(HuffmanTreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        private String content = null;
        private int weight;
        private String code = "";
        private HuffmanTreeNode leftChild = null;
        private HuffmanTreeNode rightChild = null;


        public HuffmanTreeNode(int weight){
            this.weight = weight;
        }

        public int compareTo(HuffmanTreeNode o) {
            if(weight<o.getWeight()){
                return -1;
            }else if(weight > o.getWeight()){
                return 1;
            }else{
                return 0;
            }
        }
    }

}










