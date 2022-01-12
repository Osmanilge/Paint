import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;



public class Paint {
    public static ArrayList<ArrayList<Integer>> cizim= new  ArrayList<ArrayList<Integer>>();
    public static ArrayList<Color> colors = new ArrayList<Color>();

    static int sayac =0;
    static int  mode=1;
    static Color clr=Color.BLACK;





    static class b1    implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){mode =1;}

    }
    static class b2    implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){mode =2;}

    }
    static class b3    implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){mode =3;}

    }
    static class b4    implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){mode =4;}

    }
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.GRAY);

        JButton dikdortgen = new JButton("Rectangle");

        dikdortgen.addActionListener(new b2());

        JButton tasi = new JButton("Move");

        tasi.addActionListener(new b3());

        JButton ciz = new JButton("Draw");

        ciz.addActionListener(new b1());

        JButton sil = new JButton("Delete");

        sil.addActionListener(new b4());

        MyPanel paints = new MyPanel();
        paints.setBackground(Color.WHITE);

        //******************** assign black to static color variable***********************
        JPanel p = new JPanel();
        p.setBackground(Color.black);
        p.setPreferredSize(new Dimension(50,30));
        JFrame jf=new ColorFrame(p);
        p.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clr=p.getBackground();
                sayac++;
                if(sayac>1){
                    jf.setVisible(true);
                    sayac=0;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

                clr=p.getBackground();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clr=p.getBackground();
                //if(sayac==1)sayac++;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                sayac=0;

            }
        });

        //******************** assign black to static color variale********************
        //******************** assign red to static color variable***********************
        JPanel p2 = new JPanel();
        p2.setBackground(Color.RED);
        p2.setPreferredSize(new Dimension(50,30));
        p2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clr=Color.RED;
            }

            @Override
            public void mousePressed(MouseEvent e) {

                clr=Color.RED;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clr=Color.RED;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//******************** assign red to static color variale********************
        //******************** assign green to static color variale***********************
        JPanel k = new JPanel();
        k.setBackground(Color.GREEN);
        k.setPreferredSize(new Dimension(50,30));
        k.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                clr=Color.GREEN;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                clr=Color.GREEN;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clr=Color.GREEN;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });//******************** assign green to static color variale*******************

        //******************** assign blue to static color variale***********************
        JPanel s = new JPanel();
        s.setBackground(Color.BLUE);
        s.setPreferredSize(new Dimension(50,30));
        s.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                clr=Color.BLUE;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                clr=Color.BLUE;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clr=Color.BLUE;
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //******************** assign blue to static color variale***********************



        paints.setPreferredSize(new Dimension(2000,900));
        frame.add(ciz);
        frame.add(dikdortgen);
        frame.add(tasi);
        frame.add(sil);
        frame.add(p);
        frame.add(p2);
        frame.add(s);
        frame.add(k);
        paints.setVisible(true);
        frame.add(paints);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setVisible(true);


    }


    public static int i;
    static boolean tasima=false;
    static class MyPanel extends JPanel implements MouseInputListener {
        int old_x,old_y;





        @Override
        public void mouseClicked(MouseEvent e) {


            

        }

        @Override
        public void mousePressed(MouseEvent e) {


            i =cizim.size();
            if(mode == 4){
                for (int n =i-1;n>-1;n--){

                    if( cizim.get(n).get(0)==1 &&((cizim.get(n).get(1)>e.getX() && cizim.get(n).get(3)<e.getX() &&cizim.get(n).get(2)<e.getY() && cizim.get(n).get(4)>e.getY())||(cizim.get(n).get(1)<e.getX() && cizim.get(n).get(3)>e.getX() &&cizim.get(n).get(2)>e.getY() && cizim.get(n).get(4)<e.getY())||(cizim.get(n).get(1)<e.getX() && cizim.get(n).get(3)>e.getX() && cizim.get(n).get(2)<e.getY() && cizim.get(n).get(4)>e.getY() )||(cizim.get(n).get(1)>e.getX() && cizim.get(n).get(3)<e.getX() && cizim.get(n).get(2)>e.getY() && cizim.get(n).get(4)<e.getY() )))
                    {

                        
                        colors.remove(n);
                        cizim.remove(n);
                        i=i-1;

                        break;
                    }
                    if(cizim.get(n).get(0)==0 ){
                        boolean bb=false;
                        for(int j=2;j<cizim.get(n).size();j+=2){
                            if( abs(e.getX()-cizim.get(n).get(j-1))<3 && abs(e.getY()-cizim.get(n).get(j))<3 ){

                                colors.remove(n);
                                cizim.remove(n);
                                i=i-1;
                                bb=true;
                                break;
                            }
                        }
                        if(bb)break;
                    }
                }
            }


            if(mode == 3){
                for (int n =i-1;n>-1;n--){

                    if( cizim.get(n).get(0)==1 &&((cizim.get(n).get(1)>e.getX() && cizim.get(n).get(3)<e.getX() &&cizim.get(n).get(2)<e.getY() && cizim.get(n).get(4)>e.getY())||(cizim.get(n).get(1)<e.getX() && cizim.get(n).get(3)>e.getX() &&cizim.get(n).get(2)>e.getY() && cizim.get(n).get(4)<e.getY())||(cizim.get(n).get(1)<e.getX() && cizim.get(n).get(3)>e.getX() && cizim.get(n).get(2)<e.getY() && cizim.get(n).get(4)>e.getY() )||(cizim.get(n).get(1)>e.getX() && cizim.get(n).get(3)<e.getX() && cizim.get(n).get(2)>e.getY() && cizim.get(n).get(4)<e.getY() )))
                    {

                        old_x=e.getX();
                        old_y=e.getY();
                        tasima=true;
                        ArrayList<Integer> bilgi = new ArrayList<Integer>();
                        cizim.add(bilgi);
                        cizim.get(i).add(1);
                        cizim.get(i).add(cizim.get(n).get(1));
                        cizim.get(i).add(cizim.get(n).get(2));
                        cizim.get(i).add(cizim.get(n).get(3));
                        cizim.get(i).add(cizim.get(n).get(4));
                        colors.add(colors.get(n));
                        colors.remove(n);
                        cizim.remove(n);
                        i=i-1;

                        break;
                    }
                }
            }
            if(mode ==1||mode==2) {
                colors.add(clr);
                ArrayList<Integer> bilgi = new ArrayList<Integer>();
                cizim.add(bilgi);
                if(mode ==1)cizim.get(i).add(0);
                if(mode ==2){cizim.get(i).add(1);
                    cizim.get(i).add(e.getX());
                    cizim.get(i).add(e.getY());
                    }
                cizim.get(i).add(e.getX());
                cizim.get(i).add(e.getY());




            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(mode==3&&tasima){
                int farkx,farky;
                farkx=e.getX()-old_x;
                farky=e.getY()-old_y;
                cizim.get(i).set(1, cizim.get(i).get(1)+farkx);
                cizim.get(i).set(2, cizim.get(i).get(2)+farky);

                cizim.get(i).set(3, cizim.get(i).get(3)+farkx);
                cizim.get(i).set(4, cizim.get(i).get(4)+farky);
                old_x=e.getX();
                old_y=e.getY();
                tasima=false;
            }

            if(mode ==2) {
                cizim.get(i).set(3, e.getX());
                cizim.get(i).set(4, e.getY());
            }
            if(mode==1){

                cizim.get(i).add(e.getX());
                cizim.get(i).add(e.getY());
            }
            repaint();


        }

        @Override
        public void mouseEntered(MouseEvent e) {
            


        }

        @Override
        public void mouseExited(MouseEvent e) {
            

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(mode == 4){
                for (int n =i-1;n>-1;n--){

                    if( cizim.get(n).get(0)==1 &&((cizim.get(n).get(1)>e.getX() && cizim.get(n).get(3)<e.getX() &&cizim.get(n).get(2)<e.getY() && cizim.get(n).get(4)>e.getY())||(cizim.get(n).get(1)<e.getX() && cizim.get(n).get(3)>e.getX() &&cizim.get(n).get(2)>e.getY() && cizim.get(n).get(4)<e.getY())||(cizim.get(n).get(1)<e.getX() && cizim.get(n).get(3)>e.getX() && cizim.get(n).get(2)<e.getY() && cizim.get(n).get(4)>e.getY() )||(cizim.get(n).get(1)>e.getX() && cizim.get(n).get(3)<e.getX() && cizim.get(n).get(2)>e.getY() && cizim.get(n).get(4)<e.getY() )))
                    {

                        
                        colors.remove(n);
                        cizim.remove(n);
                        i=i-1;

                        break;
                    }
                    if(cizim.get(n).get(0)==0 ){
                        boolean bb=false;
                        for(int j=2;j<cizim.get(n).size();j+=2){
                            if( abs(e.getX()-cizim.get(n).get(j-1))<3 && abs(e.getY()-cizim.get(n).get(j))<3 ){

                                colors.remove(n);
                                cizim.remove(n);
                                bb=true;
                                i=i-1;
                                break;
                            }
                        }
                        if(bb)break;
                    }
                }
            }

            
            if(mode==3&&tasima){
                int farkx,farky;
                farkx=e.getX()-old_x;
                farky=e.getY()-old_y;
                cizim.get(i).set(1, cizim.get(i).get(1)+farkx);
                cizim.get(i).set(2, cizim.get(i).get(2)+farky);

                cizim.get(i).set(3, cizim.get(i).get(3)+farkx);
                cizim.get(i).set(4, cizim.get(i).get(4)+farky);
                old_x=e.getX();
                old_y=e.getY();

            }
            if(mode ==2) {
                cizim.get(i).set(3, e.getX());
                cizim.get(i).set(4, e.getY());
            }

           


            if(mode==1){

                cizim.get(i).add(e.getX());
                cizim.get(i).add(e.getY());
            }
            repaint();


        }

        @Override
        public void mouseMoved(MouseEvent e) {

            

        }

        public MyPanel() {



            addMouseListener(this);
            addMouseMotionListener(this);
        }
        @Override
        public void paint(Graphics g){
            g.clearRect(0,0,2000,900);


            for(int i =0;i<cizim.size();i++){
                g.setColor(colors.get(i));

                if(cizim.get(i).get(0)==1)
                    g.fillRect(cizim.get(i).get(1)<cizim.get(i).get(3) ?cizim.get(i).get(1):cizim.get(i).get(3),cizim.get(i).get(2)<cizim.get(i).get(4) ? cizim.get(i).get(2) :cizim.get(i).get(4),mutlak(cizim.get(i).get(1)-cizim.get(i).get(3)),mutlak(cizim.get(i).get(2)-cizim.get(i).get(4)));
                if(cizim.get(i).get(0)==0)
                    for(int k =3 ;k<cizim.get(i).size()-1;k=k+2){
                        //g.fillOval(cizim.get(i).get(k),cizim.get(i).get(k+1),3,3);
                        if(k>2)g.drawLine(cizim.get(i).get(k-2),cizim.get(i).get(k-1),cizim.get(i).get(k),cizim.get(i).get(k+1));
                    }
            }
        }





    }


    public static int mutlak(int a){return  a>0 ? a:-a;}





    public static int abs(int x){
        if(x<0)return -x;
        return x;
    }

    public static class ColorFrame extends JFrame {
        Color clr2;

        public ColorFrame(JPanel p){
            clr2=p.getBackground();
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(250,180);
            //setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel l1 = new JLabel("     Green (0-255)  ");
            JTextField t1 = new JTextField("0");
            JLabel l2 = new JLabel("      Red (0-255)      ");
            JTextField t2 = new JTextField("0");
            JLabel l3 = new JLabel("     Blue (0-255)      ");
            JTextField t3 = new JTextField("0");
            t1.setPreferredSize(new Dimension(30,18));
            t2.setPreferredSize(new Dimension(30,18));
            t3.setPreferredSize(new Dimension(30,18));


            JPanel s = new JPanel();
            s.setBackground(clr2);
            s.setPreferredSize(new Dimension(250,50));

            JButton btn = new JButton("      Apply     ");

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clr2= new Color(Integer.parseInt(t2.getText().trim()),Integer.parseInt(t1.getText().trim()),Integer.parseInt(t3.getText().trim()));
                    s.setBackground(clr2);
                    p.setBackground(clr2);
                    clr=clr2;
                }
            });



            this.add(l1);
            this.add(t1);
            this.add(l2);
            this.add(t2);
            this.add(l3);
            this.add(t3);
            this.add(btn);
            this.add(s);
        }

    }
}
