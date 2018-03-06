public class MyLinkedList <T extends Object>{
    private MyNode first;
    private MyNode last;

    public MyLinkedList(){
        first = null;
        last = null;
    }

    //добавление
    public void add(T value){
        MyNode newNode = new MyNode(value);
        if (last != null){
            last.setNext(newNode);
        }
        else {
            first = newNode;
        }
        last = newNode;
    }

    //вставка в середину
    public void add(int index, T value){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        MyNode newNode = new MyNode(value);
        if (index == 0){
            newNode.setNext(first);
            first = newNode;
            return;
        }
        MyNode nextNode = first;
        MyNode previousNode = null;
        for (int i = 0; i < index; i++){
            if (nextNode == null){
                throw new IndexOutOfBoundsException();
            }
            if (nextNode.getNext() == null){
                previousNode = nextNode;
            }
            nextNode = nextNode.getNext();
        }
        newNode.setNext(nextNode);
        if (nextNode != null){
            previousNode = nextNode.getPrevious();
            nextNode.setPrevious(newNode);
        }
        newNode.setPrevious(previousNode);
        previousNode.setNext(newNode);

    }

    //получение
    public T get(int index){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        MyNode node = first;
        for (int i = 0; i < index; i++){
            if (node == null){
                throw new IndexOutOfBoundsException();
            }
            node = node.getNext();
        }
        if (node == null){
            throw  new IndexOutOfBoundsException();
        }
        return node.getValue();
    }

    //удаление
    public T remove(int index){
        if (index < 0){
            throw new IndexOutOfBoundsException();
        }
        MyNode node = first;
        MyNode nextNode;
        MyNode previousNode;
        for (int i = 0; i < index; i++){
            if (node == null){
                throw new IndexOutOfBoundsException();
            }
            node = node.getNext();
        }
        if (node == null){
            throw new IndexOutOfBoundsException();
        }
        nextNode = node.getNext();
        previousNode = node.getPrevious();
        if (previousNode == null && nextNode == null){
            first = null;
            last = null;
        }
        else if (nextNode == null){
            previousNode.setNext(nextNode);
        }
        else if (previousNode == null){
            first = nextNode;
        }
        else {
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }
        return node.getValue();
    }

    //очистка
    public void clear(){
        first = null;
        last = null;
    }

    //размер
    public int size(){
        int result = 0;
        MyNode node = first;
        while (node != null){
            node = node.getNext();
            result++;
        }
        return result;
    }


    //класс элементов листа
    private class MyNode{
        private T value;
        private MyNode next;
        private MyNode previous;

        MyNode(T value) {
            this.value = value;
            this.next = null;
            this.previous = last;
        }

        public T getValue() {
            return value;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }

        public MyNode getPrevious() {
            return previous;
        }

        public void setPrevious(MyNode previous) {
            this.previous = previous;
        }
    }
}
