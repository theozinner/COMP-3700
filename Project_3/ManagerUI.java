import com.google.gson.Gson;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ManagerUI {
    public JFrame view;
    UserModel user = null;
    public JButton btnManageCustomer = new JButton("Manage Customers");
    public JButton btnManageProduct = new JButton("Manage Products");
    public JButton btnPurchaseReport = new JButton("Purchase Report");

    private List<CustomerModel> customerList = new ArrayList<CustomerModel>();
    public ManagerUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System - Manager View");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnManageProduct);
        panelButtons.add(btnManageCustomer);
        panelButtons.add(btnPurchaseReport);

        view.getContentPane().add(panelButtons);


        btnManageProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageProductUI ui = new ManageProductUI();
                ui.run();
            }
        });

        btnPurchaseReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 1; i <= 4; i++)
                    customerList.add(StoreManager.getInstance().getDataAdapter().loadCustomer(i));

                PurchaseReportUI ui = new PurchaseReportUI(customerList);

                ui.view.setVisible(true);
            }
        });

        btnManageCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManageCustomerUI ui = new ManageCustomerUI();
                ui.run();
            }
        });

    }
}
