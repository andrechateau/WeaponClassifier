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
public interface Node {

    public String getText();

    public boolean isLeaf();

    public Node getYesNode();

    public Node getNoNode();

    public void setYesNode(Node node);

    public void setNoNode(Node node);
}
