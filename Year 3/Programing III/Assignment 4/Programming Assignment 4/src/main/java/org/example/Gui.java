package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * Student name: Paulius Zabinskas
 * Student Number: 20120267
 */

public class Gui implements ActionListener {

    private JFrame frame;
    private JPanel cards; // a panel that uses CardLayout
    private JPanel albumViewPanel; // Panel for album covers
    private JPanel trackListViewPanel; // Panel for track listing
    private CardLayout cardLayout;
    private List<Album> albums;

    public Gui(List<Album> albums) {
        this.albums = albums;

        // Create and set up the window
        frame = new JFrame("Music Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // create the panel that contains the "cards"
        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) (cards.getLayout());

        // Create the "Album View" card
        albumViewPanel = new JPanel();
        // fill the albumViewPanel with album cover as buttons

        for (int i = 0; i < albums.size(); i++) {
            Album album = albums.get(i);
            JButton button = new JButton();
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);
            try {
                // code given as example to adjust image scale
                BufferedImage coverImage = ImageIO.read(new File(album.getCoverImageFilename()));
                Image scaledImage = coverImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon coverIcon = new ImageIcon(scaledImage);
                button.setIcon(coverIcon);
                button.setBorder(BorderFactory.createEmptyBorder());
                button.setContentAreaFilled(false);
            } catch (IOException e) {
                // debuting
                e.printStackTrace();
                button.setText("Cover not found");
            }
            albumViewPanel.add(button);
        }

        // Create the "Track Listing View" card
        trackListViewPanel = new JPanel(new BorderLayout());
        // Back button to return to album view
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(cards, "AlbumView"));
        trackListViewPanel.add(backButton, BorderLayout.SOUTH);
        // Add a placeholder for the JTable, we'll populate it later
        trackListViewPanel.add(new JScrollPane(new JTable()), BorderLayout.CENTER);

        // Add the cards to the main panel
        cards.add(albumViewPanel, "AlbumView");
        cards.add(trackListViewPanel, "TrackListView");

        // Add the cards panel to the frame
        frame.add(cards);

        // Display the window
        frame.setVisible(true);
    }

    // Handle button click events
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        int albumIndex = Integer.parseInt(cmd);
        Album selectedAlbum = albums.get(albumIndex);
        // Update and show the track listing for the selected album
        showTrackListing(selectedAlbum);
        cardLayout.show(cards, "TrackListView");
    }

    // Method to update and show track listing
    private void showTrackListing(Album album) {
        // Create a table model and populate it with tracks
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Track");
        model.addColumn("Duration");
        for (Track track : album.getTrackListing()) {
            model.addRow(new Object[]{track.getTitle(), track.getDuration()});
        }
        JTable table = new JTable(model);
        // Update the trackListViewPanel
        trackListViewPanel.remove(1); // Remove the old table
        trackListViewPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        trackListViewPanel.revalidate(); // Refresh the panel
    }

    // Main method to launch the GUI
    public static void main(String[] args) {
        AlbumReader albumReader = new AlbumReader();
        try {
            List<Album> albums = albumReader.ReadAlbums();
            SwingUtilities.invokeLater(() -> new Gui(albums));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading album data.");
        }
    }
}
