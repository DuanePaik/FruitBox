import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetryButton extends JButton implements ActionListener {

    private ResultFrame frame;
    private ImageIcon rty_pgn = new ImageIcon("./src/imgPack/retry.png");
    private ImageIcon rty_gif = new ImageIcon("./src/imgPack/ret.gif");

    public RetryButton(ResultFrame f) {

        frame = f;

        setIcon(rty_pgn);
        setRolloverIcon(rty_gif);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GreetingFrame();
        frame.dispose();
    }
}
