import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class Function_File {
    GUI gui;
    String fileName;
    String fileAdress;

    public Function_File(GUI gui) {
        this.gui = gui;

    }

    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAdress = null;
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        System.out.println("Direktorijum otvorenog fajla= " + fileAdress + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAdress + fileName)); // potrebna je adresa kako bi
                                                                                           // se procitao file, ovako
                                                                                           // dobijamo ceo direktorijum

            gui.textArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File could not be opened.");

        }

    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                FileWriter fw = new FileWriter(fileAdress + fileName);
                fw.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fw.close();

            } catch (Exception e) {
                System.out.println("Something is wrong");

            }
        }
    }

    public void saveAs() {
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            fileName = fd.getFile()+".txt";
            fileAdress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAdress + fileName);
            fw.write(gui.textArea.getText());
            fw.close();

        } catch (Exception e) {
            System.out.println("Something is wrong");
        }

    }

    public void exit(){
        System.exit(0);
    }

}
