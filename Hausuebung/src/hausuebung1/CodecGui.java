package hue1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Eine Klasse die uns als Teil "view" dient.
 * Damit haben wir das Aussehen aller in der Caesar oder Wuerfel Klassen vorhandenen Methoden bei ein Interface.
 * Die Variablen "codec1" und "codec2" sind Klassenattributen mit denen man die Hauptmethoden
 * "Coder"(kodiere) und "decoder"(dekodiere) bedienbar machen werden.
 *
 * @author Constantin Nshuti
 */
public class CodecGUI extends JFrame {

    private  Codec codec_wuerfel;
    private  Codec codec_caesar;

    private Container container;

    private JLabel labelwillkomen = new JLabel("Waehlen Sie Ihre Verschluesselung Methode aus !!!", JLabel.CENTER);

    private JRadioButton caesar = new JRadioButton("Caesar Verschluesselung", true);
    private JRadioButton wuerfel = new JRadioButton("Wuerfel Verschluesselung");
    private ButtonGroup group = new ButtonGroup();
    private JPanel selectMethodePanel = new JPanel();



    private JTextField losung1 = new JTextField();
    private JTextField losung2 = new JTextField();
    //Eingabebereich fr die Schlsselwrter
    //private GridLayout beideLosung = new GridLayout(1,2,10,10);
    private JPanel beideLosungPanel = new JPanel();

    private JTextArea klarTextArea = new JTextArea(5,20);
    private JScrollPane scrollKlarText = new JScrollPane(klarTextArea);
    private JTextArea geheimTextArea = new JTextArea(5,20);
    private JScrollPane scrollGeheimText = new JScrollPane(geheimTextArea);
    private JPanel beideTextAreaPanel = new JPanel();

    // Erster Button and  Zweiter Button für kodiere und dekodiere
    private JButton kodiereButton = new JButton("Kodierer");
    private JButton dekodiereButton = new JButton("Dekodierer");
    private JButton start = new JButton("Reset");
    private JPanel buttonPanel = new JPanel();

    private JLabel nichtsLabel = new JLabel("@Copyright Constantin Nshuti" ,JLabel.CENTER);

    public CodecGUI(Codec codec1, Codec codec2){
        this.codec_wuerfel = codec1;
        this.codec_caesar = codec2;

        container = getContentPane();
        container.setLayout(new GridLayout(7,1,10,10));

        labelwillkomen.setFont(new Font("Arial Narrow", Font.BOLD, 25));
        nichtsLabel.setFont(new Font("Arial Narrow", Font.BOLD, 20));

        selectMethodePanel.add(caesar);
        selectMethodePanel.add(wuerfel);

        group.add(caesar);
        group.add(wuerfel);

        losung1.setBorder(new TitledBorder("Losungswort1  "));
        losung1.setPreferredSize(new Dimension(230,50));
        losung1.setBackground(new Color(250,200,200));
        losung1.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
        losung1.setToolTipText("Hier ersten Schluessel eingeben");


        losung2.setBorder(new TitledBorder("Losungswort2  "));
        losung2.setPreferredSize(new Dimension(230,50));
        losung2.setBackground(new Color(250,200,200));
        losung2.setFont(new Font(Font.SERIF, Font.ITALIC, 15));
        losung2.setToolTipText("Hier zweiten Schluessel eingeben");
        losung2.setEnabled(false);

        //beideLosungPanel.setSize(new Dimension(100,4000));
        //beideLosungPanel.setLayout(new FlowLayout());
        beideLosungPanel.add(losung1);
        beideLosungPanel.add(losung2);



        klarTextArea.setToolTipText("Hier Klartext eingeben");
        klarTextArea.setBorder(new TitledBorder("Klartext  "));
        klarTextArea.setLineWrap(true);

        geheimTextArea.setToolTipText("Geheimtext aus Ihrem Klartext");
        geheimTextArea.setBorder(new TitledBorder("Geheimtext  "));
        geheimTextArea.setLineWrap(true);


        beideTextAreaPanel.add(scrollKlarText);
        beideTextAreaPanel.add(scrollGeheimText);

        caesar.addActionListener((e) ->{
            if(caesar.isSelected()){
                losung2.setEnabled(false);
            }
        } );

        wuerfel.addActionListener((e) ->{
            if(wuerfel.isSelected()){
                losung2.setEnabled(true);
            }
        } );


        kodiereButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent a) {

                if (wuerfel.isSelected()) {
                   String losungword1 = losung1.getText();
                   String losungword2 = losung2.getText();
                   String klarTextWuerfel = klarTextArea.getText();


                   codec_wuerfel.setzeLosung(losungword1);
                   String geheimText_wuerfel1 = codec_wuerfel.kodiere(klarTextWuerfel);


                   codec_wuerfel.setzeLosung(losungword2);
                   String geheimText_wuerfel2 = codec_wuerfel.kodiere(geheimText_wuerfel1);


                   geheimTextArea.setText(geheimText_wuerfel2);




                } else if (caesar.isSelected()) {
                    String losungword = losung1.getText();
                    String klartext = klarTextArea.getText();

                    codec_caesar.setzeLosung(losungword);
                    String geheimText = codec_caesar.kodiere(klartext);
                    geheimTextArea.setText(geheimText);


                }


            }
        });

        dekodiereButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent a) {

                if (wuerfel.isSelected()) {
                    String losungword1 = losung1.getText();
                    String losungword2 = losung2.getText();
                    String geheimTextWuerfel = geheimTextArea.getText();

                    codec_wuerfel.setzeLosung(losungword2);
                    String geheimText_wuerfel1 = codec_wuerfel.dekodiere(geheimTextWuerfel);

                    codec_wuerfel.setzeLosung(losungword1);
                    String geheimText_wuerfel2 = codec_wuerfel.dekodiere(geheimText_wuerfel1);
                    klarTextArea.setText(geheimText_wuerfel2);



                } else if (caesar.isSelected()) {
                    String losungword = losung1.getText();
                    String geheimtext = geheimTextArea.getText();

                    codec_caesar.setzeLosung(losungword);
                    String klartext = codec_caesar.dekodiere(geheimtext);
                    klarTextArea.setText(klartext);

                }

            }

        });


        start.setToolTipText("Loesche alles");

        start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent a) {
                if(a.getSource() == start) {
                    losung1.setText(" ");
                    losung2.setText(" ");
                    klarTextArea.setText(null);
                    geheimTextArea.setText(null);
                    kodiereButton.setEnabled(true);
                    dekodiereButton.setEnabled(true);
                }
            }
        });

        buttonPanel.add(kodiereButton);
        buttonPanel.add(dekodiereButton);
        buttonPanel.add(start);

        container.add(labelwillkomen);
        container.add(selectMethodePanel);
        //container.add(nichtsLabel);
        container.add(beideLosungPanel);

        container.add(beideTextAreaPanel);
        container.add(buttonPanel);
        container.add(nichtsLabel);




        this.setTitle("CAESAR- UND WUERFEL ALGORITHMEN");
        this.setSize(800, 400);
        this.setBounds(400,100,600,600);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            new CodecGUI(new Wuerfel("THM"), new Caesar());
        });
    }

}

