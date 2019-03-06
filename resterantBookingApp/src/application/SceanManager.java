package application;

import application.Bill.Purchase;
import application.TableList.Table;
import application.bookingList.booking;
import application.menuItem.Item;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SceanManager implements EventHandler<ActionEvent>{
	private Button bookItemBack = new Button("BACK");
	private Button billBack = new Button("BACK");
	private Button TableAdd = new Button("ADD");
	private Button BookAdd = new Button("ADD");
	private Button purAdd = new Button("ADD");
	private Button itemAdd = new Button("ADD");
	private Button Menu = new Button("Menu");
	private Button TableSubbmit = new Button("Submit");
	private Button TableCancel = new Button("Cancel");
	private Button bookSubbmit = new Button("Submit");
	private Button bookCancel = new Button("Cancel");
	private Button purSubbmit = new Button("Submit");
	private Button purCancel = new Button("Cancel");
	private Button itemSubbmit = new Button("Submit");
	private Button itemCancel = new Button("Cancel");
	private TextField textbox1 = new TextField();
	private TextField textbox2 = new TextField();
	private TextField textbox3 = new TextField();
	private TextField textbox4 = new TextField();
	private Text text1 = new Text();
	private Text text2 = new Text();
	private Text text3 = new Text();
	private Text text4 = new Text();
	
	private Table activeTable =null;
	private booking activeBook = null;
	
	
	public SceanManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void tableScene() {
		GridPane main = new GridPane();
		main.setVgap(10); 
	    main.setHgap(10);
		Table temp = Main.tableList.head;
		int c = 0,r=0,tableNo=1;
		while(temp != null) {//gose trow all elaments and figers out were thay go
			if( c%2 == 0 && c !=0) {
				c=0;
				r++;
			}
		main.add(temp.TableRep(tableNo), c, r);
		c++;
		tableNo++;
		temp = temp.next;
		}
		
		TableAdd.setFont(Font.font(20));
		TableAdd.addEventHandler(ActionEvent.ACTION, this);
		
		Menu.setFont(Font.font(20));
		Menu.addEventHandler(ActionEvent.ACTION, this);
		
		GridPane navBar = new GridPane();
		navBar.add(TableAdd, 0, 0,1,1);
		navBar.add(Menu, 1, 0,1,1);
		navBar.setAlignment(Pos.CENTER);
		navBar.setHgap(170); 
	    
		GridPane show = new GridPane();
		show.add(main, 0, 0);
		show.add(navBar, 0, 1);
		
		Main.stage.setScene(new Scene(show,510,510));
		Main.stage.show();
	}
	
	public void billScene(booking addBook) {
		activeBook=addBook;
		GridPane billScrean = new GridPane(); 
		billScrean.setVgap(10); 
	    billScrean.setHgap(10); 
	    
		Purchase temp = activeBook.bill.head;
		int c = 0,r=0;
		while(temp != null) {//gose trow all elaments and figers out were thay go
			if( c%2 == 0 && c !=0) {
				c=0;
				r++;
			}
		billScrean.add(temp.PurchaseRep(), c, r);
		c++;
		temp = temp.next;
		}
		
		purAdd.setFont(Font.font(20));
		purAdd.addEventHandler(ActionEvent.ACTION, this);
		
		billBack.setFont(Font.font(20));
		billBack.addEventHandler(ActionEvent.ACTION, this);
		
		GridPane navBar = new GridPane();
		navBar.add(purAdd, 0, 0,1,1);
		navBar.add(billBack, 1, 0,1,1);
		navBar.setAlignment(Pos.CENTER);
		navBar.setHgap(170); 
	    
		GridPane show = new GridPane();
		show.add(billScrean, 0, 0);
		show.add(navBar, 0, 1);
		
		Main.stage.setScene(new Scene(show,510,510));
		Main.stage.show();
	}
	
	public void bookingScene(Table addTable) {
		activeTable=addTable;
		GridPane bookingsScrean = new GridPane();
		bookingsScrean.setVgap(10); 
	    bookingsScrean.setHgap(10);
	    
	    booking temp = activeTable.bookings.head;
		int c = 0,r=0;
		while(temp != null) {//gose trow all elaments and figers out were thay go
			if( c%2 == 0 && c !=0) {
				c=0;
				r++;
			}
		bookingsScrean.add(temp.bookingRep(), c, r);
		c++;
		temp = temp.next;
		}

		BookAdd.setFont(Font.font(20));
		BookAdd.addEventHandler(ActionEvent.ACTION, this);
		
		bookItemBack.setFont(Font.font(20));
		bookItemBack.addEventHandler(ActionEvent.ACTION, this);
		
		GridPane navBar = new GridPane();
		navBar.add(BookAdd, 0, 0,1,1);
		navBar.add(bookItemBack, 1, 0,1,1);
		navBar.setAlignment(Pos.CENTER);
		navBar.setHgap(170); 
	    
		GridPane show = new GridPane();
		show.add(bookingsScrean, 0, 0);
		show.add(navBar, 0, 1);
		
		Main.stage.setScene(new Scene(show,510,550));
		Main.stage.show();
	}
	
	public void menuScene() {
		GridPane main = new GridPane();
		main.setVgap(10); 
	    main.setHgap(10);
		Item temp = Main.menuItems.head;
		int c = 0,r=0;
		while(temp != null) {//gose trow all elaments and figers out were thay go
			if( c%2 == 0 && c !=0) {
				c=0;
				r++;
			}
		main.add(temp.ItemRep(), c, r);
		c++;
		temp = temp.next;
		}
		
		itemAdd.setFont(Font.font(20));
		itemAdd.addEventHandler(ActionEvent.ACTION, this);
		
		bookItemBack.setFont(Font.font(20));
		bookItemBack.addEventHandler(ActionEvent.ACTION, this);
		
		GridPane navBar = new GridPane();
		navBar.add(itemAdd, 0, 0,1,1);
		navBar.add(bookItemBack, 1, 0,1,1);
		navBar.setAlignment(Pos.CENTER);
		navBar.setHgap(170); 
	    
		GridPane show = new GridPane();
		show.add(main, 0, 0);
		show.add(navBar, 0, 1);
		
		Main.stage.setScene(new Scene(show,510,510));
		Main.stage.show();
	}
	
	public void tableAdd() {
		GridPane main = new GridPane();
		main.setVgap(10); 
		main.setHgap(10);
		text1.setFont(Font.font(20));
		text1.setText("Num of Chairs: ");
		
		TableSubbmit.setFont(Font.font(20));
		TableSubbmit.addEventHandler(ActionEvent.ACTION, this);
		
		TableCancel.setFont(Font.font(20));
		TableCancel.addEventHandler(ActionEvent.ACTION, this);
	    
	    main.add(text1, 0,0,1,1);
	    main.add(textbox1, 1, 0,1,1);
	    main.add(TableSubbmit, 0, 1,1,1);
	    main.add(TableCancel, 1, 1,1,1);
	    main.setAlignment(Pos.CENTER);
	    Main.stage.setScene(new Scene(main,500,250));
	    Main.stage.show();  
	}
	
	public void bookingAdd() {
		GridPane main = new GridPane();
		main.setVgap(10); 
		main.setHgap(10);
		text1.setFont(Font.font(20));
		text1.setText("Names: ");
		text2.setFont(Font.font(20));
		text2.setText("Num of people: ");
		text3.setFont(Font.font(20));
		text3.setText("start time: ");
		text4.setFont(Font.font(20));
		text4.setText("Duration: ");
		
		bookSubbmit.setFont(Font.font(20));
		bookSubbmit.addEventHandler(ActionEvent.ACTION, this);
		
		bookCancel.setFont(Font.font(20));
		bookCancel.addEventHandler(ActionEvent.ACTION, this);
	    
	    main.add(text1, 	   0,0,1,1);
	    main.add(text2, 	   0,1,1,1);
	    main.add(text3, 	   0,2,1,1);
	    main.add(text4, 	   0,3,1,1);
	    main.add(textbox1,     1,0,1,1);
	    main.add(textbox2,     1,1,1,1);
	    main.add(textbox3,     1,2,1,1);
	    main.add(textbox4,     1,3,1,1);
	    main.add(bookSubbmit, 0,4,1,1);
	    main.add(bookCancel,  1,4,1,1);
	    main.setAlignment(Pos.CENTER);
	    
	    Main.stage.setScene(new Scene(main,500,250));
	    Main.stage.show();  
	}
	
	public void billAdd() {

		
		GridPane main = new GridPane();
		main.setVgap(10); 
		main.setHgap(10);
		text1.setFont(Font.font(20));
		text1.setText("Item: ");
		text2.setFont(Font.font(20));
		text2.setText("Ammount: ");
		
		purSubbmit.setFont(Font.font(20));
		purSubbmit.addEventHandler(ActionEvent.ACTION, this);
		
		purCancel.setFont(Font.font(20));
		purCancel.addEventHandler(ActionEvent.ACTION, this);
	    
	    main.add(text1, 	   0,0,1,1);
	    main.add(text2, 	   0,1,1,1);
	    main.add(textbox1,     1,0,1,1);
	    main.add(textbox2,     1,1,1,1);
	    main.add(purSubbmit, 0,2,1,1);
	    main.add(purCancel,  1,2,1,1);
	    main.setAlignment(Pos.CENTER);

	    Main.stage.setScene(new Scene(main,500,250));
	    Main.stage.show();  
	}
	
	public void itemAdd() {
		GridPane main = new GridPane();
		main.setVgap(10); 
		main.setHgap(10);
		text1.setFont(Font.font(20));
		text1.setText("name : ");
		text2.setFont(Font.font(20));
		text2.setText("Price: ");
		
		itemSubbmit.setFont(Font.font(20));
		itemSubbmit.addEventHandler(ActionEvent.ACTION, this);
		
		itemCancel.setFont(Font.font(20));
		itemCancel.addEventHandler(ActionEvent.ACTION, this);
	    
	    main.add(text1, 	   0,0,1,1);
	    main.add(text2, 	   0,1,1,1);
	    main.add(textbox1,     1,0,1,1);
	    main.add(textbox2,     1,1,1,1);
	    main.add(itemSubbmit, 0,2,1,1);
	    main.add(itemCancel,  1,2,1,1);
	    main.setAlignment(Pos.CENTER);

	    
	    Main.stage.setScene(new Scene(main,500,250));
	    Main.stage.show();  
	}

	@Override
	public void handle(ActionEvent e) {
		if(e.getSource()==TableAdd) {
		Main.Scean_Manager.tableAdd();
		}
		
		else if(e.getSource()==TableSubbmit) {
			int tnc;
			try {tnc=Integer.parseInt(textbox1.getText());}catch(Exception e1){tnc = 0;}//try catch sets tnc if invalid input
			Main.tableList.addTable(tnc);
			Main.Scean_Manager.tableScene();
		}
		
		else if(e.getSource()==TableCancel) {
			Main.Scean_Manager.tableScene();
		}
		
		else if(e.getSource()==bookItemBack ) {
			Main.Scean_Manager.tableScene();
		}
		
		else if(e.getSource()==BookAdd) {
			Main.Scean_Manager.bookingAdd();
		}
		
		else if(e.getSource()==bookSubbmit) {
			int nop,st,d;
			try {nop=Integer.parseInt(textbox2.getText());}catch(Exception e1){nop = 0;}//try catch sets tnc if invalid input
			try {st=Integer.parseInt(textbox3.getText());}catch(Exception e1){st = 0;}//try catch sets tnc if invalid input
			try {d=Integer.parseInt(textbox4.getText());}catch(Exception e1){d = 0;}//try catch sets tnc if invalid input
			Main.Scean_Manager.activeTable.bookings.addBooking(textbox1.getText().toString(), nop, st, d);
			Main.Scean_Manager.bookingScene(this.activeTable);
		}
		
		else if(e.getSource()==bookCancel) {
			Main.Scean_Manager.bookingScene(this.activeTable);
		}
		
		else if(e.getSource()==billBack) {
			Main.Scean_Manager.bookingScene(activeTable);
		}
		
		else if(e.getSource()==purAdd) {
			Main.Scean_Manager.billAdd();
		}
		
		else if(e.getSource()==purSubbmit) {
			int am;
			try {am=Integer.parseInt(textbox2.getText());}catch(Exception e1){am = 0;}//try catch sets tnc if invalid input
			Main.Scean_Manager.activeBook.bill.addPurchase(textbox1.getText().toString(), am);;
			Main.Scean_Manager.billScene(activeBook);
		}
		
		else if(e.getSource()==purCancel) {
			Main.Scean_Manager.billScene(activeBook);
		}
		
		else if(e.getSource()==itemSubbmit) {
			double pr;
			try {pr=Double.parseDouble(textbox2.getText());}catch(Exception e1){pr = 0.0;}//try catch sets tnc if invalid input
			Main.menuItems.addItem(textbox1.getText().toString(), pr);
			Main.Scean_Manager.menuScene();
		}
		
		else if(e.getSource()==itemAdd) {
			Main.Scean_Manager.itemAdd();
		}
		
		else if(e.getSource()==itemCancel) {
			Main.Scean_Manager.menuScene();
		}
		
		else if(e.getSource()==Menu) {
			Main.Scean_Manager.menuScene();
		}
		
	}
}
