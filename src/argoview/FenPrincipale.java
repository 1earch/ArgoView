/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package argoview;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Florent Fayollas
 */
public class FenPrincipale extends javax.swing.JFrame {

    /**
     * Creates new form FenPrincipale
     */
    public FenPrincipale() {
        initComponents();
        
        this.nomAnimal = "Aucun animal";
        this.positions = new ArrayList();
        this.positions.add(new DonneeArgos("0000000", "NULL", "0000/00/00", "00:00", "0", "0"));
        nbrPointsAff = sliderNbrPoints.getValue()+1;
        nbrPointsAffiche = Double.toString(nbrPointsAff);
        jLabel5.setText(nbrPointsAffiche);
        lireDonnees();
        afficherDonnees();
        initialFolder();
    }

    /**
     * Fonction permettant de charger toutes les positions
     */
    private void lireDonnees() {
        gaia.lireDonnees();
        irchad.lireDonnees();
        teria3.lireDonnees();
        aquila.lireDonnees();
        leloki.lireDonnees();
        toms.lireDonnees();
        victor.lireDonnees();
        arcaique.lireDonnees();
        bandido.lireDonnees();
        flocon.lireDonnees();
        liriane.lireDonnees();
        malys.lireDonnees();
        neige.lireDonnees();
        una.lireDonnees();
        vanille.lireDonnees();
        ecume.lireDonnees();
        aura.lireDonnees();
        aurore.lireDonnees();
        nora.lireDonnees();
        vella.lireDonnees();
    }
    
