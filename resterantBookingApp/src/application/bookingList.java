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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class bookingList {//list class

	public booking head = null;//first booking in the list
	
	public void addBooking(String Name, int NumOfPeople,int startTime, int Duration) { //Add element to head of list
		booking newBooking= new booking(Name,NumOfPeople,startTime,Duration);// creats booking
		newBooking.next=head;//attaches it to the head of the list
		head=newBooking;//makes it the new head
		if(head.next != null) {
			head.next.previous = newBooking;//if it is not the only elament have the next refer to the new booking
		}
	}
	
	
	public class booking implements EventHandler<ActionEvent>{//sub list class class
		public booking next = null;//points to next booking
		public booking previous = null;//points to previous booking
		
		// sets up basic veriabuls
		private String name;
		private int startTime;
		private int numOfPeople;
		private int duration;
		public Bill bill = new Bill();
		//
		//button used for eatch booking
		private Button delete = new Button("DELETE");
		private Button billBut = new Button("Bill");
		//
			//booking constructor
			public booking(String Name, int NumOfPeople,int startTime, int Duration) {
				this.name = Name;
				this.numOfPeople = NumOfPeople;
				this.startTime= startTime;
				this.duration = Duration;
			}
			//
			
			//used to a perches to the bill
			public void buy(String Item, int amount) {
				bill.addPurchase(Item, amount);
			}
			//
			//creats the gui segment for the eatch booking
			public GridPane bookingRep() {//generates the grid pain for the main menu
				GridPane show = new GridPane();
				
				//Creates element and sets text size
				Text name = new Text("Name: "+this.name);
				name.setFont(Font.font(20));
				
				Text peopleCount = new Text("people: "+this.numOfPeople);
				peopleCount.setFont(Font.font(20));
				
				Text startTime = new Text("Time: "+this.startTime);
				startTime.setFont(Font.font(20));
				
				Text duration = new Text("Duration: "+this.duration);
				duration.setFont(Font.font(20));
				
				delete.setFont(Font.font(20));
				delete.addEventHandler(ActionEvent.ACTION, this);//event handler
				billBut.setFont(Font.font(20));
				billBut.addEventHandler(ActionEvent.ACTION, this);//event handler
				//
				//adds elaments to the grid
				show.add(name,0,0,2,1);
				show.add(peopleCount, 0, 1, 2, 1);
				show.add(startTime, 0, 2,2,1);
				show.add(duration, 0, 3,2,1);
				show.add(delete, 1, 4,1,1);
				show.add(billBut, 0, 4,1,1);
				//
				//sets the styleing of the grid
				show.setAlignment(Pos.CENTER);
				show.setVgap(10); 
			    show.setHgap(10);
			    show.setMinSize(250,250);
			    //
			    //alins the elaments
			    show.setHalignment(name, HPos.CENTER);
			    show.setHalignment(peopleCount, HPos.CENTER);
			    show.setHalignment(startTime, HPos.CENTER);
			    show.setHalignment(duration, HPos.CENTER);
			    show.setHalignment(delete,HPos.CENTER);
			    //
			    //returns the gridpain
				return show;
				//
			//
		}
			
			@Override
			public void handle(ActionEvent e) {
				
			//figers out were the elament is
			    Table tableTemp = Main.tableList.head;
			    boolean found = false;
			    booking bookTemp = tableTemp.bookings.head;
			    //gose trow eatch table
			    while(tableTemp != null && found == false) {
			    	// gose trow eatch booking in the table
			    	while(bookTemp != null && found == false) {
			    		if (this == bookTemp) {
			    			found = true;
			    		}
			    		else if(bookTemp.next != null) {
			    			bookTemp = bookTemp.next;
			    		}
			    		else bookTemp=null;
			    	}
			    	//
			    	//if the booking is not in the table moves onto the next table
			    	if(bookTemp == null) {
			    		tableTemp = tableTemp.next;
			    		bookTemp = tableTemp.bookings.head;
			    	}
			    	//
			    }
			    //
			//
			    //handels when the bill button is presed
				if(e.getSource()==billBut) {
					//gose to the right billScean
					Main.Scean_Manager.billScene(bookTemp);
					//
				}
				//
				// removes the elament    
				if(e.getSource()==delete) {
					//how to handel deleating an elament in the middel of a list
				    if(this.next != null && this.previous != null) {
				    	//Connects the next and previous elements together
				    	this.next.previous = this.previous;
				    	this.previous.next = this.next;
				    	//
				    }
				    //
				    //hot to handel an elament at the end of the list
				    else if(this.next == null && this.previous != null) {
				    	//makes the previous the last elament
				    	this.previous.next=null;
				    	//
				    }
				    //
				    //how to handel a head elament 
				    else if(this.next != null && this.previous == null) {
				    	//makes the next elament the head and removes referance to the old head
				    	tableTemp.bookings.head = this.next;
				    	this.next.previous = null;
				    	//
				    }
				    //how to handel the only elament in the list
				    else {
				    	tableTemp.bookings.head = null;
				    }
				    //
				    //refreshes the scean
				    Main.Scean_Manager.bookingScene(tableTemp);
				    //
				}
				//
				
			}
	}
}

