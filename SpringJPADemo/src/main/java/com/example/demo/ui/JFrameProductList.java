package com.example.demo.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.orm.jpa.JpaVendorAdapter;

import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImp;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class JFrameProductList extends JFrame {

	private JPanel contentPane;
	private JTable tablePrList;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtQuantity;

	@Autowired
	private ProductService prService;

	private List<Product> listPr;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameProductList frame = new JFrameProductList();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameProductList() {
		setTitle("ProductList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 6, 694, 235);
		contentPane.add(scrollPane);

		tablePrList = new JTable();
		tablePrList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		scrollPane.setViewportView(tablePrList);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Product Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(36, 253, 694, 267);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblId.setBounds(82, 31, 51, 16);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setBounds(145, 27, 443, 28);
		panel.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(145, 70, 443, 28);
		panel.add(txtName);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblName.setBounds(82, 74, 51, 16);
		panel.add(lblName);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(145, 110, 443, 28);
		panel.add(txtPrice);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblPrice.setBounds(82, 114, 51, 16);
		panel.add(lblPrice);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(145, 152, 443, 28);
		panel.add(txtQuantity);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblQuantity.setBounds(82, 156, 65, 24);
		panel.add(lblQuantity);

		JButton btnCreate = new JButton(" Create ");
		btnCreate.setBounds(151, 204, 96, 28);
		panel.add(btnCreate);

		JButton btnEdit = new JButton("Edit ");
		btnEdit.setBounds(259, 204, 96, 28);
		panel.add(btnEdit);

		JButton btnDelete = new JButton("Delete ");
		btnDelete.setBounds(367, 204, 96, 28);
		panel.add(btnDelete);
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCreateClick();
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDeleteCLick();
			}
		});

		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnEditClick();
			}
		});

//		this.prService = (ProductService) BeanUtil.getBeanByName("productService");
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		prService = (ProductService) context.getBean("productService");

		loadData();

	}

	public void btnCreateClick() {
		try {
			Product pr = new Product();
			pr.setId(txtId.getText());
			pr.setName(txtName.getText());
			pr.setPrice(BigDecimal.valueOf(Double.parseDouble(txtPrice.getText())));
			pr.setQuantity(Integer.parseInt(txtQuantity.getText()));

			prService.save(pr);
			JOptionPane.showMessageDialog(this, "Save Successfull");
			listPr.add(pr);
			model.addRow(new Object[] { pr.getId(), pr.getName(), pr.getPrice(), pr.getQuantity() });
			tablePrList.revalidate();
		} catch (Exception e) {
			// TODO: handle exception
//			JOptionPane.showMessageDialog(this, e.getStackTrace());
			e.printStackTrace();
		}
	}

	public void btnDeleteCLick() {
		try {
			int row = tablePrList.getSelectedRow();
			if (row != -1) {
				String id = (String) tablePrList.getModel().getValueAt(row, 0);
				prService.delete(id);
				listPr.remove(row);
				model.removeRow(row);
				tablePrList.revalidate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void btnEditClick() {
		try {
			int row = tablePrList.getSelectedRow();
			if (row != -1) {
				String id = txtId.getText();
				String name = txtName.getText();
				BigDecimal price = BigDecimal.valueOf(Double.parseDouble(txtPrice.getText()));
				int quantity = Integer.parseInt(txtQuantity.getText());
				Product pr = new Product(id, name, price, quantity);
				prService.save(pr);
				listPr.set(row, pr);

				model.setValueAt(id, row, 0);
				model.setValueAt(name, row, 1);
				model.setValueAt(price, row, 2);
				model.setValueAt(quantity, row, 3);
				tablePrList.revalidate();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	String[] columnName = { "Id", "Name", "Price", "Quantity" };

	private void loadData() {
		// TODO Auto-generated method stub
		listPr = new ArrayList<Product>();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnName);

		List<String> listSort = new ArrayList<String>();
		listSort.add("id");
		listSort.add("name");
//		listPr = (List<Product>) prService.findAll(new Sort(Direction.ASC, listSort));
		listPr = (List<Product>) prService.findAll();

		for (Product pr : listPr) {
			model.addRow(new Object[] { pr.getId(), pr.getName(), pr.getPrice(), pr.getQuantity() });

		}
		this.tablePrList.setModel(model);

	}

	public void tableClick() {
		int row = tablePrList.getSelectedRow();
		if (row != -1) {
			Product pr = listPr.get(row);
			txtId.setText(pr.getId());
			txtName.setText(pr.getName());
			txtPrice.setText(pr.getPrice() + "");
			txtQuantity.setText(pr.getQuantity() + "");
		}
	}
}
