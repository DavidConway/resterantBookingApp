package application;



import java.awt.Window;

import application.TableList.Table;
import application.bookingList.booking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TableList {
	public Table head = null;
	
	public void addTable(int chairCount) { //Add element to head of list
		Table newTable=new Table(chairCount);
		newTable.next=head;
		head=newTable;
		if(head.next != null) {
			head.next.previous = newTable;
		}
	} 

	
	public class Table implements EventHandler<ActionEvent>{
		public Table next =null;
		public Table previous = null;
		private int chairCount;
		public bookingList bookings = new bookingList();//list of booking for the table
		private Stage bookingStage;
		private Button bookingsBut = new Button("Bookings");
		private Button delete = new Button("DELETE");
		
		
		
		public Table(int chairAmount){
			this.chairCount = chairAmount;
		}
		
		
		public GridPane TableRep(int tableNo) {//generates the grid pain for the main menu
			GridPane show = new GridPane();
			
			//sets elaments text size
			Text titel = new Text("Table: "+tableNo);
			titel.setFont(Font.font(28));
			
			Text chairNum = new Text("Chair Count: "+this.chairCount);
			chairNum.setFont(Font.font(20));
			
			bookingsBut.setFont(Font.font(20));
			bookingsBut.addEventHandler(ActionEvent.ACTION, this);//event andler
			
			delete.setFont(Font.font(20));
			delete.addEventHandler(ActionEvent.ACTION, this);//event andler
			
			//adds elaments to the grid
			show.add(titel, 0, 0, 2, 1);
			show.add(chairNum, 0, 1,2,1);
			show.add(bookingsBut, 0, 2,1,1);
			show.add(delete, 1, 2,1,1);
			
			//sets the styleing of the grid
			show.setAlignment(Pos.CENTER);
			show.setVgap(10); 
		    show.setHgap(10);
		    show.setMinSize(250,250);
		    
		    //alins the elaments
		    show.setHalignment(titel, HPos.CENTER);
		    show.setHalignment(chairNum, HPos.CENTER);
		    show.setHalignment(bookingsBut, HPos.CENTER);
		    show.setHalignment(delete, HPos.CENTER);
			return show;

		}
			
		@Override
		public void handle(ActionEvent e) {
			if(e.getSource()==bookingsBut) {//checs its the right button
				Main.Scean_Manager.bookingScene(this);
			}
			
			if(e.getSource()==delete) {
				if(this.next != null && this.previous != null) {
			    	this.next.previous = this.previous;
			    	this.previous.next = this.next;
			    }
			    else if(this.next == null && this.previous != null) {
			    	this.previous.next=null;
			    }
			    else if(this.next != null && this.previous == null) {
			    	Main.tableList.head = this.next;
			    	this.next.previous = null;
			    }
			    else {
			    	Main.tableList.head = null;
			    }
				

				Main.Scean_Manager.tableScene();
			}
		}
	}
}
