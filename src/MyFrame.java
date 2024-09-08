import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame implements NativeKeyListener {
    public MyFrame() {
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Window Manager");

        JToggleButton jToggleButton = new JToggleButton("Toggle");
        getContentPane().add(jToggleButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        if ( e.getKeyCode() == NativeKeyEvent.VC_X) {
            WinDef.HWND hwnd = User32.INSTANCE.GetForegroundWindow();
            User32.INSTANCE.SetWindowPos(hwnd, null, 100, 100, 800, 600, 0);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {}

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}
}