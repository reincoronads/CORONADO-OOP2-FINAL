package customTable;

import adminDash.ManageEquipment.updateEquipment;
import adminDash.ManageStaff.updateStaff;
import adminDash.ManageUser.updateUser;
import adminDash.Membership.editMember;
import config.dbConnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

public class TableDarkWithEdit extends JTable {

    public TableDarkHeader header;
    public TableDarkCell cell;
    private JPopupMenu popupMenu;
    private String idColumnName;    // Actual database column name
    private String displayColumnName; // Display column name in table
    private String tableName;       // Database table name
    private dbConnector dbConnector;
    private String currentQuery; // Store the current query for refreshing
    private String currentUserId;
    
    public TableDarkWithEdit() {
        initTable();
        initPopupMenu();
    }
    
    public void setCurrentUserId(String userId) {
        this.currentUserId = userId;
    }
    
    private void logActivity(String action) {
        if (dbConnector == null || currentUserId == null) return;

        String logQuery = "INSERT INTO activity_logs (user_id, description) VALUES (?, ?)";

        try (Connection conn = dbConnector.getConnection();
             PreparedStatement pst = conn.prepareStatement(logQuery)) {

            pst.setString(1, currentUserId);
            pst.setString(2, action);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Activity log failed: " + ex.getMessage());
        }
    }

    private void initTable() {
        header = new TableDarkHeader();
        cell = new TableDarkCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        getTableHeader().setReorderingAllowed(false); // prevent column reordering
        setDefaultRenderer(Object.class, cell);
        setRowHeight(30);
        setFillsViewportHeight(false);
        setDefaultEditor(Object.class, null); // disable cell editing
        setDragEnabled(false); // disable drag and drop

        setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }
    
