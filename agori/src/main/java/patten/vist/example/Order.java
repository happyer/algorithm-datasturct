package patten.vist.example;

public class Order implements IVisitable {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
