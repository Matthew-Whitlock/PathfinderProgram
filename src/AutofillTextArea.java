package src;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.Collection;

/**
 * Created by Matthew on 7/31/2016.
 */
public class AutofillTextArea extends JTextField{
    private Collection<String> suggestedFills;
    public int maxSuggestions;
    private JPopupMenu popup;
    private String currentSearchTerm = "";

    private Boolean settingText = false;

    public AutofillTextArea(Collection<String> suggestedFills, int maxSuggestions){
        this.suggestedFills = suggestedFills;
        this.maxSuggestions = maxSuggestions;

        popup = new JPopupMenu();
        popup.addMenuKeyListener(new MenuKeyListener(){
            public void menuKeyTyped(MenuKeyEvent e) {}
            public void menuKeyPressed(MenuKeyEvent e) {}

            public void menuKeyReleased(MenuKeyEvent e){
                if(isMenuKey(e.getKeyCode())) return;
                popup.setVisible(false);
                AutofillTextArea.this.requestFocus();
                if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED && (java.lang.Character.isLetterOrDigit(e.getKeyCode()) || e.getKeyCode() == KeyEvent.VK_SPACE))
                    AutofillTextArea.this.dispatchEvent(new KeyEvent(AutofillTextArea.this, KeyEvent.KEY_TYPED, e.getWhen(), e.getModifiers(), KeyStroke.getKeyStroke(e.getKeyChar()).getKeyCode(), e.getKeyChar()));
                else {
                    AutofillTextArea.this.dispatchEvent(new KeyEvent(AutofillTextArea.this, KeyEvent.KEY_PRESSED, e.getWhen(), e.getModifiers(), e.getKeyCode(), e.getKeyChar()));
                    AutofillTextArea.this.dispatchEvent(new KeyEvent(AutofillTextArea.this, KeyEvent.KEY_RELEASED, e.getWhen(), e.getModifiers(), e.getKeyCode(), e.getKeyChar()));
                }
            }
        });

        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(settingText){
                    settingText = false;
                    return;
                }
                showSuggestions(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(settingText){
                    settingText = false;
                    return;
                }
                showSuggestions(getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(settingText){
                    settingText = false;
                    return;
                }
                showSuggestions(getText());
            }
        });

        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                getCaret().setVisible(true);
            }
        });
    }

    public void showSuggestions(String toSearch){
        if(toSearch.equalsIgnoreCase(currentSearchTerm)){
            if(popup.isVisible()) return;
            popup.show(this, 0, this.getHeight());
            return;
        }

        popup.removeAll();
        int currentlyMade = 0;
        for(String term : suggestedFills){
            if(term.toLowerCase().contains(toSearch.toLowerCase())) {
                JMenuItem toShow = new JMenuItem(term);
                toShow.addActionListener(e -> {
                    settingText = true;
                    AutofillTextArea.this.setText(toShow.getText());
                    popup.setVisible(false);
                });
                popup.insert(toShow, currentlyMade);
                currentlyMade++;
                if(currentlyMade == maxSuggestions) break;
            }
        }
        currentSearchTerm = toSearch;
        popup.setPreferredSize(new Dimension(this.getWidth(), currentlyMade * 25));
        popup.show(this, 0, this.getHeight());
    }

    public static boolean isMenuKey(int keyCode){
        return keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_KP_DOWN || keyCode == KeyEvent.VK_KP_UP ||
                keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_ENTER;
    }
}
