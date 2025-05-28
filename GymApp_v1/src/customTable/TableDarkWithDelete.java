package customTable;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
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

public class TableDarkWithDelete extends JTable {
    
    
    private boolean logByStaff = false;
    private TableDarkHeader header;
    private TableDarkCell cell;
    private JPopupMenu popupMenu;
    private String idColumnName;    // Actual database column name
    private String displayColumnName; // Display column name in table
    private String tableName;       // Database table name
    private String customDeleteQuery;
    private dbConnector dbConnector;
    
    public TableDarkWithDelete() {
        initTable();
        initPopupMenu();
    }
    
    public void setLogByStaff(boolean logByStaff) {
        this.logByStaff = logByStaff;
    }
    
    private String getDetailsOfDeletedItem(int row) {
        StringBuilder details = new StringBuilder();

        DefaultTableModel model = (DefaultTableModel) getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            String columnName = model.getColumnName(i);
            Object value = model.getValueAt(convertRowIndexToModel(row), i);
            details.append(columnName).append(": ").append(value).append("; ");
        }

        return details.toString().trim();
    }


    private void initTable() {
        header = new TableDarkHeader();
        cell = new TableDarkCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(30);
        setFillsViewportHeight(false);
        setDefaultEditor(Object.class, null); // Completely disable editing
        
        setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }
    
    private void initPopupMenu() {
        popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(e -> deleteSelectedRow());
        popupMenu.add(deleteItem);

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

    public void setDeleteQuery(String customQuery) {
        this.customDeleteQuery = customQuery;
    }

    // Main delete functionality
    private void deleteSelectedRow() {
        if (!validateDeletePreconditions()) return;

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to delete this record?", 
            "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            performDeleteOperation();
        }
    }

    private boolean validateDeletePreconditions() {
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
    
    /*
    private void logActivity(String description) {
        dbConnector dbc = new dbConnector();
        Connection conn = null;
        PreparedStatement pst = null;

        Session sess = Session.getInstance();

        try {
            String query = "INSERT INTO activity_logs (user_id, description) VALUES (?, ?)";

            conn = dbc.getConnection();
            pst = conn.prepareStatement(query);

            pst.setInt(1, sess.getUid());
            pst.setString(2, description);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error logging activity: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    */
    
    private void logActivity(String description) {
        dbConnector dbc = new dbConnector();
        Connection conn = null;
        PreparedStatement pst = null;

        Session sess = Session.getInstance();
        int userId = logByStaff ? sess.getStaffId() : sess.getUid();  // You must have a getStaffId() method in Session

        try {
            String query = "INSERT INTO activity_logs (user_id, description) VALUES (?, ?)";

            conn = dbc.getConnection();
            pst = conn.prepareStatement(query);

            pst.setInt(1, userId);
            pst.setString(2, description);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error logging activity: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void performDeleteOperation() {
        try {
            int selectedRow = getSelectedRow();
            Object idValue = getModelValueAt(selectedRow, displayColumnName);
            String query = buildDeleteQuery();

            try (Connection conn = dbConnector.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setObject(1, idValue);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    // ✅ Get full details of the deleted item
                    String deletedItemDetails = getDetailsOfDeletedItem(selectedRow);

                    // ✅ Remove from table
                    ((DefaultTableModel) getModel()).removeRow(convertRowIndexToModel(selectedRow));
                    showSuccess("Record deleted successfully");

                    // ✅ Log detailed activity
                    String activityDescription = "Deleted item - " + deletedItemDetails;
                    logActivity(activityDescription);

                } else {
                    showError("No record was deleted");
                }
            }
        } catch (Exception ex) {
            showError("Delete failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }


    private String buildDeleteQuery() {
        return customDeleteQuery != null ? customDeleteQuery 
               : "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?";
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

    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void setIdColumnName(String idColumnName) {
        this.idColumnName = idColumnName;
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