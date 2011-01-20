/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

import model.LibUtil;

import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.effect.BufferedImageOpEffect;
import org.jdesktop.jxlayer.plaf.ext.LockableUI;

import view.AboutWindow;
import view.AnalyticPanel;
import view.BookPanel;
import view.BorrowPanel;
import view.EmployeePanel;
import view.LoginDialog;
import view.ManageFrame;
import view.ProSettingDialog;
import view.SubjectPanel;

import com.jhlabs.image.BlurFilter;

/**
 * Main program, manage controller, control manage frame
 * 
 * @author CuongNQ
 */
public class ManageController {

	// Defined LoginController & login view
	private LoginController loginControl;
	private LoginDialog loginDialog;
	// Defined card layout
	private CardLayout cardLayout;
	// Defined EmployeeController & employee model
	private EmployeeController empControl;
	private DefaultTableModel empModel;
	// Defined BookController & book model
	private BookController bookControl;
	private DefaultTableModel bookModel;
	// Defined SubjectController & subject model
	private SubjectController subControl;
	private DefaultTableModel subModel;
	// Defined SubjectController & subject model
	private BorrowController borControl;
	private DefaultTableModel borModel;
	// Defined SubjectController & subject model
	private AnalyticController anaControl;
	private DefaultTableModel anaModel;
	// Defined program setting
	private ProSettingController proControl;
	// Defined about window
	@SuppressWarnings("unused")
	private AboutWindow about;
	// Defined Setting Dialog
	private ManageFrame view;
	// Defined Jxlayer
	private JXLayer<JComponent> layer;
	// Defined blurUI
	private LockableUI blurUI;
	// Defined Jcomponent
	private JComponent jc;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param loginDialog
	 */
	public ManageController(ManageFrame view, LoginDialog loginDialog) {
		this.view = view;
		this.loginDialog = loginDialog;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	@SuppressWarnings("serial")
	private void initComponent() {
		// Create new instance of program setting
		proControl = new ProSettingController(new ProSettingDialog(view), this);

		// Create new instance of login controller
		loginControl = new LoginController(loginDialog, this);

		// Create instance of card layout
		cardLayout = (CardLayout) view.getPanelMain().getLayout();

		// Create employee model
		empModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};

		// Create book model
		bookModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		// Create subject model
		subModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		// Create borrow model
		borModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		// Create analytic model
		anaModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};

		// Create new employee controller
		empControl = new EmployeeController(new EmployeePanel(), empModel, this);
		// Create new book controller
		bookControl = new BookController(new BookPanel(), bookModel, this);
		// Create new subject controller
		subControl = new SubjectController(new SubjectPanel(), subModel, this);
		// Create new borrow controller
		borControl = new BorrowController(new BorrowPanel(), borModel, this);
		// Create new analytic controller
		anaControl = new AnalyticController(new AnalyticPanel(), anaModel, this);

		// Add employee panel
		view.getPanelMain().add(empControl.getView(),
				Messages.getString("ManageController.0")); //$NON-NLS-1$
		// Add book panel
		view.getPanelMain().add(bookControl.getView(),
				Messages.getString("ManageController.1")); //$NON-NLS-1$
		// Add subject panel
		view.getPanelMain().add(subControl.getView(),
				Messages.getString("ManageController.2")); //$NON-NLS-1$
		// Add borrow panel
		view.getPanelMain().add(borControl.getView(),
				Messages.getString("ManageController.3")); //$NON-NLS-1$
		// Add subject panel
		view.getPanelMain().add(anaControl.getView(),
				Messages.getString("ManageController.4")); //$NON-NLS-1$

