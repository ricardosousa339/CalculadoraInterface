
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame.*;
import javax.swing.*;

public class Calculadora {


    public Calculadora() {
        JPanel panel = new JPanel();


        GridLayoutFrame janela = new GridLayoutFrame();
        janela.setSize(350,500);
        janela.setVisible(true);

        janela.setResizable(false);

    }
    public static void main(String[] args) {
        Calculadora j = new Calculadora();

    }
}

class GridLayoutFrame extends JFrame{


    StringBuilder expressao = new StringBuilder();

    private final GridLayout gridLayout;
    private final Container container;

    final JLabel visor = new JLabel(" ");

    public GridLayoutFrame() {
        gridLayout = new GridLayout(4,4);

        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();

        container = getContentPane();
        container.setLayout(new BorderLayout());

        Container teclado = new Container();
        Container tela = new Container();

        teclado.setLayout(gridLayout);
        tela.setLayout(new BorderLayout());
        JLabel vazio = new JLabel(" ");
        JLabel vazio2 = new JLabel(" ");

        tela.add(vazio, BorderLayout.NORTH);
        tela.add(visor, BorderLayout.CENTER);
        tela.add(vazio2, BorderLayout.SOUTH);


        container.add(tela, BorderLayout.NORTH);
        container.add(teclado, BorderLayout.CENTER);

        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        JButton buttonAdicao = new JButton("+");
        JButton buttonSubtracao = new JButton("-");
        JButton buttonMultiplicacao = new JButton("x");
        JButton buttonDivisao = new JButton("/");
        JButton buttonIgual = new JButton("=");
        JButton buttonDel = new JButton("Del");

        //buttonIgual.setBackground(Color.GRAY);
        //buttonIgual.setFont(fonte);
        Font fonte0 = new Font("SansSerif", Font.BOLD,35);
        visor.setFont(fonte0);
        visor.setSize(container.getWidth(), 120);

        /**
         * Comecando edicao das cores
         */

        button1.setBackground(Color.LIGHT_GRAY);
        button2.setBackground(Color.LIGHT_GRAY);
        button3.setBackground(Color.LIGHT_GRAY);
        button4.setBackground(Color.LIGHT_GRAY);
        button5.setBackground(Color.LIGHT_GRAY);
        button6.setBackground(Color.LIGHT_GRAY);
        button7.setBackground(Color.LIGHT_GRAY);
        button8.setBackground(Color.LIGHT_GRAY);
        button9.setBackground(Color.LIGHT_GRAY);
        button0.setBackground(Color.LIGHT_GRAY);

        buttonAdicao.setBackground(Color.CYAN);
        buttonSubtracao.setBackground(Color.CYAN);
        buttonMultiplicacao.setBackground(Color.CYAN);
        buttonDivisao.setBackground(Color.CYAN);
        buttonIgual.setBackground(Color.ORANGE);
        buttonDel.setBackground(Color.RED);
        /**
         * Fima da edicao das cores
         */


        //visor.setHorizontalTextPosition(JLabel.CENTER);

        /*
        add(vazio);
        add(vazio2);
        add(vazio3);
        */

        teclado.add(button9);
        teclado.add(button8);
        teclado.add(button7);

        teclado.add(buttonAdicao);

        teclado.add(button6);
        teclado.add(button5);
        teclado.add(button4);
        teclado.add(buttonSubtracao);

        teclado.add(button3);
        teclado.add(button2);
        teclado.add(button1);
        teclado.add(buttonMultiplicacao);
        teclado.add(buttonDel);
        teclado.add(button0);
        teclado.add(buttonIgual);
        teclado.add(buttonDivisao);

        //janela.getContentPane().add(panel);
        buttonClicks(button0);
        buttonClicks(button1);
        buttonClicks(button2);
        buttonClicks(button3);
        buttonClicks(button4);
        buttonClicks(button5);
        buttonClicks(button6);
        buttonClicks(button7);
        buttonClicks(button8);
        buttonClicks(button9);
        buttonClicks(buttonAdicao);
        buttonClicks(buttonSubtracao);
        buttonClicks(buttonMultiplicacao);
        buttonClicks(buttonDivisao);
        buttonClicks(buttonIgual);
        buttonClicks(buttonDel);

        button0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public void buttonClicks(JButton button) {

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText().equals("=")) {
                    expressao.replace(0, expressao.length(), calcula(expressao.toString())+"");
                }
                else if(button.getText().equals("Del")) {
                    if(expressao.length()>0)
                        expressao.deleteCharAt(expressao.length()-1);
                }
                else {
                    expressao.append(button.getText());
                }

                if(expressao.toString().endsWith(".0")) {
                    expressao.delete(expressao.length()-2, expressao.length());
                }

                if(expressao.toString().equals("")){
                    visor.setText(" ");
                }
                else
                visor.setText(expressao.toString());
            }

        });

        if(button.getText().equals("Del")) {
            Font fonte1 = new Font("SansSerif", Font.ITALIC+Font.BOLD,13);
            button.setFont(fonte1);
        }
        else {
            Font fonte = new Font("SansSerif", Font.BOLD, 18);
            button.setFont(fonte);
        }



    }


    public double calcula(String exp) {

        System.out.println(exp);

        double resultado = 0;


        if (exp.equals("")) {
            resultado = 0;
        } else {
            int indice1 = exp.indexOf("x");
            int indice2 = exp.indexOf("/");
            int indice3 = exp.indexOf("-");
            int indice4 = exp.indexOf("+");
            if (indice1 == -1 && indice2 == -1 && indice3 == -1 && indice4 == -1) {
                resultado = Double.parseDouble(exp);
            } else {


                if (indice3 != -1) {
                    resultado = ((calcula(exp.substring(0, indice3))) - (calcula(exp.substring(indice3 + 1, exp.length()))));
                } else if (indice4 != -1) {
                    resultado = calcula(exp.substring(0, indice4)) + calcula(exp.substring(indice4 + 1, exp.length()));
                } else if (indice1 != -1) {
                    resultado = calcula(exp.substring(0, indice1)) * calcula(exp.substring(indice1 + 1, exp.length()));

                } else if (indice2 != -1) {
                    resultado = calcula(exp.substring(0, indice2)) / calcula(exp.substring(indice2 + 1, exp.length()));
                }

            }

        }
        return resultado;
    }

}