    /**
     * Fonction permettant de recharger l'affichage du tableau positions
     */
    private void afficherDonnees() {
        String[] enTetes = new String [] {
                "Nom de l'animal", "Balise n°", "Précision", "Date", "Heure", "Latitude", "Longitude"
        };
        Object[][] contenu = new Object[positions.size()][enTetes.length];
        
        for (int i = 0; i < positions.size(); i++) {
            contenu[i][0] = nomAnimal;
            contenu[i][1] = positions.get(i).getNumBalise();
            contenu[i][2] = positions.get(i).getPrecision();
            String date = (positions.get(i).getDate().get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "")
                    + positions.get(i).getDate().get(Calendar.DAY_OF_MONTH) + " ";
            switch ( positions.get(i).getDate().get(Calendar.MONTH) ) {
                case Calendar.JANUARY:
                    date += "janvier";
                    break;
                case Calendar.FEBRUARY:
                    date += "février";
                    break;
                case Calendar.MARCH:
                    date += "mars";
                    break;
                case Calendar.APRIL:
                    date += "avril";
                    break;
                case Calendar.MAY:
                    date += "mai";
                    break;
                case Calendar.JUNE:
                    date += "juin";
                    break;
                case Calendar.JULY:
                    date += "juillet";
                    break;
                case Calendar.AUGUST:
                    date += "aoüt";
                    break;
                case Calendar.SEPTEMBER:
                    date += "septembre";
                    break;
                case Calendar.OCTOBER:
                    date += "octobre";
                    break;
                case Calendar.NOVEMBER:
                    date += "novembre";
                    break;
                case Calendar.DECEMBER:
                    date += "décembre";
                    break;
                default:
                    date += "mois";
                    break;
            }
            date += " ";
            date += positions.get(i).getDate().get(Calendar.YEAR);
            contenu[i][3] = date;
            contenu[i][4] = (positions.get(i).getDate().get(Calendar.HOUR_OF_DAY) < 10 ? "0" : "")
                    + positions.get(i).getDate().get(Calendar.HOUR_OF_DAY)
                    + ":"
                    + (positions.get(i).getDate().get(Calendar.MINUTE) < 10 ? "0" : "")
                    + positions.get(i).getDate().get(Calendar.MINUTE);
            contenu[i][5] = positions.get(i).getLatitude();
            contenu[i][6] = positions.get(i).getLongitude();
        }
        
        DefaultTableModel modele = new DefaultTableModel(contenu, enTetes) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        ptsTable.setModel(modele);
    }
    
    
    /**
     * Fonction qui permet de créer le dossier contenant les images
     */
    private void initialFolder() {
        File file = new File("img");
        boolean success = file.delete();
        String dirName = "img";
        File dir = new File(dirName);
        boolean isCreated = dir.mkdirs();
    }
    /**
     * Fonction qui permet de calculer la moyenne des latitudes
     */
    private double calcMLat () {
       double add = 0;double result = 0;
       for (int i = 0; i<nbrPoints; i++) {
           add = add+positions.get(i).getLatitude();
       }
       result = add/nbrPoints;
       return (result);
    }
    /**
     * Fonction qui permet de calculer la moyenne des longitudes
     */
    private double calcMLon () {
       double add = 0;double result = 0;
       for (int i = 0; i<nbrPoints; i++) {
           add = add+positions.get(i).getLongitude();
       }
       result = add/nbrPoints;
       return (result);
    }
    /**
     * Fonction qui permet de définir le type de carte à afficher
     */
    private String map () {
        if (mapType == 0){
            map ="roadmap";
        }
        else if (mapType == 1){
            map = "terrain";
        }
        else if (mapType == 2){
            map = "satellite";
        }
        else if (mapType == 3){
            map = "hybrid";
        }
        return (map);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containChoixAnimal = new javax.swing.JPanel();
        boutonGaia = new javax.swing.JButton();
        boutonIrchad = new javax.swing.JButton();
        boutonTeria3 = new javax.swing.JButton();
        boutonAquila = new javax.swing.JButton();
        boutonLeloki = new javax.swing.JButton();
        boutonToms = new javax.swing.JButton();
        boutonVictor = new javax.swing.JButton();
        boutonBandido = new javax.swing.JButton();
        boutonArcaique = new javax.swing.JButton();
        boutonFlocon = new javax.swing.JButton();
        boutonMalys = new javax.swing.JButton();
        boutonEcume = new javax.swing.JButton();
        boutonVanille = new javax.swing.JButton();
        boutonLiriane = new javax.swing.JButton();
        boutonUna = new javax.swing.JButton();
        boutonNeige = new javax.swing.JButton();
        boutonNora = new javax.swing.JButton();
        boutonAura = new javax.swing.JButton();
        boutonAurore = new javax.swing.JButton();
        boutonVella = new javax.swing.JButton();
        containAnimal = new javax.swing.JPanel();
        ptsScroll = new javax.swing.JScrollPane();
        ptsTable = new javax.swing.JTable();
        containActs = new javax.swing.JPanel();
        majDonnees = new javax.swing.JButton();
        affDonnees = new javax.swing.JButton();
        containActsDonnees = new javax.swing.JPanel();
        affTrace = new javax.swing.JCheckBox();
        affPts = new javax.swing.JCheckBox();
        affDates = new javax.swing.JCheckBox();
        sliderZoom = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        sliderNbrPoints = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArgoView");
        setResizable(false);

        containChoixAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder("Choix de l'animal"));
        containChoixAnimal.setPreferredSize(new java.awt.Dimension(200, 0));

