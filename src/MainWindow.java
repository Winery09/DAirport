import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindow extends JFrame {
    private JTabbedPane tabbedPane;
    private JTable tableAirplanes, tablePassengers, tableFlights, tableTickets;

    public MainWindow() {
        super("Система управления аэропортом");

        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Database.testConnection();

        tabbedPane = new JTabbedPane();

        tableAirplanes = new JTable();
        tablePassengers = new JTable();
        tableFlights = new JTable();
        tableTickets = new JTable();

        tabbedPane.addTab("Самолеты", createTablePanel(tableAirplanes, "Воздушные суда"));
        tabbedPane.addTab("Пассажиры", createTablePanel(tablePassengers, "Пассажиры"));
        tabbedPane.addTab("Рейсы", createTablePanel(tableFlights, "Расписание рейсов"));
        tabbedPane.addTab("Билеты", createTablePanel(tableTickets, "Продажа и бронирование билетов"));

        JPanel buttonPanel = new JPanel();
        JButton refreshButton = new JButton("Обновить данные");
        JButton exitButton = new JButton("Выход");

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAllData();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(refreshButton);
        buttonPanel.add(exitButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        loadAllData();
    }

    private JPanel createTablePanel(JTable table, String title) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    private void loadAllData() {
        loadAirplanes();
        loadPassengers();
        loadFlights();
        loadTickets();
    }

    private void loadAirplanes() {
        AirplaneDAO dao = new AirplaneDAO();
        List<Airplane> list = dao.getAllAirplanes();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Модель самолета");
        model.addColumn("Вместимость");
        model.addColumn("Статус");

        for (Airplane a : list) {
            model.addRow(new Object[]{
                a.getIdAirplane(),
                a.getModel(),
                a.getCapacity(),
                a.getStatus()
            });
        }
        tableAirplanes.setModel(model);
    }

    private void loadPassengers() {
        PassengerDAO dao = new PassengerDAO();
        List<Passenger> list = dao.getAllPassengers();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Фамилия");
        model.addColumn("Имя");
        model.addColumn("Отчество");
        model.addColumn("Паспорт");
        model.addColumn("Телефон");

        for (Passenger p : list) {
            model.addRow(new Object[]{
                p.getIdPassenger(),
                p.getFam(),
                p.getName(),
                p.getOtchestvo(),
                p.getPassport(),
                p.getTelefon()
            });
        }
        tablePassengers.setModel(model);
    }

    private void loadFlights() {
        FlightDAO dao = new FlightDAO();
        List<Flight> list = dao.getAllFlights();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Номер рейса");
        model.addColumn("Самолет");
        model.addColumn("Город вылета");
        model.addColumn("Город прибытия");
        model.addColumn("Время вылета");
        model.addColumn("Время прилета");

        for (Flight f : list) {
            model.addRow(new Object[]{
                f.getIdFlight(),
                f.getFlightNumber(),
                f.getAirplaneModel(),
                f.getDepartureCity(),
                f.getArrivalCity(),
                f.getDepartureTime(),
                f.getArrivalTime()
            });
        }
        tableFlights.setModel(model);
    }

    private void loadTickets() {
        TicketDAO dao = new TicketDAO();
        List<Ticket> list = dao.getAllTickets();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Пассажир");
        model.addColumn("Рейс");
        model.addColumn("Место");
        model.addColumn("Стоимость");
        model.addColumn("Дата бронирования");

        for (Ticket t : list) {
            model.addRow(new Object[]{
                t.getIdTicket(),
                t.getPassengerFam(),
                t.getFlightNumber(),
                t.getSeatNumber(),
                t.getPrice(),
                t.getBookingDate()
            });
        }
        tableTickets.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow();
            window.setVisible(true);
        });
    }
}