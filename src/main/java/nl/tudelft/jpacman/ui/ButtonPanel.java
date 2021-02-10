package nl.tudelft.jpacman.ui;

import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A panel containing a button for every registered action.
 *
 * @author Jeroen Roosen 
 */
class ButtonPanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create a new button panel with a button for every action.
     * @param buttons The map of caption - action for each button.
     * @param parent The parent frame, used to return window focus.
     */
    ButtonPanel(final Map<String, Action> buttons, final JFrame parent) {
        super();
        if(buttons == null|| parent == null ){
            throw new AssertionError();
        }

        for (final Map.Entry<String, Action> caption : buttons.entrySet()) {
            JButton button = new JButton(caption.getKey());
            button.addActionListener(e -> {
                buttons.get(caption.getKey()).doAction();
                parent.requestFocusInWindow();
            });
            add(button);
        }
    }
}
