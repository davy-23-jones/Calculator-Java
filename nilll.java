import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nilll implements ActionListener {
    JFrame frame;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton clrButton, equButton, decButton, delButton;
    JTextField textField;
    Font font = new Font("Verdana", Font.PLAIN, 30);
    JPanel panel;
    char operator;
    double number1=0, number2=0;
    double result;

    nilll(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.setLayout(null);
        frame.setSize(420, 550);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        delButton = new JButton("Del");
        equButton = new JButton("=");
        clrButton = new JButton("Clr");functionButtons[0] = addButton;

        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i=0; i<8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setForeground(Color.white);
            functionButtons[i].setBackground(Color.darkGray);
        }

        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.gray);
            numberButtons[i].setForeground(Color.white);
        }

        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        frame.add(delButton);
        frame.add(clrButton);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);



        frame.add(textField);
        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == addButton){
            number1 = Integer.parseInt(textField.getText());
            operator = '+';
            textField.setText("");

        }
        if(e.getSource()==equButton) {
            number2=Double.parseDouble(textField.getText());

            switch(operator) {
                case'+':
                    result=number1+number2;
                    break;
                case'-':
                    result=number1-number2;
                    break;
                case'*':
                    result=number1*number2;
                    break;
                case'/':
                    result=number1/number2;
                    break;
            }
            textField.setText(String.valueOf(result));
            number1=result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText().concat(String.valueOf(string.charAt(i))));
            }
        }
        if(e.getSource()==subButton) {
            number1 = Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton) {
            number1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }
        if(e.getSource()==divButton) {
            number1 = Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }


    }

}