        boutonGaia.setBackground(java.awt.Color.white);
        boutonGaia.setText("Baleine à bosse Gaïa");
        boutonGaia.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonGaia.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonGaia.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonGaia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonGaiaActionPerformed(evt);
            }
        });

        boutonIrchad.setBackground(java.awt.Color.white);
        boutonIrchad.setText("Baleine à bosse Irchad");
        boutonIrchad.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonIrchad.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonIrchad.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonIrchad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonIrchadActionPerformed(evt);
            }
        });

        boutonTeria3.setBackground(java.awt.Color.white);
        boutonTeria3.setText("Baleine à bosse Teria3");
        boutonTeria3.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonTeria3.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonTeria3.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonTeria3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonTeria3ActionPerformed(evt);
            }
        });

        boutonAquila.setBackground(java.awt.Color.white);
        boutonAquila.setText("Manchot royal Aquila");
        boutonAquila.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonAquila.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonAquila.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonAquila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAquilaActionPerformed(evt);
            }
        });

        boutonLeloki.setBackground(java.awt.Color.white);
        boutonLeloki.setText("Manchot royal Leloki");
        boutonLeloki.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonLeloki.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonLeloki.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonLeloki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonLelokiActionPerformed(evt);
            }
        });

        boutonToms.setBackground(java.awt.Color.white);
        boutonToms.setText("Manchot royal Toms");
        boutonToms.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonToms.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonToms.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonToms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonTomsActionPerformed(evt);
            }
        });

        boutonVictor.setBackground(java.awt.Color.white);
        boutonVictor.setText("Manchot royal Victor");
        boutonVictor.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonVictor.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonVictor.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonVictor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonVictorActionPerformed(evt);
            }
        });

        boutonBandido.setBackground(java.awt.Color.white);
        boutonBandido.setText("Ours polaire Bandido");
        boutonBandido.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonBandido.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonBandido.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonBandido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonBandidoActionPerformed(evt);
            }
        });

        boutonArcaique.setBackground(java.awt.Color.white);
        boutonArcaique.setText("Ours polaire Arcaique");
        boutonArcaique.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonArcaique.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonArcaique.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonArcaique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonArcaiqueActionPerformed(evt);
            }
        });

        boutonFlocon.setBackground(java.awt.Color.white);
        boutonFlocon.setText("Ours polaire Flocon");
        boutonFlocon.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonFlocon.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonFlocon.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonFlocon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonFloconActionPerformed(evt);
            }
        });

        boutonMalys.setBackground(java.awt.Color.white);
        boutonMalys.setText("Ours polaire Malys");
        boutonMalys.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonMalys.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonMalys.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonMalys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonMalysActionPerformed(evt);
            }
        });

        boutonEcume.setBackground(java.awt.Color.white);
        boutonEcume.setText("Tortue Ecume");
        boutonEcume.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonEcume.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonEcume.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonEcume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonEcumeActionPerformed(evt);
            }
        });

        boutonVanille.setBackground(java.awt.Color.white);
        boutonVanille.setText("Ours polaire Vanille");
        boutonVanille.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonVanille.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonVanille.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonVanille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonVanilleActionPerformed(evt);
            }
        });

        boutonLiriane.setBackground(java.awt.Color.white);
        boutonLiriane.setText("Ours polaire Liriane");
        boutonLiriane.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonLiriane.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonLiriane.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonLiriane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonLirianeActionPerformed(evt);
            }
        });

        boutonUna.setBackground(java.awt.Color.white);
        boutonUna.setText("Ours polaire Una");
        boutonUna.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonUna.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonUna.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonUna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonUnaActionPerformed(evt);
            }
        });

        boutonNeige.setBackground(java.awt.Color.white);
        boutonNeige.setText("Ours polaire Neige");
        boutonNeige.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonNeige.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonNeige.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonNeige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonNeigeActionPerformed(evt);
            }
        });

        boutonNora.setBackground(java.awt.Color.white);
        boutonNora.setText("Eléphant de mer Nora");
        boutonNora.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonNora.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonNora.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonNora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonNoraActionPerformed(evt);
            }
        });

        boutonAura.setBackground(java.awt.Color.white);
        boutonAura.setText("Eléphant de mer Aura");
        boutonAura.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonAura.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonAura.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonAura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAuraActionPerformed(evt);
            }
        });

        boutonAurore.setBackground(java.awt.Color.white);
        boutonAurore.setText("Eléphant de mer Aurore");
        boutonAurore.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonAurore.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonAurore.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonAurore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonAuroreActionPerformed(evt);
            }
        });

        boutonVella.setBackground(java.awt.Color.white);
        boutonVella.setText("Eléphant de mer Vella");
        boutonVella.setMaximumSize(new java.awt.Dimension(200, 23));
        boutonVella.setMinimumSize(new java.awt.Dimension(200, 23));
        boutonVella.setPreferredSize(new java.awt.Dimension(200, 23));
        boutonVella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonVellaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containChoixAnimalLayout = new javax.swing.GroupLayout(containChoixAnimal);
        containChoixAnimal.setLayout(containChoixAnimalLayout);
        containChoixAnimalLayout.setHorizontalGroup(
            containChoixAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containChoixAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containChoixAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonGaia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonTeria3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonAquila, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonLeloki, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonToms, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonVictor, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonArcaique, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonBandido, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonIrchad, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonFlocon, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(containChoixAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonLiriane, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonNeige, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonUna, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonVanille, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonEcume, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonAura, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonAurore, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonNora, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonMalys, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonVella, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containChoixAnimalLayout.setVerticalGroup(
            containChoixAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containChoixAnimalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containChoixAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containChoixAnimalLayout.createSequentialGroup()
                        .addComponent(boutonLiriane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonMalys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonNeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonUna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonVanille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonEcume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonAura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonAurore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonNora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containChoixAnimalLayout.createSequentialGroup()
                        .addComponent(boutonGaia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonIrchad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonTeria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonAquila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonLeloki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonToms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonVictor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonArcaique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonBandido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(containChoixAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boutonFlocon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonVella, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        containAnimal.setBorder(javax.swing.BorderFactory.createTitledBorder("Données de positionnement relatives à l'animal"));
        containAnimal.setPreferredSize(new java.awt.Dimension(200, 0));

        ptsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom de l'animal", "Balise n°", "Précision", "Date", "Heure", "Latitude", "Longitude"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ptsTable.setFocusable(false);
        ptsScroll.setViewportView(ptsTable);

        javax.swing.GroupLayout containAnimalLayout = new javax.swing.GroupLayout(containAnimal);
        containAnimal.setLayout(containAnimalLayout);
        containAnimalLayout.setHorizontalGroup(
            containAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ptsScroll)
        );
        containAnimalLayout.setVerticalGroup(
            containAnimalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ptsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );

        containActs.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions sur les données"));
        containActs.setPreferredSize(new java.awt.Dimension(200, 0));

        majDonnees.setBackground(java.awt.Color.white);
        majDonnees.setText("Mettre à jour");
        majDonnees.setMaximumSize(new java.awt.Dimension(200, 23));
        majDonnees.setMinimumSize(new java.awt.Dimension(200, 23));
        majDonnees.setPreferredSize(new java.awt.Dimension(200, 23));
        majDonnees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majDonneesActionPerformed(evt);
            }
        });

        affDonnees.setBackground(java.awt.Color.white);
        affDonnees.setText("Afficher");
        affDonnees.setMaximumSize(new java.awt.Dimension(200, 23));
        affDonnees.setMinimumSize(new java.awt.Dimension(200, 23));
        affDonnees.setPreferredSize(new java.awt.Dimension(200, 23));
        affDonnees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affDonneesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containActsLayout = new javax.swing.GroupLayout(containActs);
        containActs.setLayout(containActsLayout);
        containActsLayout.setHorizontalGroup(
            containActsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containActsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(majDonnees, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(affDonnees, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        containActsLayout.setVerticalGroup(
            containActsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containActsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containActsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majDonnees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(affDonnees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        containActsDonnees.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions sur les données"));
        containActsDonnees.setPreferredSize(new java.awt.Dimension(200, 0));

        affTrace.setText("Afficher le tracé");
        affTrace.setBorderPaintedFlat(true);
        affTrace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affTraceActionPerformed(evt);
            }
        });

        affPts.setText("Afficher les points");
        affPts.setBorderPaintedFlat(true);
        affPts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                affPtsActionPerformed(evt);
            }
        });

        affDates.setText("Afficher les dates");
        affDates.setBorderPaintedFlat(true);

        sliderZoom.setMaximum(11);
        sliderZoom.setMinimum(1);
        sliderZoom.setValue(6);

        jLabel1.setText("option Zoom");

        jLabel2.setText("0");

        jLabel3.setText("11");

        list.setBackground(new java.awt.Color(240, 240, 240));
        list.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "carte", "terrain", "satellite", "satellite et routes" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(list);

        sliderNbrPoints.setMaximum(3);
        sliderNbrPoints.setValue(0);
        sliderNbrPoints.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderNbrPointsStateChanged(evt);
            }
        });

        jLabel4.setText("afficher tous les");

        jLabel6.setText("points");

        javax.swing.GroupLayout containActsDonneesLayout = new javax.swing.GroupLayout(containActsDonnees);
        containActsDonnees.setLayout(containActsDonneesLayout);
        containActsDonneesLayout.setHorizontalGroup(
            containActsDonneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator1)
            .addGroup(containActsDonneesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containActsDonneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containActsDonneesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(containActsDonneesLayout.createSequentialGroup()
                        .addGroup(containActsDonneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(affPts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(affDates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(affTrace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sliderNbrPoints, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addGroup(containActsDonneesLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addComponent(sliderZoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        containActsDonneesLayout.setVerticalGroup(
            containActsDonneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containActsDonneesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(affPts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(affDates)
                .addGap(3, 3, 3)
                .addComponent(affTrace)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containActsDonneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sliderZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containActsDonneesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderNbrPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(containActs, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(containChoixAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(containActsDonnees, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(containChoixAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(containActs, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(containActsDonnees, javax.swing.GroupLayout.PREFERRED_SIZE, 408, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(containAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        containActsDonnees.getAccessibleContext().setAccessibleName("Affichage des données sur les données");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonGaiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonGaiaActionPerformed
        positions = gaia.getPositions();
        nomAnimal = "gaia";
        this.latitude = gaia.getPositions().get(0).getLatitude();
        this.longitude = gaia.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonGaiaActionPerformed

    private void boutonIrchadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonIrchadActionPerformed
        positions = irchad.getPositions();
        nomAnimal = "irchad";
        this.latitude = irchad.getPositions().get(0).getLatitude();
        this.longitude = irchad.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonIrchadActionPerformed

    private void boutonTeria3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonTeria3ActionPerformed
        positions = teria3.getPositions();
        nomAnimal = "teria3";
        this.latitude = teria3.getPositions().get(0).getLatitude();
        this.longitude = teria3.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonTeria3ActionPerformed

    private void boutonAquilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAquilaActionPerformed
        positions = aquila.getPositions();
        nomAnimal = "aquila";
        this.latitude = aquila.getPositions().get(0).getLatitude();
        this.longitude = aquila.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonAquilaActionPerformed

    private void boutonLelokiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonLelokiActionPerformed
        positions = leloki.getPositions();
        nomAnimal = "leloki";
        this.latitude = leloki.getPositions().get(0).getLatitude();
        this.longitude = leloki.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonLelokiActionPerformed

    private void boutonTomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonTomsActionPerformed
        positions = toms.getPositions();
        nomAnimal = "toms";
        this.latitude = toms.getPositions().get(0).getLatitude();
        this.longitude = toms.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonTomsActionPerformed

    private void boutonVictorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonVictorActionPerformed
        positions = victor.getPositions();
        nomAnimal = "victor";
        this.latitude = victor.getPositions().get(0).getLatitude();
        this.longitude = victor.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonVictorActionPerformed

    private void boutonBandidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonBandidoActionPerformed
        positions = bandido.getPositions();
        nomAnimal = "bandido";
        this.latitude = bandido.getPositions().get(0).getLatitude();
        this.longitude = bandido.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonBandidoActionPerformed

    private void boutonArcaiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonArcaiqueActionPerformed
        positions = arcaique.getPositions();
        nomAnimal = "arcaique";
        this.latitude = arcaique.getPositions().get(0).getLatitude();
        this.longitude = arcaique.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonArcaiqueActionPerformed

    private void majDonneesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majDonneesActionPerformed
        majDonnees.setEnabled(false);

        // Téléchargement des fichiers
        gaia.telechargerFichier();
        irchad.telechargerFichier();
        teria3.telechargerFichier();
        aquila.telechargerFichier();
        leloki.telechargerFichier();
        toms.telechargerFichier();
        victor.telechargerFichier();
        arcaique.telechargerFichier();
        bandido.telechargerFichier();
        flocon.telechargerFichier();
        liriane.telechargerFichier();
        malys.telechargerFichier();
        neige.telechargerFichier();
        una.telechargerFichier();
        vanille.telechargerFichier();
        ecume.telechargerFichier();
        aura.telechargerFichier();
        aurore.telechargerFichier();
        nora.telechargerFichier();
        vella.telechargerFichier();
        
        JOptionPane.showMessageDialog(this,
                "Mise à jour des fichiers de positionnement terminé !",
                "Mise à jour", JOptionPane.INFORMATION_MESSAGE);
        
        majDonnees.setBackground(couleurValide);
        majDonnees.setText("Données à jour !");
        majDonnees.setEnabled(true);
        
        // Relecture des données
        lireDonnees();
    }//GEN-LAST:event_majDonneesActionPerformed
    
    private void affDonneesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affDonneesActionPerformed
        //nombre d'image à enregister
        j++; 
        //définition des variables
        String url = new String();
        double latitude,longitude;
        // On limite le nombre de positions pour réduir le lien URL
        if (positions.size() > 30){ nbrPoints = 30;}
        else if (positions.size() <= 30){ nbrPoints = positions.size();}
        //on définit la moyenne des coordonnées
        latitude = calcMLat();
        longitude = calcMLon();
        //on définit le type de carte à afficher
        mapType = list.getSelectedIndex();
        map = map();
        //puis on définit l'url avec tous les parametres
            url = "http://maps.googleapis.com/maps/api/staticmap?center="
                    +Double.toString(latitude)
                    +","+Double.toString(longitude)
                    +"&zoom="+sliderZoom.getValue()
                    +"&size=512x512&maptype=";
            url = url+map;
        /**
         * Fonction qui ajoute des markers dans l'url
         */
        if (points == true){
            for(int i = 0; (i < nbrPoints*nbrPointsAff)&&(i<positions.size()); i=i+nbrPointsAff){
                    url = url+"&markers=color:red|label:"+(i/nbrPointsAff)+"|"+positions.get(i).getLatitude()
                    +","+positions.get(i).getLongitude();
                    System.out.println(i);
                    }
					
                    System.out.println(url);
        
        }
        /**
         * fonction qui ajoute une trace entre chaque markers
         */
        if (trace == true) {
            url = url+"&path=color:red";
            for (int i = 0; (i < nbrPoints*nbrPointsAff)&&(i<positions.size()); i=i+nbrPointsAff){
                url = url+"|"+positions.get(i).getLatitude()
                         +","+positions.get(i).getLongitude();
            }
        }
        //on ferme l'url
        url = url+"&sensor=false";
        //on envoit url et le nombre d'image à 'carte' avant de l'afficher
        Carte fen = new Carte(url,j);
        fen.show();
    }//GEN-LAST:event_affDonneesActionPerformed
    
    private void boutonFloconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonFloconActionPerformed
        positions = flocon.getPositions();
        nomAnimal = "flocon";
        this.latitude = flocon.getPositions().get(0).getLatitude();
        this.longitude = flocon.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonFloconActionPerformed

    private void boutonMalysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonMalysActionPerformed
        positions = malys.getPositions();
        nomAnimal = "malys";
        this.latitude = malys.getPositions().get(0).getLatitude();
        this.longitude = malys.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonMalysActionPerformed

    private void boutonEcumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonEcumeActionPerformed
        positions = ecume.getPositions();
        nomAnimal = "ecume";
        this.latitude = ecume.getPositions().get(0).getLatitude();
        this.longitude = ecume.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonEcumeActionPerformed

    private void boutonVanilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonVanilleActionPerformed
        positions = vanille.getPositions();
        nomAnimal = "vanille";
        this.latitude = vanille.getPositions().get(0).getLatitude();
        this.longitude = vanille.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonVanilleActionPerformed

    private void boutonLirianeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonLirianeActionPerformed
        positions = liriane.getPositions();
        nomAnimal = "liriane";
        this.latitude = liriane.getPositions().get(0).getLatitude();
        this.longitude = liriane.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonLirianeActionPerformed

    private void boutonUnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonUnaActionPerformed
        positions = una.getPositions();
        nomAnimal = "una";
        this.latitude = una.getPositions().get(0).getLatitude();
        this.longitude = una.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonUnaActionPerformed

    private void boutonNeigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonNeigeActionPerformed
        positions = neige.getPositions();
        nomAnimal = "neige";
        this.latitude = neige.getPositions().get(0).getLatitude();
        this.longitude = neige.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonNeigeActionPerformed

    private void boutonNoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonNoraActionPerformed
        positions = nora.getPositions();
        nomAnimal = "nora";
        this.latitude = nora.getPositions().get(0).getLatitude();
        this.longitude = nora.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonNoraActionPerformed

    private void boutonAuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAuraActionPerformed
        positions = aura.getPositions();
        nomAnimal = "aura";
        this.latitude = aura.getPositions().get(0).getLatitude();
        this.longitude = aura.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonAuraActionPerformed

    private void boutonAuroreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonAuroreActionPerformed
        positions = aurore.getPositions();
        nomAnimal = "aurore";
        this.latitude = aurore.getPositions().get(0).getLatitude();
        this.longitude = aurore.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonAuroreActionPerformed

    private void boutonVellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonVellaActionPerformed
        positions = vella.getPositions();
        nomAnimal = "vella";
        this.latitude = vella.getPositions().get(0).getLatitude();
        this.longitude = vella.getPositions().get(0).getLongitude();
        afficherDonnees();
    }//GEN-LAST:event_boutonVellaActionPerformed

    private void affPtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affPtsActionPerformed
        if(points == false){
            points = true;
        }
        else if (points == true){
            points = false;
        }
    }//GEN-LAST:event_affPtsActionPerformed

    private void affTraceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_affTraceActionPerformed
        if (trace == false){
            trace = true;
        }
        else if (trace == true){
            trace = false;
        }
    }//GEN-LAST:event_affTraceActionPerformed

    private void sliderNbrPointsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderNbrPointsStateChanged
        if (sliderNbrPoints.getValue() == 0){
            nbrPointsAff = sliderNbrPoints.getValue()+1;
        }                                             
        if (sliderNbrPoints.getValue() == 1){
            nbrPointsAff = sliderNbrPoints.getValue()+1;
        }                                             
        if (sliderNbrPoints.getValue() == 2){
            nbrPointsAff = sliderNbrPoints.getValue()+3;
        }                                             
        if (sliderNbrPoints.getValue() == 3){
            nbrPointsAff = sliderNbrPoints.getValue()+7;
        }
        
        nbrPointsAffiche = Double.toString(nbrPointsAff);
        jLabel5.setText(nbrPointsAffiche);
    }//GEN-LAST:event_sliderNbrPointsStateChanged

    /*
        Variables
    */
        // Variables contenant les animaux
    private Animal gaia         = new Animal("Baleine à bosse Gaia", "gaia");
    private Animal irchad       = new Animal("Baleine à bosse Irchad", "irchad");
    private Animal teria3       = new Animal("Baleine à bosse Teria3", "teria3");
    private Animal aquila       = new Animal("Manchot royal Aquila", "aquila");
    private Animal leloki       = new Animal("Manchot royal Leloki", "leloki");
    private Animal toms         = new Animal("Manchot royal Toms", "toms");
    private Animal victor       = new Animal("Manchot royal Victor", "victor");
    private Animal arcaique     = new Animal("Ours polaire Arcaique", "arcaique");
    private Animal bandido      = new Animal("Ours polaire Bandido", "bandido");
    private Animal flocon       = new Animal("Ours polaire Flocon", "flocon");
    private Animal liriane      = new Animal("Ours polaire Liriane", "liriane");
    private Animal malys        = new Animal("Ours polaire Malys", "malys");
    private Animal neige        = new Animal("Ours polaire Neige", "neige");
    private Animal una          = new Animal("Ours polaire Una", "una");
    private Animal vanille      = new Animal("Ours polaire Vanille", "vanille");
    private Animal ecume        = new Animal("Tortue Ecume", "ecume");
    private Animal aura         = new Animal("Eléphant de mer Aura", "aura");
    private Animal aurore       = new Animal("Eléphant de mer Autore", "aurore");
    private Animal nora         = new Animal("Eléphant de mer Nora", "nora");
    private Animal vella        = new Animal("Eléphant de mer Vella", "vella");
        // Variable contenant les données à afficher sur le carte et affichées dans le tableau
    private ArrayList<DonneeArgos> positions;
    private String nomAnimal;
    public double latitude;
    public double longitude;
    public int j=0;//nombre d'images
    public boolean points = false;//afficher les points sur la carte
    public boolean trace = false;//afficher le tracer sur la carte
    public int mapType = 3;//type de map choisi par l'utilisateur, default=hybrid
    public String map;//mapType en string
    public int nbrPoints = 0;//nombre de points à afficher
    public int nbrPointsAff = 1;
    public String nbrPointsAffiche = " ";
        // Diverses couleurs utilisées dans le programme
    private final Color couleurValide = new Color(0, 175, 81);
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox affDates;
    private javax.swing.JButton affDonnees;
    private javax.swing.JCheckBox affPts;
    private javax.swing.JCheckBox affTrace;
    private javax.swing.JButton boutonAquila;
    private javax.swing.JButton boutonArcaique;
    private javax.swing.JButton boutonAura;
    private javax.swing.JButton boutonAurore;
    private javax.swing.JButton boutonBandido;
    private javax.swing.JButton boutonEcume;
    private javax.swing.JButton boutonFlocon;
    private javax.swing.JButton boutonGaia;
    private javax.swing.JButton boutonIrchad;
    private javax.swing.JButton boutonLeloki;
    private javax.swing.JButton boutonLiriane;
    private javax.swing.JButton boutonMalys;
    private javax.swing.JButton boutonNeige;
    private javax.swing.JButton boutonNora;
    private javax.swing.JButton boutonTeria3;
    private javax.swing.JButton boutonToms;
    private javax.swing.JButton boutonUna;
    private javax.swing.JButton boutonVanille;
    private javax.swing.JButton boutonVella;
    private javax.swing.JButton boutonVictor;
    private javax.swing.JPanel containActs;
    private javax.swing.JPanel containActsDonnees;
    private javax.swing.JPanel containAnimal;
    private javax.swing.JPanel containChoixAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JList list;
    private javax.swing.JButton majDonnees;
    private javax.swing.JScrollPane ptsScroll;
    private javax.swing.JTable ptsTable;
    private javax.swing.JSlider sliderNbrPoints;
    private javax.swing.JSlider sliderZoom;
    // End of variables declaration//GEN-END:variables
}
