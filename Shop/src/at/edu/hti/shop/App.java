package at.edu.hti.shop;

import java.util.ArrayList;

import at.edu.hti.shop.domain.Lebensmittel;
import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.Werkzeug;
import at.edu.hti.shop.specification.DeliveryTimeSpecification;
import at.edu.hti.shop.specification.MaxWeightSpecification;
import at.edu.hti.shop.specification.ProductTypeSpecification;
import at.edu.hti.shop.specification.tools.ISpecification;

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
//
//		shopOrder.add(line1);
//		shopOrder.add(line2);
//		System.out.println(shopOrder.size());
//		System.out.println(shopOrder);
//
//		shopOrder.setLineAmount(1,8);
//
//		System.out.println(shopOrder.size());
//		System.out.println(shopOrder);
//
//		shopOrder.setLineAmount(2,0);
//
//		System.out.println(shopOrder.size());
//		System.out.println(shopOrder);
//
//		shopOrder.add(line3);
//		shopOrder.add(line4);
//		
//    System.out.println(shopOrder.size());
//    System.out.println(shopOrder);
    
    
    shopOrder = new Order();
    shopOrder.add(line1);
    shopOrder.add(line2);
    shopOrder.add(line3);
    shopOrder.add(line4);
    shopOrder.add(line5);
    shopOrder.add(line6);
    shopOrder.add(line7);
    shopOrder.add(line8);
    
    System.out.println("original order: "+shopOrder);
    
    System.out.println("\n\n---------------SPLITTING------------------");
    
    //Lebensmittel, Lieferzeit <= 20 Tage, maximales Auftragsgewicht 10 kg
    System.out.println("\n\nsplit rules:");
    DeliveryTimeSpecification<OrderLine> devTime = new DeliveryTimeSpecification<OrderLine>(2);
    MaxWeightSpecification<Order> maxWeight = new MaxWeightSpecification<Order>(10.0);
    ProductTypeSpecification<OrderLine> prodType = new ProductTypeSpecification<OrderLine>(Lebensmittel.class);
    System.out.println("\n");
    ISpecification<OrderLine> prodSpec = devTime.And(prodType);
    ISpecification<Order> orderSpec = maxWeight;
    
    ArrayList<Order> subOrders = new ArrayList<>();
    
    Order splitOrder = new Order();
    
    for (OrderLine orderLine : shopOrder.getLines()) {
      if (prodSpec.isSatisfiedBy(orderLine)) {
        splitOrder.add(orderLine);
        if (!orderSpec.isSatisfiedBy(splitOrder)) {
          splitOrder.removeLine(orderLine);
        } else {
          System.out.println("ADDING: "+orderLine);
        }
      }
    }
    
    for (OrderLine orderLine : splitOrder.getLines()) {
      shopOrder.removeLine(orderLine);
    }
    
    if (splitOrder.size() > 0) {
      subOrders.add(splitOrder);
    }
    System.out.println("\n----------\nsub orders: ");
    for (Order subOrder : subOrders) {
      System.out.println("  "+subOrder);
    }
    System.out.println("remaining: "+shopOrder);
    
    //restliche Lebensmittel, Lieferzeit egal, maximales Auftragsgewicht 10 kg
    System.out.println("\n\nsplit rules:");
    prodSpec = new ProductTypeSpecification<OrderLine>(Lebensmittel.class);;
    orderSpec = new MaxWeightSpecification<Order>(10.0);
    System.out.println("\n");
    while(shopOrder.containsProductType(Lebensmittel.class)) {
      splitOrder = new Order();
      for (OrderLine orderLine : shopOrder.getLines()) {
        if (prodSpec.isSatisfiedBy(orderLine)) {
          splitOrder.add(orderLine);
          if (!orderSpec.isSatisfiedBy(splitOrder)) {
            splitOrder.removeLine(orderLine);
          } else {
            System.out.println("ADDING: "+orderLine);
          }
        }
      }
      for (OrderLine orderLine : splitOrder.getLines()) {
        shopOrder.removeLine(orderLine);
      }
      
      if (splitOrder.size() > 0) {
        subOrders.add(splitOrder);
      }else {
        //just in case an orderline is left that alone is larger than the max weight
        break;
      }
    }
    System.out.println("\n----------\nsub orders: ");
    for (Order subOrder : subOrders) {
      System.out.println("  "+subOrder);
    }
    System.out.println("\n----------\nremaining: "+shopOrder);
    
    //Werkzeug, Lieferzeit egal, maximales Auftragsgewicht 25 kg
    System.out.println("\n\nsplit rules:");
    maxWeight = new MaxWeightSpecification<Order>(25.0);
    prodType = new ProductTypeSpecification<OrderLine>(Werkzeug.class);
    System.out.println("\n");
    prodSpec = prodType;
    orderSpec = maxWeight;
    
    splitOrder = new Order();
    
    while(shopOrder.containsProductType(Werkzeug.class)) {
      splitOrder = new Order();
      for (OrderLine orderLine : shopOrder.getLines()) {
        if (prodSpec.isSatisfiedBy(orderLine)) {
          splitOrder.add(orderLine);
          if (!orderSpec.isSatisfiedBy(splitOrder)) {
            splitOrder.removeLine(orderLine);
          } else {
            System.out.println("ADDING: "+orderLine);
          }
        }
      }
      for (OrderLine orderLine : splitOrder.getLines()) {
        shopOrder.removeLine(orderLine);
      }
      
      if (splitOrder.size() > 0) {
        subOrders.add(splitOrder);
      } else {
        //just in case an orderline is left that alone is larger than the max weight
        break;
      }
    }
    System.out.println("\n----------\nsub orders: ");
    for (Order subOrder : subOrders) {
      System.out.println("  "+subOrder);
    }
    if (shopOrder.size() > 0) {
      System.out.println("\n----------\nremaining: "+shopOrder);
    }
    
    System.out.println("\n\n---------------JOINING------------------");
    
    for (Order subOrder : subOrders) {
      for (OrderLine line : subOrder.getLines()) {
        shopOrder.add(line);
      }
    }
    
    subOrders = new ArrayList<>();
    
    System.out.println("joined order: "+shopOrder);
    
	}
}
