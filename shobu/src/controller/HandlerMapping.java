package controller;

public class HandlerMapping {
	private static HandlerMapping handler  = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("itemList.do")) {
			//controller = new ItemListController();
			System.out.println("ItemListController 생성");
		}else if(command.contains("itemDetail.do")) {
			//controller = new ItemDetailController();
			System.out.println("ItemDetailController 생성");
		}
		return controller;
	}
}
