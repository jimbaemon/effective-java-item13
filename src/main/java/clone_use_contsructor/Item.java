package clone_use_contsructor;

public class Item implements Cloneable {

    private String name;

    public static void main(String[] args) {
        Item item = new Item();
        Item clone = item.clone();

        System.out.println("item = " + item);
        System.out.println("clone = " + clone);
    }

    /**
     * 이렇게 구현하면 하위 클래스의 clone()이 깨질 수 있다. p78
     *
     * @return
     */
    @Override
    public Item clone() {
        try {
            return (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new AssertionError();
        }
    }
}
