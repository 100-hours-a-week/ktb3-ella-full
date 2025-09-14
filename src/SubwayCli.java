import service.*;
import domain.*;

public class SubwayCli {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.startOrder();
    }
}