package main.ui.customUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.plaf.basic.BasicPasswordFieldUI;
import javax.swing.text.JTextComponent;

public class HintPasswordFieldUI extends BasicPasswordFieldUI implements FocusListener {

    private String hint;
    private boolean hideOnFocus;
    private Color color = Color.GRAY;

    // Constructor
    public HintPasswordFieldUI(String hint) {
        this(hint, false);
    }

    public HintPasswordFieldUI(String hint, boolean hideOnFocus) {
        this(hint, hideOnFocus, null);
    }

    public HintPasswordFieldUI(String hint, boolean hideOnFocus, Color color) {
        this.hint = hint;
        this.hideOnFocus = hideOnFocus;
        this.color = color;
    }

    // Other methods and overrides...

    @Override
    protected void paintSafely(Graphics g) {
        super.paintSafely(g);
        JPasswordField comp = (JPasswordField) getComponent();
        if (hint != null && comp.getPassword().length == 0 && (!(hideOnFocus && comp.hasFocus()))) {
            if (color != null) {
                g.setColor(color);
            } else {
                g.setColor(comp.getForeground().brighter().brighter().brighter());
            }
            int padding = (comp.getHeight() - comp.getFont().getSize()) / 2;
            g.drawString(hint, 2, comp.getHeight() - padding - 1);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        //if(hideOnFocus) paintSafely();

    }

    @Override
    public void focusLost(FocusEvent e) {
        //if(hideOnFocus) paintSafely();
    }
    @Override
    protected void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(this);
    }
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        getComponent().removeFocusListener(this);
    }
}

