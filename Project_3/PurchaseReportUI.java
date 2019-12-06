import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;

public class PurchaseReportUI {

    public JFrame view;
    //public JList purchases;
    public JTable purchaseTable;

    public List<CustomerModel> cL = null;
    private List<PurchaseListModel> pL = new ArrayList<PurchaseListModel>();

//    public JButton btnLoad = new JButton("Load Customer");
//    public JButton btnSave = new JButton("Save Customer");
//
//    public JTextField txtCustomerID = new JTextField(20);
//    public JTextField txtName = new JTextField(20);
//    public JTextField txtPhone = new JTextField(20);
//    public JTextField txtAddress = new JTextField(20);


    public PurchaseReportUI(List<CustomerModel> customers) {
        this.cL = customers;

        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("View Purchase History");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Purchase history for all customers");

        title.setFont (title.getFont().deriveFont (24.0f));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        view.getContentPane().add(title);

        for(CustomerModel customer: customers) {
            pL.add(StoreManager.getInstance().getDataAdapter().loadPurchaseHistory(customer.mCustomerID));
        }
//        DefaultListModel<String> data = new DefaultListModel<>();
        DefaultTableModel tableData = new DefaultTableModel();
//        String[] columnNames = {"PurchaseID", "ProductID", "Total"};
//        data.addElement(String.format("PurchaseId: %d, ProductId: %d, Total: %8.2f",
//                purchase.mPurchaseID,
//                purchase.mProductID,
//                purchase.mTotal))

        tableData.addColumn("PurchaseID");
        tableData.addColumn("ProductID");
        tableData.addColumn("Product Name");
        tableData.addColumn("Total");

        for (PurchaseListModel p: pL) {
            for (PurchaseModel purchase : p.purchases) {
                Object[] row = new Object[tableData.getColumnCount()];
                row[0] = purchase.mPurchaseID;
                row[1] = purchase.mProductID;
                ProductModel product = StoreManager.getInstance().getDataAdapter().loadProduct(purchase.mProductID);
                row[2] = product.mName;
                row[3] = purchase.mTotal;
                tableData.addRow(row);
            }
        }

//        purchases = new JList(data);

        purchaseTable = new JTable(tableData);

        JScrollPane scrollableList = new JScrollPane(purchaseTable);

        view.getContentPane().add(scrollableList);


    }
}