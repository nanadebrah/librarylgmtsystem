/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.LibConfig;
import model.LibEmailSender;
import model.LibUtil;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.renderers.SubstanceDefaultComboBoxRenderer;
import org.pushingpixels.substance.api.skin.SkinInfo;

import view.ProSettingDialog;

/**
 * 
 * @author CuongNQ
 */
public class ProSettingController {

	// Defined
	private ProSettingDialog view;
	private ManageController parent;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param parent
	 */
	public ProSettingController(ProSettingDialog view, ManageController parent) {
		this.parent = parent;
		this.view = view;
		initComponent();
	}

	/**
	 * Initialize the controller.
	 */
	@SuppressWarnings("serial")
	private void initComponent() {
		// Add event open window
		view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				// Load config
				LibConfig.getInstance().loadProConfig(view);
			}
		});

		// Fill value to combobox theme
		view.getCbxTheme().setRenderer(
				new SubstanceDefaultComboBoxRenderer(view.getCbxTheme()) {

					@Override
					public Component getListCellRendererComponent(JList list,
							Object value, int index, boolean isSelected,
							boolean cellHasFocus) {
						SkinInfo si = (SkinInfo) value;
						return super.getListCellRendererComponent(list,
								si.getDisplayName(), index, false, cellHasFocus);
					}
				});

		// Add event change theme
		view.getCbxTheme().addItemListener(new java.awt.event.ItemListener() {

			@Override
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						SubstanceLookAndFeel.setSkin(((SkinInfo) view
								.getCbxTheme().getSelectedItem())
								.getClassName());
					}
				});
				SwingUtilities.updateComponentTreeUI(parent.getView());
				parent.getView().pack();
				parent.getView().repaint();
			}
		});

		// Add event save btn
		view.getBtnDefault().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (LibUtil.getInstance().isWindows()) {
						UIManager
								.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
					} else {
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(view);
				view.pack();
				SwingUtilities.updateComponentTreeUI(parent.getView());
				parent.getView().pack();
				view.getSpinNoRow().setValue(20);
				view.getTxtEmail().setText(
						Messages.getString("ProSettingController.2")); //$NON-NLS-1$
				view.getTxtHost().setText(
						Messages.getString("ProSettingController.3")); //$NON-NLS-1$
				view.getTxtPort().setText(
						Messages.getString("ProSettingController.4")); //$NON-NLS-1$
				view.getTxtPass().setText(
						Messages.getString("EmptyText")); //$NON-NLS-1$
			}
		});

		// Add event close btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});

		// Add event btn save
		view.getBtnSave().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LibConfig.getInstance().saveProConfig(
						view.getSpinNoRow().getValue().toString(),
						view.getTxtHost().getText(),
						view.getTxtPort().getText(),
						view.getTxtEmail().getText(),
						new String(view.getTxtPass().getPassword()));
				LibUtil.noRow = Integer.parseInt(view.getSpinNoRow().getValue()
						.toString());
				view.dispose();
			}
		});

		// Add event spn change
		view.getSpinNoRow().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (Integer.parseInt(view.getSpinNoRow().getValue().toString()) < 1) {
					view.getSpinNoRow().setValue(1);
				}
			}
		});

		// Add event btn Check email
		view.getBtnCheck().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				try {
					Thread t = new Thread(new Runnable() {

						@Override
						public void run() {
							checkConnection();
							view.setCursor(null);
						}
					});
					t.start();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Check email connection
	 */
	private void checkConnection() {
		try {
			if (LibEmailSender.getInstance().testEmail(
					view.getTxtHost().getText(), view.getTxtPort().getText(),
					view.getTxtEmail().getText(),
					new String(view.getTxtPass().getPassword()))) {
				view.getLblStatus().setText(
						Messages.getString("ProSettingController.0")); //$NON-NLS-1$
			} else {
				view.getLblStatus().setText(
						Messages.getString("ProSettingController.1")); //$NON-NLS-1$
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public ProSettingDialog getView() {
		return view;
	}
}
