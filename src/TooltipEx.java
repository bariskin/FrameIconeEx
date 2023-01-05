import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TooltipEx extends JFrame {

    public TooltipEx() {

        initUI();
    }

    private void initUI() {

        var btn = new JButton("Button");
        btn.setToolTipText("A button component");

        createLayout(btn);

        setTitle("Tooltip");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {
        /*
          A content pane is an instance of a JPanel component. The getContentPane() method returns a Container type.
          Since setting a tooltip requires a JComponent instance, we cast the object to a JPanel.
         */

        var pane = (JPanel) getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        pane.setToolTipText("Content pane");

        gl.setAutoCreateContainerGaps(true);

        /*
           We call the addGap() method for horizontal and vertical dimensions.
           It creates some space to the right and to the bottom of the button. (The aim is to increase the initial size of the window.)
        */
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(300)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(300)
        );

        /*
         The pack() method automatically sizes JFrame based on the size of its components. It takes the defined space into account, too.
         Our window will display the button and the spaces that we have set with the addGap() method.
         */
        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new TooltipEx();
            ex.setVisible(true);
        });
    }
}
