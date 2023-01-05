import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.EventQueue;

public class QuitButtonEx extends JFrame {

    public QuitButtonEx() {

        initUI();
    }

    private void initUI() {

       /** Here we create a button component. This constructor takes a string label as a parameter. */

        var quitButton = new JButton("Quit");

       /** We plug an action listener to the button. The action terminates the application by calling the System.exit() method.*/
        quitButton.addActionListener((event) -> System.exit(0));

       /** The child components need to be placed into containers. We delegate the task to the createLayout() method.*/
        createLayout(quitButton);

        setTitle("Quit button");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    private void createLayout(JComponent... arg) {
       /**
        The content pane of a JFrame is an area where child components are placed.
        The children are organised by specialised non-visible components called layout managers.
        The default layout manager of a content pane is the BorderLayout manager.
        This manager is very simple. In this tutorial, we use the GroupLayout manager which is more powerful and flexible.
        */
        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);
        /**
        The setAutoCreateContainerGaps() method creates gaps between components and the edges of the container.
                Space or gaps are important part of the design of each application.
         */
        gl.setAutoCreateContainerGaps(true);
         /**
          GroupLayout manager defines the layout for each dimension independently.
          In one step, we lay out components alongside the horizontal axis; in the other step,
          we lay out components along the vertical axis. In both kinds of layouts we can arrange components sequentially
          or in parallel. In a horizontal layout, a row of components is called a sequential group and a column of components is called a parallel group.
          In a vertical layout, a column of components is called a sequential group and a row of components a parallel group.
        */
          gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new QuitButtonEx();
            ex.setVisible(true);
        });
    }
}