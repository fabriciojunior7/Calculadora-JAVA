/*
    Fabricio Junior
    Inicio: 06/01/2018
    Ultima Atualizacao: 08/01/2018
 */

package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Tela implements  ActionListener, KeyListener {

    //Atributos
    public ArrayList<JButton> botoes = new ArrayList<JButton>();
    private JButton n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, mais, menos, vezes,dividido, igual, ac, ponto;
    private JLabel monitor;
    private double a, b, c;
    private boolean adicao, subtracao, multiplicacao, divisao, isA;
    private int maxChar;
    public JFrame tela;


    //Construtor
    public Tela(){
        tela = new JFrame("Calculadora Junior");
        tela.setSize(320, 400);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setResizable(false);
        tela.setFocusable(true);
        tela.setAutoRequestFocus(true);

        tela.setLayout(null);

        Insets in = tela.getInsets();

        monitor = new JLabel();
        n0 = new JButton("0");
        n1 = new JButton("1");
        n2 = new JButton("2");
        n3 = new JButton("3");
        n4 = new JButton("4");
        n5 = new JButton("5");
        n6 = new JButton("6");
        n7 = new JButton("7");
        n8 = new JButton("8");
        n9 = new JButton("9");
        mais = new JButton("+");
        menos = new JButton("-");
        dividido = new JButton("/");
        vezes = new JButton("x");
        igual = new JButton("=");
        ac = new JButton("AC");
        ponto = new JButton(".");

        botoes.add(n0);
        botoes.add(n1);
        botoes.add(n2);
        botoes.add(n3);
        botoes.add(n4);
        botoes.add(n5);
        botoes.add(n6);
        botoes.add(n7);
        botoes.add(n8);
        botoes.add(n9);
        botoes.add(mais);
        botoes.add(menos);
        botoes.add(dividido);
        botoes.add(vezes);
        botoes.add(igual);
        botoes.add(ac);
        botoes.add(ponto);

        Font fonteBotao = new Font("Arial", Font.BOLD, 28);
        Font fonteMonitor = new Font("Arial", Font.BOLD, 30);

        monitor.setFont(fonteMonitor);
        monitor.setHorizontalAlignment(JLabel.CENTER);
        monitor.setVerticalAlignment(JLabel.CENTER);
        for(JButton b : botoes){
            b.setFont(fonteBotao);
            b.setFocusPainted(false);
        }
        ac.setForeground(Color.red);

        monitor.setBounds(10, 10, 250, 70);
        n1.setBounds(10, 90, 50, 100);
        n2.setBounds(60, 90, 50, 100);
        n3.setBounds(110, 90, 50, 100);

        n4.setBounds(10, 190, 50, 100);
        n5.setBounds(60, 190, 50, 100);
        n6.setBounds(110, 190, 50, 100);

        n7.setBounds(10, 290, 50, 100);
        n8.setBounds(60, 290, 50, 100);
        n9.setBounds(110, 290, 50, 100);

        n0.setBounds(10, 390, 150, 50);
        ponto.setBounds(160, 390, 100, 50);

        mais.setBounds(160, 90, 50, 100);
        menos.setBounds(210, 90, 50, 100);
        vezes.setBounds(160, 190, 50, 100);
        dividido.setBounds(210, 190, 50, 100);
        igual.setBounds(160, 290, 100, 50);
        ac.setBounds(160, 340, 100, 50);

        //mais.setBounds();

        tela.setSize(270+in.left, 450+in.top);

        this.ajusteBotoes();

        tela.add(monitor);
        for(JButton b : botoes){tela.add(b);}

        tela.addKeyListener(this);

        a = 0;
        b = 0;
        c = 0;
        maxChar = 13;

        adicao = false;
        subtracao = false;
        multiplicacao = false;
        divisao = false;

        isA = true;
    }

    private void ajusteBotoes(){
        n0.setActionCommand("0");
        n0.addActionListener(this);
        n1.setActionCommand("1");
        n1.addActionListener(this);
        n2.setActionCommand("2");
        n2.addActionListener(this);
        n3.setActionCommand("3");
        n3.addActionListener(this);
        n4.setActionCommand("4");
        n4.addActionListener(this);
        n5.setActionCommand("5");
        n5.addActionListener(this);
        n6.setActionCommand("6");
        n6.addActionListener(this);
        n7.setActionCommand("7");
        n7.addActionListener(this);
        n8.setActionCommand("8");
        n8.addActionListener(this);
        n9.setActionCommand("9");
        n9.addActionListener(this);
        mais.setActionCommand("operacao+");
        mais.addActionListener(this);
        menos.setActionCommand("operacao-");
        menos.addActionListener(this);
        vezes.setActionCommand("operacaox");
        vezes.addActionListener(this);
        dividido.setActionCommand("operacao/");
        dividido.addActionListener(this);
        igual.setActionCommand("resultado");
        igual.addActionListener(this);
        ac.setActionCommand("limpar");
        ac.addActionListener(this);
        ponto.setActionCommand(".");
        ponto.addActionListener(this);
    }

    //METODOS
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("operacao+")){this.adicao = true; this.operacao(monitor.getText());}
        else if(e.getActionCommand().equals("operacao-") && (monitor.getText() == "" || Double.valueOf(monitor.getText().substring(0,1)) == 0)){monitor.setText("-");}
        else if(e.getActionCommand().equals("operacao-")){this.subtracao = true; this.operacao(monitor.getText());}
        else if(e.getActionCommand().equals("operacaox")){this.multiplicacao = true; this.operacao(monitor.getText());}
        else if(e.getActionCommand().equals("operacao/")){this.divisao = true; this.operacao(monitor.getText());}
        else if(e.getActionCommand().equals("resultado")){this.resultado(monitor.getText());}
        else if(e.getActionCommand().equals("limpar")){this.limpar();}

        else if(e.getActionCommand().equals(".")){monitor.setText(monitor.getText()+".");}

        else if(monitor.getText().length() < maxChar){
            monitor.setText(monitor.getText()+e.getActionCommand());
        }

        tela.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        String key = Character.toString(e.getKeyChar());
        String[] numeros = "0123456789.,".split("");
        String[] operacoes = "+-=/x".split("");
        for(String s : numeros){
            if(key.equals(s)){
                if(key.equals(",")){key = ".";}
                ActionEvent a = new ActionEvent(new Object(), 1, key);
                this.actionPerformed(a);
                break;
            }
            else{
                if(key.equals("+")){
                    ActionEvent a = new ActionEvent(new Object(), 1, "operacao+");
                    this.actionPerformed(a);
                    break;
                }
                else if(key.equals("-")){
                    ActionEvent a = new ActionEvent(new Object(), 1, "operacao-");
                    this.actionPerformed(a);
                    break;
                }
                else if(key.equals("x") || key.equals("X") || key.equals("*")){
                    ActionEvent a = new ActionEvent(new Object(), 1, "operacaox");
                    this.actionPerformed(a);
                    break;
                }
                else if(key.equals("/")){
                    ActionEvent a = new ActionEvent(new Object(), 1, "operacao/");
                    this.actionPerformed(a);
                    break;
                }
                else if(key.equals("=") || e.getKeyCode() == 10){
                    ActionEvent a = new ActionEvent(new Object(), 1, "resultado");
                    this.actionPerformed(a);
                    break;
                }
                else if(e.getKeyCode() == 27 || e.getKeyCode() == 32){
                    ActionEvent a = new ActionEvent(new Object(), 1, "limpar");
                    this.actionPerformed(a);
                    break;
                }
                else if(e.getKeyCode() == 8 && monitor.getText().length() > 0){
                    monitor.setText(monitor.getText().substring(0, monitor.getText().length()-1));
                    break;
                }
            }
        }
        //System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyChar());
    }

    private void operacao(String numero){
        numero = numero.replaceAll(",", ".");
        if(isA){
            if(numero.contains("E")){
                String[] x = numero.split("E");
                System.out.println(x);
                double y = Double.valueOf(x[0]);
                int z = Integer.valueOf(x[1]);
                a = (Double.valueOf(y*Math.pow(10, z)));
            }
            else{a = Double.valueOf(numero);}
            isA = false;
            monitor.setText("");
        }
        else{
            a = c;
        }
    }

    private void resultado(String numero){
        numero = numero.replaceAll(",", ".");
        if(!isA){
            if(numero.contains("E")){
                String[] x = numero.split("E");
                System.out.println(x);
                double y = Double.valueOf(x[0]);
                int z = Integer.valueOf(x[1]);
                b = (Double.valueOf(y*Math.pow(10, z)));
            }
            else{b = Double.valueOf(numero);}
            isA = true;
        }
        else{
            //b = c;
            isA = false;
        }

        if(adicao){c = a+b;}
        else if(subtracao){c = a-b;}
        else if(multiplicacao){c = a*b;}
        else if(divisao){c = a/b;}
        a = 0;
        b = 0;

        if((c > 0 && (c > 9999999999999d || c < 0.00000000001d)) || (c < 0 && (c < -9999999999999d || c > -0.00000000001d))){
            if(c > 0 && (c > 9999999999999d || c < 0.00000000001d)){
                DecimalFormat f = new DecimalFormat("0.#########E0");
                monitor.setText(String.valueOf(f.format(c)));
            }
            else if(c < 0 && (c < -9999999999999d || c > -0.00000000001d)){
                DecimalFormat f = new DecimalFormat("0.#########E0");
                monitor.setText(String.valueOf(f.format(c)));
            }
        }
        else{
            if(c > 0){
                if(c < 0.001){monitor.setText(String.format("%.11f", c));}
                else if(c > 9999999d && c <= 99999999999d){monitor.setText(String.format("%.3f", c));}
                else if(c > 99999999999d){monitor.setText(String.format("%.1f", c));}
                else{monitor.setText(Double.toString(c));}
            }
            else if(c < 0){
                if(c > -0.001){monitor.setText(String.format("%.11f", c));}
                else if(c < -9999999d && c >= -99999999999d){monitor.setText(String.format("%.3f", c));}
                else if(c < -99999999999d){monitor.setText(String.format("%.1f", c));}
                else{monitor.setText(Double.toString(c));}
            }
            else{monitor.setText(Double.toString(c));}
        }

        this.adicao = false;
        this.subtracao = false;
        this.multiplicacao = false;
        this.divisao = false;

        //checadorTamanho();
    }

    private void limpar(){
        a = 0;
        b = 0;
        c = 0;
        isA = true;
        monitor.setText("");
    }

    private void checadorTamanho(){
        if(monitor.getText().length() >= maxChar){monitor.setForeground(Color.red);}
        else{monitor.setForeground(Color.black);}
    }

}
