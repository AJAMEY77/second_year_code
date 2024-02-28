import java.applet.Applet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementSystem extends Applet implements ActionListener {
    // Fields
    private Label nameLabel, rollLabel, courseLabel;
    private TextField nameTextField, rollTextField, courseTextField;
    private Button addButton, displayButton;

    // Initialization method
    public void init() {
        // Initialize labels
        nameLabel = new Label("Name:");
        rollLabel = new Label("Roll Number:");
        courseLabel = new Label("Course:");

        // Initialize text fields
        nameTextField = new TextField(20);
        rollTextField = new TextField(10);
        courseTextField = new TextField(15);

        // Initialize buttons
        addButton = new Button("Add Student");
        displayButton = new Button("Display Students");

        // Add components to the applet
        add(nameLabel);
        add(nameTextField);
        add(rollLabel);
        add(rollTextField);
        add(courseLabel);
        add(courseTextField);
        add(addButton);
        add(displayButton);

        // Register action listeners
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    // ActionPerformed method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Code to add a student (e.g., to a list or database)
            // You can display a message or perform additional actions here
            System.out.println("Student added!");
        } else if (e.getSource() == displayButton) {
            // Code to display students (e.g., from a list or database)
            // You can display the students in a new window or console
            System.out.println("Displaying Students...");
        }
    }

    public static void main(String[] args) {
        // Create an instance of StudentManagementSystem
        StudentManagementSystem sms = new StudentManagementSystem();

        // Set the size of the applet
        sms.setSize(400, 300);

        // Call the init method to initialize the applet components
        sms.init();

        // Add the applet to a frame
        Frame frame = new Frame("Student Management System");
        frame.add(sms);

        // Make the frame visible
        frame.setVisible(true);
    }
}
