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
public class Weapon implements Node {

    private String text;

    public Weapon(String text) {
        this.text = text;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Node getYesNode() {
        throw new RuntimeException("Leafs nodes has no answer node."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node getNoNode() {
        throw new RuntimeException("Leafs nodes has no answer node."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setYesNode(Node node) {
        throw new RuntimeException("Leafs nodes has no answer node."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNoNode(Node node) {
        throw new RuntimeException("Leafs nodes has no answer node."); //To change body of generated methods, choose Tools | Templates.
    }

}
