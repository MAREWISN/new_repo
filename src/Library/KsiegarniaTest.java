package Library;

import Library.frames.KsiegarniaFrame;

import java.awt.*;

public class KsiegarniaTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            KsiegarniaFrame frame = new KsiegarniaFrame();
            frame.setVisible(true);
        });

    }
}
