package clone_use_contsructor;

public class SubItem extends Item implements
    Cloneable {

    private String name;

    public static void main(String[] args) {
        SubItem item = new SubItem();
        SubItem clone = item.clone();

        System.out.println(clone != item);
        System.out.println(clone.getClass() == item.getClass());
        System.out.println(clone.equals(item));
    }

    @Override
    public SubItem clone() {
        return (SubItem) super.clone(); //공변 반환 타이핑으로 가능
    }
}