    private void initPopupMenu() {
        popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("Edit");
        editItem.addActionListener(e -> editSelectedUser());
        popupMenu.add(editItem);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMouseEvent(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                handleMouseEvent(e);
            }

            private void handleMouseEvent(MouseEvent e) {
                if (!SwingUtilities.isRightMouseButton(e)) return;
                
                int row = rowAtPoint(e.getPoint());
                if (row >= 0 && row < getRowCount()) {
                    setRowSelectionInterval(row, row);
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    // Configuration methods
    public void setDbConnector(dbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public void configureForTable(String tableName, String idColumnName, String displayColumnName) {
        this.tableName = tableName;
        this.idColumnName = idColumnName;
        this.displayColumnName = displayColumnName;
    }
    
    public void configureForStaff() {
        this.tableName = "staff_tbl";
        this.idColumnName = "staff_id";
        this.displayColumnName = "ID";
    }

    private void openStaffEditForm(ResultSet rs) throws SQLException {
        updateStaff editForm = new updateStaff();

        // Map database columns to form fields
        editForm.staffID.setText(rs.getString("staff_id"));
        editForm.fname.setText(rs.getString("staff_Fname"));
        editForm.lname.setText(rs.getString("staff_Lname"));
        editForm.txtDate.setText(rs.getString("staff_Birthdate"));
        editForm.emailPane.setText(rs.getString("staff_Email"));
        editForm.mobileNum.setText(rs.getString("staff_Phone"));

        // Set combo box values
        setComboBoxValue(editForm.staffType, rs.getString("staff_Type"));
        setComboBoxValue(editForm.staffStatus, rs.getString("staff_Status"));

        // Set parent table reference for refresh after update
        editForm.setParentTable(this);
        editForm.setVisible(true);
    }

    // Modify the editSelectedUser method to use the existing connection
    private void editSelectedUser() {
        if (!validateEditPreconditions()) return;

        try {
            String idValue = getModelValueAt(getSelectedRow(), displayColumnName).toString();
            String query = "SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?";

            try (Connection conn = dbConnector.getConnection();
                 PreparedStatement pst = conn.prepareStatement(query)) {

                pst.setString(1, idValue);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        switch(tableName) {
                            case "tbl_user":
                                openUserEditForm(rs);
                                logActivity("Opened edit form for User ID: " + rs.getString("user_id"));
                                break;
                            case "staff_tbl":
                                openStaffEditForm(rs);
                                logActivity("Opened edit form for Staff ID: " + rs.getString("staff_id"));
                                break;
                            case "equipment_tbl":
                                openEquipmentEditForm(rs);
                                logActivity("Opened edit form for Equipment ID: " + rs.getString("id"));
                                break;
                            case "memberships":
                                openMembershipEditForm(rs);
                                logActivity("Opened edit form for Membership ID: " + rs.getString("membership_id"));
                                break;
                            default:
                                showError("No edit form configured for table: " + tableName);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            showError("Error preparing edit: " + ex.getMessage());
        }
    }
    
    private void openMembershipEditForm(ResultSet rs) throws SQLException {
        editMember editForm = new editMember(rs.getString("membership_id"));
        // Set other membership fields as needed
        editForm.setVisible(true);
    }
    
    private void editSelectedStaff() {
        if (!validateEditPreconditions()) return;

        try {
            String staffId = getModelValueAt(getSelectedRow(), displayColumnName).toString();
            String query = "SELECT * FROM staff_tbl WHERE staff_id = ?";

            // Use the existing connection
            if (currentConnection == null || currentConnection.isClosed()) {
                currentConnection = dbConnector.getConnection();
            }

            try (PreparedStatement pstmt = currentConnection.prepareStatement(query)) {
                pstmt.setString(1, staffId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        openStaffEditForm(rs);
                    }
                }
            }
        } catch (Exception ex) {
            showError("Error preparing edit: " + ex.getMessage());
        }
    }

    private boolean validateEditPreconditions() {
        if (dbConnector == null) {
            showError("Database connector not set");
            return false;
        }
        if (idColumnName == null || displayColumnName == null) {
            showError("Table configuration not complete");
            return false;
        }
        if (getSelectedRow() == -1) {
            showError("No row selected");
            return false;
        }
        return true;
    }
    
    private Connection currentConnection; // Track the current connection

    public void loadTableData(String query) {
        this.currentQuery = query;
        try {
            // Close previous connection if exists
            if (currentConnection != null && !currentConnection.isClosed()) {
                currentConnection.close();
            }
            
            // Get new connection
            currentConnection = dbConnector.getConnection();
            PreparedStatement pst = currentConnection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            this.setModel(DbUtils.resultSetToTableModel(rs));
            this.setDefaultRenderer(Object.class, cell);
            this.getTableHeader().setDefaultRenderer(header);

            // Reapply alignments
            for (int i = 0; i < getColumnCount(); i++) {
                setCellAlignment(i, JLabel.LEFT);
            }

            rs.close();
            pst.close();
        } catch (SQLException ex) {
            showError("Error loading data: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    // Add a method to clean up resources when done
    public void cleanup() {
        try {
            if (currentConnection != null && !currentConnection.isClosed()) {
                currentConnection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void refreshTable() {
        if (currentQuery != null) {
            loadTableData(currentQuery);
        }
    }

    
    private void openUserEditForm(ResultSet rs) throws SQLException {
        updateUser editForm = new updateUser();
        editForm.fname.setText(rs.getString("user_Fname"));
        editForm.lname.setText(rs.getString("user_Lname"));
        editForm.txtDate.setText(rs.getString("user_Birthdate"));
        editForm.emailPane.setText(rs.getString("user_Email"));
        editForm.mobileNum.setText(rs.getString("user_Phone"));
        editForm.userID.setText(rs.getString("user_id"));  // Changed from "name" to "user_id"

        // For combo boxes
        setComboBoxValue(editForm.userType, rs.getString("user_Type"));
        setComboBoxValue(editForm.userStatus, rs.getString("user_Status"));

        editForm.setVisible(true);
    }

    private void openEquipmentEditForm(ResultSet rs) throws SQLException {
        updateEquipment editForm = new updateEquipment();

        // Map database columns to form fields
        editForm.equipmentId.setText(rs.getString("id"));
        editForm.equipName.setText(rs.getString("name"));
        editForm.desc.setText(rs.getString("description"));
        editForm.date.setText(rs.getString("date"));  // Assuming you have a date field
        editForm.quantity.setText(rs.getString("quantity"));
        // In your form loading code:
        editForm.vendorAddress.setText(rs.getString("address")); 
        editForm.vendor.setText(rs.getString("vendor"));
        editForm.price.setText(rs.getString("price"));

        editForm.setVisible(true);
    }

    private void setComboBoxValue(javax.swing.JComboBox<String> comboBox, String value) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equalsIgnoreCase(value)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    // Utility methods
    public Object getModelValueAt(int viewRowIndex, String columnName) {
        int modelRow = convertRowIndexToModel(viewRowIndex);
        int modelCol = findModelColumnIndex(columnName);
        return getModel().getValueAt(modelRow, modelCol);
    }

    private int findModelColumnIndex(String columnName) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Column '" + columnName + "' not found");
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void setColumnAlignment(int column, int align) {
        header.setAlignment(column, align);
    }

    public void setCellAlignment(int column, int align) {
        cell.setAlignment(column, align);
    }

    public void setColumnWidth(int column, int width) {
        TableColumnModel columnModel = getColumnModel();
        columnModel.getColumn(column).setPreferredWidth(width);
        columnModel.getColumn(column).setMinWidth(width);
        columnModel.getColumn(column).setMaxWidth(width);
        columnModel.getColumn(column).setMinWidth(10);
        columnModel.getColumn(column).setMaxWidth(10000);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.setHorizontalScrollBar(new ScrollBarCustom());
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 30));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        
        scroll.getViewport().setBackground(new Color(30, 30, 30));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
        
        scroll.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        setFillsViewportHeight(false);
    }

    @Override
    protected JTableHeader createDefaultTableHeader() {
        return new JTableHeader(columnModel) {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 35;
                return d;
            }
        };
    }

    private class TableDarkHeader extends DefaultTableCellRenderer {
        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            com.setBackground(new Color(30, 30, 30));
            com.setForeground(new Color(200, 200, 200));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            if (alignment.containsKey(i1)) {
                setHorizontalAlignment(alignment.get(i1));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }

    private class TableDarkCell extends DefaultTableCellRenderer {
        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Color(33, 103, 153));
                } else {
                    com.setBackground(new Color(29, 86, 127));
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(new Color(50, 50, 50));
                } else {
                    com.setBackground(new Color(30, 30, 30));
                }
            }
            com.setForeground(new Color(200, 200, 200));
            setBorder(new EmptyBorder(0, 5, 0, 5));
            if (alignment.containsKey(column)) {
                setHorizontalAlignment(alignment.get(column));
            } else {
                setHorizontalAlignment(JLabel.LEFT);
            }
            return com;
        }
    }
}