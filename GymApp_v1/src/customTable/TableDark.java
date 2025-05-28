    package customTable;

    import java.awt.Color;
    import java.awt.Component;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.util.HashMap;
    import java.util.Map;
    import javax.swing.BorderFactory;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.JViewport;
    import javax.swing.border.EmptyBorder;
    import javax.swing.table.DefaultTableCellRenderer;
    import javax.swing.table.DefaultTableModel;
    import javax.swing.table.JTableHeader;
    import javax.swing.table.TableColumnModel;

    public class TableDark extends JTable {

        private TableDarkHeader header;
        private TableDarkCell cell;

        public TableDark() {
            header = new TableDarkHeader();
            cell = new TableDarkCell();
            getTableHeader().setDefaultRenderer(header);
            getTableHeader().setPreferredSize(new Dimension(0, 35));
            setDefaultRenderer(Object.class, cell);
            setRowHeight(30);
            setFillsViewportHeight(false);

            // Make table non-editable
            setModel(new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // All cells become non-editable
                }
            });
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
            // Apply custom scrollbar
            scroll.setVerticalScrollBar(new ScrollBarCustom());
            scroll.setHorizontalScrollBar(new ScrollBarCustom());

            // Custom corner panel
            JPanel panel = new JPanel();
            panel.setBackground(new Color(30, 30, 30));
            scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);

            // Viewport styling
            scroll.getViewport().setBackground(new Color(30, 30, 30));
            scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));

            // Prevent extra space
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