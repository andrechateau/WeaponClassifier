package sistemaespecialista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andre Chateaubriand
 */
public class Rule implements Node {

    private String text;
    private Node yesNode;
    private Node noNode;

    public Rule(String text, Node noNode, Node yesNode) {
        this.text = text;
        this.yesNode = yesNode;
        this.noNode = noNode;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Node getYesNode() {
        return yesNode;
    }

    @Override
    public Node getNoNode() {
        return noNode;
    }

    @Override
    public void setYesNode(Node node) {
        yesNode = node;
    }

    @Override
    public void setNoNode(Node node) {
        noNode = node;
    }
}
