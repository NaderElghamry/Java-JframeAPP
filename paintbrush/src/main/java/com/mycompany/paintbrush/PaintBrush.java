package com.mycompany.paintbrush;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintBrush extends JPanel {


    JButton  red = new JButton("Red");
    JButton   green = new JButton("Green");
    JButton blue;
    JButton rectangle;
    JButton oval;
    JButton line;

    JButton freeHand;
    JButton eraser;
    JButton clear;

    Checkbox dotted;
    Checkbox filled;

    ArrayList<MasterShape> shapes;
    ArrayList<MasterShape> temps;

    Color color; //c
   Graphics2D gg;
    Point p1, p2, trackPoint;
    int x1, y1, x2, y2;
    int width, height;
    boolean isDragged;
    boolean isDotted;
    boolean isFilled;
    DrawingChoice choice;


    public PaintBrush() {
       
      
        blue = new JButton("Blue");
        rectangle = new JButton("Rectangle");
        oval = new JButton("Oval");
        line = new JButton("Line");
        freeHand = new JButton("FreeHand");
        eraser = new JButton("Eraser");
        clear = new JButton("Clear");

        dotted = new Checkbox("Dotted");
        filled = new Checkbox("Opaque");


        isDotted = false;
        isFilled = false;
        isDragged = false;
        shapes = new ArrayList<>();
        temps = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.setFocusable(true);


        red.setSize(100, 50);
        green.setSize(100, 50);
        blue.setSize(100, 50);
        rectangle.setSize(100, 50);
        oval.setSize(100, 50);
        line.setSize(100, 50);
        freeHand.setSize(100, 50);
        eraser.setSize(100, 50);
        clear.setSize(100, 50);
        dotted.setSize(50, 50);
filled.setSize(50, 50);


        red.setLocation(100, 300);
        green.setLocation(100, 450);
        blue.setLocation(100, 600);
        rectangle.setLocation(400, 50);
        oval.setLocation(600, 50);
        line.setLocation(800, 50);
        freeHand.setLocation(100, 50);
        eraser.setLocation(100, 100);
        clear.setLocation(100, 150);
        dotted.setLocation(1200, 50);
        filled.setLocation(1200, 100);

        this.setLayout(null);
        this.add(red);
        this.add(green);
        this.add(blue);
        this.add(rectangle);
        this.add(oval);
        this.add(line);
        this.add(freeHand);
        this.add(eraser);
        this.add(clear);
        this.add(dotted);
        this.add(filled);


//red.setBounds(10, 10, 30, 30); (Not usefull)
        red.setBackground(Color.RED);
        green.setBackground(Color.green);
        blue.setBackground(Color.BLUE);

       // addMouseMotionListener(new MouseMotionListener() );
        //addMouseListener(new MouseListener());

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.RED;
            }
        });

        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.GREEN;
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLUE;
            }
        });

        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = DrawingChoice.RECTANGLE;
            }
        });

        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = DrawingChoice.OVAL;
            }
        });

        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = DrawingChoice.LINE;
            }
        });

        freeHand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = DrawingChoice.FREEHAND;
            }
        });

        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = DrawingChoice.ERASER;
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temps = shapes;
                choice = DrawingChoice.CLEARALL;
                color = Color.BLACK;
                repaint();
            }
        });

        dotted.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1)
                    isDotted = true;
                else isDotted = false;
            }
        });

        filled.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1)
                    isFilled = true;
                else isFilled = false;
            }
        });



        this.addMouseListener(new java.awt.event.MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (choice == DrawingChoice.LINE) {
                    p1 = e.getPoint();
                    isDragged = false;
                    shapes.add(new Line(p1, p2, color, isDotted));
                    repaint();
                }
                if (choice == DrawingChoice.RECTANGLE ) { //check
                    x1 = e.getX();
                    y1 = e.getY();
                    x2=e.getX();
                    y2=e.getY();
                    isDragged = false;
                    repaint();
                }
                if (choice == DrawingChoice.OVAL){
                    x1 = e.getX();
                    y1 = e.getY();
                    x2=e.getX();
                    y2=e.getY();
                    isDragged = false;
                    repaint();

                }
                if (choice == DrawingChoice.CLEARALL){
                    x1 = e.getX();
                    y1 = e.getY();
                    x2=e.getX();
                    y2=e.getY();
                    isDragged = false;
                    repaint();
                }
                if (choice == DrawingChoice.FREEHAND) {
                    shapes.add(new FreeHand(e.getPoint(), color));
                    isDragged = false;
                    repaint();
                }
                if (choice == DrawingChoice.ERASER) {
                    shapes.add(new Eraser(e.getPoint(), Color.white)); //Check
                    isDragged = true;
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (choice == DrawingChoice.LINE) {

                    p2=e.getPoint();
                    shapes.add(new Line(p1, p2, color, isDotted));
                    isDragged = false;
                    repaint();
                }
               if(choice==DrawingChoice.RECTANGLE){
                   trackPoint=new Point(Math.min(x1, x2), Math.min(y1, y2));
                   width= Math.abs(x1-x2);
                   height=Math.abs(y1-y2);
                   shapes.add(new Rectangle(trackPoint, width, height, color, isFilled, isDotted));
                   isDragged = false;
                   repaint();
               }
                if(choice==DrawingChoice.OVAL) {
                    trackPoint = new Point(Math.min(x1, x2), Math.min(y1, y2));
                    width = Math.abs(x1 - x2);
                    height = Math.abs(y1 - y2);
                    shapes.add(new Oval(trackPoint, width, height, color, isDotted, isFilled));
                    isDragged = false;
                    repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseMotionListener(new java.awt.event.MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (choice == DrawingChoice.LINE) {
                    p2 = e.getPoint();
                    isDragged = true;
                    repaint();
                }
                if (choice == DrawingChoice.RECTANGLE || choice == DrawingChoice.OVAL) {
                    x2 = e.getX();
                    y2 = e.getY();
                    isDragged = true;
                    repaint();
                }
                if (choice == DrawingChoice.FREEHAND) {
                    shapes.add(new FreeHand(e.getPoint(), color));
                    isDragged = true;
                    repaint();
                }
                if (choice == DrawingChoice.ERASER) {
                    shapes.add(new Eraser(e.getPoint(), Color.WHITE)); // CHECK
                    isDragged = true;
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    @Override
    public void paintComponent (Graphics g) {
       // super.paintComponents(g);
        gg = (Graphics2D) g;
    if (!shapes.isEmpty()) {
            clear.setEnabled(true);
        } else {
            clear.setEnabled(false);
        } //Check

        if (choice == DrawingChoice.CLEARALL)
            clear.setEnabled(true);

        //Graphics2D ggg = (Graphics2D) g;
        for (MasterShape master : shapes) {
            g.setColor(master.getsColor());
            if (master.isDotted()) {
                gg.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, new float[]{9}, 0));
            } else {
                gg.setStroke(new BasicStroke(0));
            }

            if (master instanceof Rectangle rectangle1) {
                if (rectangle1.isFilled()) {
                    g.fillRect(rectangle1.getStart().x, rectangle1.getStart().y,
                            rectangle1.getWidth(), rectangle1.getHeight());
                } else g.drawRect(rectangle1.getStart().x, rectangle1.getStart().y,
                        rectangle1.getWidth(), rectangle1.getHeight());
            }
            if (master instanceof Line line1){
                g.drawLine(line1.getP1().x,line1.getP1().y,line1.getP2().x, line1.getP2().y );
            }
            if (master instanceof Oval){

                if (((Oval) master).isFilled()) {
                    g.fillOval(((Oval) master).getStart().x, ((Oval) master).getStart().y,
                            ((Oval) master).getWidth(), ((Oval) master).getHeight());
                } else g.drawOval(((Oval) master).getStart().x, ((Oval) master).getStart().y,
                        ((Oval) master).getWidth(), ((Oval) master).getHeight());
            }
            if(master instanceof FreeHand){
                g.fillOval(((FreeHand)master).getStart().x,((FreeHand)master).getStart().y, ((FreeHand)master).getWidth(),((FreeHand) master).getHeight());
            }
            if(master instanceof Eraser eraser1){
                g.fillRect(eraser1.getStart().x,eraser1.getStart().y, (eraser1.getWidth()),eraser1.getHeight());
            }
        }


    }



   /* private class MouseMotionListener implements java.awt.event.MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (choice == DrawingChoice.LINE) {
                p2 = e.getPoint();
                isDragged = true;
                repaint();
            }
            if (choice == DrawingChoice.RECTANGLE || choice == DrawingChoice.OVAL) {
                x2 = e.getX();
                y2 = e.getY();
                isDragged = true;
                repaint();
            }
            if (choice == DrawingChoice.FREEHAND) {
                shapes.add(new FreeHand(e.getPoint(), color));
                isDragged = true;
                repaint();
            }
            if (choice == DrawingChoice.ERASER) {
                shapes.add(new Eraser(e.getPoint(), Color.white)); // CHECK
                isDragged = true;
                repaint();
            }

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

    }
        class MouseListener implements java.awt.event.MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if (choice == DrawingChoice.LINE) {
                    p1 = e.getPoint();
                    isDragged = false;
                    repaint();
                }
                if (choice == DrawingChoice.RECTANGLE || choice == DrawingChoice.OVAL || choice == DrawingChoice.FREEHAND) {
                    x1 = e.getX();
                    y1 = e.getY();
                    isDragged = false;
                    repaint();
                }
                if (choice == DrawingChoice.FREEHAND) {
                    shapes.add(new FreeHand(e.getPoint(), color));
                    isDragged = false;
                    repaint();
                }
                if (choice == DrawingChoice.ERASER) {
                    shapes.add(new Eraser(e.getPoint(), null)); //Check
                    isDragged = true;
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (choice == DrawingChoice.LINE) {
                    lines.add(new Line(p1,p2,c));
                    shapes.add(new Line(p1, p2, color, isDotted));
                    isDragged = false;
                    repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        }
`


    }
