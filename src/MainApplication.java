
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class MainFrame extends JFrame {

    // component
    private JPanel contentpane, x;
    private JLabel drawpane, ingameb;
    private JButton newButton, loadButton;
    private JRadioButton[] dog;
    private ButtonGroup bgroup;
    private JTextField nametext;
    private JButton ok;
    private image[][][] imgFrontDog ;
    private image[][][] imgBackDog ;
    private image[][][] imgLeftDog ;
    private image[][][] imgRightDog ;
    // size
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private character maincha = new character();
    private int tmtype;
    private int dogWidth = 100, dogHeight = 100;
    private int defaultDogX = 700, defaultDogY = 250;
    //private boolean ingame = false;

    public MainFrame() {

        setTitle("MainApplication");
        setLocationRelativeTo(null);
        setBounds(0, 0, screenSize.width, screenSize.height);

        setResizable(true);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contentpane = (JPanel) getContentPane();
        contentpane.setLayout(new BorderLayout());
        //contentpane.setLayout(new BorderLayout());
        AddMenu(this);
        AddMainGame();

    }

    public void AddMenu(JFrame par) {

        drawpane = new JLabel(); // รูป background
        JPanel control = new JPanel();
        //drawpane.setIcon(new image("bgi.jpg").resize(screenSize.width, screenSize.height));
        //drawpane.setLayout(new BorderLayout());
        newButton = new JButton("New Game");
        newButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JDialog charac = new JDialog();
                {
                    charac.setBounds(0, 0, 600, 600);
                    charac.setTitle("New Game");
                    charac.setResizable(false);
                    charac.setVisible(true);
                    charac.setModal(true);
                    charac.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                }
                dog = new JRadioButton[5];
                bgroup = new ButtonGroup();
                nametext = new JTextField(20);
                ok = new JButton("OK");
                ok.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        maincha.setname(nametext.getText());
                        maincha.settype(tmtype);
                        //System.out.print(a.getname()+a.gettype());
                        charac.dispose();
                        contentpane.remove(control);
                        contentpane.remove(drawpane);
                        repaint();
                        revalidate();
                    }

                });

                dog[0] = new JRadioButton("1");
                dog[0].setName("1");
                dog[1] = new JRadioButton("2");
                dog[1].setName("2");
                dog[2] = new JRadioButton("3");
                dog[2].setName("3");
                dog[3] = new JRadioButton("4");
                dog[3].setName("4");
                dog[4] = new JRadioButton("5");
                dog[4].setName("5");

                dog[0].setSelected(true);
                for (int i = 0; i < dog.length; i++) {
                    boolean check = dog[i].isSelected();
                    if(check){
                        tmtype = i;
                    }
                }
                
                JPanel name = new JPanel();
                JPanel menu = new JPanel();
                JPanel okbut = new JPanel();

                menu.setLayout(
                        new GridLayout(6, 1, 100, 10));
                name.add(
                        new JLabel("Name : "));
                name.add(nametext);

                menu.add(
                        new JLabel("Select Character"));
                for (int i = 0;
                        i < dog.length;
                        i++) {
                    bgroup.add(dog[i]);
                    menu.add(dog[i]);
                }

                okbut.add(ok);

                charac.add(name, BorderLayout.NORTH);

                charac.add(menu);

                charac.add(okbut, BorderLayout.SOUTH);

                charac.validate();
            }
        }
        );
        loadButton = new JButton("Load Game");

        //control.setLayout(new BorderLayout());
        control.setBounds(
                0, 0, 1000, 200);
        //contentpane.add(drawpane);
        control.add(newButton);

        control.add(loadButton);

        /*drawpane.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                //contentpane.add(control, BorderLayout.CENTER);
                contentpane.add(drawpane, BorderLayout.CENTER);
            }
        });*/
        contentpane.add(control, BorderLayout.NORTH);

        contentpane.add(drawpane, BorderLayout.CENTER);

        validate();

    }

    public void AddMainGame() {

        ingameb = new JLabel(); // รูป ba
        ingameb.setLayout(new BorderLayout());
        ingameb.setIcon(new image("bgi.jpg").resize(screenSize.width, screenSize.height));

        imgFrontDog = new image[5][4][3];
        imgBackDog = new image[5][4][3];
        imgLeftDog = new image[5][4][3];
        imgRightDog = new image[5][4][3];
        
        for(int i=1; i<6; i++){
            for(int j=1; j<5; j++){
                for(int k=1; k<4; k++)
                {
                    new image("dog-" + i + "-" + j + k + ".png").resize(dogWidth, dogHeight);
                }
            }
        }
        //contentpane.add(ingameb, BorderLayout.CENTER);
        /*JLabel front1 = new JLabel(new image("dog-" + maincha.gettype() + "-1.png").resize(dogWidth, dogHeight));
        front1.setBounds(defaultDogX, defaultDogX, dogWidth, dogHeight);
        contentpane.add(ingameb);
        JLabel front2 = new JLabel(new image("dog-" + maincha.gettype() + "-2.png").resize(dogWidth, dogHeight));
        JLabel front3 = new JLabel(new image("dog-" + maincha.gettype() + "-3.png").resize(dogWidth, dogHeight));
        JLabel back1 = new JLabel(new image("dog-" + maincha.gettype() + "-4.png").resize(dogWidth, dogHeight));
        JLabel back2 = new JLabel(new image("dog-" + maincha.gettype() + "-5.png").resize(dogWidth, dogHeight));
        JLabel back3 = new JLabel(new image("dog-" + maincha.gettype() + "-6.png").resize(dogWidth, dogHeight));

        JLabel left1 = new JLabel(new image("dog-" + maincha.gettype() + "-7.png").resize(dogWidth, dogHeight));
        JLabel right1 = new JLabel(new image("dog-" + maincha.gettype() + "-8.png").resize(dogWidth, dogHeight));

        ingameb.add(new JLabel(new image("dog-" + maincha.gettype() + "-1.png").resize(dogWidth, dogHeight)));*/

        //contentpane.add(front1);
        validate();
        //image maindog = new JLabel(new image("bgi.jpg").resize(screenSize.width, screenSize.height));

    }
}

class image extends ImageIcon {

    public image(String fname) {
        super(fname);
    }

    public image(Image image) {
        super(image);
    }

    public image resize(int width, int height) {
        Image oldimg = this.getImage();
        Image newimg = oldimg.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new image(newimg);
    }
}

class character {

    private String name;
    private int type = 1;

    public character() {
    }

    public String getname() {
        return name;
    }

    public int gettype() {
        return type;
    }

    public void setname(String nm) {
        name = nm;
    }

    public void settype(int t) {
        type = t;
    }

}

public class MainApplication {

    public static void main(String Args[]) {
        new MainFrame();
    }
}
