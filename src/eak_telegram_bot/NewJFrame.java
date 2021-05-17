package eak_telegram_bot;

import eak_telegram_bot.TelegramBot;
import java.awt.event.ItemEvent;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class NewJFrame extends javax.swing.JFrame {

    private TelegramBotsApi botsApi;
    private BotSession myBot;

    public NewJFrame() {
        initComponents();
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            myBot = botsApi.registerBot(new TelegramBot());
            LabelStatus.setText("Бот включен");
        } catch (TelegramApiException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        LabelStatus = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EAK Telegram Bot");
        setMaximumSize(new java.awt.Dimension(100, 150));
        setResizable(false);

        LabelStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelStatus.setText("Статус");

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton1.setSelected(true);
        jToggleButton1.setText("Переключить");
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jToggleButton1ItemStateChanged(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(LabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelStatus)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jToggleButton1ItemStateChanged(java.awt.event.ItemEvent evt) {                                                
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            myBot.start();
            LabelStatus.setText("Бот включен");
        } else {
            myBot.stop();
            LabelStatus.setText("Бот выключен");
        }
    }                                               

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new NewJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel LabelStatus;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration                   
}
