/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.LibConfig;
import model.LibUtil;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultComboBoxRenderer;
import org.pushingpixels.substance.api.skin.SkinInfo;
import view.ProgramSettingDialog;

/**
 *
 * @author CuongNQ
 */
public class ProSettingController {

    //Defined
    private ProgramSettingDialog view;
    private ManageController parent;    

    public ProSettingController(ProgramSettingDialog view,
            ManageController parent) {
        this.parent = parent;
        this.view = view;
        initComponent();
    }

    private void initComponent() {
        //Load config
        LibConfig.getInstance().loadProConfig(view.getTxtRow());

        //Fill value to combobox theme
        view.getCbxTheme().setRenderer(new SubstanceDefaultComboBoxRenderer(
                view.getCbxTheme()) {

            @Override
            public Component getListCellRendererComponent(JList list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                SkinInfo si = (SkinInfo) value;
                return super.getListCellRendererComponent(list, si.getDisplayName(),
                        index, false, cellHasFocus);
            }
        });

        //Add event change theme
        view.getCbxTheme().addItemListener(new java.awt.event.ItemListener() {

            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        SubstanceLookAndFeel.setSkin(((SkinInfo)
                                view.getCbxTheme()
                                .getSelectedItem()).getClassName());
                    }
                });
                SwingUtilities.updateComponentTreeUI(parent.getView());
                parent.getView().pack();
                parent.getView().repaint();
            }
        });

        //Add event save btn
        view.getBtnDefault().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(view);
                view.pack();
                SwingUtilities.updateComponentTreeUI(parent.getView());
                parent.getView().pack();
                LibConfig.getInstance().loadProConfig(view.getTxtRow());
            }
        });

        //Add event close btn
        view.getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

        //Add event btn save
        view.getBtnSave().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LibConfig.getInstance().saveProConfig(
                        view.getTxtRow().getValue().toString());
                LibUtil.noRow=Integer.parseInt(
                        view.getTxtRow().getValue().toString());
                view.dispose();
            }
        });

        //Add event spn change
        view.getTxtRow().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                if (Integer.parseInt(view.getTxtRow().getValue().toString())<1) {
                    view.getTxtRow().setValue(1);
                }
            }
        });
    }

    /**
     * 
     * @return
     */
    public ProgramSettingDialog getView() {
        return view;
    }
}
