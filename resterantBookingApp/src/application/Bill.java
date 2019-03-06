package application;

import application.TableList.Table;
import application.bookingList.booking;
import application.menuItem.Item;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Bill {

public Purchase head = null;

	public void addPurchase(String Item, int amount) { //Add element to head of list
		Purchase newPurchase=new Purchase(Item,amount);
		newPurchase.next=head;
		head=newPurchase;
		if(head.next != null) {
			head.next.previous = newPurchase;
		}
	} 

	
	public class Purchase implements EventHandler<ActionEvent>{
		public Purchase next =null;
		public Purchase previous = null;
		private Item item;
		private int Amount;
		private Button delete = new Button("DELETE");
		
		
		public Purchase(String ItemName, int amount){
			this.Amount = amount; 
			boolean match = false;
			Item temp = Main.menuItems.head;
			while (temp != null && match == false) {
				if(temp.Name.equals(ItemName)) {
					match = true;
					this.item = temp;
				}
				System.out.print(ItemName +" "+ temp.Name);
				temp = temp.next;
			}
			if(match== false) {
				this.item= Main.menuItems.defalt;
			}
		}
		
		
		public GridPane PurchaseRep() {//generates the grid pain for the main menu
			GridPane show = new GridPane();
			
			//Creates element and sets text size
			Text itemName = new Text("Item: "+this.item.Name);
			itemName.setFont(Font.font(20));
			
			Text itemAmount = new Text("Amount: "+this.Amount);
			itemAmount.setFont(Font.font(20));
			
			Text Price = new Text("Price: "+this.Amount*item.Price);
			Price.setFont(Font.font(20));
			
			delete.setFont(Font.font(20));
			delete.addEventHandler(ActionEvent.ACTION, this);//event andler
			
			//adds elaments to the grid
			show.add(itemName,0,0,2,1);
			show.add(itemAmount, 0, 1, 2, 1);
			show.add(Price, 0, 2,2,1);
			show.add(delete, 0, 3,1,1);
			
			//sets the styleing of the grid
			show.setAlignment(Pos.CENTER);
			show.setVgap(10); 
		    show.setHgap(10);
		    show.setMinSize(250,250);
		    
		    //alins the elaments
		    show.setHalignment(itemName, HPos.CENTER);
		    show.setHalignment(itemAmount, HPos.CENTER);
		    show.setHalignment(Price, HPos.CENTER);
		    show.setHalignment(delete,HPos.CENTER);
			return show;

		}


		@Override
		public void handle(ActionEvent e) {
			
		//find elment location
		    Table tableTemp = Main.tableList.head;
		    boolean found = false;
		    booking bookTemp = tableTemp.bookings.head;
		    Purchase purTemp = null;
		    
		    if(bookTemp != null) {
		    	purTemp = bookTemp.bill.head;
		    }

		    while(tableTemp != null && found == false) {
		    	while(bookTemp != null && found == false) {
		    		while(purTemp != null && found == false) {
			    		if (this == purTemp) {
			    			found = true;
			    		}
			    		else if (purTemp.next != null){
			    			purTemp = purTemp.next;
			    		}
			    		else if(bookTemp.next != null) {
			    			bookTemp = bookTemp.next;
			    			purTemp = bookTemp.bill.head;
			    		}
			    		else purTemp=null;
			    	}
			    	if(purTemp == null) {//if the bookTemp is null go to the next table
			    		bookTemp = bookTemp.next;
			    		purTemp = bookTemp.bill.head;
			    	}
		    	}
		    	if(bookTemp == null) {//if the bookTemp is null go to the next table
		    		tableTemp = tableTemp.next;
		    		bookTemp = tableTemp.bookings.head;
		    		purTemp = bookTemp.bill.head;
		    	}
		    }
		//
		    
			if(e.getSource()==delete) {//checs its the right button
			
			    if(this.next != null && this.previous != null) {
			    	this.next.previous = this.previous;
			    	this.previous.next = this.next;
			    }
			    else if(this.next == null && this.previous != null) {
			    	this.previous.next=null;
			    }
			    else if(this.next != null && this.previous == null) {
			    	bookTemp.bill.head = this.next;
			    	this.next.previous = null;
			    }
			    else {
			    	bookTemp.bill.head = null;
			    }
			    
				Main.Scean_Manager.billScene(bookTemp);
			}
			
		}

	}
	
	

}
