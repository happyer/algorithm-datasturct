package patten.vist.example;

public class Customer implements  IVisitable{

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
