package scripts.safeMiner.graphics.gui;

import org.tribot.api.General;

import javax.swing.*;
import java.awt.*;

import static scripts.safeMiner.data.Vars.*;

public class SwingUI {
    public void drawUI() {
        JFrame frame = new JFrame("SafeMiner");

        JCheckBox banking = new JCheckBox("Banking?");

        JButton startButton = new JButton("Start");

        JTextField radiusField = new JTextField("Enter Radius as int");

        JComboBox<String> oresBox = new JComboBox<>();
        getOres(oresBox);

        frame.setSize(200, 150);
        frame.setLocationRelativeTo(null);

        frame.add(oresBox, BorderLayout.NORTH);
        frame.add(banking, BorderLayout.WEST);
        frame.add(startButton, BorderLayout.SOUTH);
        frame.add(radiusField, BorderLayout.CENTER);

        frame.setVisible(true);

        while (frame.isVisible()) {
            if (startButton.getModel().isPressed()) {
                shouldBank = banking.getModel().isSelected();
                oreToMine = oresBox.getModel().getSelectedItem().toString();
                try {
                    miningRadius = Integer.parseInt(radiusField.getText());
                } catch (Exception e) {
                    System.out.println("No radius value entered, defaulting to 10");
                }
                frame.setVisible(false);
                return;
            }
            General.sleep(10, 50);
        }
        throw new RuntimeException("GUI Closed");
    }
    private void getOres(JComboBox<String> oresBox) {
        oresBox.addItem("Copper ore");
        oresBox.addItem("Tin ore");
        oresBox.addItem("Clay");
        oresBox.addItem("Iron ore");
        oresBox.addItem("Coal");
        oresBox.addItem("Silver ore");
        oresBox.addItem("Gold ore");
        oresBox.addItem("Mithril ore");
        oresBox.addItem("Adamantite ore");
        oresBox.addItem("Runite ore");
    }
}