		// Add btn Employee manage
		view.getBtnEmployee().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(view.getPanelMain(),
						Messages.getString("ManageController.5")); //$NON-NLS-1$
				setBorSelect(view.getBtnEmployee());
			}
		});
		// Add btn Book manage
		view.getBtnBook().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(view.getPanelMain(),
						Messages.getString("ManageController.6")); //$NON-NLS-1$
				setBorSelect(view.getBtnBook());
			}
		});
		// Add btn Subject Manage
		view.getBtnSubject().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(view.getPanelMain(),
						Messages.getString("ManageController.7")); //$NON-NLS-1$
				setBorSelect(view.getBtnSubject());
			}
		});
		// Add btn Borrow Manage
		view.getBtnBorrow().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(view.getPanelMain(),
						Messages.getString("ManageController.8")); //$NON-NLS-1$
				setBorSelect(view.getBtnBorrow());
			}
		});
		// Add btn Analytics Manage
		view.getBtnAnalytic().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(view.getPanelMain(),
						Messages.getString("ManageController.9")); //$NON-NLS-1$
				setBorSelect(view.getBtnAnalytic());
			}
		});

		// Add event window opened
		view.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowOpened(java.awt.event.WindowEvent evt) {
				setBorSelect(view.getBtnEmployee());
				empControl.searchEmp();
				subControl.searchSubject();
				bookControl.searchBook();
				borControl.searchBorrow();
			}
		});

		// Add event quit
		view.getMnQuit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				System.exit(0);
			}
		});

		// Add event about us
		view.getMnAboutUs().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setVisible(false);// hidden current frame
				about = new AboutWindow(view, null);
			}
		});

		// Add event logout menu
		view.getMnLogout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
				loginControl.getView().setVisible(true);
			}
		});

		// Add event menu setting
		view.getMnSetting().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doBlur();
				proControl.getView().setVisible(true);
				doBlur();
			}
		});

		// Add event all menu
		view.getMnAnalytic().addMenuListener(
				new javax.swing.event.MenuListener() {

					@Override
					public void menuCanceled(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuDeselected(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuSelected(javax.swing.event.MenuEvent evt) {
						cardLayout.show(view.getPanelMain(),
								Messages.getString("ManageController.10")); //$NON-NLS-1$
						setBorSelect(view.getBtnAnalytic());
					}
				});
		view.getMnSubject().addMenuListener(
				new javax.swing.event.MenuListener() {

					@Override
					public void menuCanceled(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuDeselected(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuSelected(javax.swing.event.MenuEvent evt) {
						cardLayout.show(view.getPanelMain(),
								Messages.getString("ManageController.11")); //$NON-NLS-1$
						setBorSelect(view.getBtnSubject());
					}
				});
		view.getMnBook().addMenuListener(new javax.swing.event.MenuListener() {

			@Override
			public void menuCanceled(javax.swing.event.MenuEvent evt) {
			}

			@Override
			public void menuDeselected(javax.swing.event.MenuEvent evt) {
			}

			@Override
			public void menuSelected(javax.swing.event.MenuEvent evt) {
				cardLayout.show(view.getPanelMain(),
						Messages.getString("ManageController.12")); //$NON-NLS-1$
				setBorSelect(view.getBtnBook());
			}
		});
		view.getMnBorrow().addMenuListener(
				new javax.swing.event.MenuListener() {

					@Override
					public void menuCanceled(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuDeselected(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuSelected(javax.swing.event.MenuEvent evt) {
						cardLayout.show(view.getPanelMain(),
								Messages.getString("ManageController.13")); //$NON-NLS-1$
						setBorSelect(view.getBtnBorrow());
					}
				});
		view.getMnEmployee().addMenuListener(
				new javax.swing.event.MenuListener() {

					@Override
					public void menuCanceled(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuDeselected(javax.swing.event.MenuEvent evt) {
					}

					@Override
					public void menuSelected(javax.swing.event.MenuEvent evt) {
						cardLayout.show(view.getPanelMain(),
								Messages.getString("ManageController.14")); //$NON-NLS-1$
						setBorSelect(view.getBtnEmployee());
					}
				});

		// Add event open help mn
		view.getMnHelp().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LibUtil.getInstance().openHelp();
			}
		});

		// Create new instance of blurUI
		blurUI = new LockableUI(new BufferedImageOpEffect(new BlurFilter()));
		// Create new instance of Jcomponent
		jc = (JComponent) view.getContentPane();
		// Create new instance of layer
		layer = new JXLayer<JComponent>(jc);
		// Set layer blur effect
		layer.setUI(blurUI);
		blurUI.setLockedCursor(null);
		// set layer blur to pane
		view.setContentPane(layer);
	}

	/**
	 * Blur main frame when dialog open
	 */
	public void doBlur() {
		// set layer blur to pane
		view.setContentPane(layer);
		blurUI.setLocked(!blurUI.isLocked());
	}

	/**
	 * @return the view
	 */
	public ManageFrame getView() {
		return view;
	}

	/**
	 * Remove all row on table model
	 * 
	 * @param model
	 */
	public void removeModel(DefaultTableModel model) {
		int row = model.getRowCount();
		for (int i = 0; i < row; i++) {
			model.removeRow(0);
		}
	}

	/**
	 * Start program by run display login dialog
	 */
	public void Run() {
		loginControl.getView().setVisible(true);
	}

	/**
	 * Set border painted for button selected
	 */
	private void setBorSelect(JButton btSelected) {
		view.getBtnEmployee().setBorderPainted(false);
		view.getBtnBook().setBorderPainted(false);
		view.getBtnSubject().setBorderPainted(false);
		view.getBtnBorrow().setBorderPainted(false);
		view.getBtnAnalytic().setBorderPainted(false);
		btSelected.setBorderPainted(true);
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(ManageFrame view) {
		this.view = view;
	}
}
