package src.gui;

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
    private int maxSuggestions;
    private JPopupMenu popup;
    private String currentSearchTerm = "";

    private Boolean settingText = false;

    public AutofillTextArea(Collection<String> suggestedFills, int maxSuggestions){
        this.suggestedFills = suggestedFills;
        this.maxSuggestions = maxSuggestions;
        popup = new JPopupMenu();

        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                popup.setVisible(false);
                if(settingText){
                    settingText = false;
                    return;
                }
                showSuggestions(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                popup.setVisible(false);
                if(settingText){
                    settingText = false;
                    return;
                }
                showSuggestions(getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                popup.setVisible(false);
                if(settingText){
                    settingText = false;
                    return;
                }
                showSuggestions(getText());
            }
        });
    }

    public void showSuggestions(String toSearch){
        new Thread(){
            public void run(){
                displayPopup(toSearch);
            }
        }.start();
    }

    private synchronized void displayPopup(String toSearch){
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
                //Not triggered on pressing enter, oddly, but is triggered by clicking. Weird, and I don't know why.
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

        AutofillTextArea.this.requestFocus();
    }

    public static boolean isMenuKey(int keyCode){
        return keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_KP_DOWN || keyCode == KeyEvent.VK_KP_UP ||
                keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_ENTER;
    }
}