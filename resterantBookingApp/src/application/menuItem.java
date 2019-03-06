package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class menuItem{
	public Item head = null;
	public Item defalt = new Item("No Match", 0);
	
	public void addItem(String Name, double price) { //Add element to head of list
		Item newItem= new Item(Name, price);
		newItem.next=head;
		head=newItem;
		if(head.next != null) {
			head.next.previous = newItem;
		}
	} 
	
	public class Item  implements EventHandler<ActionEvent>{
		public Item next =null;
		public Item previous = null;
		public String Name;
		public double Price;
		private Button delete = new Button("Delete");
		
		public Item(String name, double price){
			this.Name = name;
			this.Price = price;
		}
		
		public GridPane ItemRep() {//generates the grid pain for the main menu
			GridPane show = new GridPane();
			
			//sets elaments text size
			Text titel = new Text("Name: "+this.Name);
			titel.setFont(Font.font(28));
			
			Text price = new Text("Price: "+this.Price);
			price.setFont(Font.font(20));
			
			delete.setFont(Font.font(20));
			delete.addEventHandler(ActionEvent.ACTION, this);//event andler
			
			//adds elaments to the grid
			show.add(titel, 0, 0, 2, 1);
			show.add(price, 0, 1,2,1);
			show.add(delete, 0, 2, 2,1);
			
			//sets the styleing of the grid
			show.setAlignment(Pos.CENTER);
			show.setVgap(10); 
		    show.setHgap(10);
		    show.setMinSize(250,250);
		    
		    //alins the elaments
		    show.setHalignment(titel, HPos.CENTER);
		    show.setHalignment(price, HPos.CENTER);
		    show.setHalignment(delete, HPos.CENTER);
			return show;
		}
		
		public void handle(ActionEvent e) {
			if(e.getSource()==delete) {
				if(this.next != null && this.previous != null) {
			    	this.next.previous = this.previous;
			    	this.previous.next = this.next;
			    }
			    else if(this.next == null && this.previous != null) {
			    	this.previous.next=null;
			    }
			    else if(this.next != null && this.previous == null) {
			    	Main.menuItems.head = this.next;
			    	this.next.previous = null;
			    }
			    else {
			    	Main.menuItems.head = null;
			    }
				

				Main.Scean_Manager.menuScene();
			}
		}		
	}
}


