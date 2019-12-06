import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUI {

    public UserModel user = null;

    public JFrame view;

    public JButton btnSetupSystemConfig = new JButton("Setup System Config");
    public JButton btnAddNewUser = new JButton("Add New User");
    public JButton btnDeleteExistingUser = new JButton("Delete Existing User");
    public JButton btnChangePosition = new JButton("Change User Position");

    public AdminUI(UserModel user) {

        this.user = user;

        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System - Admin View");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelUser = new JPanel(new FlowLayout());

        view.getContentPane().add(panelUser);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnSetupSystemConfig);
        panelButtons.add(btnAddNewUser);
        panelButtons.add(btnDeleteExistingUser);
        panelButtons.add(btnChangePosition);



        view.getContentPane().add(panelButtons);


        btnSetupSystemConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddConfigUI ui = new AddConfigUI();
                ui.run();
            }
        });

        btnAddNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddCustomerUI ui = new AddCustomerUI();
                ui.run();
            }
        });

        btnDeleteExistingUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeleteCustomerUI ui = new DeleteCustomerUI();
                ui.run();
            }
        } );

        btnChangePosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChangeUserUI ui = new ChangeUserUI();
                ui.run();
            }
        } );

    }
}