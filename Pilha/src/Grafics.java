import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafics {
    private static  Pilha pilha = new Pilha();
    private static DefaultListModel<Integer> model = new DefaultListModel<>();
    private  static  JList<Integer> list = new JList<>(model);

    public static void main(String[] args){
        JFrame frame = new JFrame("Pilha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JTextField textField = new JTextField();
        JButton addButton = new JButton("Adicionar");
        JButton popButton = new JButton("Remover");

        Dimension buttonSize = new Dimension(100, 10);
        Dimension textSize = new Dimension(100, 30);

        textField.setPreferredSize(textSize);
        addButton.setPreferredSize(buttonSize);
        popButton.setPreferredSize(buttonSize);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(textField.getText());
                pilha.push(number);
                model.add(0, number);
                textField.setText("");

            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!model.isEmpty()) {
                    int elemento = pilha.pop();
                    model.remove(0);
                }else {
                    JOptionPane.showConfirmDialog(frame, "A pilha está vazia!");
                }
            }
        });
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER); // Centraliza o texto
                return label;
            }
        });

        panel.add(textField, BorderLayout.NORTH);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.WEST);
        panel.add(popButton, BorderLayout.EAST);

        frame.add(panel);
        frame.setVisible(true);
    }
}
