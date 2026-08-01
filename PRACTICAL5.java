import javax.swing.*;
import java.awt.*;

public final class PRACTICAL5 extends JFrame {

    JTextField nameF, dobF, emailF, phoneF;
    JRadioButton male, female, other;
    JTextArea addressA, summaryA;
    JComboBox<String> eduBox;
    JCheckBox java, python, cpp, sql, html, dsa;
    JButton submitBtn, clearBtn;

    public PRACTICAL5() {
        setTitle("Student Resume Form");
        setSize(600, 640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(230, 240, 255));

        JLabel title = new JLabel("My Resume (S124)", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setOpaque(true);
        title.setForeground(Color.WHITE);
        title.setBackground(new Color(40, 90, 160));
        title.setBorder(BorderFactory.createEmptyBorder(14, 0, 14, 0));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(230, 240, 255));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 10, 6, 10);
        g.anchor = GridBagConstraints.WEST;
        int r = 0;

        nameF = new JTextField(22);
        dobF = new JTextField(22);
        emailF = new JTextField(22);
        phoneF = new JTextField(22);
        addressA = new JTextArea(2, 18);
        summaryA = new JTextArea(2, 18);
        addressA.setLineWrap(true);
        summaryA.setLineWrap(true);

        addRow(form, g, r++, "Full Name:", nameF);

        JPanel genderP = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        genderP.setBackground(new Color(230, 240, 255));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female); bg.add(other);
        genderP.add(male); genderP.add(female); genderP.add(other);
        addRow(form, g, r++, "Gender:", genderP);

        addRow(form, g, r++, "Date of Birth:", dobF);
        addRow(form, g, r++, "Email:", emailF);
        addRow(form, g, r++, "Phone Number:", phoneF);
        addRow(form, g, r++, "Address:", new JScrollPane(addressA));

        String[] edu = {"High School", "Diploma", "Undergraduate", "Postgraduate", "PhD"};
        eduBox = new JComboBox<>(edu);
        addRow(form, g, r++, "Education:", eduBox);

        JPanel skillsP = new JPanel(new GridLayout(2, 3, 5, 3));
        skillsP.setBackground(new Color(230, 240, 255));
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        cpp = new JCheckBox("C++");
        sql = new JCheckBox("SQL");
        html = new JCheckBox("HTML/CSS");
        dsa = new JCheckBox("DSA");
        skillsP.add(java); skillsP.add(python); skillsP.add(cpp);
        skillsP.add(sql); skillsP.add(html); skillsP.add(dsa);
        addRow(form, g, r++, "Skills:", skillsP);

        addRow(form, g, r++, "Resume Summary:", new JScrollPane(summaryA));
        add(form, BorderLayout.CENTER);

        JPanel btnP = new JPanel(new GridLayout(1, 2, 20, 0));
        btnP.setBackground(new Color(230, 240, 255));
        btnP.setBorder(BorderFactory.createEmptyBorder(10, 70, 20, 70));
        submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(40, 90, 160));
        submitBtn.setForeground(Color.WHITE);
        clearBtn = new JButton("Clear");
        clearBtn.setBackground(new Color(200, 60, 70));
        clearBtn.setForeground(Color.WHITE);
        btnP.add(submitBtn); btnP.add(clearBtn);
        add(btnP, BorderLayout.SOUTH);

        submitBtn.addActionListener(e -> submit());
        clearBtn.addActionListener(e -> clear());
    }

    void addRow(JPanel p, GridBagConstraints g, int row, String label, Component c) {
        g.gridx = 0; g.gridy = row; p.add(new JLabel(label), g);
        g.gridx = 1; p.add(c, g);
    }

    void submit() {
        String name = nameF.getText().trim();
        String dob = dobF.getText().trim();
        String email = emailF.getText().trim();

        if (name.isEmpty() || dob.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill Name, DOB and Email.", "Missing Info", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : other.isSelected() ? "Other" : "N/A";
        StringBuilder skills = new StringBuilder();
        if (java.isSelected()) skills.append("Java ");
        if (python.isSelected()) skills.append("Python ");
        if (cpp.isSelected()) skills.append("C++ ");
        if (sql.isSelected()) skills.append("SQL ");
        if (html.isSelected()) skills.append("HTML/CSS ");
        if (dsa.isSelected()) skills.append("DSA ");
        if (skills.length() == 0) skills.append("None");

        String msg = """
                     Resume Submitted Successfully!
                     
                     Name: """ + name + "\nDOB: " + dob + "\nGender: " + gender
                + "\nEmail: " + email + "\nPhone: " + phoneF.getText().trim()
                + "\nAddress: " + addressA.getText().trim()
                + "\nEducation: " + eduBox.getSelectedItem()
                + "\nSkills: " + skills.toString().trim()
                + "\nSummary: " + summaryA.getText().trim();

        JOptionPane.showMessageDialog(this, msg, "Resume Submitted", JOptionPane.INFORMATION_MESSAGE);
    }

    void clear() {
        nameF.setText(""); dobF.setText(""); emailF.setText(""); phoneF.setText("");
        addressA.setText(""); summaryA.setText("");
        male.setSelected(false); female.setSelected(false); other.setSelected(false);
        eduBox.setSelectedIndex(0);
        java.setSelected(false); python.setSelected(false); cpp.setSelected(false);
        sql.setSelected(false); html.setSelected(false); dsa.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PRACTICAL5().setVisible(true));
    }
}