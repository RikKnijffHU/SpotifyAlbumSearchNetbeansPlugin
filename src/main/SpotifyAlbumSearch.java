/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import com.wrapper.spotify.Api;
import javax.swing.ImageIcon;
import com.wrapper.spotify.methods.*;
import com.wrapper.spotify.models.Page;
import com.wrapper.spotify.models.*;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.JList;
import main.Bundle;



/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//main//spotify//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "Spotify_Album_Search",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "output", openAtStartup = true)
@ActionID(category = "Window", id = "main.spotifyTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_klsdAction",
        preferredID = "klsdTopComponent"
)
@Messages({
    "CTL_klsdAction=Spotify",
    "CTL_klsdTopComponent=Spotify Album Search",
    "HINT_klsdTopComponent=Spotify Album Search"
})
public final class SpotifyAlbumSearch extends TopComponent {
DefaultListModel listModel;
private ImageIcon imageIcon;
    public SpotifyAlbumSearch() {
        initComponents();
        setName(Bundle.CTL_klsdTopComponent());
        setToolTipText(Bundle.HINT_klsdTopComponent());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchBar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SearchResults = new javax.swing.JList<>();
        Text = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        SearchBar.setText(org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.SearchBar.text")); // NOI18N
        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SearchResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        SearchResults.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                SearchResultsComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(SearchResults);

        org.openide.awt.Mnemonics.setLocalizedText(Text, org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.Text.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton2, org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("https://i.scdn.co/image/27d53ef123721fc297a9289bb2ffacffd4155933.jpg"));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.jLabel3.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(SpotifyAlbumSearch.class, "SpotifyAlbumSearch.jLabel3.AccessibleContext.accessibleName")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 108, Short.MAX_VALUE)
                        .addComponent(Text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      DefaultListModel listModel = new DefaultListModel();



                
         Api api = Api.DEFAULT_API; 
         
   final ArtistSearchRequest request = api.searchArtists(SearchBar.getText()).market("SE").limit(10).build();

try {
   final Page<Artist> artistSearchResult = request.get();
   final List<Artist> artists = artistSearchResult.getItems();
   
   Text.setText("I've found " + artistSearchResult.getTotal() + " artists!\n");

   for (Artist artist : artists) {
       listModel.addElement(artist.getName()+":"+artist.getId());
   }
SearchResults.setModel(listModel);
} catch (Exception e) {
  Text.setText("Something went wrong!" + e.getMessage());
}
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBarActionPerformed

    private void SearchResultsComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_SearchResultsComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchResultsComponentAdded

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         Api api = Api.DEFAULT_API; 
         String[] Artistid = SearchResults.getSelectedValue().split("\\:");
         final AlbumsForArtistRequest request = api.getAlbumsForArtist(Artistid[1]).offset(0).limit(3).build();
try {
   final Page<SimpleAlbum> albumSearchResult = request.get();

    SimpleAlbum album = albumSearchResult.getItems().get(0);
    URL url = new URL(album.getImages().get(0).getUrl());
    BufferedImage img = ImageIO.read(url);
    imageIcon = new ImageIcon(img);  
ImageIcon newimg = new ImageIcon(imageIcon.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH)); // scale it the smooth way  

    jLabel1.setIcon(newimg);
    jLabel1.setText(album.getName());
    
    SimpleAlbum album1 = albumSearchResult.getItems().get(1);
    URL url1 = new URL(album1.getImages().get(0).getUrl());
    BufferedImage img1 = ImageIO.read(url1);
       imageIcon = new ImageIcon(img1);  
ImageIcon newimg1 = new ImageIcon(imageIcon.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH)); // scale it the smooth way  

    jLabel2.setIcon(newimg1);
    jLabel2.setText(album1.getName());
     
    SimpleAlbum album2 = albumSearchResult.getItems().get(2);
    URL url2 = new URL(album2.getImages().get(0).getUrl());
    BufferedImage img2 = ImageIO.read(url2);
       imageIcon = new ImageIcon(img2);  
ImageIcon newimg2 = new ImageIcon(imageIcon.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH)); // scale it the smooth way  

    jLabel3.setIcon(newimg2);
     jLabel3.setText(album2.getName());
    

} catch (Exception e) {
   System.out.println("Something went wrong!" + e.getMessage());
}
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SearchBar;
    private javax.swing.JList<String> SearchResults;
    private javax.swing.JLabel Text;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
    
}
