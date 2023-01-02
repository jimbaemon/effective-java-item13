import clone_default.PhoneNumber;
import java.util.Arrays;

// Stack의 복제 가능 버전 (80-81쪽)
public class Stack implements Cloneable {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    // clone이 동작하는 모습을 보려면 명령줄 인수를 몇 개 덧붙여서 호출해야 한다.
    public static void main(String[] args) {
        Object[] values = new Object[2];
        values[0] = new PhoneNumber("010-2289-9244");
        values[1] = new PhoneNumber("010-2290-9244");

        Stack stack = new Stack();
        for (Object arg : values) {
            stack.push(arg);
        }

        Stack copy = stack.clone();

        System.out.println("pop from stack");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }

        System.out.println("pop from copy");
        while (!copy.isEmpty()) {
            System.out.println(copy.pop() + " ");
        }

        System.out.println(stack.elements[0] == copy.elements[0]);
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public synchronized Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            this.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // 원소를 위한 공간을 적어도 하나 이상 확보한다.
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
