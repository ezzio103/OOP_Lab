package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
//import javafx.scene.text.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore (Media media) { this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
//        new Font(title.getFont().getName(), Font.PLAIN, 15);
//        new java.awt.Font(title.getFont().getName(), Font.PLAIN, 15);
        title.setFont( new Font("Arial", Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel cost = new JLabel(""+media.getCost()+" $"); cost.setAlignmentX(CENTER_ALIGNMENT);
        JPanel container = new JPanel(); container.setLayout(new FlowLayout(FlowLayout.CENTER));
        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Playable playableMedia = (Playable) media;
                    // Lấy danh sách track từ đối tượng Playable


                    // Hiển thị danh sách track trong một JDialog

                    // Tạo và hiển thị JDialog
                    JDialog trackDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(MediaStore.this), "Track List", true);
                    trackDialog.setLayout(new BorderLayout());
                    String play1= media.getTitle()+" dang phat ";
                    JTextArea trackTextArea = new JTextArea(play1);
                    trackTextArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(trackTextArea);
                    trackDialog.add(scrollPane, BorderLayout.CENTER);

                    JButton closeDialogButton = new JButton("Close");
                    closeDialogButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            trackDialog.dispose();
                        }
                    });
                    trackDialog.add(closeDialogButton, BorderLayout.SOUTH);

                    trackDialog.setSize(300, 200);
                    trackDialog.setLocationRelativeTo((JFrame) SwingUtilities.getWindowAncestor(MediaStore.this));
                    trackDialog.setVisible(true);
                }
            });
            /////////
            container.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue()); this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }


}