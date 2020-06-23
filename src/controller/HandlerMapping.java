package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		System.out.println(command);
		
		if(command.equals("itemlist.do")) {
			//controller = new ItemListController();
			System.out.println("ItemListController() 반환");
		}else if(command.contains("itemdetail.do")){
			//controller = new ItemDetailController();
			System.out.println("ItemDetailController() 반환");
		}
		return controller;
	}
}
