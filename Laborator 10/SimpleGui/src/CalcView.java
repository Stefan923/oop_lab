// CalcView.java - View component
//    Presentation only.  No user actions.
// Fred Swartz -- December 2004

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

class CalcView extends JFrame {
    //... Components
    private JTextField m_userInputTf = new JTextField(5);
    private JTextField m_totalTf     = new JTextField(20);
    private JButton    m_multiplyBtn = new JButton("Multiply");
    private JButton    m_clearBtn    = new JButton("Clear");
    
    private CalcModel m_model;
    
    //======================================================= constructor
    /** Constructor */
    CalcView(CalcModel model) {
        //... Set up the logic
        m_model = model;
        m_model.setValue(CalcModel.INITIAL_VALUE);
        
        //... Initialize components
        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);
        
        //... Layout the components.      
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(2, 1));

        JPanel input = new JPanel();
        input.setLayout(new FlowLayout());
        input.add(new JLabel("Input"));
        input.add(m_userInputTf);
        input.add(m_multiplyBtn);

        Border redLine = BorderFactory.createLineBorder(Color.RED);
        input.setBorder(redLine);

        JPanel output = new JPanel();
        output.setLayout(new FlowLayout());
        output.add(new JLabel("Total"));
        output.add(m_totalTf);
        output.add(m_clearBtn);

        Border greenLine = BorderFactory.createLineBorder(Color.GREEN);
        output.setBorder(greenLine);

        content.add(input);
        content.add(output);

        //... finalize layout
        this.setContentPane(content);
        this.pack();
        
        this.setTitle("Simple Calc - MVC");
        // The window closing event should probably be passed to the 
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void reset() {
        m_totalTf.setText(CalcModel.INITIAL_VALUE);
        m_userInputTf.setText("");
    }
    
    String getUserInput() {
        return m_userInputTf.getText();
    }
    
    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }
    
    void showError(String errMessage) {
        JOptionPane.showConfirmDialog(this, errMessage);
    }
    
    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }
    
    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
