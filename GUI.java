import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;
    // TEXTAREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    // TOPMENUBAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // FILEMENU
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    //EDITMENU
    JMenuItem iUndo, iRedo;
    // FORMATMENU
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize20, iFontSize32;
    JMenu menuFont, menuFontSize;
    //COLORMENU
    JMenuItem iColor1, iColor2, iColor3,iColor4;

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);
    KeyHandler kHandler = new KeyHandler(this);
    
    UndoManager um = new UndoManager();



    public static void main(String[] args) {
        new GUI();
    }

    // konstruktor (stavlja se sve sto napravis)
    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();
        format.selectedFont = "Arial";//default values
        format.createFont(16);//default values
        color.changeColor("White");//default values        
        window.setVisible(true);//default values
        

    }

    // stvara prozor
    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
        window.setIconImage(logo.getImage());
    }

    // stvara mesto za text i stavlja scrollpane
    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setFont(format.arial);

        textArea.addKeyListener(kHandler);
        //editmanager
        textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener(){
                public void undoableEditHappened(UndoableEditEvent e){
                     um.addEdit(e.getEdit());                
                }});


        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        // window.add(textArea);
    }

    // meni i njihovi nazivi
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

    }

    // stvari (itemi) unutar tih menija
    public void createFileMenu() {

        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }
    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("Word wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize32 = new JMenuItem("32");
        iFontSize32.addActionListener(this);
        iFontSize32.setActionCommand("size32");
        menuFontSize.add(iFontSize32);

    }
    public void createColorMenu(){
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);

        iColor4 = new JMenuItem("CoolColor");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("CoolColor");
        menuColor.add(iColor4);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "SaveAs":
                file.saveAs();
                break;
            case "Save":
                file.save();
                break;
            case "Exit":
                file.exit();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "size8": format.createFont(8);break;
            case "size12":format.createFont(12);break;
            case "size20":format.createFont(20);break;
            case "size32":format.createFont(32);break;
            case "Arial":format.setFont(command);break;
            case "Comic Sans MS":format.setFont(command);break;
            case "Times New Roman":format.setFont(command);break;
            case "White": color.changeColor(command);break;
            case "Black": color.changeColor(command);break;
            case "Blue": color.changeColor(command);break;
            case "CoolColor": color.changeColor(command);break;
            case "Undo": edit.undo();break;
            case "Redo": edit.redo();break;


        }
    }

}
