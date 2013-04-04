package at.edu.hti.shop;

import at.edu.hti.shop.domain.Lebensmittel;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.Werkzeug;

public class App {
  
  //ID, name, prize, weight, deliveryDays 
  private final static Product apfel = new Lebensmittel(1, "Äpfel", 1.2, 0.5, 1);
  private final static Product birne = new Lebensmittel(2, "Birnen", 1.5, 0.6, 1);
  private final static Product pfirsich = new Lebensmittel(3, "Pfirsich", 2.2, 0.3, 2);
  private final static Product kiwi = new Lebensmittel(4, "Kiwi", 3.5, 0.2, 3);
  
  private final static Product hammer = new Werkzeug(5, "Hammer", 10.0, 2.5, 5);
  private final static Product nagel = new Werkzeug(6, "Nagel", 0.01, 0.01, 1);
  private final static Product schaufel = new Werkzeug(7, "Schaufel", 15.0, 5.0, 1);
  private final static Product axt = new Werkzeug(8, "Axt", 12.5, 3.5, 3);
  
	public static void main(String[] args) {

		Order shopOrder = new Order();

		OrderLine line1 = new OrderLine(apfel, 4);
		OrderLine line2 = new OrderLine(birne, 2);
		OrderLine line3 = new OrderLine(pfirsich, 5);
		OrderLine line4 = new OrderLine(kiwi, 6);
		
    OrderLine line5 = new OrderLine(hammer, 1);
    OrderLine line6 = new OrderLine(nagel, 2000);
    OrderLine line7 = new OrderLine(schaufel, 3);
    OrderLine line8 = new OrderLine(axt, 2);

		shopOrder.add(line1);
		shopOrder.add(line2);
		System.out.println(shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.setLineAmount(1,8);

		System.out.println(shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.setLineAmount(2,0);

		System.out.println(shopOrder.size());
		System.out.println(shopOrder);

		shopOrder.add(line3);
		shopOrder.add(line4);
		
    System.out.println(shopOrder.size());
    System.out.println(shopOrder);

	}
}
