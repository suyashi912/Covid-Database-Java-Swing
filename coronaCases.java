import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.awt.event.ActionListener.*;
import java.time.LocalDate;
import java.util.HashMap;

public class coronaCases {

    static patient[] DataFrame = new patient[20];


    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            DataFrame[i] = new patient();
        }
        DataFrame[0].input("Flora", 6, "A", LocalDate.of(2020, 04, 01));
        DataFrame[1].input("Denys", 24, "B", LocalDate.of(2020, 04, 01));
        DataFrame[2].input("Jim", 42, "C", LocalDate.of(2020, 05, 18));
        DataFrame[3].input("Hazel", 87, "D", LocalDate.of(2020, 06, 23));
        DataFrame[4].input("Caery", 72, "A", LocalDate.of(2020, 06, 01));
        DataFrame[5].input("David", 7, "B", LocalDate.of(2020, 06, 14));
        DataFrame[6].input("Kevim", 37, "D", LocalDate.of(2020, 06, 05));
        DataFrame[7].input("Tom", 67, "D", LocalDate.of(2020, 06, 20));
        DataFrame[8].input("Bob", 74, "A", LocalDate.of(2020, 07, 04));
        DataFrame[9].input("Rachel", 48, "C", LocalDate.of(2020, 07, 24));
        DataFrame[10].input("Thomas", 21, "C", LocalDate.of(2020, 06, 11));
        DataFrame[11].input("Mary", 17, "D", LocalDate.of(2020, 06, 21));
        DataFrame[12].input("Smith", 89, "A", LocalDate.of(2020, 8, 07));
        DataFrame[13].input("Pearson", 47, "B", LocalDate.of(2020, 06, 04));
        DataFrame[14].input("Anderson", 62, "B", LocalDate.of(2020, 07, 27));
        DataFrame[15].input("Johnson", 10, "D", LocalDate.of(2020, 8, 01));
        DataFrame[16].input("Robertz", 50, "A", LocalDate.of(2020, 8, 9));
        DataFrame[17].input("Julie", 86, "B", LocalDate.of(2020, 05, 02));
        DataFrame[18].input("Edith", 42, "D", LocalDate.of(2020, 06, 07));
        DataFrame[19].input("John", 95, "D", LocalDate.of(2020, 06, 01));

        Swing_java s = new Swing_java();
    }

    static class Swing_java {
        JTextField date, month, year;
        JCheckBox towerA, towerB, towerC, towerD;
        JLabel tower, rDate, dateL, monthL, yearL;
        JFrame f = new JFrame("corona");
        JButton ok;
        JPanel p1, p2, p3;
        Swing_java() {

            tower = new JLabel("TOWERS:  ");
            rDate = new JLabel("Reporting date: ");

            dateL = new JLabel("Date: ");
            monthL = new JLabel("Month: ");
            yearL = new JLabel("Year: ");
            date = new JTextField(2);
            month = new JTextField(2);
            year = new JTextField(4);
            towerA = new JCheckBox("A");
            towerB = new JCheckBox("B");
            towerC = new JCheckBox("C");
            towerD = new JCheckBox("D");
            ok = new JButton("RESULT");

            tower.setSize(30, 30);
            p1 = new JPanel();
            p1.setBounds(40, 30, 610, 150);
            p1.setOpaque(true);
            p1.setBackground(Color.green);
            int xp1 = 90, yp1 = 50, add = 90;
            tower.setBounds(xp1, yp1, 70, 50);
            towerA.setBounds(xp1+add, yp1, 50, 50);
            towerB.setBounds(xp1+add*2, yp1, 50, 50);
            towerC.setBounds(xp1+add*3, yp1, 50, 50);
            towerD.setBounds(xp1+add*4, yp1, 50, 50);
            p1.setLayout(null);
            p1.add(tower); p1.add(towerA); p1.add(towerB); p1.add(towerC); p1.add(towerD);

            p2 = new JPanel();
            p2.setBounds(40, 210, 610, 150);
            p2.setOpaque(true);
            p2.setBackground(Color.pink);
            int xp2 = 0, yp2 = 0 ;
            rDate.setBounds(40, 50, 120, 50);
            dateL.setBounds(200, 50, 50, 50);
            date.setBounds(250, 64, 20, 20 );
            monthL.setBounds(300, 50, 50, 50);
            month.setBounds(350, 64, 20, 20);
            yearL.setBounds(400, 50, 50, 50);
            year.setBounds(450, 64, 40, 20);
            p2.setLayout(null);
            p2.add(rDate); p2.add(dateL);  p2.add(yearL); p2.add(monthL); p2.add(date); p2.add(month); p2.add(year);

            p3 = new JPanel();
            p3.setBounds(125, 400, 400, 150);
            p3.setBackground(Color.cyan);
            ok.setBounds(140, 35, 110, 50);
            p3.add(ok);
            p3.setLayout(null);

            f.add(p1); f.add(p2);   f.add(p3);

            FlowLayout flow = new FlowLayout();
            f.setLayout(flow);
            f.setTitle("COVID-19 Database Search ");
            f.setSize(700, 700);
            f.setLayout(null);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ok.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String d = date.getText();
                    String m = month.getText();
                    String y = year.getText();
                    int a = Integer.parseInt(d);
                    int b = Integer.parseInt(m);
                    int c = Integer.parseInt(y);
                    LocalDate inputDate = LocalDate.of(c, b, a);
                    if(inputDate.compareTo((LocalDate.of(2020, 04, 01)))>=0 && inputDate.compareTo(LocalDate.of(2020, 8, 31))<=0)
                    {
                        JLabel print;

                        JFrame Data = new JFrame("Database");

                        JPanel pane = new JPanel();
                        Data.setSize(900, 700);
                        pane.setBackground(Color.cyan);
                        pane.setBounds(20, 20, 700, 800);

                        HashMap<String, Integer> countA = new HashMap<String, Integer>();
                        HashMap<String, Integer> countR = new HashMap<String, Integer>();
                        countA.put("A", 0); countA.put("B", 0); countA.put("C", 0); countA.put("D", 0);
                        countR.put("A", 0); countR.put("B", 0); countR.put("C", 0); countR.put("D", 0);

                        DefaultTableModel model = new DefaultTableModel();
                        model.addColumn("Name");
                        model.addColumn("Age");
                        model.addColumn("Tower");
                        model.addColumn("Active Date");
                        model.addColumn("Recovery Date");
                        model.addColumn("Status");
                        JTable t = new JTable(model);
                        t.setRowHeight(20);
                        t.setShowGrid(true);
                        t.getColumnModel().getColumn(4).setPreferredWidth(120);
                        t.getColumnModel().getColumn(3).setPreferredWidth(120);
                        t.getColumnModel().getColumn(5).setPreferredWidth(100);
                        t.setBounds(200, 400, 200, 200);
                        model = (DefaultTableModel) t.getModel();

                        for (int i = 0; i < 20; i++) {
                            if (inputDate.compareTo(DataFrame[i].activeDate) >= 0) {
                                if (inputDate.compareTo(DataFrame[i].recoveryDate) < 0) {
                                    countA.replace(DataFrame[i].tower, countA.get(DataFrame[i].tower) + 1);
                                } else {
                                    countR.replace(DataFrame[i].tower, countR.get(DataFrame[i].tower) + 1);
                                }
                            }
                        }

                        print = new JLabel();
                        print.setText("<html>"+" The number of active and recovered cases in the selected towers are: "+"<br><br>");
                        if(towerA.isSelected()==false && towerB.isSelected()==false && towerC.isSelected()==false && towerD.isSelected()==false)
                        {
                            print.setText("<html>"+"NO TOWER HAS BEEN SELECTED :(");
                        }
                        else {
                            if (towerA.isSelected()) {
                                for (int i = 0; i < 20; i++) {
                                    if (inputDate.compareTo(DataFrame[i].activeDate) >= 0 && ("A").equals(DataFrame[i].tower)) {
                                        if (inputDate.compareTo(DataFrame[i].recoveryDate) < 0)
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Active "});
                                        else
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Recovered "});
                                    }
                                }
                                print.setText(print.getText() + "TOWER A : " + "<br>" + " ACTIVE CASES-  " + countA.get("A") + "<br>" + "RECOVERED CASES-  " + countR.get("A") + "<br><br>");
                            }
                            if (towerB.isSelected()) {
                                for (int i = 0; i < 20; i++) {
                                    if (inputDate.compareTo(DataFrame[i].activeDate) >= 0 && ("B").equals(DataFrame[i].tower)) {
                                        if (inputDate.compareTo(DataFrame[i].recoveryDate) < 0)
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Active "});
                                        else
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Recovered "});
                                    }
                                }
                                print.setText(print.getText() + "TOWER B : " + "<br>" + " ACTIVE CASES-  " + countA.get("B") + "<br>" + "RECOVERED CASES-  " + countR.get("B") + "<br><br>");
                            }
                            if (towerC.isSelected()) {
                                for (int i = 0; i < 20; i++) {
                                    if (inputDate.compareTo(DataFrame[i].activeDate) >= 0 && ("C").equals(DataFrame[i].tower)) {
                                        if (inputDate.compareTo(DataFrame[i].recoveryDate) < 0)
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Active "});
                                        else
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Recovered "});
                                    }
                                }
                                print.setText(print.getText() + "TOWER C : " + "<br>" + " ACTIVE CASES-  " + countA.get("C") + "<br>" + "RECOVERED CASES-  " + countR.get("C") + "<br><br>");

                            }
                            if (towerD.isSelected()) {
                                for (int i = 0; i < 20; i++) {
                                    if (inputDate.compareTo(DataFrame[i].activeDate) >= 0 && ("D").equals(DataFrame[i].tower)) {
                                        if (inputDate.compareTo(DataFrame[i].recoveryDate) < 0)
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Active "});
                                        else
                                            model.addRow(new Object[]{DataFrame[i].name, DataFrame[i].age, DataFrame[i].tower, DataFrame[i].activeDate, DataFrame[i].recoveryDate, "Recovered "});
                                    }
                                }
                                print.setText(print.getText() + "TOWER D : " + "<br>" + " ACTIVE CASES-  " + countA.get("D") + "<br>" + "RECOVERED CASES-  " + countR.get("D") + "<br>");

                            }

                        }
                        print.setText(print.getText() + "</html>");
                        FlowLayout flow = new FlowLayout(FlowLayout.LEADING);
                        pane.setLayout(flow);
                        pane.add(print);
                        if(towerA.isSelected()==false && towerB.isSelected()==false && towerC.isSelected()==false && towerD.isSelected()==false)
                        {
                        }
                        else
                        {
                            pane.add(new JScrollPane(t));
                        }

                        Data.add(pane);

                        Data.setLayout(flow);
                        Data.setVisible(true);
                        //Data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                    else
                    {
                        JLabel not = new JLabel();
                        not.setText("<html>"+ "Invalid date : "+"<br>"+"ENTER A DATE BETWEEN 1st April 2020 and 31st August 2020" +"</html>");
                        not.setBounds(40, 60, 400, 100);
                        p3.add(not);

                    }
                }
            });
        }
    }
}
class patient {
    String name;
    int age;
    String tower;
    int year, month, date;
    LocalDate activeDate ;
    LocalDate recoveryDate;
    patient()
    {

    }
    public void input(String n, int a, String t, LocalDate ad)
    {
        this.name = n;
        this.age = a;
        this.tower = t;
        this.activeDate = ad;
        this.recoveryDate  = ad.plusDays(22);
    }

}



