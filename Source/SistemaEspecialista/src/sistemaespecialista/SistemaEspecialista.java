/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaespecialista;

import javax.swing.JOptionPane;

/**
 *
 * @author Andre Chateaubriand
 */
public class SistemaEspecialista {

    public static void main(String[] args) {
        Node w_mace = new Weapon("Mace");
        Node w_morningStar = new Weapon("Morning Star");
        Node w_hammer = new Weapon("Hammer");
        Node w_warhammer = new Weapon("Warhammer");
        Node w_polearm = new Weapon("Polearm");
        Node w_spear = new Weapon("Spear");
        Node w_axe = new Weapon("Axe");
        Node w_falchion = new Weapon("Falchion");
        Node w_cutlass = new Weapon("Cutlass");
        Node w_kukri = new Weapon("Kukri");
        Node w_broadsword = new Weapon("Broadsword");
        Node w_bastard = new Weapon("Bastard Sword (One and a half hand)");
        Node w_sabre = new Weapon("Sabre");
        Node w_falx = new Weapon("Falx Sword");
        Node w_pallasch = new Weapon("Pallasch");
        Node w_ulfberht = new Weapon("Ulfberht");
        Node w_longsword = new Weapon("Long Sword");
        Node w_greatsword = new Weapon("Greatsword");
        Node w_armingsword = new Weapon("Arming Sword");
        Node w_shortsword = new Weapon("Short Sword");
        Node w_sidesword = new Weapon("Side Sword");
        Node w_rapier = new Weapon("Rapier");

        Node chains = new Rule("The Weapon has chains?", w_mace, w_morningStar);
        Node align = new Rule("The Weapon has the need to align the hit?", chains, w_hammer);
        Node handle_blunt = new Rule("The Weapon's handle is larger than 1 meter?", align, w_warhammer);
        Node handle_2m = new Rule("The Weapon's handle is larger than 2 meters?", w_polearm, w_spear);
        Node handle_1m = new Rule("The Weapon's handle is smaller than 1 meter?", handle_2m, w_axe);

        Node notparalled_innercurved = new Rule("The Weapon's blade is curved to the edge side?", w_cutlass, w_kukri);
        Node notparalled_curved = new Rule("The Weapon's blade is curved?", w_falchion, notparalled_innercurved);

        Node paralled_innercurved = new Rule("The Weapon's blade is curved to the edge side?", w_sabre, w_falx);
        Node paralled_curved = new Rule("The Weapon's blade is curved?", w_broadsword, paralled_innercurved);

        Node parallel = new Rule("The Weapon's blade is parallel?", notparalled_curved, paralled_curved);
        Node baskethilt = new Rule("The Weapon's hilt is a Basket Hilt?", parallel, w_broadsword);
        Node swepthilt = new Rule("The Weapon's hilt is a Swept Hilt?", baskethilt, w_pallasch);

        Node armspan = new Rule("The Weapon's blade is greater than both arms span?", w_longsword, w_greatsword);
        Node twohanded = new Rule("The Weapon's handle is big enought for full two hands?", w_bastard, armspan);
        Node smalledge = new Rule("The Weapon's blade lenght is lesser than 70cm?", w_armingsword, w_shortsword);
        Node onehanded = new Rule("The Weapon's handle is one handed?", twohanded, smalledge);

        Node roundblade = new Rule("The Blade shade is near a round shape?", w_sidesword, w_rapier);
        Node sweptcrosshilt = new Rule("The Weapon's hilt is a Swept Hilt?", onehanded, roundblade);

        Node crossguards = new Rule("The Weapon's guard are crossiform (cross guards)?", w_ulfberht, sweptcrosshilt);
        Node doubleedge = new Rule("The Weapon is double edged?", swepthilt, crossguards);
        Node blade = new Rule("The Weapon is double edged?", handle_1m, doubleedge);
        Node cuttingedge = new Rule("The Weapon has a cutting edge (blade or cleaver)?", handle_blunt, blade);

        JOptionPane.showMessageDialog(null, "This is a system that classifies european medieval meelee weapons. \n Please have a weapon in mind in order to answer the questions." );

        Node node = cuttingedge;
        while (!node.isLeaf()) {
            int ans = JOptionPane.showConfirmDialog(null, node.getText(), "Meelee Medieval Weapon Classifier", JOptionPane.YES_NO_OPTION);
            System.out.println(ans);
            if (ans == -1) {
                JOptionPane.showMessageDialog(null, "Classification Aborted.");
                System.exit(0);
            }
            node = ans == 0 ? node.getYesNode() : node.getNoNode();
        }
        JOptionPane.showMessageDialog(null, "The Weapon is classified as a: \n" + node.getText());

    }

}
