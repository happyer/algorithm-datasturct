package patten.vist.example;

public interface IVisitor {

    void visit(Customer customer);

    void visit(Order order);

    void visit(Item item);
}
