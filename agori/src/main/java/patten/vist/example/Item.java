package patten.vist.example;

public class Item implements IVisitable {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
